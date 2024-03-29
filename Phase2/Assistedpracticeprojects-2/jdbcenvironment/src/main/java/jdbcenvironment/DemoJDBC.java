package jdbcenvironment;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jdbcenvironment.DBConnection;

/**
 * Servlet implementation class DemoJDBC
 */
@WebServlet("/DemoJDBC")
public class DemoJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DemoJDBC() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			 PrintWriter out = response.getWriter();
			 out.println("<html><body>");
			 
			 InputStream in = 
			getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			 Properties props = new Properties();
			 props.load(in);
			 
			 DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"),props.getProperty("password"));
			 out.println("DB Connection initialized.<br>");
			 
			 conn.closeConnection();
			out.println("DB Connection closed.<br>");
			 
			 out.println("</body></html>");
			 conn.closeConnection();
			 
		 } catch (ClassNotFoundException e) {
		 e.printStackTrace();
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
