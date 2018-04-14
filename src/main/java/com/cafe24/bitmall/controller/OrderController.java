package com.cafe24.bitmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.bitmall.service.CartService;
import com.cafe24.bitmall.service.MemberService;
import com.cafe24.bitmall.service.OrderService;
import com.cafe24.bitmall.service.POService;
import com.cafe24.bitmall.service.ProductService;
import com.cafe24.bitmall.vo.MemberVo;
import com.cafe24.bitmall.vo.OrderVo;
import com.cafe24.bitmall.vo.PoVo;
import com.cafe24.bitmall.vo.ProductVo;
import com.cafe24.jblog.dto.CartDTO;
import com.cafe24.security.AuthUser;

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;
    
    @Autowired
    private MemberService memberService;
    
    @Autowired
    private ProductService productService;

  
    @RequestMapping( value="/orderok", method=RequestMethod.POST )
    public String orderPay( Model model, @AuthUser MemberVo authUser ) {
	
	
	return "order/order_ok";
    }
    
    
    @RequestMapping( value="/baroorder/{no}", method=RequestMethod.GET )
    public String baroOrder( @PathVariable("no")Long no, Model model, @AuthUser MemberVo authUser ) {
	ProductVo vo = productService.getOne( no );
	MemberVo user = memberService.getUser( authUser.getNo() );
	
	String phone1 = user.getPhone().substring(0,3);
	String phone2 = user.getPhone().substring(3,7);
	String phone3 = user.getPhone().substring(7);
	
	String zip1 = user.getAddress().substring( 0, 3 );
	String zip2 = user.getAddress().substring( 3, 6 );
	String lastAddress = user.getAddress().substring( 6 );
	
	model.addAttribute( "user", user);
	model.addAttribute( "phone1", phone1 );
	model.addAttribute( "phone2", phone2 );
	model.addAttribute( "phone3", phone3 );
	model.addAttribute( "zip1", zip1 );
	model.addAttribute( "zip2", zip2 );
	model.addAttribute( "lastAddress", lastAddress );
	
	model.addAttribute( "vo", vo );
	
	return "order/baroorder";
    }
    
    @RequestMapping( value="/order", method=RequestMethod.POST )
    public String order( @ModelAttribute OrderVo orderVo, @AuthUser MemberVo authUser, Model model) {
	List<CartDTO> list = cartService.getList( authUser.getNo() );
	System.out.println( authUser );
	System.out.println( list );
	model.addAttribute( "list", list );
	
	return "order/order_pay";
    }
    
    @RequestMapping( value="/order", method=RequestMethod.GET )
    public String order( Model model, @AuthUser MemberVo authUser ) {
	
	List<CartDTO> list = cartService.getList(authUser.getNo());
	MemberVo vo = memberService.getUser( authUser.getNo() );
	
	String phone1 = vo.getPhone().substring(0,3);
	String phone2 = vo.getPhone().substring(3,7);
	String phone3 = vo.getPhone().substring(7);
	
	String zip1 = vo.getAddress().substring( 0, 3 );
	String zip2 = vo.getAddress().substring( 3, 6 );
	String lastAddress = vo.getAddress().substring( 6 );
	
	model.addAttribute( "user", vo );
	model.addAttribute( "phone1", phone1 );
	model.addAttribute( "phone2", phone2 );
	model.addAttribute( "phone3", phone3 );
	model.addAttribute( "zip1", zip1 );
	model.addAttribute( "zip2", zip2 );
	model.addAttribute( "lastAddress", lastAddress );
	
	model.addAttribute( "list", list );
	
	
	return "order/order";
    }
    
}
