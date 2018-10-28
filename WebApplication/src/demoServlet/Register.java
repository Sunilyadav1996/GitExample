package demoServlet;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myejb.MyRegistration;
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	MyRegistration myRegistration;
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		RequestDispatcher rd = request.getRequestDispatcher("Resitration.html");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub0
		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String number = request.getParameter("number");
		myRegistration.setName(name);
		myRegistration.setEmail(email);
		myRegistration.setNumber(number);
		myRegistration.setPassword(password);
		myRegistration.insertData();
		rd.forward(request, response);
	}

}
