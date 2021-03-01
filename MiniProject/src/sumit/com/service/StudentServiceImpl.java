package sumit.com.service;

import java.util.List;

import sumit.com.model.Student;
import sumit.com.repository.StudentRepositoryImpl;

public class StudentServiceImpl implements StudentService{
 
	StudentRepositoryImpl studRepo=new StudentRepositoryImpl();
	
	@Override
	public boolean isAddNewStudent(Student student) {
		// TODO Auto-generated method stub
		return studRepo.isAddNewStudent(student);
	}

	@Override
	public List<Student> getAllStudentRecords() {
		// TODO Auto-generated method stub
		return studRepo.getAllStudentRecords();
	}

	@Override
	public boolean isDeleteRecord(int id) {
		// TODO Auto-generated method stub
		return studRepo.isDeleteRecord(id);
	}

}
