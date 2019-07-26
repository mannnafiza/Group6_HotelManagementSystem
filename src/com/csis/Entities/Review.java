package com.csis.Entities;

import java.util.Vector;

public class Review {

	private Integer Id = 0;
    private String Comment;
	
    /**
     * constructor
     */
    public Review() {
    	
    }
	
    /**
     * 
     * @return the id of review
     */
	public Integer getId() {
		return Id;
	}

	/**
	 * 
	 * @param id the id of review
	 */
	public void setId(Integer id) {
		Id = id;
	}

	/**
	 * 
	 * @return the review comment
	 */
	public String getComment() {
		return Comment;
	}

	/**
	 * 
	 * @param comment is the review comment
	 */
	public void setComment(String comment) {
		Comment = comment;
	}

	/**
	 * 
	 * @return the vector for review
	 */
	public Vector getVector() {
		Vector v = new Vector();
		
		v.add(Id);
		v.add(Comment);
		
		
		return v;
	}
	
}
