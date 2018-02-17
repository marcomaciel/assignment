package com.myco.assignment.entity;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDataDAOTest {
	
	private MessageDataDAO msgDAO;
	private MessageData messageData;
	private String id = "1";

	@Test
	public void sendNullMessageDataToSaveReturnFalse() {
		msgDAO = new MessageDataDAO();
		assertFalse(msgDAO.saveMessageData(null));
	}
	
	@Test
	public void sendValidMessageDataToSaveReturnTrue() {
		msgDAO = new MessageDataDAO();
		messageData = new MessageData(id);
		assertTrue(msgDAO.saveMessageData(messageData));
	}

	@Test (expected = NullPointerException.class)
	public void nullIdParameterToGetMessageData() {
		msgDAO.getMessageData(null);
	}
	
	@Test (expected = NullPointerException.class)
	public void emptyIdParameterToGetMessageData() {
		msgDAO.getMessageData("");
	}
	
	@Test
	public void getMessageDataObjectById() {
		messageData = new MessageData(id,null,null);
		msgDAO = new MessageDataDAO();
		msgDAO.saveMessageData(messageData);
		assertTrue(msgDAO.getMessageData(id) instanceof MessageData);
	}

}
