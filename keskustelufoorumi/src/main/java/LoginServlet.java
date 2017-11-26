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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    @Resource(name = "jdbc/FoorumiDB")
    DataSource ds;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String knimi = request.getParameter("kayttajanimi");
        String salasana = request.getParameter("salasana");

        if(autentikoi(knimi, salasana)){
            out.print("Tervetuloa, " + knimi + "!");
            HttpSession session = request.getSession();
            session.setAttribute("knimi", knimi);
            session.setAttribute("kayttajanviestit", kayttajanViestit(knimi));
            session.setAttribute("henkilotiedot", henkiloTiedot(knimi));
            request.getRequestDispatcher("index.jsp").include(request, response);

        }else{
            out.print("Väärä käyttäjänimi tai salasana!");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public boolean autentikoi(String knimi, String salasana){
        boolean status = false;

        try(Connection con= ds.getConnection()){
            String sql = ("SELECT henkilo.nimimerkki, salasana.salasana FROM henkilo " +
                    "JOIN salasana ON henkilo.hloid = salasana.kayttaja " +
                    "WHERE henkilo.nimimerkki = ? AND salasana.salasana = ?");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, knimi);
            ps.setString(2, salasana);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    public List<Viesti> kayttajanViestit(String knimi) {
        List<Viesti> viestit = new ArrayList<>();

        try (Connection con = ds.getConnection()) {
            String sql = ("SELECT * FROM viesti JOIN henkilo ON viesti.kirjoittaja = henkilo.hloid " +
                    "JOIN alue on viesti.alueid = alue.alueid " +
                    "WHERE henkilo.nimimerkki = ?");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, knimi);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Viesti v = new Viesti();
                v.setViestiID(rs.getInt("id"));
                v.setOtsikko(rs.getString("otsikko"));
                v.setViesti(rs.getString("viesti"));
                v.setAjankohta(rs.getString("kirjoitettu"));
                v.setAlueID(rs.getInt("alueid"));
                v.setNimimerkki(rs.getString("nimimerkki"));
                viestit.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viestit;
    }

    public List<Henkilo> henkiloTiedot(String knimi){
        List<Henkilo> tiedot = new ArrayList<>();

        try (Connection con = ds.getConnection()) {
            String sql = ("SELECT * FROM henkilo " +
                    "WHERE henkilo.nimimerkki = ?");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, knimi);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Henkilo h = new Henkilo();
                h.setHloid(rs.getInt("hloid"));
                h.setNimi(rs.getString("nimi"));
                h.setNimimerkki(rs.getString("nimimerkki"));
                h.setKuvaus(rs.getString("kuvaus"));
                h.setKuvausteksti(rs.getString("kuvausteksti"));
                tiedot.add(h);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tiedot;

    }
}
