package com.bitcamp.sc.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PayController {
	
	@RequestMapping("/shop/pay")
	public String shopPay() {
		return "shop_payment";
	}
}
