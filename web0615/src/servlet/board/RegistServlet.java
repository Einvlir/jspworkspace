package servlet.board;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
//글쓰기 요청 처리!! ( 파라미터들을 넘겨받아 sql수행)
public class RegistServlet extends HttpServlet{
	String url = "jdbc:oracle:thin:@localhost:1521";
	String user = "webmaster";
	String password = "1234";
	Connection con;
	PreparedStatement pstmt;
	//요청을 처리 
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//파라미터 받기 
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		response.setContentType("text/html");
		//클라이언트의 브라우저에 응답정보를 구성하여 전송해보자 
		PrintWriter out = response.getWriter(); //응답객체로 부터 스트림 뽑기
		out.print("title= "+title+"<br>");
		out.print("writer= "+writer+"<br>");
		out.print("content= "+content+"<br>");
		
		//해당 DB시스템에 알맞는 드라이버 로드
		//오라클에 접속하여 쿼리수행
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("싱글 벙글");
			out.print("good");

			//접속시도
			con = DriverManager.getConnection(url,user,password);
			if(con==null){
				out.print("Fail..");
			}else{
				out.print("good ^^");

				String sql = "insert into board(board_id, title, writer, content) values(seq_board.nextval,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,title);
				pstmt.setString(2,writer);
				pstmt.setString(3,content);

				int result = pstmt.executeUpdate();
				out.print("<script>");
				if(result>0){
					out.print("alert('insert good');");
					out.print("location.href='/board/list';");

				}else{
					out.print("fuck T.T");
				}
				out.print("</script>");
			}

		}catch(ClassNotFoundException e){
			System.out.println("드라이버를 찾을 수 없습니다..");
			out.print("fuck");
		}catch(SQLException e){
			out.print(e);
		}finally{
			if(pstmt!=null){
				try{pstmt.close();}catch(SQLException e){}
			}
			if(con!=null){
				try{con.close();}catch(SQLException e){}
			}
		}
		
	}
}
