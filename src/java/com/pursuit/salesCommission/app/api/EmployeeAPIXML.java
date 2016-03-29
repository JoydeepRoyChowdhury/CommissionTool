package com.pursuit.salesCommission.app.api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import com.pursuit.salesCommission.app.model.Employee;


public class EmployeeAPIXML {
	private Connection connection;
	private Statement statement;

	public EmployeeAPIXML() { }
	
	public Employee createEmployee(long id, String name) throws ApplicationException{
		String query = "INSERT INTO Employees " +
                "VALUES (" + id + ", '" + name + "')";
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
}