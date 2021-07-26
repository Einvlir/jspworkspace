package com.koreait.site0622.model.comments.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koreait.site0622.model.domain.Comments;
import com.koreait.site0622.util.pool.PoolManager;

public class JdbcCommentsDAO implements CommentsDAO{
	PoolManager pool = PoolManager.getInstance();
	
	public int insert(Comments comments) {
		PreparedStatement pstmt = null;
		Connection con = null;
		int result = 0;
		con = pool.getConnection();
		String sql = "insert into comments(msg, cwriter, news_id) values(?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, comments.getMsg());
			pstmt.setString(2, comments.getCwriter());
			pstmt.setInt(3, comments.getNews_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}

	@Override
	public List selectALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comments select(int comments_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Comments comments) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int Comments_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List selectByNewsId(int news_id) {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		String sql = "select * from comments where news_id=?";
		ArrayList<Comments> list = new ArrayList<Comments>();
		con = pool.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, news_id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Comments comments = new Comments();
				comments.setComments_id(rs.getInt("comments_id"));
				comments.setMsg(rs.getString("msg"));
				comments.setCwriter(rs.getString("cwriter"));
				comments.setCdate(rs.getString("cdate"));
				comments.setNews_id(rs.getInt("news_id"));
				
				list.add(comments);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt, rs);
		}
		return list;
	}
}
