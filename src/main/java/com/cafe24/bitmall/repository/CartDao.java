package com.cafe24.bitmall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.jblog.dto.CartDTO;

@Repository
public class CartDao {

    @Autowired
    private SqlSession sqlSession;
    
    public boolean insert(CartDTO cartDto) {
	return sqlSession.insert( "cart.insert", cartDto ) == 1;
    }

    public List<CartDTO> getList() {
	return sqlSession.selectList( "cart.getList" );
    }

    public List<CartDTO> getList(Long no) {
	return sqlSession.selectList( "cart.getListByNo", no );
    }

    public boolean delete(Long no) {
	return sqlSession.delete( "cart.deleteByNo", no ) == 1;
    }

    public boolean update(CartDTO cartDto) {
	return sqlSession.update( "cart.updateByNo", cartDto ) == 1;
    }

    public boolean deleteOne(CartDTO cartDto) {
	long no = cartDto.getNo();
	return sqlSession.delete( "cart.deleteOne", no ) == 1;
    }

    public boolean insertcopy(CartDTO cartDto) {
	return sqlSession.insert( "cart.insertcopy", cartDto ) == 1;	
    }

}
