import org.junit.jupiter.api.*;
import training.hibernate.day01.dao.EmployeeDao;
import training.hibernate.day01.dao.EmployeeDaoImpl;
import training.hibernate.day01.entities.Employee;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDaoImplTest {
    static EmployeeDao employeeDao;

    @BeforeAll
    static void beforeAll() {
        employeeDao = new EmployeeDaoImpl();
    }

    @Test
    void create_Employee_Success_Test() {
        Employee employee = new Employee();
        employee.setFirstName("First ");
        employee.setLastName("Last");

        employeeDao.create(employee);
    }

    @Test
    void get_EmployeeById_Success_Test() {
        assertNotNull(employeeDao.getEmployeeById(1));
    }

    @Test
    void get_EmployeeById_Failed_Test() {
        assertNull(employeeDao.getEmployeeById(100));
    }

    @Test
    void getAll_Employees_Success_Test() {
        assertTrue(employeeDao.getAllEmployees().size() > 0);
    }

    @Test
    void update_EmployeeById_Success_Test() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("First 2");
        employee.setLastName("Last 2");

        assertNotNull(employeeDao.updateEmployeeByID(employee));
    }

    @Test
    void update_EmployeeById_Failed_Test() {
        Employee employee = new Employee();
        employee.setId(100);
        employee.setFirstName("First 1");
        employee.setLastName("Last 1");

        assertNull(employeeDao.updateEmployeeByID(employee));
    }

    @Test
    void delete_EmployeeById_Success_Test() {
        assertNull(employeeDao.deleteEmployeeByID(1));
    }

    @Test
    void delete_EmployeeById_Failed_Test() {
        assertNull(employeeDao.deleteEmployeeByID(100));
    }
}
