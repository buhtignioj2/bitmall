package com.cafe24.bitmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.bitmall.service.CategoryService;
import com.cafe24.bitmall.service.MemberService;
import com.cafe24.bitmall.service.OrderService;
import com.cafe24.bitmall.service.ProductService;
import com.cafe24.bitmall.vo.CategoryVo;
import com.cafe24.bitmall.vo.MemberVo;
import com.cafe24.bitmall.vo.PaymenthistoryDTO;
import com.cafe24.bitmall.vo.ProductVo;
import com.cafe24.security.Auth;
import com.cafe24.security.Auth.Role;
import com.cafe24.security.AuthUser;

@Controller
@RequestMapping("/ad")
public class AdminController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private MemberService memberService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private OrderService orderService;
    
    @RequestMapping("")
    public String admin() {
	return "admin/login";
    }
    
    @Auth(role = Role.ADMIN)
    @RequestMapping("/member")
    public String member( Model model ) {
	List<MemberVo> vo = memberService.getAll();
	model.addAttribute( "vo", vo );
	model.addAttribute( "size", vo.size() );
	return "admin/member";
    }
    
    @Auth(role = Role.ADMIN)
    @RequestMapping("/product")
    public String product( Model model) {
	List<ProductVo> vo = productService.getAll();
	model.addAttribute( "vo", vo );
	model.addAttribute( "size", vo.size() );
	return "admin/product";
    }
    
    @Auth(role = Role.ADMIN)
    @RequestMapping( value = "/productnew", method = RequestMethod.GET )
    public String productNew( Model model ) {
	List<CategoryVo> vo = categoryService.getAll();

	model.addAttribute( "vo", vo );
	return "admin/product_new";
    }
    
    @Auth(role = Role.ADMIN)
    @RequestMapping( value = "/productnew", method = RequestMethod.POST )
    public String productNew( @ModelAttribute ProductVo vo, @RequestParam("file") MultipartFile file ) {	
	productService.restore( file, vo );	
	return "redirect:/ad/product";
    }
    
    @Auth(role = Role.ADMIN)
    @RequestMapping("/jumun")
    public String jumun(@AuthUser MemberVo authUser, Model model) {
	List<PaymenthistoryDTO> list = orderService.getList();
	model.addAttribute( "list", list );
	return "admin/jumun";
    }
    
    @Auth(role = Role.ADMIN)
    @RequestMapping("/opt")
    public String opt() {
	return "admin/opt";
    }
    
    @Auth(role = Role.ADMIN)
    @RequestMapping("/optnew")
    public String optNew() {
	return "admin/opt_new";
    }
    
    @Auth(role = Role.ADMIN)
    @RequestMapping("/faq")
    public String faq() {
	return "admin/faq";
    }
    
    @Auth(role = Role.ADMIN)
    @RequestMapping("/faqnew")
    public String faqNew() {
	return "admin/faq_new";
    }
    
}
