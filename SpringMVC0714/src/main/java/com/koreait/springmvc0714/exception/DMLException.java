package com.koreait.springmvc0714.exception;

//sun에서 제공해주는 익셉션 만으로는 모든 경우의 에러를 처리할 수 없으므로
//Runtime익셉션을 상속받아 개발자만의 예외를 만들어 사용하자
public class DMLException extends RuntimeException{
	public DMLException(String msg) {
		super(msg);
	}
	public DMLException(String msg, Throwable e) {
		super(msg,e);
	}
}
