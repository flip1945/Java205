package com.bitcamp.sc.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PayController {
	
	@RequestMapping("/shop/pay")
	public String shopPay(Model model) {
		model.addAttribute("userName", "CHY");
		return "shop_payment";
	}
}
