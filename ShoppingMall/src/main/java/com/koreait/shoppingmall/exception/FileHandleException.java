package com.koreait.shoppingmall.exception;

public class FileHandleException extends RuntimeException{
	public FileHandleException(String msg) {
		super(msg);
	}
	public FileHandleException(Throwable e) {
		super(e);
	}
	public FileHandleException(Throwable e, String msg) {
		super(msg, e);
	}
}
