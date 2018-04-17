package com.cafe24.bitmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.bitmall.service.OrderService;
import com.cafe24.bitmall.vo.MemberVo;
import com.cafe24.bitmall.vo.PaymenthistoryDTO;
import com.cafe24.security.AuthUser;

@Controller
@RequestMapping("/jumun")
public class JumunController {
    
    @Autowired
    private OrderService orderService;
    
    @RequestMapping("")
    public String jumun( Model model, @AuthUser MemberVo authUser  ) {
	List<PaymenthistoryDTO> list = orderService.getListByNo(authUser.getNo());
	model.addAttribute( "list", list );
	
	return "jumun/jumun";
    }
}
