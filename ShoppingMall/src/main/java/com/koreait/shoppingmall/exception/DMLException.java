package com.koreait.shoppingmall.exception;

public class DMLException extends RuntimeException{
	public DMLException(String msg) {
		super(msg);
	}
	public DMLException(Throwable e) {
		super(e);
	}
	public DMLException(Throwable e, String msg) {
		super(msg, e);
	}
}
