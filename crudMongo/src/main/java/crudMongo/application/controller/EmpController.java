package crudMongo.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crudMongo.application.employee.Employee;
import crudMongo.application.userEmployee.UserService;

@RestController
@RequestMapping(value="/emp")
public class EmpController {
	
	@Autowired
	UserService empService;
	
	@PostMapping("/create")
	public Employee create(@RequestBody Employee employee)
	{
		return empService.create(employee);
		
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmployee()
	{
		return empService.getAllEmployyee();
		
	}
	
	@GetMapping("/get/{id}")
	public Employee getById(@PathVariable ("id") String id)
	{
		return empService.getByTd(id);
	}
	
	@PutMapping("/update/{id}")
	public Employee updateById(@PathVariable ("id") String id,@RequestBody Employee employee)
	{
		return empService.updateById(id, employee);
	}
	
	public void deleteById(@PathVariable String id)
	{
		empService.deleteById(id);
	}
	
	
}
