package crudMongo.application.employee;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "emp")
public class Employee {
	@Id
	private String id;
	private String name;
	private  String email;
	private String job;
	private String city;
	
	
	public Employee(String id, String name, String email, String job, String city) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.job = job;
		this.city = city;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJop() {
		return job;
	}
	public void setJop(String job) {
		this.job = job;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
