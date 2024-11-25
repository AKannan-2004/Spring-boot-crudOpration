package crudMongo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class CrudApplication  {
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
		
	}
}
//public static void main(String[] args) {
//    SpringApplication app = new SpringApplication(Application.class);
//    app.setDefaultProperties(Collections.singletonMap("server.port", "8085"));
//    app.run(args);