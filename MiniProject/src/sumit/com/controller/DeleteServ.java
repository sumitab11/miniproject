package sumit.com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sumit.com.service.StudentService;
import sumit.com.service.StudentServiceImpl;

/**
 * Servlet implementation class DeleteServ
 */
@WebServlet("/del")
public class DeleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("delete");
		
		String studentId=request.getParameter("studentid");
		
		StudentService studService = new StudentServiceImpl();
		boolean b=studService.isDeleteRecord(Integer.parseInt(studentId));
		
		if(b) {
			RequestDispatcher r=request.getRequestDispatcher("view");
			r.forward(request,response);
		}else {
			out.println("Some problem is occur");
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
