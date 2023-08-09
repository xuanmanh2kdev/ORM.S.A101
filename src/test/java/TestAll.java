import jakarta.persistence.PersistenceException;
import org.junit.jupiter.api.*;
import training.hibernate.day01.dao.EmployeeDao;
import training.hibernate.day01.dao.EmployeeDaoImpl;
import training.hibernate.day01.entities.Employee;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestAll {
    static EmployeeDao employeeDao;

    @BeforeAll
    static void beforeAll() {
        employeeDao = new EmployeeDaoImpl();
    }

    @Test
    @Order(1)
    void create_EmpRequireInfo_Success_Test() {
        Employee employee = new Employee();
        employee.setFirstName("First ");
        employee.setLastName("Last");

        employeeDao.create(employee);

        assertNotEquals(0, employee.getId());
    }

    @Test
    @Order(2)
    void create_EmpRequireInfo_Failed_Test() {
        Employee employee = new Employee();
        employee.setFirstName("First ");
//        employee.setLastName("Last");

        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

        assertThrows(PersistenceException.class,
                () -> employeeDao.create(employee));
    }

    @Test
    @Order(3)
    void get_EmployeeById_Success_Test() {
        assertNotNull(employeeDao.getEmployeeById(1));
    }

    @Test
    @Order(4)
    void get_EmployeeById_Failed_Test() {
        assertNull(employeeDao.getEmployeeById(100));
    }

    @Test
    @Order(5)
    void getAll_Employees_Success_Test() {
        assertTrue(employeeDao.getAllEmployees().size() > 0);
    }

    @Test
    @Order(6)
    void update_EmployeeById_Success_Test() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("First 2");
        employee.setLastName("Last 2");

        employeeDao.updateEmployeeByID(employee);

        assertEquals("First 2", employeeDao.getEmployeeById(1).getFirstName());
    }

    @Test
    @Order(7)
    void update_EmployeeById_Failed_Test() {
        Employee employee = new Employee();
        employee.setId(100);
        employee.setFirstName("First 1");
        employee.setLastName("Last 1");

        employeeDao.updateEmployeeByID(employee);

        assertNull(employeeDao.getEmployeeById(100));
    }


    @Test
    @Order(8)
    void delete_EmployeeById_Success_Test() {
        employeeDao.deleteEmployeeByID(1);

        assertNull(employeeDao.getEmployeeById(1));
    }

    @Test
    @Order(9)
    void delete_EmployeeById_Failed_Test() {
        employeeDao.deleteEmployeeByID(100);

        assertNull(employeeDao.getEmployeeById(100));
    }
}
