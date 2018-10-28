package myFilter;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class MyLoginWebFilter
 */
@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
			, 
		urlPatterns = { 
				"/MyLoginWebFilter", 
				"/Store.jsp", 
				"/Personal.jsp", 
				"/DeliveryBoy.jsp"
				
		})
public class MyLoginWebFilter implements Filter {

    public MyLoginWebFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	HttpServletRequest req = (HttpServletRequest)request;
	HttpServletResponse res = (HttpServletResponse)response;
	System.out.println("Path information is : "+req.getPathInfo());
	System.out.println("Path Translated is : "+req.getPathTranslated());
	System.out.println("Context Path is : ");
	
	if("/Store.jsp".equals(req.getRequestURI().substring(req.getContextPath().length(), req.getRequestURI().length()))) {
		Cookie[] c = req.getCookies();
		if(c==null) {
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/administrator?useSSL=false", "root", "root");
				
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				try {
					if(con!=null) {
						con.close();	
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			Cookie c1 = new Cookie("username",request.getParameter("username"));
			Cookie c2 = new Cookie("password",request.getParameter("password"));
			res.addCookie(c1);
			res.addCookie(c2);
		}else {
			
		}
	}
	
	if("/Personal.jsp".equals(req.getRequestURI().substring(req.getContextPath().length(), req.getRequestURI().length()))) {
		
	}
	
	if("/DeliveryBoy.jsp".equals(req.getRequestURI().substring(req.getContextPath().length(), req.getRequestURI().length()))) {
		
	}
	
	chain.doFilter(req, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
