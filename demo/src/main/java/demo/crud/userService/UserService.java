package demo.crud.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.crud.Student.Student;
import demo.crud.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public Student create(Student student)
	{
		return userRepository.save(student);
	}
	
	
	public List<Student> getAllStudent()
	{
		return userRepository.findAll();
		
	}
	
	public Student getById(int id)
	{
		return userRepository.findById(id).get();
	}
	
	public Student updateStudentById(int id,Student student)

	{
		Student std=userRepository.findById(id).orElse(null);
		if(std !=null)
		{
		std.setId(student.getId());
		std.setName(student.getName());
		std.setCity(student.getCity());
		return userRepository.save(std);
		
	}
	return userRepository.save(student);
	}
	
	public void deleteStudentById(int id)
	{
		userRepository.deleteById(id);
	}
	
	public void deleteAll(Student student)
	{
		userRepository.delete(student);
	}


}
