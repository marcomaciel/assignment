/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myco.assignment.entity;

/**
 * Model of a message data used for comparison of the left and right data 
 *
 * @author Marco Maciel
 */
public class MessageData {

	private String id;
	private String rightData;
	private String leftData;
	
	/**
	 * @param id Id of a message for comparison
	 */
	public MessageData(String id) {
		this.id = id;
	}

	public MessageData(String id, String leftData, String rightData) {
		super();
		this.id = id;
		this.rightData = rightData;
		this.leftData = leftData;
	}

	public String getId() {
		return id;
	}

	public String getRightData() {
		return rightData;
	}

	public String getLeftData() {
		return leftData;
	}

	public void setRightData(String rightData) {
		this.rightData = rightData;
	}

	public void setLeftData(String leftData) {
		this.leftData = leftData;
	}

	@Override
	public String toString() {
		return "MessageData{" + "id=" + id + ", leftData=" + leftData + ", rightData=" + rightData + '}';
	}

}
