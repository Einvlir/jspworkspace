package study;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import java.io.IOException;
public class TestServlet extends HttpServlet {
	public void init(){
		System.out.println("����");
	}
	//��û�� ���� ����ó��..

	//node.js�� ���������� Ŭ���̾�Ʈ�� ��û�� ó���Ϸ��� � ��û������ ������
	//Ŭ���̾�Ʈ�� ��û�ߴ����� ���� ������ ����, ��û��ü�� �̿��ؾ� �Ѵ�
	//����� ������Ʈ ��ü�� ��û�� ���� �� �ڵ� �����Ǿ� ������ ������ ����
	//ä�����Ƿ� �����ڴ� ���� ��븸 �ϸ� �ȴ�.
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();//���ڱ�� ��½�Ʈ��
		out.print("this is my second Sevlet!!");
	}

}