package test;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//jsp���̵� �� �������� ����� ������ �� �ְ�, �Ʒ��� ����
//�������� �ؼ� �� ����Ǵ� Ŭ������ ������ �����̶� �Ѵ�..
//javaEE ����� ����..

//������ �����ֱ� �޼���� �Ҹ��� �ֿ� �޼��尡 �����Ѵ�.. �� �����ֱ� �޼����
//�ϳ��� ���� ��ü�� �¾�� ���ϸ�, �Ҹ��ϴ� ������ ������ �ֿ� �޼�����.

public class MyServlet extends HttpServlet{
	//���� �ν��Ͻ��� �¾ �� ������ �ʱ�ȭ �۾� �� ȣ��Ǵ� �޼���
	public void init(){
		System.out.println("�ʱ�ȭ");
	}	
	//�ʱ�ȭ�� �Ϸ��� ������ �� Ŭ���̾�Ʈ�� ��û�� ó���� �� ����
	public void service(HttpServletRequest request, HttpServletResponse response){
		System.out.println("��û ó��");
		//����ó��
		try{
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print("���� hehe");
		}catch(IOException e){
			e.printStackTrace();
		}
		

	}
	//������ �Ҹ�� �� ȣ��
	public void destroy(){
		System.out.println("��� �ȳ�");
	}
}