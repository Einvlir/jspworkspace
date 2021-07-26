package com.koreait.shoppingmall.model.repository.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.shoppingmall.domain.Product;
import com.koreait.shoppingmall.exception.DMLException;
import com.koreait.shoppingmall.exception.FileHandleException;
@Repository
public class MybatisProductDAO implements ProductDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Product.selectAll");
	}

	@Override
	public Product select(int product_id) {
		return sqlSessionTemplate.selectOne("Product.select",product_id);
	}

	@Override
	public void insert(Product product) throws DMLException{
		
		int result = sqlSessionTemplate.insert("Product.insert",product);
		if(result == 0) {
			throw new DMLException("등록에 오류가 있습니다..");
		}
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int product_id) throws FileHandleException{
		int result = sqlSessionTemplate.delete("Product.delete",product_id);
		if(result ==0) {
			throw new FileHandleException("삭제중 오류가 발생했습니다.");
		}
		
	}

}
