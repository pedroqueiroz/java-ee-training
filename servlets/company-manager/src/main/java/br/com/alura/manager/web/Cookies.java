package br.com.alura.manager.web;

import javax.servlet.http.Cookie;

public class Cookies {

    private final Cookie[] cookies;

    public Cookies(Cookie[] cookies) {
        this.cookies = cookies;
    }

    public Cookie getAuthenticatedUser() {
        if (cookies == null) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("logged.user")) {
                return cookie;
            }
        }

        return null;
    }

}