import fi.academy.dbo.ViestiDBO;
import fi.academy.papu.Viesti;

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

@WebServlet(name = "UusiViestiServlet", urlPatterns = "/uusiviesti")
public class UusiViestiServlet extends HttpServlet {

    @Resource(name = "jdbc/FoorumiDB")
    DataSource ds;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession istunto = request.getSession();

        Viesti uusiviesti = new Viesti();
        String otsikko = request.getParameter("uusiotsikko");
        String viesti = request.getParameter("uusiviesti");
        int alueID = Integer.parseInt(request.getParameter("alueid"));
        int viestiID = Integer.parseInt(request.getParameter("viestiid"));
        int kirjoittaja = Integer.parseInt(request.getParameter("hloid"));

        uusiviesti.setOtsikko(otsikko);
        uusiviesti.setViesti(viesti);
        uusiviesti.setHloID(kirjoittaja);
        uusiviesti.setAlueID(alueID);
        uusiviesti.setVastausID(viestiID);

        try (Connection con = ds.getConnection()) {
            ViestiDBO.lisaaViesti(con, uusiviesti);
        } catch (SQLException e) {
            e.printStackTrace();
            istunto.setAttribute("virheviesti", e.getMessage());
            request.getRequestDispatcher("virhe.jsp").forward(request, response);
            return;
        }
        String paluu = (String) istunto.getAttribute("paluuosoite");
        request.getRequestDispatcher(paluu).include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
