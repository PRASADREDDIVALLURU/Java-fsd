import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/InterfaceDemo")
public class InterfaceDemo implements Servlet{
	ServletConfig config=null;
	 public void init(ServletConfig config){
	 this.config=config;
	 System.out.println("Initialization complete");
	 }
	 public void service(ServletRequest req,ServletResponse res)
	 throws IOException,ServletException{
	 res.setContentType("text/html");
	 PrintWriter pwriter=res.getWriter();
	 pwriter.print("<html>");
	 pwriter.print("<body>");
	 pwriter.print("In the service() method<br>");
	 pwriter.print("</body>");
	 pwriter.print("</html>");
	 }
	 public void destroy(){
	 System.out.println("In destroy() method");
	 }
	 public ServletConfig getServletConfig(){
	 return config;
	 }
	 public String getServletInfo(){
	 return "This is a sample servlet info";
	 }

}
