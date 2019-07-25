package com.csis.SystemTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.csis.Boundary.AdminHome;
import com.csis.Boundary.AdminLogin;
import com.csis.Boundary.DBHelper;
import com.csis.Boundary.StaffDAO;
import com.csis.Controller.Authenticate;
import com.csis.Controller.Validate;
import com.csis.Entities.Staff;
import com.csis.Entities.UserInfo;

class AdminModuleTest {
	
	UserInfo user = new UserInfo();
	DBHelper helper = new DBHelper();
	StaffDAO staffDAO = new StaffDAO();
	Staff staff = new Staff();
	static ArrayList<Staff> member = new ArrayList<>();
	static int loginId;
	static int id;
	
	@Test
	void TestAAdminLogin() {
		Validate validate = new Validate("admin", "Admin123");
		Authenticate auth = new Authenticate();
		auth.setUsername("admin");
		auth.setPassword(AdminLogin.encrypt("Admin123"));
		user.setUsername("admin");
		loginId = helper.getUserId("Admin");
		user.setId(loginId);
		
		AdminHome.main(null, user);
		
		
	}
	

	@Test
	void TestAddStaff() {
		staff.setUsername("Chandler");
		staff.setPassword("Bing123");
		staff.setGender("Male");
		staff.setCity("Surrey");
		
		staffDAO.createStaff(staff.getUsername(), staff.getPassword(), staff.getGender(), staff.getCity());
		member = staffDAO.listStaff();
		
		assertEquals("Chandler", member.get(member.size() - 1).getUsername());
		assertEquals("Male", member.get(member.size() - 1).getGender());
		
		id = member.get(member.size() -1).getId();
		
	}
	
	
	@Test
	void TestUpdateStaff() {
		staff = staffDAO.getStaffMember(AdminModuleTest.id);
		staff.setCity("Vancouver");
		
		staffDAO.updateStaff(staff);
		
		AdminModuleTest.member = staffDAO.listStaff();
		
		assertEquals("Vancouver", AdminModuleTest.member.get(AdminModuleTest.member.size() - 1).getCity());
	}

	
	@Test
	void TestZDeleteStaff() {
		staffDAO.deleteStaffMember(AdminModuleTest.id);
		
		AdminModuleTest.member = staffDAO.listStaff();
		assertEquals("Johny", AdminModuleTest.member.get(AdminModuleTest.member.size() - 1).getUsername());
		
	}
}




