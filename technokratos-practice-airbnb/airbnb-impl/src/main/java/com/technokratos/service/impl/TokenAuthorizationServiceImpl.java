package com.technokratos.service.impl;

import com.technokratos.dto.response.UserResponse;
import com.technokratos.exception.UserNotFoundException;
import com.technokratos.mapper.UserMapper;
import com.technokratos.repository.UserRepository;
import com.technokratos.service.TokenAuthorizationService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TokenAuthorizationServiceImpl implements TokenAuthorizationService {

    @Value("${airbnb.secret}")
    private String secretKey;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse getUserInfoByToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token).getBody();
        String email = claims.getSubject();
        return userMapper.toResponse(userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new));
    }
}
