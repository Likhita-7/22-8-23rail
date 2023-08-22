

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;


@WebServlet("/Dup2")
public class Dup2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			Ser ss = new Ser();
			JSONArray h = null;
			try {
				ss.meth();
				//System.out.println("conn");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				h = ss.meth1();
			} catch (SQLException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().write(h.toString());
		}
		
	}

	


