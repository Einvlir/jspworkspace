package com.koreait.model2app.model.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koreait.model2.util.pool.PoolManager;
import com.koreait.model2app.model.domain.Member;

import lombok.Data;
@Data
public class JdbcMemberDAO implements MemberDAO{
	private Connection con;
	
	public int insert(Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into member(member_id, name, phone, addr, photo) values(seq_member.nextval,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getAddr());
			pstmt.setString(4, member.getPhoto());
			result = pstmt.executeUpdate();
			
			if(result!=0) {
				sql = "select seq_member.currval as member_id from dual";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					result = rs.getInt("member_id");
				}
			}
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	
	public List selectAll() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		try {
			pstmt=con.prepareStatement("select * from member");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setMember_id(rs.getInt("member_id"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setAddr(rs.getString("addr"));
				
				list.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public Member select(int member_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			pstmt=con.prepareStatement("select * from member where member_id=?");
			pstmt.setInt(1, member_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setMember_id(rs.getInt("member_id"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setAddr(rs.getString("addr"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return member;
	}

	public int update(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int member_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
