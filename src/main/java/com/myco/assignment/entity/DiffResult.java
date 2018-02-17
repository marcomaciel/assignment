package com.myco.assignment.entity;

/**
 * Class used to model the difference of offset and length of two messages
 *
 * @author Marco Maciel
 */
public class DiffResult {

	private int offset;
	private int length;

	/**
	 * @param offset Offset of the start position of a change
	 * @param length Length of the difference
	 */
	public DiffResult(int offset, int length) {
		this.offset = offset;
		this.length = length;
	}

	public int getOffset() {
		return offset;
	}

	public int getLength() {
		return length;
	}

}
