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

@WebServlet(urlPatterns = "/search")
public class CompanySearchServlet extends HttpServlet {
    public CompanySearchServlet() {
        System.out.println("Servlet was instantiated.");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Init servlet");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Destroy servlet ");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<body>");
        writer.println("Search Result: <br/>");

        _filter = req.getParameter("filter");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CompanyDAO companyDAO = new CompanyDAO();

        writer.println("<ul>");

        for (Company company : companyDAO.searchBySimilarity(_filter)) {
            writer.println("<li>" + company.getId() + ": " + company.getName() + "</li>");
        }

        writer.println("</ul>");

        writer.println("</body>");
        writer.println("</html>");
    }

    private String _filter;

}
