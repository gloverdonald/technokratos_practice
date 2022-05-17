package com.technokratos.security.oauth2.service;

import com.technokratos.dto.enums.Role;
import com.technokratos.exception.RoleNotFoundException;
import com.technokratos.model.RoleEntity;
import com.technokratos.model.UserEntity;
import com.technokratos.repository.RoleRepository;
import com.technokratos.repository.UserRepository;
import com.technokratos.security.oauth2.user.GoogleUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomOidcUserService extends OidcUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);
        try {
            return processOidcUser(oidcUser);
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OidcUser processOidcUser(OidcUser oidcUser) {
        GoogleUserInfo googleUserInfo = new GoogleUserInfo(oidcUser.getAttributes());
        Optional<UserEntity> userOptional = userRepository.findByEmail(googleUserInfo.getEmail());
        if (userOptional.isEmpty()) {
            UserEntity user = new UserEntity();
            user.setEmail(googleUserInfo.getEmail());
            user.setFirstName(googleUserInfo.getFirstName());
            user.setLastName(googleUserInfo.getLastName());
            user.setHashPassword("GOOGLE AUTHORIZATION");
            RoleEntity userRole = roleRepository.findByRole(Role.USER).orElseThrow(RoleNotFoundException::new);
            user.setRoles(List.of(userRole));
            user.setVerified(true);
            userRepository.save(user);
        }
        return oidcUser;
    }
}