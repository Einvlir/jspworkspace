package com.koreait.shoppingmall.model.repository.admin;

import java.util.List;

import com.koreait.shoppingmall.domain.Admin;

public interface AdminDAO {
	public Admin login(Admin admin);
	public void regist(Admin admin);
	public void update(Admin admin);
	public void delete(Admin admin);
	public List selectAll();
}
