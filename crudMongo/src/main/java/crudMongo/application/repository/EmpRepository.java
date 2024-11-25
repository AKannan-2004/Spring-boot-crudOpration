package crudMongo.application.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import crudMongo.application.employee.Employee;

public interface EmpRepository extends MongoRepository<Employee, String> {
	
	
//	Employee findByEmail(String email);
//	List<Employee> findByCity(String city);
	
	
//	4. Using Spring Data MongoDB Query Methods
//	Here are some of the most commonly used query methods in Spring Data MongoDB:
//
//	findByField: Automatically converts method names into queries.
//
//	java
//	Copy code
//	List<Employee> findByCity(String city);
//	findByFieldOrderByField: For sorting queries.
//
//	java
//	Copy code
//	List<Employee> findByCityOrderByNameAsc(String city);
//	findByFieldAndField: For querying with multiple fields.
//
//	java
//	Copy code
//	List<Employee> findByCityAndJob(String city, String job);
//	Count: To count the number of documents.
//
//	java
//	Copy code
//	long countByCity(String city);

}
