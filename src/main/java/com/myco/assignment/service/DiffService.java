/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myco.assignment.service;

import com.myco.assignment.comparator.DiffComparator;
import com.myco.assignment.entity.MessageData;
import com.myco.assignment.entity.MessageDataDAO;

/**
 * Service to provide access to the RestControler class
 *
 * @author Marco Maciel
 */
public class DiffService {

	private MessageDataDAO messageDataDAO = new MessageDataDAO();

	/**
	 * Saves the right data into a MessageData object by Id
	 * 
	 * @param id Id of the message for comparison
	 * @param data Valeu of the right input
	 * @return
	 */
	public Boolean saveRightData(final String id, final String data) {

		if (id.isEmpty() || data.isEmpty()) {
			return false;
		}

		MessageData messageData = messageDataDAO.getMessageData(id);

		if (messageData == null) {
			messageData = new MessageData(id);
		}
		messageData.setRightData(data);

		return messageDataDAO.saveMessageData(messageData);
	}
	
	/**
	 * Saves the left data into a MessageData object by Id
	 * 
	 * @param id Id of the message for comparison
	 * @param data Valeu of the left input
	 * @return
	 */
	public Boolean saveLeftData(final String id, final String data) {

		if (id.isEmpty() || data.isEmpty()) {
			return false;
		}

		MessageData messageData = messageDataDAO.getMessageData(id);

		if (messageData == null) {
			messageData = new MessageData(id);
		}

		messageData.setLeftData(data);

		return messageDataDAO.saveMessageData(messageData);
	}

	/**
	 * 	Gets a MessageData object by Id
	 * @param id Id of the message
	 * @return MessageData object
	 */
	public MessageData getMessageDataById(String id) {
		return messageDataDAO.getMessageData(id);
	}

	/**
	 * Get the result of the comparison of a MessageData values by Id
	 * 
	 * @param id Id of the MessageData object used for comparison
	 * @return Result message of the comparison between left and right data by id
	 */
	public String getMessageDataDifferences(String id) {
		MessageData messageData = messageDataDAO.getMessageData(id);
		
		if (messageData.getLeftData() == null) {
			return "[{Left data is empty}]";
		}
		
		if (messageData.getRightData() == null) {
			return "[{Righ data is empty}]";
		}

		DiffComparator diffComparator = new DiffComparator();
		return diffComparator.dataComparison(messageData);

	}

}
