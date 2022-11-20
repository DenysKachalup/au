package service;

import entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee getEmployeeById(long id);

    boolean updateEmployee(Employee employee);

    boolean saveEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
