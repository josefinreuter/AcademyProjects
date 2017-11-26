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
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "RekistServlet", urlPatterns = {"/rekisteroityminen"})
public class RekistServlet extends HttpServlet {
    @Resource(name = "jdbc/FoorumiDB")
    DataSource ds;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        String nimimerkki = request.getParameter("nimimerkki");
        String nimi = request.getParameter("nimi");
        String kuvaus = request.getParameter("kuvaus");
        String kuvausteksti = request.getParameter("kuvausteksti");
        String salasana = request.getParameter("salasana");

        if(session.getAttribute("knimi")!= null){
            out.print("Olet jo sisäänkirjautunut rekisteröityneenä käyttäjänä!");
            request.getRequestDispatcher("index.jsp").include(request, response);
        } else{
            rekisteroidy(nimimerkki, nimi, kuvaus, kuvausteksti);
            asetaSalasana(salasana);
            out.print("Tervetuloa, " + nimimerkki + "! Voit nyt kirjautua sisään.");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void rekisteroidy(String nimimerkki, String nimi, String kuvaus, String kuvausteksti){

        try (Connection con = ds.getConnection()) {
            String sql = ("INSERT INTO henkilo VALUES(NULL, ?, ?, ?, ?, ?)");
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nimi);
            ps.setString(2, nimimerkki);
            ps.setString(3, kuvaus);
            ps.setString(4, "rekisteroitynyt");
            ps.setString(5, kuvausteksti);
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void asetaSalasana(String salasana){
        try (Connection con = ds.getConnection()) {
            int id = 0;

            String sql = ("SELECT hloid FROM henkilo");
            PreparedStatement ps1 = con.prepareStatement(sql);
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                id = rs.getInt("hloid");
            }

            String sql2 = ("INSERT INTO salasana VALUES(NULL, ?, ?)");
            PreparedStatement ps = con.prepareStatement(sql2);
            ps.setInt(1, id);
            ps.setString(2, salasana);

            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
