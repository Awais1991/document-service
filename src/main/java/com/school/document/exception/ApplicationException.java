package com.school.document.exception;


import com.school.document.enums.ErrorCode;

/**
 * @author Awais
 * @created 1/23/2024 - 5:47 PM
 * @project demo-assessment
 */
public class ApplicationException extends RuntimeException {

	private final String code;
	public ApplicationException(String code, String message) {
		super(message);
		this.code = code;
	}

	public ApplicationException(ErrorCode errorCode, String message) {
		super(message);
		this.code = errorCode.getCode();
	}

	public ApplicationException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.code = errorCode.getCode();
	}

	public String getCode() {
		return code;
	}
}
