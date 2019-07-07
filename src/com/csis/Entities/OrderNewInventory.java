package com.csis.Entities;

import java.util.Vector;

public class OrderNewInventory {
	
	private String Item;
	private Integer Quantity = 0;
	private float UnitPrice = 0;
	private float Amount = 0;
	
	
	/**
	 * @return the item
	 */
	public String getItem() {
		return Item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(String item) {
		Item = item;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return Quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	/**
	 * @return the unitPrice
	 */
	public float getUnitPrice() {
		return UnitPrice;
	}
	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(float unitPrice) {
		UnitPrice = unitPrice;
	}
	/**
	 * @return the amount
	 */
	public float getAmount() {
		return Amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(float amount) {
		Amount = amount;
	}
	
	
	public Vector getVector() {
		Vector v = new Vector();
		
		//	itemId, Item, Type, Quantity , Category , Unitprice , Price

		
		//v.add(itemId);
		v.add(Item);
		v.add(Quantity);
		v.add(UnitPrice);
		v.add(Amount);
	
		
		return v;
	}


}
