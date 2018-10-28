package demoServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HelloServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("Hello");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PrintWriter pw = response.getWriter();
			pw.println("<table border = '1' style = 'border-collapse:collapse;'><tr><th>Sr. No.</th><th>Name</th><th>Last Name</th><th>Date</th></tr>");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false","root","root");
			Statement state = con.createStatement();
			ResultSet rs = state.executeQuery("SELECT * FROM actor");
			while(rs.next()) {
				pw.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
			}
			pw.println("<table>");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
