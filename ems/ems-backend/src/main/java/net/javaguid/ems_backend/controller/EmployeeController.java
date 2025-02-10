package net.javaguid.ems_backend.controller;


import net.javaguid.ems_backend.entity.Employee;
import net.javaguid.ems_backend.repository.EmployeeRepository;
import net.javaguid.ems_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //this class become controller capable to handle all http requests
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:5500")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees(@RequestParam(required = false) Integer depno) {
        if (depno != null) {
            return employeeService.getEmployeesByDepartment(depno);
        }
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

}
