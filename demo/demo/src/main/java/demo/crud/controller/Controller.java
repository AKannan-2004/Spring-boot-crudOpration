package demo.crud.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.crud.Student.Student;
import demo.crud.userService.UserService;

	
	@RestController
	@RequestMapping(value = "/student")
	public class Controller {
		
		@Autowired
		UserService userService;
		
		@PostMapping("/add")
		public Student create(@RequestBody Student student)
		{
			return userService.create(student);
		}
		
		@GetMapping("/getAll")
		public List<Student> getAllStudent()
		{
			return userService.getAllStudent();
		}
		
		@GetMapping("/get/{id}")
		
		public Student getById(@PathVariable("id") int id)
		{
			return userService.getById(id);
		}
		
		@PutMapping("/update/{id}")
		public Student updateStudentById(@PathVariable ("id") int id,@RequestBody Student student)
		{
			return userService.updateStudentById(id, student);
		}
		
		@DeleteMapping("/delete/{id}")
		public void deleteStudentById(@PathVariable ("id") int id)
		{
			userService.deleteStudentById(id);
		}
		

	}

