package com.csis.ControllerTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.csis.Boundary.StaffDAO;
import com.csis.Entities.Staff;

class WhiteBoxStaffTest {
	
	StaffDAO staffDAO = new StaffDAO();
	Staff staff = new Staff();
	static ArrayList<Staff> member = new ArrayList<>();
	static int id;

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
		staff = staffDAO.getStaffMember(WhiteBoxStaffTest.id);
		staff.setCity("Vancouver");
		
		staffDAO.updateStaff(staff);
		
		WhiteBoxStaffTest.member = staffDAO.listStaff();
		
		assertEquals("Vancouver", WhiteBoxStaffTest.member.get(WhiteBoxStaffTest.member.size() - 1).getCity());
	}

	
	@Test
	void TestZDeleteStaff() {
		staffDAO.deleteStaffMember(WhiteBoxStaffTest.id);
		
		WhiteBoxStaffTest.member = staffDAO.listStaff();
		assertEquals("Johny", WhiteBoxStaffTest.member.get(WhiteBoxStaffTest.member.size() - 1).getUsername());
		
	}
}




