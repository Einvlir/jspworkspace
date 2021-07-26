package servlet.board;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ListServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		
		PrintWriter out = response.getWriter();
		
		
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","webmaster","1234");
			if(con==null){
				out.print("connect fail");	
			}else{
				out.print("good<br>");
				String sql = "select * from board order by board_id desc";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				out.print("<table width='100%' border='1px'>");
				out.print("<tr>");
				out.print("<th>No</th>");
				out.print("<th>title</th>");
				out.print("<th>writer</th>");
				out.print("<th>regdate</th>");
				out.print("<th>hit</th>");
				out.print("</tr>");
				while(rs.next()){
					out.print("<tr>");
					out.print("<td>No</td>");
					out.print("<td>"+rs.getString("title")+"</td>");
					out.print("<td>"+rs.getString("writer")+"</td>");
					out.print("<td>"+rs.getString("regdate")+"</td>");
					out.print("<td>"+rs.getInt("hit")+"</td>");
					out.print("</tr>");
				}





				out.print("</table>");

			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(con!=null){try{con.close();}catch(SQLException e){}}
			if(pstmt!=null){try{pstmt.close();}catch(SQLException e){}}
			if(rs!=null){try{rs.close();}catch(SQLException e){}}
		}


	}

	
}