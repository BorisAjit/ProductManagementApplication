package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbutil.DbUtil;
import pojo.LoginInfo;

public class LoginDao {
	public static boolean isUserValid(LoginInfo userDetails) {
		boolean validStatus = false;
		try {
			Connection conn = DbUtil.getConnection();
			Statement stmnt = conn.createStatement();
			ResultSet rs = stmnt
					.executeQuery(String.format("select * from login_info where user_name='%s' and password='%s'",
							userDetails.getUserName(), userDetails.getPassword()));
			while(rs.next()) {
				validStatus = true;
			}
			DbUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return validStatus;
	}
}
