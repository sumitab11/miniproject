package sumit.com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServ
 */
@WebServlet("/update")
public class UpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r = request.getRequestDispatcher("adminmaster.html");
		r.include(request, response);
		
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		
		
		out.println("<br>");
		out.println("<form name='frm' action='' method='GET'>");
		
		out.println("<div class='container mt-4'>"); 
		out.println("<div class='form-group'>");
		out.println("<input type='text' name='name' value='"+name+"' class='form-control' placeholder='Enter name'/>");
		out.println("</div>");
			
		out.println("<div class='form-group'>");
		out.println("<input type='text' name='email' value='"+email+"' class='form-control' placeholder='Enter email'/>");
		out.println("</div>");
		
		out.println("<div class='form-group'>");
		out.println("<input type='text' name='contact' value='"+contact+"' class='form-control' placeholder='Enter contact'/>");
		out.println("</div>");
		
		out.println("<div class='form-group'>");
		out.println("<input type='submit' name='s' value='Update' class='form-control'/>");
		out.println("</div>");
			
	    out.println("</div>");		
		out.println("</form>");
		
		
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
