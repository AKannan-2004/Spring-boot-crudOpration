package demo.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import demo.crud.Student.Student;

public interface UserRepository extends JpaRepository<Student, Integer>
{
	
}


