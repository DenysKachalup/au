package entity;

import entity.enumeration.EmployeeRole;

public class Employee extends User{
    private EmployeeRole employeeRole;

    public Employee(final long id, final String name, final String surname, final String number, final EmployeeRole employeeRole) {
        super(id, name, surname, number);
        this.employeeRole = employeeRole;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(final EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }


}
