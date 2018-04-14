package com.cafe24.bitmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.CartDao;
import com.cafe24.jblog.dto.CartDTO;

@Service
public class CartService {

    @Autowired
    private CartDao cartDao;
    
    public void setCart(CartDTO cartDto) {
	cartDao.insert(cartDto);
    }
    public List<CartDTO> getList() {
	List<CartDTO> list = cartDao.getList();

	return list;
    }
    public List<CartDTO> getList(Long no) {
	System.out.println( "@@@@@@@@@@@@@@@@@@@@@@@@@" );
	System.out.println( "@@@@@@@@@@@@@@@@@@@@@@@@@" );
	System.out.println( "@@@@@@@@@@@@@@@@@@@@@@@@@" );
	System.out.println( "@@@@@@@@@@@@@@@@@@@@@@@@@" );
	return cartDao.getList(no);
    }
    public void delete(Long no) {
	cartDao.delete( no );	
    }
    public void update(CartDTO cartDto) {
	cartDao.update( cartDto );
    }
    public void delete(CartDTO cartDto) {
	cartDao.deleteOne( cartDto );		
    }

}
