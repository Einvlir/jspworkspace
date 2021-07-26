package com.koreait.shoppingmall.exception;

public class UploadException extends RuntimeException{
	public UploadException(String msg) {
		super(msg);
	}
	public UploadException(Throwable e) {
		super(e);
	}
	public UploadException(Throwable e, String msg) {
		super(msg, e);
	}
}
