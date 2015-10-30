package DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogIn {
	public static boolean isValidAdmin(Connection connnection,String email,String password) {
		PreparedStatement ps = null;
		String query = "Select * from admin";
		ResultSet rs = null;
		boolean isLogInCorrect = false;
		try {
			ps = connnection.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getString(1).equalsIgnoreCase(email) && rs.getString(2).equalsIgnoreCase(password)) {
					isLogInCorrect = true;
					break;
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
			}
		finally {
			/* close prepared statement */
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
			}
		}
		return isLogInCorrect;
	}
}
