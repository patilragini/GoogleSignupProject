/****************************************************************************** 
 *  @author  Ragini Patil
 *  @version 1.0
 *  @since   5-10-2017
 *	@purpose RegisterDao is class responsible for Database related operations
 *			 while registration.
 *			
 *			 
 ******************************************************************************/
package com.bridgelabz.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import com.bridgelabz.Component.Registration;

public class RegisterDao {
/**
 * 
 * @param user Registration
 * @return boolean 
 * @throws SQLException
 * @throws ClassNotFoundException
 * <p>register accepts object user of type Registration having name ,emailid,phonenumber,password
 *    and enter details  in database  return true if insert is sucessfull
 */
	public static boolean register(Registration user) throws SQLException, ClassNotFoundException {
		//System.out.println("Jdbc Database Meta Data");
		Class.forName("com.mysql.jdbc.Driver");
		/*System.out.println("dao register details !!! :\n" + user.getName() + " " + user.getEmail() + " "
				+ user.getPassword() + "  " + user.getphoneNumber());*/

		Connection connection = null;		
		String url = "jdbc:mysql://localhost:3306/google_signup";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		connection = DriverManager.getConnection(url, userName, password);
		//System.out.println("connction done");
		try {
			String SQL = "insert into registration (name,email_id,password,phone_number) values(?,?,?,?)";
			//System.out.println("connection done!!!!!!!!");
			
			java.sql.PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setLong(4, user.getphoneNumber());
			int rows = preparedStatement.executeUpdate();
			//System.out.println(rows + " records affected");
			return true;
		} catch (Exception e) {	
			
			e.printStackTrace();
		//	System.out.println("catch");
			return false;
		}
	}

}
