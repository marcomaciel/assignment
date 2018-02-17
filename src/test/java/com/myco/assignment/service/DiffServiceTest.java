package com.myco.assignment.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myco.assignment.entity.MessageData;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiffServiceTest {
	
	private DiffService diffService;
	
	private String id = "1";
	private String leftData = "{\"name\":\"John\",\"age\":30,\"city\":\"Utrecht\"}";
	private String rightData = "{\"name\":\"John\",\"age\":31,\"city\":\"Utrecht\"}";
	private String jsonMessage = "[{\"offset\":22,\"length\":1}]";
	
	@Before
	public void setup() {
		diffService = new DiffService();
	}
	
	@Test
	public void saveRightData() {
		assertTrue(diffService.saveLeftData(id, rightData));
	}
	
	@Test
	public void saveLeftData() {
		assertTrue(diffService.saveLeftData(id, leftData));
	}
	
	@Test
	public void leftDataIsEmpty() {
		assertFalse(diffService.saveLeftData(id, ""));
	}
	
	@Test
	public void rightDataIsEmpty() {
		assertFalse(diffService.saveRightData(id, ""));
	}
	
	@Test
	public void returnDifferencesBetweenDatas() {
		diffService.saveLeftData(id, leftData);
		diffService.saveRightData(id, rightData);
		assertEquals(jsonMessage, diffService.getMessageDataDifferences(id));
	}
	
	@Test
	public void returnMessageDataObject() {
		diffService.saveLeftData(id, leftData);
		assertTrue(diffService.getMessageDataById(id) instanceof MessageData);
	}
	

}
