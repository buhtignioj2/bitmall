package com.cafe24.bitmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.bitmall.repository.ProductDao;
import com.cafe24.bitmall.vo.ProductVo;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;
    
    public List<ProductVo> get(Long no) {
	List<ProductVo> vo = productDao.get(no);
	return vo;
    }

    public ProductVo getOne(Long no) {
	return productDao.getOne(no);
    }

    public List<ProductVo> getAll() {
	return productDao.getAll();
    }

    public void addProduct(ProductVo vo) {
	productDao.insert(vo);
    }

    public List<ProductVo> getAllList() {
	return productDao.getAllList();
    }
}
