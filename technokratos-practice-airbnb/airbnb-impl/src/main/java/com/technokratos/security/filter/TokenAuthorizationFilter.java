package com.technokratos.security.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.technokratos.dto.response.UserResponse;
import com.technokratos.service.TokenAuthorizationService;
import com.technokratos.util.HttpResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@RequiredArgsConstructor
public class TokenAuthorizationFilter extends GenericFilterBean {
    private final TokenAuthorizationService tokenAuthorizationService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {
        try {
            String token = parseToken(((HttpServletRequest) request));
            if (Objects.nonNull(token)) {
                UserResponse userResponse = tokenAuthorizationService.getUserInfoByToken(token);
                PreAuthenticatedAuthenticationToken authenticationToken =
                        new PreAuthenticatedAuthenticationToken(userResponse, token);
                if (Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                } else if (!SecurityContextHolder.getContext().getAuthentication().getCredentials().equals(token)) {
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
            chain.doFilter(request, response);
        } catch (Exception exception) {
            SecurityContextHolder.clearContext();
            HttpResponseUtil.putExceptionInResponse(((HttpServletRequest) request), ((HttpServletResponse) response),
                    exception, HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    public String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    private String parseToken(HttpServletRequest request) {
        String headerAuth = request.getHeader("AUTHORIZATION");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("BEARER ")) {
            return headerAuth.substring(7);
        }
        return null;
    }
}