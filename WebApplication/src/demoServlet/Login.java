
package demoServlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		RequestDispatcher rs = request.getRequestDispatcher("index.html");
		RequestDispatcher rs1 = request.getRequestDispatcher("Profile.jsp");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?useSSL=false","root","root");
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery("SELECT * FROM passenger WHERE email = '"+email+"' AND password = '"+password+"';");
			if(res.next()) {
				HttpSession userSession= request.getSession();
				userSession.setAttribute("id", res.getString(1));
				
			}else {
				rs.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			rs.forward(request, response);
			e.printStackTrace();
		}
		
	}

}
