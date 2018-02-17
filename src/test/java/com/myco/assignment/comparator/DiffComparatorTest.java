package com.myco.assignment.comparator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myco.assignment.entity.MessageData;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiffComparatorTest {
	
	private DiffComparator diffComparator;
	private MessageData messageData;
	private String id = "1";
	private String leftData = "{\"name\":\"John\",\"age\":30,\"city\":\"Utrecht\"}";
	private String rightData = "{\"name\":\"John\",\"age\":31,\"city\":\"Utrecht\"}";
	private String rightDataBigger = "{\"name\":\"John\",\"age\":30,\"city\":\"IJsselstein/Utrecht\"}";
	private String jsonMessage = "[{\"offset\":22,\"length\":1}]";
	private String sameSize = "{message:\"left and right data values are the same\"}";
	private String differentSizes = "{message:\"left data and right data have different lengths\"}"; 
	
	@Before
	public void setup() {
		diffComparator = new DiffComparator();
	}
	
	@Test
	public void leftDataAddRightDataAreTheSame() {
		messageData = new MessageData(id, leftData, leftData);
		assertEquals(sameSize,diffComparator.dataComparison(messageData));
	}

	@Test
	public void leftDataAddRightDataHaveDifferentSize() {
		messageData = new MessageData(id, leftData, rightDataBigger);
		assertEquals(differentSizes,diffComparator.dataComparison(messageData));
	}
	
	@Test
	public void leftDataAddRightDataSameSizeDiffContent() {
		messageData = new MessageData(id, leftData, rightData);
		assertEquals(jsonMessage,diffComparator.dataComparison(messageData));
	}
	
}
