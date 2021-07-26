package com.koreait.shoppingmall.model.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.shoppingmall.domain.SubCategory;
import com.koreait.shoppingmall.model.repository.category.SubCategoryDAO;
@Service
public class SubCategoryServiceImpl implements SubCategoryService{
	@Autowired
	private SubCategoryDAO subcategoryDAO;
	@Override
	public List selectAllById(int topCategory_id) {
		return subcategoryDAO.selectAllById(topCategory_id);
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(SubCategory subCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SubCategory select(int subCategory_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SubCategory SubCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int subCategory_id) {
		// TODO Auto-generated method stub
		
	}

}
