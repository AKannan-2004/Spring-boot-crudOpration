package crudMongo.application.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import crudMongo.application.employee.Employee;

public interface EmpRepository extends MongoRepository<Employee, String> {
	
	
//	Employee findByEmail(String email);
//	List<Employee> findByCity(String city);
	
	

//	List<Employee> findByCity(String city);
//	findByFieldOrderByField: For sorting queries.
//

//	List<Employee> findByCityOrderByNameAsc(String city);
//	findByFieldAndField: For querying with multiple fields.
//

//	List<Employee> findByCityAndJob(String city, String job);
//	Count: To count the number of documents.
//

//	long countByCity(String city);

}
