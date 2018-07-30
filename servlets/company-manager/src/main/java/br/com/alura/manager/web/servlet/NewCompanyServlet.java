package br.com.alura.manager.web.servlet;

import br.com.alura.manager.Company;
import br.com.alura.manager.dao.CompanyDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/newCompany")
public class NewCompanyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Company company = new Company(name);

        CompanyDAO companyDAO = new CompanyDAO();

        companyDAO.add(company);

        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<body>");
        writer.println("New company named " + company.getName() + " was added successfully");
        writer.println("</body>");
        writer.println("</html>");
    }
}
