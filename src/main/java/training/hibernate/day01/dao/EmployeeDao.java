package training.hibernate.day01.dao;

import training.hibernate.day01.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {

    void create(Employee employee);

    Optional<Employee> getEmployeeById(Integer id);

    List<Employee> getAllEmployees();

    Optional<Employee> updateEmployeeByID(Employee employee);

    Optional<Employee> deleteEmployeeByID(Integer id);

}
