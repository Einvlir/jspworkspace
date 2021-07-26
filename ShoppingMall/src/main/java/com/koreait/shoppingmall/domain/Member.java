package com.koreait.shoppingmall.domain;

import lombok.Data;

@Data
public class Member {
	private int member_id;
	private String user_id;
	private String pass;
	private String name;
}
