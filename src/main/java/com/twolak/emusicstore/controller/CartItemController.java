package com.twolak.emusicstore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartItemController {
	
	@GetMapping
	public String get(HttpServletRequest httpServletRequest) {
		return "redirect:/cart/" + httpServletRequest.getSession(true).getId();
	}
	
	@GetMapping("/{cartId}")
	public String getCart(@PathVariable("cartId") String cartId, Model model) {
		model.addAttribute("cartId", cartId);
		
		return "cart/cart";
	}

}
