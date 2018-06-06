import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuyTShirt
 */
@WebServlet("/BuyTShirt")
public class BuyTShirt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String driver = "com.mysql.jdbc.Driver";
	String host = "jdbc:mysql://localhost:3306/java";
	String user = "root";
	String pass = "12345678";
	Connection con;

    public BuyTShirt() {
        super();
    	try{
    		Class.forName(driver);
    		con = DriverManager.getConnection(host, user, pass);
    	}
    	catch (Exception e) {
    		e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tag = request.getParameter("tag");
		String colour = request.getParameter("colour");
		String[] accessories = request.getParameterValues("acc");
		int pocket = Integer.parseInt(request.getParameter("pocket"));

		String acc = "";
		for (String x : accessories )
			acc = acc + x + " ";

		try {
			PreparedStatement stmt;
			stmt = con.prepareStatement("insert into tshirt values(?,?,?,?,?)");
			stmt.setInt(1,0);
			stmt.setString(2,acc);
			stmt.setString(3,tag);
			stmt.setInt(4,pocket);
			stmt.setString(5,colour);
			stmt.executeUpdate();
//			stmt.executeUpdate("insert into tshirt values("+0+"," + acc + ",'" + tag + "','" + pocket +"','" + colour +"');");

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("display.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}