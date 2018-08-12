package br.com.alura.manager.web.servlet;

import br.com.alura.manager.Company;
import br.com.alura.manager.dao.CompanyDAO;

import javax.servlet.RequestDispatcher;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Company company = new Company(req.getParameter("name"));

        CompanyDAO companyDAO = new CompanyDAO();

        companyDAO.add(company);

        req.setAttribute("company", company);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/new_company.jsp");

        requestDispatcher.forward(req, resp);
    }
}
