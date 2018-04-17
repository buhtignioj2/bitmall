package com.cafe24.bitmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.bitmall.service.ProductService;
import com.cafe24.bitmall.vo.ProductVo;

@Controller
public class MainController {
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping("")
    public String index(Model model) {
	List<ProductVo> vo = productService.getAllList();
	model.addAttribute( "vo", vo );
	return "main/index";
    }
    
    @RequestMapping("/company")
    public String company() {
	return "company";
    }

    @RequestMapping("/useinfo")
    public String useinfo() {
	return "useinfo";
    }

    @RequestMapping("/policy")
    public String policy() {
	return "policy";
    }
}
