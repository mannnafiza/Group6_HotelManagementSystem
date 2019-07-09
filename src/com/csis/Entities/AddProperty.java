package com.csis.Entities;

import java.util.Vector;

public class AddProperty {
	
	private Integer itemId = 0;
	private String Item;
	private String Type;
	private Integer Quantity = 0;
	private float Price  = 0;
	private String Category ;
	private float Unitprice = 0;
	
	
	
	/**
	 * @return the itemId
	 */
	public Integer getItemId() {
		return itemId;
	}
	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
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
	 * @return the type
	 */
	public String getType() {
		return Type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		Type = type;
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
	 * @return the price
	 */
	public float getPrice() {
		return Price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		Price = price;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return Category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		Category = category;
	}
	/**
	 * @return the unitprice
	 */
	public float getUnitprice() {
		return Unitprice;
	}
	/**
	 * @param unitprice the unitprice to set
	 */
	public void setUnitprice(float unitprice) {
		Unitprice = unitprice;
	}
	

	public Vector getVector() {
		Vector v = new Vector();
		
		//	itemId, Item, Type, Quantity , Category , Unitprice , Price

		
		v.add(itemId);
		v.add(Item);
		v.add(Type);
		v.add(Quantity);
		v.add(Price);
		v.add(Category);
		v.add(Unitprice);
	
		
		return v;
	}

	public void validateTheProperty() {
		
		
	}
	

}
