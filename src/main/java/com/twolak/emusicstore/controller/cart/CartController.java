package com.twolak.emusicstore.controller.cart;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twolak.emusicstore.model.Cart;
import com.twolak.emusicstore.services.CustomerService;
import com.twolak.emusicstore.services.security.UserDetailsImpl;

@Controller
@RequestMapping("/customer/cart")
public class CartController {
	
	private final CustomerService customerService;
	
	public CartController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	public String getCartForActiveCustomer(@AuthenticationPrincipal UserDetailsImpl activeUser) {
		Cart activeCart = this.customerService.getActiveCartForCustomer(activeUser.getUsername());
		return "redirect:/customer/cart/" + activeCart.getId();
	}
	
//	@GetMapping
//	public String get(HttpServletRequest httpServletRequest) {
//		return "redirect:/cart/" + httpServletRequest.getSession(true).getId();
//	}
	
	@GetMapping("/{cartId}")
	public String getCart(@PathVariable("cartId") Long cartId, Model model) {
		model.addAttribute("cartId", cartId);
		
		return "cart/cart";
	}
}
