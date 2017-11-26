import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        HttpSession session=request.getSession();

        if(session.getAttribute("knimi")!=null){
            String knimi = (String)session.getAttribute("knimi");
            session.invalidate();
            out.print("Olet kirjautunt ulos, " + knimi + "!");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
        else{
            out.print("Et ole edes kirjautunut sisään vielä!");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }

        out.close();
    }
}
