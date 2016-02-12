package com.pursuit.salesCommission.app.api.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import com.pursuit.salesCommission.app.api.dao.ConnectionFactory;
import com.pursuit.salesCommission.app.model.Employee;
import com.pursuit.salesCommission.app.api.dao.ApplicationException;

public class EmployeeDaoAnother {
	private Connection connection;
	private Statement statement;

	public EmployeeDaoAnother() { }
	public Employee createEmployee(int id, String name) throws ApplicationException{
		String query = "INSERT INTO Employees " +
                "VALUES (" + id + ", '" +name + "')";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
			SQLWarning warning = statement.getWarnings();
			if (warning != null)
				throw new ApplicationException(warning.getMessage());
		} catch (SQLException e) {
			ApplicationException exception = new ApplicationException(
					e.getMessage(), e);
			throw exception;
		} finally {
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		//return new Employee(id, name);
		return new Employee();
	}
	 public Employee getEmployee(int employeeId) throws SQLException {
	        String query = "SELECT * FROM Employees WHERE id=" + employeeId;
	        ResultSet rs = null;
	        Employee employee = null;
	        try {
	            connection = ConnectionFactory.getConnection();
	            statement = connection.createStatement();
	            rs = statement.executeQuery(query);
	            if (rs.next()) {
	                employee = new Employee();
	                employee.setId(rs.getInt("id"));
	                employee.setName(rs.getString("name"));
	               // employee.setRole(rs.getString("role"));
	               // employee.setSalary(rs.getInt("salary"));
	                //employee.setDeptId((rs.getInt("managerId")));
	            }
	        } finally {
	            DBUtil.close(rs);
	            DBUtil.close(statement);
	            DBUtil.close(connection);
	        }
	        return employee;
	    }
}
