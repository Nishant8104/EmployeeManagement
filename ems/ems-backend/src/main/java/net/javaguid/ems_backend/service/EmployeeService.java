package net.javaguid.ems_backend.service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import net.javaguid.ems_backend.entity.Employee;
import net.javaguid.ems_backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    @Transactional
    public void init() {
        // Add some initial data if table is empty
        if (employeeRepository.count() == 0) {
            employeeRepository.save(new Employee(0, "John Doe", 101, "john@example.com", "Developer"));
            employeeRepository.save(new Employee(0, "Jane Smith", 102, "jane@example.com", "Manager"));
            employeeRepository.save(new Employee(0, "Bob Johnson", 101, "bob@example.com", "Tester"));
        }
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesByDepartment(int department) {
        return employeeRepository.findByDepartment(department);
    }

    @Transactional
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
