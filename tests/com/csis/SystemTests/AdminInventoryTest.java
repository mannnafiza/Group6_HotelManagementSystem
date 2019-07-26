package com.csis.SystemTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import com.csis.Boundary.AdminLogin;
import com.csis.Boundary.DBHelper;
import com.csis.Boundary.ManageInventory;
import com.csis.Controller.Authenticate;
import com.csis.Controller.ChangeInventoryDAO;
import com.csis.Controller.OrderInventoryDAO;
import com.csis.Controller.PropertyInventoryDAO;
import com.csis.Controller.Validate;
import com.csis.Entities.AddProperty;
import com.csis.Entities.OrderNewInventory;
import com.csis.Entities.UserInfo;

class AdminInventoryTest {

	static UserInfo user = new UserInfo();
	DBHelper helper = new DBHelper();
	static ArrayList<AddProperty> orderList = new ArrayList<>();
	OrderNewInventory order = new OrderNewInventory();
	AddProperty property = new AddProperty();
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
	}
	
	
	@Test
	void TestAddNewInventory() {
		OrderInventoryDAO orderDAO = new OrderInventoryDAO(AdminInventoryTest.user);
		order.setItem("Iron");
		order.setAmount(500);
		order.setQuantity(2);
		order.setUnitPrice(250);
		
		orderDAO.AddOrderInventory(order);
		ArrayList<OrderNewInventory> orderList = new ArrayList<>();
		orderList = orderDAO.listAddOrderInventory();
		
		assertEquals("Iron", orderList.get(orderList.size() - 1).getItem());
	}
	
	
	@Test
	void TestAddInventory() {
		PropertyInventoryDAO inventory = new PropertyInventoryDAO(AdminInventoryTest.user);
		ManageInventory manage = new ManageInventory(AdminInventoryTest.user);
		
		property.setItem("Towels");
		property.setCategory("House Keeping");
		property.setPrice(5000);
		property.setQuantity(50);
		property.setUnitprice(100);
		property.setType("Bath Towels");
		inventory.AddPropertyInv(property);
		orderList = manage.listAddPropertyInventory();
		assertEquals("Towels", orderList.get(orderList.size() - 1).getItem());
		assertEquals(100, orderList.get(orderList.size() - 1).getUnitprice());
		id = orderList.get(orderList.size() - 1).getItemId();
		
	}
	
	@Test
	void TestUpdateInventory() {
		ChangeInventoryDAO change = new ChangeInventoryDAO(AdminInventoryTest.user);
		ManageInventory manage = new ManageInventory(AdminInventoryTest.user);
		
		
		property = change.getProperty(id);
		property.setPrice(6000);
		change.updateInventory(property);
		
		orderList = manage.listAddPropertyInventory();
		
		assertEquals(6000, orderList.get(orderList.size() - 1).getPrice());
	}
}


