package com.school.document.enums;

/**
 * @author Awais
 * @created 1/24/2024 - 11:30 PM
 * @project demo-assessment
 */
public enum ErrorCode {

	UNABLE_TO_GENERATE_RECEIPT("400101", "Unable to add receipt"),
	UNABLE_TO_FIND_RECEIPT("400101", "Receipt not found"),
	VALUE_REQ("400101", "value required"),
	;
	private String code;
	private String message;

	ErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
