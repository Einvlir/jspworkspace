package test;

import java.io.BufferedReader;
import java.io.IOException;

/* Java 샘플 코드 */


import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class ApiTest {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"); /*URL*/
    	String serviceKey = "FeG7wGlEaJKxAS%2F919wZ2INS1RgD5Ya18cEt%2BH%2FiQTKd4ZUh5UmmXWVaF%2BMqJmr9v071OvjfTbWoOwMNk6qMGg%3D%3D";
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+serviceKey); /*Service Key*/
        //urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode(serviceKey, "UTF-8")); /*공공데이터포털에서 발급받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드),WIN (원도우폰), ETC*/
        urlBuilder.append("&" + URLEncoder.encode("arrange","UTF-8") + "=" + URLEncoder.encode("A", "UTF-8")); /*(A=제목순, B=조회순, C=수정일순, D=생성일순) , 대표이미지가 반드시 있는 정렬 (O=제목순, P=조회순, Q=수정일순, R=생성일순)*/
        urlBuilder.append("&" + URLEncoder.encode("cat1","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*대분류 코드*/
        urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("15", "UTF-8")); /*관광타입(관광지, 숙박 등) ID*/
        urlBuilder.append("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("4", "UTF-8")); /*지역코드*/
        urlBuilder.append("&" + URLEncoder.encode("sigunguCode","UTF-8") + "=" + URLEncoder.encode("4", "UTF-8")); /*시군구코드(areaCode 필수)*/
        urlBuilder.append("&" + URLEncoder.encode("cat2","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*중분류 코드(cat1필수)*/
        urlBuilder.append("&" + URLEncoder.encode("cat3","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*소분류 코드(cat1,cat2필수)*/
        urlBuilder.append("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*목록 구분 (Y=목록, N=개수)*/
        urlBuilder.append("&" + URLEncoder.encode("modifiedtime","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*콘텐츠 수정일*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        
        //곧바로 json으로 변환해봅시다!
        rd.close();
        conn.disconnect();
        //System.out.println(sb.toString());
        
        JSONObject json=XML.toJSONObject(sb.toString()); //xml 스트링을 json 객체로 변환!!
        
        JSONObject res=(JSONObject)json.get("response"); //response key 가 가리키는 json 추출
        
        JSONObject body=(JSONObject)res.get("body");//body key 가 가리키는 json 추출
        
        JSONObject items=(JSONObject)body.get("items"); //items key가 가리키는 json 추출 
        
        JSONArray item=(JSONArray)items.get("item"); //item key가 가리키는 json array 추출 
        
        System.out.println("관광 아이템의 수는 "+item.length());
    }
}