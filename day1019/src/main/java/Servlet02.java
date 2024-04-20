import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet02 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        this.getServletContext().getAttribute("name","li4");
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse rep){

    }
}
