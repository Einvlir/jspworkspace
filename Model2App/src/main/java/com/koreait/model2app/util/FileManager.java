package com.koreait.model2app.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.koreait.model2app.model.domain.License;
import com.koreait.model2app.model.domain.Member;

public class FileManager {
	//확장자 추출
	public static String getExt(String path) {//경로를 이어받아 확장자 추출
		return path.substring(path.lastIndexOf(".")+1,path.length());
		
	}
	//웹 기반의 파일 업로드
	public static Member saveFile(HttpServletRequest request) {
		//아파치 파일업로드를 이용한 파일 저장 및 파라미터 처리
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletContext context = request.getServletContext();//어플리케이션의 정보를 가진 객체!
				String realPath = context.getRealPath("/data");//물리적 저장경로
				factory.setRepository(new File(realPath));
				factory.setSizeThreshold(2*1024*1024); //2m
				FileManager fileManeger = new FileManager();
				Member member = null;
				
				ServletFileUpload upload = new ServletFileUpload(factory);
				try {
					List<FileItem> items = upload.parseRequest(request);
					member = new Member();
					
					for(FileItem item : items) {
						if(item.isFormField()) {//text
							if(item.getFieldName().equals("name")) {
								member.setName(item.getString("utf-8"));
							}else if(item.getFieldName().equals("phone")){
								member.setPhone(item.getString("utf-8"));
							}else if(item.getFieldName().equals("addr")){
								member.setAddr(item.getString("utf-8"));	
							}else if(item.getFieldName().equals("title")){
								License license = new License(); // empty vo
								license.setTitle(item.getString("utf-8"));	
								member.getList().add(license);//멤버 vo에 자격증 하나 추가
							}
						}else {//file
							try {
								String ext = fileManeger.getExt(item.getName());
								String newName = System.currentTimeMillis()+"."+ext;
								System.out.println(realPath+"/"+newName);
								item.write(new File(realPath+"/"+newName));
								member.setPhoto(newName);//member vo에 파일명 저장
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				} catch (FileUploadException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return member;
	}
}
