package com.cafe24.bitmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.bitmall.vo.ProductVo;

@Repository
public class ProductDao {
    
    @Autowired
    private SqlSession sqlSession;
    
    public List<ProductVo> get(Long no) {
	return sqlSession.selectList( "product.getByNo", no );
    }

    public ProductVo getOne(Long no) {
	return sqlSession.selectOne( "product.getOne", no );
    }

    public List<ProductVo> getAll() {
	return sqlSession.selectList("product.getAll");
    }

    public boolean insert(ProductVo vo) {
	return sqlSession.insert( "product.insert", vo ) == 1;	
    }

    public List<ProductVo> getAllList() {
	return sqlSession.selectList("product.getAllList");
    }

}
