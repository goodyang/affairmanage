package com.saga.affairmanage.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saga.affairmanage.bean.Employee;
import com.saga.affairmanage.dao.EmployeeDAO;
import com.saga.affairmanage.util.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void addEmployee(Employee employee) {
		Connection conn = DBConnection.getConnection();
		String addSQL = "insert into employee values(?,?,?,?,?,?,?,?,?)";
		
		if(employee != null && employee.getEmployeeID()>0) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				int index = 1;
				pstmt = conn.prepareStatement(addSQL);
				pstmt.setInt(index, employee.getEmployeeID());
				pstmt.setString(index++, employee.getEmployeeName());
				pstmt.setBoolean(index++, employee.isEmployeeSex());
				pstmt.setDate(index++, new Date(employee.getEmployeeBirth().getTime()));
				pstmt.setString(index++, employee.getEmployeePhone());
				pstmt.setString(index++, employee.getEmployeePlace());
				pstmt.setDate(index++, new Date(employee.getJoinTime().getTime()));
				pstmt.setString(index++, employee.getPassword());
				pstmt.setBoolean(index, employee.isLead());
				rs = pstmt.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBConnection.close(rs);
				DBConnection.close(pstmt);
				DBConnection.close(conn);
			}
		}	
	}

	@Override
	public void updateEmployee(Employee employee) {
		Connection conn = DBConnection.getConnection();
		String updateSQL = "update employee set employeeName=?, employeeSex=?,"+
				" employeeBirth=?, employeePhone=?, employeePlace=?, joinTime=?,password=?,isLead=?"+
				" where employeeID=?";
		Employee testEmployee = null;
		if(employee.getEmployeeID()>0){
			testEmployee = findEmployeeById(employee.getEmployeeID());
		}
		if(testEmployee != null) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				int index = 1;
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(index++, employee.getEmployeeName());
				pstmt.setBoolean(index++, employee.isEmployeeSex());
				pstmt.setDate(index++, new Date(employee.getEmployeeBirth().getTime()));
				pstmt.setString(index++, employee.getEmployeePhone());
				pstmt.setString(index++, employee.getEmployeePlace());
				pstmt.setDate(index++, new Date(employee.getJoinTime().getTime()));
				pstmt.setString(index++, employee.getPassword());
				pstmt.setBoolean(index, employee.isLead());
				rs = pstmt.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBConnection.close(rs);
				DBConnection.close(pstmt);
				DBConnection.close(conn);
			}
		}		
	}

	@Override
	public void deleteEmployee(int employeeID) {
		Connection conn = DBConnection.getConnection();
		String deleteByIDSQL = "delete from employee where employeeID=?";
		Employee employee = findEmployeeById(employeeID);
		if(employee != null) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(deleteByIDSQL);
				pstmt.setInt(1, employeeID);
				rs = pstmt.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBConnection.close(rs);
				DBConnection.close(pstmt);
				DBConnection.close(conn);
			}
		}		
	}

	@Override
	public List<Employee> findAllEmployee() {
		List<Employee> employeeList = new ArrayList<Employee>();
		Connection conn = DBConnection.getConnection();
		String findALLSQL = "select * from employee ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee employee = null;
		
		try {
			pstmt = conn.prepareStatement(findALLSQL);
			rs = pstmt.executeQuery();
			while(rs!=null && rs.next()) {
				employee = new Employee();
				int index = 1;
				employee.setEmployeeID(rs.getInt(index++));
				employee.setEmployeeName(rs.getString(index++));
				employee.setEmployeeSex(rs.getBoolean(index++));
				employee.setEmployeeBirth(rs.getDate(index++));
				employee.setEmployeePhone(rs.getString(index++));
				employee.setEmployeePlace(rs.getString(index++));
				employee.setJoinTime(rs.getDate(index++));
				employee.setPassword(rs.getString(index++));
				employee.setLead(rs.getBoolean(index++));
				
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return employeeList;
	}

	@Override
	public Employee findEmployeeById(int employeeID) {
		Connection conn = DBConnection.getConnection();
		String findByIDSQL = "select * from employee where employeeID=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee employee = null;
		
		try {
			pstmt = conn.prepareStatement(findByIDSQL);
			pstmt.setInt(1, employeeID);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				employee = new Employee();
				int index = 1;
				employee.setEmployeeID(rs.getInt(index++));
				employee.setEmployeeName(rs.getString(index++));
				employee.setEmployeeSex(rs.getBoolean(index++));
				employee.setEmployeeBirth(rs.getDate(index++));
				employee.setEmployeePhone(rs.getString(index++));
				employee.setEmployeePlace(rs.getString(index++));
				employee.setJoinTime(rs.getDate(index++));
				employee.setPassword(rs.getString(index++));
				employee.setLead(rs.getBoolean(index++));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs);
			DBConnection.close(pstmt);
			DBConnection.close(conn);
		}
		return employee;
	}
	
}
