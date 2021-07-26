package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropsTest {
	Properties props;//key-value의 쌍으로 된 데이터를 이해하는 객체
	FileReader reader;
	String path = "E:\\korea202102_jspworkspace\\MVCFramework\\src\\main\\webapp\\WEB-INF\\mapping.data";
	public PropsTest() {
		props = new Properties();
		try {
			props.load(reader = new FileReader(path));
			//이 시점부터 파일을 검색하여 key-value쌍으로 된 데이터를 접근할 수 있다.
			System.out.println(props.getProperty("protoss"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new PropsTest();
	}
}
