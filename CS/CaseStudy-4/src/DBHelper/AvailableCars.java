package DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Car;
import model.Vehicle;
import ConnectionUtil.ConnectionUtil;

public class AvailableCars {
	public static List<String> getAllCarMake() {
		Connection con = null;
		PreparedStatement ps = null;
		con = ConnectionUtil.getConnection();
		String query = "select distinct make from vehicle;";
		ResultSet rs = null;
		List<String> makeList = new ArrayList<String>();
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				makeList.add(rs.getString(1));
			}
		}catch (SQLException e) {
			e.printStackTrace();
			}
		finally {
			/* close connection */
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return makeList;
	}
}

