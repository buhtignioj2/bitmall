package com.cafe24.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.bitmall.service.MemberService;
import com.cafe24.bitmall.vo.MemberVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	
	String id = request.getParameter( "id" );
	String password = request.getParameter( "password" );
	MemberVo vo = new MemberVo();
	vo.setId( id );
	vo.setPassword( password );
	
	ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext( request.getServletContext() );

	MemberService memberService = ac.getBean( MemberService.class );
	MemberVo authUser = memberService.getUser( vo );
	
	if( authUser == null ) {
	    response.sendRedirect( request.getContextPath() + "/user/member_login" );
	    return false;
	}

	HttpSession session = request.getSession( true );
	session.setAttribute( "authUser", authUser );
	System.out.println( "##################################################" );
	System.out.println( authUser );
	System.out.println( authUser.getRole() );
	
	if( "admin".equals(authUser.getRole()) ) {
	    System.out.println( "관리자다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
	    response.sendRedirect( request.getContextPath() + "/ad/product" );
	} else {
	    System.out.println( "유저다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
	    response.sendRedirect( request.getContextPath() + "" );
	}
	System.out.println( "!!!!!!!!!!!!!!!!!!!!!!!!!" );
	System.out.println( "!!!!!!!!!!!!!!!!!!!!!!!!!" );
	System.out.println( "!!!!!!!!!!!!!!!!!!!!!!!!!" );
	System.out.println( "!!!!!!!!!!!!!!!!!!!!!!!!!" );
	System.out.println( "!!!!!!!!!!!!!!!!!!!!!!!!!" );
	System.out.println( "!!!!!!!!!!!!!!!!!!!!!!!!!" );
	System.out.println( authUser );
	System.out.println( authUser );
	System.out.println( authUser );
	System.out.println( authUser );
	System.out.println( authUser );
	System.out.println( authUser );
	return false;
    }

}
