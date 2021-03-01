package sumit.com.repository;

import java.util.List;

import sumit.com.model.Student;

public interface StudentRepository {
  
	public boolean isAddNewStudent(Student student);
	public List<Student> getAllStudentRecords();
	public boolean isDeleteRecord(int id);
	
	
}
