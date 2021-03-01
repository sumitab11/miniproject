package sumit.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sumit.com.model.Student;
import sumit.com.service.StudentService;
import sumit.com.service.StudentServiceImpl;

/**
 * Servlet implementation class ViewStudent
 */
@WebServlet("/view")
public class ViewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		 
		RequestDispatcher r=request.getRequestDispatcher("adminmaster.html");
		r.include(request, response);
		
		StudentService studService=new StudentServiceImpl();
		List<Student> studlist=studService.getAllStudentRecords();
		out.println("<table class='table'>");
		out.println("<tr><th scope='col'>Name</th><th scope='col'>Email</th><th scope='col'>Contact</th><th scope='col'>Delete</th><th scope='col'>Update</th></tr>");
		
		
		for(Student student:studlist) {
			int id =student.getId();
			String name=student.getName();
			String email=student.getEmail();
			String contact=student.getContact();
			
			
		out.println("<tr scope='row'>");
		
		out.println("<td>" + name + "</td>");
		out.println("<td>" + email + "</td>");
		out.println("<td>" + contact + "</td>");
		out.println("<td><a href='del?studentid=" +id+ "'>Delete</a></td>");
		out.println("<td><a href='update?name="+name+"&email="+email+"&contact="+contact+"'>Update</a></td>");
		
		out.println("</tr>"); 
			
		}
		out.println("</table>");
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
