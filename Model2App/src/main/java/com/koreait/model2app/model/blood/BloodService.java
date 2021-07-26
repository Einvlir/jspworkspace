package com.koreait.model2app.model.blood;

//공통 로직을 처리하기 위한 클래스
public class BloodService {
	//웹 응용 관계없이 이 메서드를 호출할 때 혈액형을 매개변수로..
	public String getAdvice(String blood) {
		String msg = null;
		if(blood.equals("A형")){
			msg="소심하지만 꼼꼼하세요~";
		}else if(blood.equals("B형")){
			msg="고집이 세다;;";
		}else if(blood.equals("O형")){
			msg="오지랖이 넓으세요~";		
		}else if(blood.equals("AB형")){
			msg="선택을 번복하는 타입;;";
		}
		return msg;
	}
}
