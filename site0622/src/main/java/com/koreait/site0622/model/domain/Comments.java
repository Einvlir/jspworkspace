package com.koreait.site0622.model.domain;

import lombok.Data;

@Data
public class Comments {
	private int comments_id;
	private String msg;
	private String cdate;
	private String cwriter;
	private int news_id;
}
