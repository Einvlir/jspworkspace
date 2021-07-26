package com.koreait.shoppingmall.exception;

public class MemberExistException extends RuntimeException{
	public MemberExistException(String msg) {
		super(msg);
	}
	public MemberExistException(Throwable e) {
		super(e);
	}
	public MemberExistException(Throwable e, String msg) {
		super(msg, e);
	}
}
