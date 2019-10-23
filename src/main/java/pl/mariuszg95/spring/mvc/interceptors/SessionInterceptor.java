package pl.mariuszg95.spring.mvc.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import pl.mariuszg95.spring.core.services.UserService;
import pl.mariuszg95.spring.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor extends HandlerInterceptorAdapter {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            UserDTO loggedUserDTO = new UserDTO(userService.getUser(request.getUserPrincipal().getName()));
            request.getSession().setAttribute("user", loggedUserDTO);
        } catch (NullPointerException npe) {
            return true;
        }

        return super.preHandle(request, response, handler);
    }
}
