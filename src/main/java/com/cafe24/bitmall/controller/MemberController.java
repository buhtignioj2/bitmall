package com.cafe24.bitmall.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.bitmall.service.MemberService;
import com.cafe24.bitmall.vo.MemberVo;
import com.cafe24.security.Auth;
import com.cafe24.security.AuthUser;

@Controller
@RequestMapping("/user")
public class MemberController {
    
    @Autowired
    private MemberService memberService;

    @RequestMapping(value="/member_agree", method = RequestMethod.GET)
    public String Join() {
	return "user/member_join";
    }
    
    @RequestMapping(value="/member_joinend", method = RequestMethod.POST)
    public String Join(@ModelAttribute MemberVo memberVo ) {
	memberService.join(memberVo);
	return "user/member_joinend";
    }
    
    @RequestMapping("/member_login")
    public String Login() {
	return "user/member_login";
    }
    
    
    @RequestMapping("/admin")
    public String adminLogin() {
	return "admin/login";
    }
    
    @Auth
    @RequestMapping(value="/member_modify/{no}", method = RequestMethod.GET)
    public String modify( @PathVariable("no") Long no, @AuthUser MemberVo authUser, Model model) {
	if( authUser == null ) {
	    return "redirect:/main";
	}

	MemberVo vo = memberService.getUser( no );

	String birth1 = vo.getBirth().split( "-" )[0];
	String birth2 = vo.getBirth().split( "-" )[1];
	String birth3 = vo.getBirth().split( "-" )[2];
	
	String phone1 = vo.getPhone().substring(0,3);
	String phone2 = vo.getPhone().substring(3,7);
	String phone3 = vo.getPhone().substring(7);
	
	String zip1 = vo.getAddress().substring( 0, 3 );
	String zip2 = vo.getAddress().substring( 3, 6 );
	String lastAddress = vo.getAddress().substring( 6 );
	
	
	model.addAttribute( "vo", vo );
	model.addAttribute( "birthday1", birth1 );
	model.addAttribute( "birthday2", birth2 );
	model.addAttribute( "birthday3", birth3 );
	model.addAttribute( "phone1", phone1 );
	model.addAttribute( "phone2", phone2 );
	model.addAttribute( "phone3", phone3 );
	model.addAttribute( "zip1", zip1 );
	model.addAttribute( "zip2", zip2 );
	model.addAttribute( "lastAddress", lastAddress );
	
	return "user/member_modify";
    }
    
    @RequestMapping(value="/member_modify/{no}", method = RequestMethod.POST)
    public String modify( @PathVariable("no") Long no, @ModelAttribute MemberVo memberVo ) {
	System.out.println( memberVo );
	memberService.modify(memberVo);
	
	return "user/member_modifying";
    }
}
