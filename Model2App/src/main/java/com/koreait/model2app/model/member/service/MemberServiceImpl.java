package com.koreait.model2app.model.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.koreait.model2.util.pool.PoolManager;
import com.koreait.model2app.exception.LicenseRegistException;
import com.koreait.model2app.model.domain.License;
import com.koreait.model2app.model.domain.Member;
import com.koreait.model2app.model.license.dao.JdbcLicenseDAO;
import com.koreait.model2app.model.license.dao.LicenseDAO;
import com.koreait.model2app.model.member.dao.JdbcMemberDAO;
import com.koreait.model2app.model.member.dao.MemberDAO;
import com.koreait.model2app.util.FileManager;

public class MemberServiceImpl implements MemberService {
	private PoolManager pool = PoolManager.getInstance(); //DAO간의 커넥션을 공유하기 위함
	
	// 부장님이 일 시킬 모델 객체들..
	FileManager fileManager;// 파일업로드
	MemberDAO memberDAO;// 회원정보
	LicenseDAO licenseDAO;// 자격증정보

	public MemberServiceImpl() {
		memberDAO = new JdbcMemberDAO();
		licenseDAO = new JdbcLicenseDAO();
	}

	public void regist(Member member, HttpServletRequest request) {
		//fileManager.saveFile(request);// 파일업로드 완료 1/3
		
		Connection con = pool.getConnection();
		((JdbcMemberDAO)memberDAO).setCon(con);
		((JdbcLicenseDAO)licenseDAO).setCon(con);
		//jdbc의 connection은 autocommit 상태임... 따라서 false로 해야 한다.
		// DB에 insert
		try {
			con.setAutoCommit(false);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		try {
			int member_id = memberDAO.insert(member); //2/3

			List<License> list = member.getList();
			for (License obj : list) {
				obj.setMember_id(member_id);
				licenseDAO.insert(obj); //3/3
			}
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (LicenseRegistException e) {
			System.out.println(e.getMessage());//에러 메세지 출력
			e.printStackTrace();//개발자를 위한 에러콘솔 출력
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw e;
		}
		pool.release(con);
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List selectAll() {
		Connection con = pool.getConnection();
		((JdbcMemberDAO)memberDAO).setCon(con);
		List list = memberDAO.selectAll();
		pool.release(con);
		return list;
	}

	public Member select(int member_id) {
		Connection con= pool.getConnection();
		((JdbcMemberDAO)memberDAO).setCon(con);
		Member member = memberDAO.select(member_id);
		pool.release(con);
		return member;
	}

	@Override
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
