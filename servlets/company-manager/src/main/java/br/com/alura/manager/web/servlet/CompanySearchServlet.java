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

@WebServlet(urlPatterns = "/search")
public class CompanySearchServlet extends HttpServlet {
    public CompanySearchServlet() {
        System.out.println("Servlet was instantiated.");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CompanyDAO companyDAO = new CompanyDAO();

        req.setAttribute("companies", companyDAO.searchBySimilarity(req.getParameter("filter")));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/company_search.jsp");

        requestDispatcher.forward(req, resp);
    }

}
