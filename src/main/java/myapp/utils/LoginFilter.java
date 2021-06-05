package myapp.utils;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter({"/company/*", "/inspection/*", "/equipment/*", "/news/*", "/start/*", "/ticket/*", "/user/*"})
public class LoginFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
            }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("id") == null) {
            ((HttpServletResponse) response).sendRedirect("/login"); //przekierowanie na servlet logowania
        } else {
            chain.doFilter(request, response);
        }
    }
}
