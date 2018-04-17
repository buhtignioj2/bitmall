package com.cafe24.bitmall.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cafe24.bitmall.service.CartService;
import com.cafe24.bitmall.service.MemberService;
import com.cafe24.bitmall.service.OrderService;
import com.cafe24.bitmall.service.ProductService;
import com.cafe24.bitmall.vo.BuyerVo;
import com.cafe24.bitmall.vo.CartVo;
import com.cafe24.bitmall.vo.MemberVo;
import com.cafe24.bitmall.vo.OrderVo;
import com.cafe24.bitmall.vo.PaymenthistoryVo;
import com.cafe24.bitmall.vo.PoVo;
import com.cafe24.bitmall.vo.ProductVo;
import com.cafe24.bitmall.vo.RecipientVo;
import com.cafe24.jblog.dto.CartDTO;
import com.cafe24.security.AuthUser;

@Controller
@SessionAttributes("cartDto")
public class OrderController {

    @Autowired
    private CartService cartService;
    
    @Autowired
    private MemberService memberService;
    
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;
  
    @RequestMapping( value="/orderpay", method=RequestMethod.POST )
    public String orderPay( @ModelAttribute PaymenthistoryVo paymenthistoryVo,
	    		    @ModelAttribute OrderVo orderVo,
	    		    @ModelAttribute CartVo cartVo,
	    		    @RequestParam("orderNo") Long no,
	    		    @ModelAttribute("cartDto") List<CartDTO> cartDto,
            		    @AuthUser MemberVo authUser ) {
	System.out.println( "######################" );
	System.out.println( "######################" );
	System.out.println( "######################" );
	System.out.println( cartDto );
	System.out.println( authUser );
	System.out.println( paymenthistoryVo );
	System.out.println( no );
	
	paymenthistoryVo.setOrderNo( no );
	System.out.println( "*******************************" );
	System.out.println( "*******************************" );
	
	if( paymenthistoryVo.getCardKinds()!= null || paymenthistoryVo.getBankKinds() == null ) {
	    paymenthistoryVo.setBankSender( authUser.getName() );
	    paymenthistoryVo.setApprovalNumber( no.toString() );
	}
	orderService.insertPaymenthistory( paymenthistoryVo );
	
	List<PoVo> poList = new ArrayList<PoVo>();
	PoVo vo = new PoVo();
	for(CartDTO dto : cartDto) {
	    vo.setProductNo( dto.getNo() );
	    vo.setOrderNo( no );
	    vo.setPrice( dto.getPrice() );
	    vo.setCount( dto.getCount() );
	    poList.add( vo );
	    orderService.setPO(vo);
	}
	
	System.out.println( vo );
	cartService.delete( authUser.getNo() );
	
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
    public String order( @ModelAttribute RecipientVo recipientVo, 
	    		 @ModelAttribute BuyerVo buyerVo,
	    		 @ModelAttribute OrderVo orderVo,
	    		 @AuthUser MemberVo authUser,
	    		 @AuthUser Model model) {
	
	orderService.insertRecipient( recipientVo );
	orderService.insertBuyer( buyerVo );
	
	orderVo.setMemberNo( authUser.getNo() );
	orderVo.setBuyerNo( buyerVo.getNo() );
	orderVo.setRecipientNo( recipientVo.getNo() );
	
	orderService.insertOrder( orderVo );
	List<CartDTO> list = cartService.getList( authUser.getNo() );
	
	model.addAttribute( "list", list );
	model.addAttribute( "orderNo", orderVo.getNo() );
	System.out.println( "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&" );
	System.out.println( "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&" );
	System.out.println( "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&" );
	System.out.println( orderVo.getNo() );
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
	
	model.addAttribute("cartDto", list);
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
