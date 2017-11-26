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
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "PoistaServlet", urlPatterns = "/PoistaServlet")
public class PoistaServlet extends HttpServlet {
    @Resource(name = "jdbc/FoorumiDB")
    DataSource ds;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession istunto = request.getSession(true);
        String del = request.getParameter("viestiid");
        String direct = request.getParameter("viesti0");
        String nimim = request.getParameter("nimimerkki");
        String hloid = request.getParameter("hloid");
        String rooli = request.getParameter("rooli");


        if (hloid == hloid) {
            try (Connection con = ds.getConnection()) {
                String sql = "DELETE FROM viesti where id = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, del);
                ps.executeUpdate();
                response.sendRedirect("viesti?value="+direct);
                //request.getRequestDispatcher("viesti?value=" + request.getParameter("viestiid")).forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
                istunto.setAttribute("virheviesti", e.getMessage());
                request.getRequestDispatcher("virhe.jsp").forward(request, response);
                return;
            }
        } else {
            request.getRequestDispatcher("viesti?value=" + request.getParameter("viestiid")).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
