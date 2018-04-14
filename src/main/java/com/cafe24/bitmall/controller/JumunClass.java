package com.cafe24.bitmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jumun")
public class JumunClass {
    
    @RequestMapping("")
    public String jumun() {
	return "jumun/jumun";
    }
}
