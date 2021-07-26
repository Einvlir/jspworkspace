package site0621.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import site0621.board.model.domain.Board;
import site0621.util.PoolManager;

public class BoardDAO {
	//insert
	PoolManager pool = PoolManager.getInstance();
	public int insert(Board board) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt= null;
		String sql = "insert into board(title, writer, content) values(?,?,?)";
		con = pool.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
	public List selectAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Board> list=new ArrayList<Board>();
		
		con=pool.getConnection();
		String sql="select * from board order by board_id desc";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Board board=new Board();
				board.setBoard_id(rs.getInt("board_id"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
				
				list.add(board); //리스트에 담기
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt, rs);
		}
		return list;
	}
	public Board select(int board_id) {
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		Board board = null;
		
		String sql = "select * from board where board_id=?";
		con = pool.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				board = new Board();
				board.setBoard_id(rs.getInt("board_id"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt, rs);
		}
		return board;
				
	}
	public int update(Board board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update board set title = ?, writer =?, content = ? where board_id = ?";
		int result = 0;
		con = pool.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getBoard_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
	public int delete(int board_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "delete from board where board_id = ?";
		
		con = pool.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
}
	