import fi.academy.papu.Viesti;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "HakuServlet", urlPatterns = {"/HakuServlet"})
public class HakuServlet extends HttpServlet {
    @Resource(name = "jdbc/FoorumiDB")
    DataSource ds;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession istunto = request.getSession(true);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String hakusana = (request.getParameter("hakusana"));
        Viesti v = new Viesti();
        try (Connection c = ds.getConnection()) {
            istunto.setAttribute("haku", Haku.haeSanat(c, hakusana));
        } catch (SQLException e) {
            e.printStackTrace();
            istunto.setAttribute("virheviesti", e.getMessage());
            request.getRequestDispatcher("virhe.jsp").include(request, response);
            return;
        }
        istunto.setAttribute("sanat", v);
        request.getRequestDispatcher("hakutulos.jsp").include(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
