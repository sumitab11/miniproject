package sumit.com.repository;

import sumit.com.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
   
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private List<Student> studlist;
	
	
	
	
	public StudentRepositoryImpl() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","sumit@1234");
			
			
		}catch(Exception ex) {
			
			System.out.println("Error" +ex);
		}
		 
		
		
		
	}
	@Override
	public boolean isAddNewStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			stmt=conn.prepareStatement("insert into student values('0',?,?,?)");
			stmt.setString(1,student.getName());
			stmt.setString(2,student.getEmail());
		    stmt.setString(3, student.getContact());	
		    int value=stmt.executeUpdate();
		    if(value>0) {
		    	return true;
		    }else {
		    	return false;
		    	
		    }
			
			
			
			
		}catch(Exception ex) {
			System.out.println("Error is " +ex);
			return false;
		}
	}
	@Override
	public List<Student> getAllStudentRecords() {
		// TODO Auto-generated method stub
		try {
			 studlist=new ArrayList<Student>();
			 
			stmt = conn.prepareStatement("select * from student");
			rs=stmt.executeQuery();
			while(rs.next()) {
				 
				Student student=new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setContact(rs.getString(4));
				studlist.add(student);
				
				
			}
		}catch(Exception ex){
			System.out.println("Error is" + ex);
			
		}
		
		return studlist;
	}
	@Override
	public boolean isDeleteRecord(int id) {
		// TODO Auto-generated method stub
		try {
			
			stmt=conn.prepareStatement("delete from student where sid=?");
			stmt.setInt(1, id);
			int value=stmt.executeUpdate();
			if(value>0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception ex) {
			
			System.out.println("error is" +ex);
			return false;
			}
		
		
	
	}

}
