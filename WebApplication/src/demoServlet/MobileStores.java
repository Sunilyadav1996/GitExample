package demoServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MobileStores")
public class MobileStores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MobileStores() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Map<String,String> m = new HashMap<String,String>();
			ArrayList<String> l = new ArrayList<String>();		
			String sql = "SELECT * FROM ACTOR;";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "root");
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery(sql);
			System.out.println(res.getFetchSize());
			while(res.next()) {
				m.put("Id", res.getString(1));
				m.put("FirstName", res.getString(2));
				m.put("LastName",res.getString(3));
				m.put("LastUpdate",res.getString(4));
				l.add(getJsonString(m));
			}
			
			response.setContentType("application/text");
			response.getWriter().write(l.toString());
			res.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	public static String getJsonString(Map<String,String> map) {
		
		Set<String> keys = map.keySet();
		Iterator<String> i = keys.iterator();
		String str = "{";
		int count =0;
		while(i.hasNext()) {
			String key = i.next();
			if(count<keys.size()-1) {
				count++;
				str +="\""+key+"\":\""+map.get(key)+"\",";	
			}else {
				str += "\""+key+"\":\""+map.get(key)+"\"";		
			}
			
		}
		
		str += "}";
		return str;
	}
	

}
