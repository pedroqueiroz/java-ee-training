package br.com.alura.manager.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/logout")
public class LogoutServet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        HttpSession session = req.getSession();

        session.removeAttribute("logged.user");

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("You are logged out.");
        writer.println("</body>");
        writer.println("</html>");
    }
}