package br.com.alura.manager.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebFilter(urlPatterns = "/*")
public class AuditURLFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        Cookie cookie = getUser(httpServletRequest);
        String user = "<unauthenticated>";

        if (cookie != null) {
            user = cookie.getValue();

            cookie.setMaxAge(10 * 60);

            httpServletResponse.addCookie(cookie);
        }

        System.out.println("User " + user + " accessing URI " + httpServletRequest.getRequestURI());

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private Cookie getUser(HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();

        if (cookies == null) {
            return null;
        }

        for (Cookie cookie: cookies) {
            if (Objects.equals(cookie.getName(), "user.logged")) {
                return cookie;
            }
        }

        return null;
    }
}
