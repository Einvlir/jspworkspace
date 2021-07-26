package com.koreait.tourapp.util;

public class FileManager {
	//확장자 추출
	public static String getExt(String path) {//경로를 이어받아 확장자 추출
		return path.substring(path.lastIndexOf(".")+1,path.length());
		
	}
}
