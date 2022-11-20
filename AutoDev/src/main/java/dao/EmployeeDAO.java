package dao;

import entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployee();
    Employee getEmployeeById(long id);
    boolean updateEmployee(Employee employee);
    boolean saveEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}

