package br.com.alura.manager.web.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/logout")
public class LogoutServet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        HttpSession session = req.getSession();

        session.removeAttribute("logged.user");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/logout.html");

        requestDispatcher.forward(req, resp);
    }
}