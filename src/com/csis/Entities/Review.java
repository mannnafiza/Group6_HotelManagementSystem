package com.csis.Entities;

import java.util.Vector;

public class Review {

	private Integer Id = 0;
    private String Comment;
	
	
    
	public Integer getId() {
		return Id;
	}



	public void setId(Integer id) {
		Id = id;
	}



	public String getComment() {
		return Comment;
	}



	public void setComment(String comment) {
		Comment = comment;
	}



	public Vector getVector() {
		Vector v = new Vector();
		
		v.add(Id);
		v.add(Comment);
		
		
		return v;
	}
	
}
