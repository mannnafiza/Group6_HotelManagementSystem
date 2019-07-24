package com.csis.Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.csis.Boundary.DBHelper;

public class HomeDAO {

	DBHelper helper = new DBHelper();
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	
	public HomeDAO() {	}

	/**
	  * @return list of usernames
	  */
		public ArrayList<String> listUserNames() 
		{
			ArrayList<String> s1 = new ArrayList<String>();

			String sql = "SELECT userName FROM user_Info";
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
		  * @param usernm, username for whom password is being fetched
		  * @return password for specific user
		  */
		public String getPassword(String usernm) {

			String s1 = "";
			String sql = "SELECT password FROM user_Info where userName = '" + usernm + "'";
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
