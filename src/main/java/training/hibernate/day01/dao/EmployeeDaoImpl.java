package training.hibernate.day01.dao;

import org.hibernate.Session;
import training.hibernate.day01.entities.Employee;
import training.hibernate.day01.utils.XmlConnectionConfig;
import java.util.List;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public void create(Employee employee) {
        try(Session session = XmlConnectionConfig.getSession()){
            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();
        }
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
        try(Session session = XmlConnectionConfig.getSession()){
            Employee employee =  session.find(Employee.class, id);
            if(employee == null){
                return null;
            }
            return Optional.of(employee);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        try(Session session = XmlConnectionConfig.getSession()){
            return session.createQuery("SELECT e from Employee e", Employee.class).getResultList();
        }
    }

    @Override
    public Optional<Employee> updateEmployeeByID(Employee employee) {
        try (Session session = XmlConnectionConfig.getSession()) {
            session.beginTransaction();
            Employee employee2 = session.find(Employee.class, employee.getId());
            if (employee2 == null) {
                return null;
            } else {
                session.merge(employee);
                session.getTransaction().commit();
                return Optional.of(employee);
            }
        }
    }

    @Override
    public Optional<Employee> deleteEmployeeByID(Integer id) {
        try(Session session = XmlConnectionConfig.getSession()){
            session.beginTransaction();
            Employee employee = session.find(Employee.class, id);
            if (employee == null) {
                return null;
            }else {
                session.delete(employee);
                session.getTransaction().commit();
                return Optional.of(employee);
            }
        }
    }
}
