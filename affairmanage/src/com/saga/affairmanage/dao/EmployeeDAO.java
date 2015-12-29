package com.saga.affairmanage.dao;

import java.util.List;

import com.saga.affairmanage.bean.Employee;

public interface EmployeeDAO {
	public void addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(int employeeID);
	public List<Employee> findAllEmployee();
	public Employee findEmployeeById(int employeeID);
}
