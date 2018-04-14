package com.cafe24.bitmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.bitmall.service.ProductService;
import com.cafe24.bitmall.vo.ProductVo;


@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @RequestMapping("/product/{no}")
    public String product(@PathVariable("no")Long no, Model model) {
	List<ProductVo> vo = productService.get(no);
	model.addAttribute( "vo", vo );
	model.addAttribute( "count", vo.size() );
	
	return "product/product";
    }
    @RequestMapping("product_detail/{no}")
    public String productDetail(@PathVariable("no")Long no, Model model) {
	ProductVo vo = productService.getOne(no);
	model.addAttribute( "vo", vo );
	
	return "product/product_detail";
    }
}
