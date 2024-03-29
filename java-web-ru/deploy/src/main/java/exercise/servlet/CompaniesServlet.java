package exercise.servlet;

import exercise.Data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        PrintWriter out = response.getWriter();
        String search = request.getParameter("search");

        List<String> companies = Data.getCompanies();

        if (search != null && !search.isEmpty()) {
            List<String> filteredCompanies = companies.stream()
                    .filter(company -> company.contains(search))
                    .collect(Collectors.toList());

            if (filteredCompanies.isEmpty()) {
                out.println("Companies not found");
                } else {
                for (String company : filteredCompanies) {
                    out.println(company);
                    }
                }
            } else {
            for (String company : companies) {
                out.println(company);
                }
            }
        // END
    }
}
