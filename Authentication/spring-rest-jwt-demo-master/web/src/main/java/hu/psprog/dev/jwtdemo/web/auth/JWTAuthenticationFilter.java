package hu.psprog.dev.jwtdemo.web.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;

import hu.psprog.dev.jwtdemo.web.util.JWTUtility;

/**
 * Token kinyerése lesz a fejlécben tárolt információk alapján.
 */
public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final String URL_ROOT = "/api/user/**";

    /* szabályozható, mely URL alatt lépjen működésbe a filter*/
    public JWTAuthenticationFilter() {
        super(new NegatedRequestMatcher(new AntPathRequestMatcher(URL_ROOT)));
    }

    /*kinyeri a fejlécből a tokent, becsomagolja authentikációs tokent objektummá és továbbadja a managernek*/
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        String token = JWTUtility.extractToken(request);
        Authentication authentication = new JWTAuthenticationToken(token);

        return getAuthenticationManager().authenticate(authentication);
    }

    /*csak akkor kerül meghívásra, ha a filter sikeresen authentikálja a felhasználót,
    egyúttal be is jegyzi az authentikációs objektumot a biztonsági kontextusba*/
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        SecurityContextHolder.getContext().setAuthentication(authResult);

        chain.doFilter(request, response);
    }
}
