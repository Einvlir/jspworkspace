package site0618.model.gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import site0618.model.domain.Gallery;
import site0618.model.pool.PoolManager;

//이 클래스는 오직 gallery 테이블에 대한 CRUD만을 담당하는 객체다
public class GalleryDAO {
	PoolManager pool = PoolManager.getInstance();
	public int insert(Gallery gallery) {
		int result=0;
		Connection con=null;
		PreparedStatement pstmt = null;
		//커넥션은 커넥션풀로부터 가져오자!
		con=pool.getConnection();
		String sql ="insert into gallery(gallery_id, title, writer, content, filename) values(seq_gallery.nextval,?,?,?,?)";
	
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, gallery.getTitle());
			pstmt.setString(2, gallery.getWriter());
			pstmt.setString(3, gallery.getContent());
			pstmt.setString(4, gallery.getFilename());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
	public List selectAll() {
		ArrayList<Gallery> list = new ArrayList<Gallery>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con=pool.getConnection();
		String sql = "select * from gallery";
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Gallery gallery = new Gallery();
				gallery.setGallery_id(rs.getInt("gallery_id"));
				gallery.setTitle(rs.getString("title"));
				gallery.setWriter(rs.getString("writer"));
				gallery.setContent(rs.getString("content"));
				gallery.setRegdate(rs.getString("regdate"));
				gallery.setFilename(rs.getString("filename"));
				gallery.setHit(rs.getInt("hit"));
				list.add(gallery);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con,pstmt,rs);
		}
		return list;
	}
	public Gallery select(int gallery_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con=pool.getConnection();
		String sql = "select * from gallery where gallery_id = ?";
		Gallery gallery = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gallery_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				gallery = new Gallery();
				gallery.setGallery_id(rs.getInt("gallery_id"));
				gallery.setTitle(rs.getString("title"));
				gallery.setWriter(rs.getString("writer"));
				gallery.setContent(rs.getString("content"));
				gallery.setRegdate(rs.getString("regdate"));
				gallery.setFilename(rs.getString("filename"));
				gallery.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt, rs);
			
		}
		return gallery;
	}
	public int del(int gallery_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		con= pool.getConnection();
		int result = 0;
		String sql = "delete from gallery where gallery_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gallery_id);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
		
	}
	public int update(Gallery gallery) {
		Connection con = null;
		PreparedStatement pstmt = null;
		con = pool.getConnection();
		int result =0;
		String sql = "update gallery set title =?, writer = ?, content =?, filename = ? where gallery_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gallery.getTitle());
			pstmt.setString(2, gallery.getWriter());
			pstmt.setString(3, gallery.getContent());
			pstmt.setString(4, gallery.getFilename());
			pstmt.setInt(5, gallery.getGallery_id());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			pool.release(con,pstmt);
		}
		return result;
	}
}
