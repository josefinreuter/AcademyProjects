import fi.academy.dbo.ViestiDBO;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "ViestiServlet", urlPatterns = "/viesti")
public class ViestiServlet extends HttpServlet {

    @Resource(name = "jdbc/FoorumiDB")
    DataSource ds;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession istunto = request.getSession(true);
        Integer viestiID = Integer.parseInt(request.getParameter("value"));
        if (viestiID != null) {
            try (Connection con = ds.getConnection()) {
                istunto.setAttribute("viestiLista", ViestiDBO.viestiListaus(con, viestiID));
                istunto.setAttribute("viesti0", ViestiDBO.viestiOrigin(con, viestiID));
            } catch (SQLException e) {
                e.printStackTrace();
                istunto.setAttribute("virheviesti", e.getMessage());
                request.getRequestDispatcher("virhe.jsp").forward(request, response);
                return;
            }
        }
        else if (viestiID == null) {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        istunto.setAttribute("paluuosoite", paluuOsoite(viestiID));
        request.getRequestDispatcher("viestisivu.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public String paluuOsoite (int value){
        String v = String.valueOf(value);
        String osoite = "viesti?value=" + v;
        return osoite;
    }
}
