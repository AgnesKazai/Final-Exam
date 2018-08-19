package hu.psprog.dev.jwtdemo.web.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Authentication provider for JWT based authentication.
 */
public class JWTAuthenticationProvider implements AuthenticationProvider {

    /*setting token to authenticated status*/
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        authentication.setAuthenticated(true);

        return authentication;
    }

    /*Megállípítja, hogy a kapott token objektum validálható-e ezzel a providerrel.*/
    @Override
    public boolean supports(Class<?> authentication) {

        return JWTAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
