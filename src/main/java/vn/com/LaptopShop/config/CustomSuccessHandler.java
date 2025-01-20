package vn.com.LaptopShop.config;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.com.LaptopShop.domain.User;
import vn.com.LaptopShop.service.UserService;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserService userService;
    
    protected String determineTargetUrl(final Authentication authentication) {
        Map<String, String> roleTargetUrlMap = Map.of(
            "ROLE_ADMIN", "/admin",
            "ROLE_USER", "/"
        );
        final var authorities = authentication.getAuthorities();
        for (var authority : authorities) {
            String authorityName = authority.getAuthority();
            if (roleTargetUrlMap.containsKey(authorityName)) {
                return roleTargetUrlMap.get(authorityName);
            }
        }
        throw new IllegalStateException();

    }

    protected void clearAuthenticationAttributes(HttpServletRequest request,Authentication authentication) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        String username = authentication.getName();

        User user = this.userService.getUserByEmail(username);
        if(user != null){
            session.setAttribute("username", user.getFullName());
            session.setAttribute("avatar", user.getAvatar());
            session.setAttribute("id", user.getId());
            session.setAttribute("email", user.getEmail());
            int sum = user.getCart() == null ? 0 : user.getCart().getSum();
            session.setAttribute("sum", sum);
        }
        
        
    }

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
                String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
        clearAuthenticationAttributes(request, authentication);
    }
    
}
