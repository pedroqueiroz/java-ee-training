package br.com.alura.manager.web.servlet;

import br.com.alura.manager.User;
import br.com.alura.manager.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDAO userDAO = new UserDAO();

        User user = userDAO.searchByEmailAndPassword(email, password);

        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<body>");

        if (user != null) {
            writer.println("User " + user.getEmail() + " has successfully logged in.");

            Cookie cookie = new Cookie("user.logged", email);

            resp.addCookie(cookie);
        }
        else {
            writer.println("User or password is wrong.");
        }

        writer.println("</body>");
        writer.println("</html>");
    }
}
