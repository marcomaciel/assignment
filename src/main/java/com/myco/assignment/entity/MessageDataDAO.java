/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myco.assignment.entity;

import java.util.HashMap;

/**
 * Class used to give access of DAO methods based on HashMaps
 *
 * @author Marco Maciel
 */
public class MessageDataDAO {

	private HashMap<String, MessageData> data = new HashMap<>();

	/**
	 * Saves a MessageData content in a HashMap<String, MessageData>
	 * 
	 * @param id Id of the message for comparison
	 * @param messageData MessageData object 
	 * @return
	 */
	public Boolean saveMessageData(MessageData messageData) {
		if (messageData == null){
			return false;
		}
		data.put(messageData.getId(), messageData);
		return true;
	}

	/**
	 * Gets a MessageData object by Id
	 * 
	 * @param id Id of the message for comparison
	 * @return MessageData object
	 */
	public MessageData getMessageData(String id) {
		if ((id.isEmpty()) || (id == null)){
			throw new NullPointerException();
		}
		return data.get(id);
	}

}
