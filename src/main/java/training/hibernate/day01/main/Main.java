package training.hibernate.day01.main;

import training.hibernate.day01.dao.EmployeeDaoImpl;
import training.hibernate.day01.entities.Employee;
public class Main {

    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setFirstName("First ");
        employee.setLastName("Last");

        Employee employee1 = new Employee();
        employee1.setFirstName("First1 ");
        employee1.setLastName("Last1");

        Employee employee2 = new Employee();
        employee2.setFirstName("First2 ");
        employee2.setLastName("Last2");

        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        employeeDao.create(employee);
        employeeDao.create(employee1);
        employeeDao.create(employee2);

        employeeDao.getAllEmployees().forEach(System.out::println);

        System.out.println("-------------------------------------------------");

        System.out.println(employeeDao.getEmployeeById(2));

        System.out.println("-------------------------------------------------");

        Employee employee3 = new Employee();
        employee3.setId(3);
        employee3.setFirstName("First3 ");
        employee3.setLastName("Last3");

        System.out.println(employeeDao.updateEmployeeByID(employee3));

        employeeDao.getAllEmployees().forEach(System.out::println);

        System.out.println("-------------------------------------------------");

        System.out.println(employeeDao.deleteEmployeeByID(2));

        employeeDao.getAllEmployees().forEach(System.out::println);
    }
}
