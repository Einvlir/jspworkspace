package site0618.model.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PoolManager {
	InitialContext ctx;//jndi를 활용한 검색객체
	DataSource ds;
	
	private static PoolManager instance;
	
	private PoolManager() {
		try {
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jndi/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	//싱글턴 기법
	public static PoolManager getInstance() {
		if(instance ==null) {
			instance = new PoolManager();
		}
		return instance;
	}
	public Connection getConnection() {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	public void release(Connection con) {
		if(con!=null)try {con.close();}catch(SQLException e) {e.printStackTrace();}
	}
	public void release(Connection con, PreparedStatement pstmt) {
		if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {e.printStackTrace();}
		if(con!=null)try {con.close();}catch(SQLException e) {e.printStackTrace();}
	}
	public void release(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(rs!=null)try {rs.close();}catch(SQLException e) {e.printStackTrace();}
		if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {e.printStackTrace();}
		if(con!=null)try {con.close();}catch(SQLException e) {e.printStackTrace();}
	}
}
