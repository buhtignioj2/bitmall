package com.cafe24.bitmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.bitmall.service.CartService;
import com.cafe24.bitmall.vo.MemberVo;
import com.cafe24.jblog.dto.CartDTO;
import com.cafe24.security.AuthUser;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String cart(Model model, @AuthUser MemberVo authUser) {
	if( authUser == null ) {
	    return "redirect:/";
	}
	List<CartDTO> list = cartService.getList( authUser.getNo() );
	model.addAttribute( "list", list );
	System.out.println( list );
	System.out.println( list );
	System.out.println( list );
	System.out.println( list );
	System.out.println( list );
	System.out.println( list );
	System.out.println( list );
	System.out.println( list );
	System.out.println( list );
	System.out.println( list );
	System.out.println( authUser );
	return "cart";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String cart(@ModelAttribute CartDTO cartDto) {
	cartDto.setTotalCount( cartDto.getPrice() * cartDto.getCount() );
	cartService.setCart( cartDto );
	return "redirect:/cart";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCart(@AuthUser MemberVo authUser) {
	cartService.delete( authUser.getNo() );
	
	return "redirect:/cart";
    }
    
    @RequestMapping(value = "/update/{no}", method = RequestMethod.GET)
    public String updateCart( @PathVariable("no")Long no,
	    		      @RequestParam(value="count",required=false)Long count,
	    		      @ModelAttribute CartDTO cartDto,
	    		      @AuthUser MemberVo authUser) {
	
	cartDto.setMemberNo( authUser.getNo() );
	cartDto.setCount( count );
	System.out.println( "######################################" );
	System.out.println( "######################################" );
	System.out.println( "######################################" );
	System.out.println( cartDto );
	cartService.delete( cartDto );
	cartService.setCart( cartDto );
	return "redirect:/cart";
    }
}
