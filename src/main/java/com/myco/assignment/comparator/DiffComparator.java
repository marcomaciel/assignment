package com.myco.assignment.comparator;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.myco.assignment.entity.DiffResult;
import com.myco.assignment.entity.MessageData;

/**
 *
 * @author Marco Maciel
 */
public class DiffComparator {

	/**
	 * Compares the left and right data of a MessageData object and gives the result in JSON format
	 * 
	 * @param messageData MessageData object used for storing id of the message, left and right data
	 * @return Result message of the comparison
	 */
	public String dataComparison(MessageData messageData) {

		String leftData = messageData.getLeftData();
		String rightData = messageData.getRightData();

		if (leftData.equals(rightData)) {
			return "{message:\"left and right data values are the same\"}";
		} else if (leftData.length() != rightData.length()) {
			return "{message:\"left data and right data have different lengths\"}";
		} else {
			Gson gsonBuilder = new GsonBuilder().create();
			String jsonFromPojo = gsonBuilder.toJson(getDiffResult(leftData, rightData));
			return jsonFromPojo;
		}

	}

	/**
	 * Process two Strings and return a list with offset and length of the differences
	 * 
	 * @param leftData String with the left data for comparison
	 * @param rightData String with the left data for comparison
	 * @return List of DiffResult objects with all difference found
	 */
	private ArrayList<DiffResult> getDiffResult(String leftData, String rightData) {
		ArrayList<DiffResult> diffResult = new ArrayList<>();

		boolean isDiff = false;
		int diffLength = 0;
		int iniOffset = 0;
		
		if (leftData == null || rightData == null) {
			throw new NullPointerException();
		}

		for (int offset = 0; offset < leftData.length(); offset++) {
			if (leftData.charAt(offset) != rightData.charAt(offset)) {
				if (isDiff) {
					diffLength++;
				} else {
					isDiff = true;
					iniOffset = offset;
					diffLength++;
				}
			} else {
				if (isDiff) {
					isDiff = false;
					diffResult.add(new DiffResult(iniOffset, diffLength));
					diffLength = 0;
					iniOffset = 0;
				}
			}
		}

		if (isDiff) {
			diffResult.add(new DiffResult(iniOffset, diffLength));
		}

		return diffResult;
	}
}
