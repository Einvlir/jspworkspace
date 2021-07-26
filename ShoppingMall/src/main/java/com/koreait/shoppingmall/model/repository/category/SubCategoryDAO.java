package com.koreait.shoppingmall.model.repository.category;

import java.util.List;

import com.koreait.shoppingmall.domain.SubCategory;

public interface SubCategoryDAO {
	public List selectAllById(int topCategory_id);
	public List selectAll();
	public void insert(SubCategory subCategory);
	public SubCategory select(int subCategory_id);
	public void update(SubCategory SubCategory);
	public void delete(int subCategory_id);
}
