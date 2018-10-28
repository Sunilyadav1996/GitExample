package demoServlet;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import myejb.Personal;
@WebServlet("/RegistrationPersonal")
public class RegistrationPersonal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	Personal personal;
	
	//This method is used to get information of Personal object
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		personal.doGet(Integer.parseInt(request.getSession().getAttribute("Id")+""),request, response);
		
	}

	//This method is used to create new Personal
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String MobileNo = request.getParameter("MobileNumber");
		String address = request.getParameter("Address");
		personal.setName(name);
		personal.setEmail(email);
		personal.setPassword(password);
		personal.setMobileNo(MobileNo);
		personal.setAddress(address);
		personal.insertData();
	}

	//This method is used to update Personal Detail
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	//This method is used to delete from table
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	//This method is used to get Head
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	//This method is used to Options
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	//This method is used to trace the route
	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
