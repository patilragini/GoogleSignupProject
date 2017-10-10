package com.bridgelabz.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

public class LoginDao {
	public static String validate(String email, String password) {
		boolean status = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "google_signup";
		String driver = "com.mysql.jdbc.Driver";
		String userNameDB = "root";
		String passwordDB = "root";
		
		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(url + dbName, userNameDB, passwordDB);
			System.out.println("in logindao!!!");
			preparedStatement = connection.prepareStatement("select * from registration where email_id=? and password=?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			status = resultSet.next();			
			System.out.println("status " + status + " \n number of row affected : " + resultSet);
			String nameResult=resultSet.getString(2);
			System.out.println(nameResult);
			return nameResult;

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
