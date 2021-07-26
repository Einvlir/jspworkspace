<%@page import="java.util.Map"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.koreait.tourapp.model.domain.Store"%>
<%@page import="java.util.List"%>
<%@page import="com.koreait.tourapp.model.store.dao.StoreDAO"%>
<%@page import="com.koreait.tourapp.model.store.dao.MybatisStoreDAO"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%!
	StoreDAO storeDAO = new MybatisStoreDAO();
%>
<%
	Store store = storeDAO.select(storeDAO.lastone());
	//Map<String,List> map = new HashMap<String, List>();
	//map.put("item",store);
	
	Gson gson = new Gson();
	String str = gson.toJson(store);
	out.print(str);
%>