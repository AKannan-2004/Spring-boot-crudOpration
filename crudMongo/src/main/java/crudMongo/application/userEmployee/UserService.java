package crudMongo.application.userEmployee;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crudMongo.application.employee.Employee;
import crudMongo.application.repository.EmpRepository;


@Service
public class UserService {
	
	@Autowired
	EmpRepository empRepository;
	
	public Employee create(Employee employee)
	{
		return empRepository.save(employee);
		
	}
	
	public List<Employee> getAllEmployyee()
	{
		return empRepository.findAll();
		
	}
	
	public Employee getByTd(String id)
	{
		return empRepository.findById(id).get();
	}
	
	public Employee updateById(String id,Employee employee)
	{
		Employee emp=empRepository.findById(id).orElse(null);
		if(emp !=null)
		{
			emp.setId(employee.getId());
			emp.setName(employee.getName());
			emp.setEmail(employee.getEmail());
			emp.setJop(employee.getJop());
			emp.setCity(employee.getCity());
			
			return empRepository.save(emp);
			
		}
		return empRepository.save(employee);
		
	}
	
	public void deleteById(String id)
	{
		empRepository.deleteById(id);
	}

	
	
	
}
