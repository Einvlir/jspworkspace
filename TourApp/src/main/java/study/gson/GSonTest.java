package study.gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class GSonTest {
	public static void main(String[] args) {
		
		//순서 있는것, 없는것, 키와 밸류로 이루어진 컬렉션프레임웍
		//List, Set, Map
		Map<String, List> map = new HashMap<String, List>();
		
		ArrayList<Fruit> list = new ArrayList<Fruit>();
		Fruit f1 = new Fruit();
		Fruit f2 = new Fruit();
		Fruit f3 = new Fruit();
		
		f1.setName("사과");
		f1.setPrice(5000);
		
		f2.setName("오렌지");
		f2.setPrice(7000);
		
		f3.setName("블루베리");
		f3.setPrice(9000);
		list.add(f1);
		list.add(f2);
		list.add(f3);
		
		map.put("fruitList", list);
		
		Gson gson = new Gson();
		String str = gson.toJson(map);
		System.out.println(str);
	}
}
