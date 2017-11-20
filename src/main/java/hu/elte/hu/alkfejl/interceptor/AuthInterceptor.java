package hu.elte.hu.alkfejl.interceptor;

import hu.elte.hu.alkfejl.annotation.Role;
import hu.elte.hu.alkfejl.dto.UserDTO;
import hu.elte.hu.alkfejl.entity.User;
import hu.elte.hu.alkfejl.enumtype.UserRole;
import hu.elte.hu.alkfejl.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private AuthService authService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<UserRole> routeRoles = getRoles((HandlerMethod) handler);
        User user = authService.getCurrentUser();

        if (routeRoles.isEmpty() || routeRoles.contains(UserRole.GUEST)) {
            return true;
        }

        if (authService.isLoggedIn() && routeRoles.contains(user.getRole())) {
            return true;
        }
        response.setStatus(401);
        response.setHeader("Bad request reason:","Operation is not allowed with this role.");
        return false;
    }

    private List<UserRole> getRoles(HandlerMethod handler) {
        Role role = handler.getMethodAnnotation(Role.class);
        return role == null ? Collections.emptyList() : Arrays.asList(role.value());
    }
}
