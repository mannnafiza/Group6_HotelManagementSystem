package com.csis.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.csis.Boundary.DBHelper;

public class AdminDAO {
	DBHelper helper = new DBHelper();
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;

	/**
	 * constructor
	 */
	public AdminDAO() {
		
	}
	
	/**
	  * @return list of user names
	  */
		public ArrayList<String> listAdminUserNames() 
		{
			ArrayList<String> s1 = new ArrayList<String>();

			String sql = "SELECT userName FROM admin_info";
			try {
				// connect to the database
				helper.connectDB();
				this.stmt = helper.getConnection().createStatement();
				rs = stmt.executeQuery(sql);

				while (rs.next())
				{
					s1.add(rs.getString("username"));				
				}

				helper.disconnectDB();
			} catch (SQLException sx) {
				System.out.println("Error fetching data from the database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
			}

			return s1;
		}
		
		
		/**
		  * 
		  * @param usernm, user name for whom password is being fetched
		  * @return password for specific user
		  */
		public String getAdminPassword(String usernm) {

			String s1 = "";
			String sql = "SELECT password FROM admin_info where userName = '" + usernm + "'";
			try {
				// connect to the database
				helper.connectDB();
				this.stmt = helper.getConnection().createStatement();
				rs = stmt.executeQuery(sql);

				while (rs.next())
				{			
					s1 = rs.getString(1);
				}

				helper.disconnectDB();
			} catch (SQLException sx) {
				System.out.println("Error fetching data from the database");
				System.out.println(sx.getMessage());
				System.out.println(sx.getErrorCode());
				System.out.println(sx.getSQLState());
			}

			return s1;
		}

}
