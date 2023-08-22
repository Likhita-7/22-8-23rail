

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dup4")
public class Dup4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			String tlist = request.getParameter("tlist");
			String clas = request.getParameter("clas");
			
			System.out.println("From: " + from);
			System.out.println("To: " + to);
			System.out.println("Tlist: " + tlist);
			System.out.println("Clas: " + clas);

			
			//String dat = request.getParameter("dat");
			String[] name = request.getParameterValues("Name");
			String[] age = request.getParameterValues("Age");
			String[] gender = request.getParameterValues("Gender");
			
			Ser ss=new Ser();
			Ticket t=ss.meth3(from, to, tlist, clas, name, age, gender);
			System.out.println(t);
			request.setAttribute("tic", t);
			
			RequestDispatcher rd=request.getRequestDispatcher("/Prev.jsp");
			//RequestDispatcher rd1=request.getRequestDispatcher("/Dup3.java");
			rd.forward(request, response);
			//rd1.include(request, response);
			
	}


}
