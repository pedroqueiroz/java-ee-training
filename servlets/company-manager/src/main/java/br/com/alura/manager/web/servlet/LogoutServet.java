package br.com.alura.manager.web.servlet;

import br.com.alura.manager.web.Cookies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/logout")
public class LogoutServet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        Cookies cookies = new Cookies(req.getCookies());

        Cookie cookie = cookies.getAuthenticatedUser();

        if (cookie != null) {
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("You are logged out.");
        writer.println("</body>");
        writer.println("</html>");
    }
}