package net.javaguid.ems_backend.repository;

import net.javaguid.ems_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//EmployeeRepository gets crud operation from JPARepository

public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
    List<Employee> findByDepartment(int department);
}
