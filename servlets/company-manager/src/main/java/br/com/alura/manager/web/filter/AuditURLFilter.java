package br.com.alura.manager.web.filter;

import br.com.alura.manager.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter(urlPatterns = "/*")
public class AuditURLFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        HttpSession session = httpServletRequest.getSession();

        User user = (User) session.getAttribute("logged.user");

        String userName = user != null ? user.getEmail() : "<unauthenticated>";

        System.out.println("User " + userName + " accessing URI " + httpServletRequest.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
