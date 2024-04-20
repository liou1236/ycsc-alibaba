import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep){
//       获取servletContext对象
        ServletContext servletContext = getServletContext();
        System.out.println("servletContext =" + servletContext);
        String mimeType =  servletContext.getMimeType("a.txt");
        System.out.println("mimeType =" + mimeType);
        servletContext.getMimeType("b.txt");

    }


}
