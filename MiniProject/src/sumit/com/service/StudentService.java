package sumit.com.service;

import java.util.List;

import sumit.com.model.Student;

public interface StudentService {

	public boolean isAddNewStudent(Student student);
	public List<Student> getAllStudentRecords();
	public boolean isDeleteRecord(int id);
	
	
}
