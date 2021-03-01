package sumit.com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sumit.com.model.Student;
import sumit.com.service.StudentServiceImpl;

/**
 * Servlet implementation class AddNewStudent
 */
@WebServlet("/Add")
public class AddNewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	RequestDispatcher r=request.getRequestDispatcher("adminmaster.html");
	r.include(request, response);
	out.println("<br>");
	out.println("<form name='frm' action='' method='GET'>");
	
	out.println("<div class='container mt-4'>"); 
	out.println("<div class='form-group'>");
	out.println("<input type='text' name='name' value='' class='form-control' placeholder='Enter name'/>");
	out.println("</div>");
		
	out.println("<div class='form-group'>");
	out.println("<input type='text' name='email' value='' class='form-control' placeholder='Enter email'/>");
	out.println("</div>");
	
	out.println("<div class='form-group'>");
	out.println("<input type='text' name='contact' value='' class='form-control' placeholder='Enter contact'/>");
	out.println("</div>");
	
	out.println("<div class='form-group'>");
	out.println("<input type='submit' name='s' value='Add New Student' class='form-control'/>");
	out.println("</div>");
		
    out.println("</div>");		
	out.println("</form>");	 
		
	String btn=request.getParameter("s");
	 if(btn!=null) {
		 String name=request.getParameter("name");
		 String email=request.getParameter("email");
		 String contact=request.getParameter("contact");
		   
		 Student student=new Student();
		 student.setName(name);
		 student.setEmail(email);
		 student.setContact(contact);
		 
		 StudentServiceImpl studService=new StudentServiceImpl();
		 boolean b=studService.isAddNewStudent(student);
		 
		 if(b) {
			 out.println("<div class='container'><span class='btn btn-success' 'form-control'>Record Save Successfully</span></div>");
		 }else {
			 out.println("<center class='btn btn-danger'>Record Not Save</center>");
		 }
	 }
	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
