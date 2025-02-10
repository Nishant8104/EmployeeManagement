package net.javaguid.ems_backend;

import net.javaguid.ems_backend.entity.Employee;
import net.javaguid.ems_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmsBackendApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(EmsBackendApplication.class, args);
	}


}
