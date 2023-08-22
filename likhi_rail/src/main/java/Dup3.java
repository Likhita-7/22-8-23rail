

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;


@WebServlet("/Dup3")
public class Dup3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ser ss= new Ser();
		try {
			ss.meth();
			System.out.println("connection");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ticket tt =(Ticket) request.getAttribute("tic");
		try {
			ss.meth4(tt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
