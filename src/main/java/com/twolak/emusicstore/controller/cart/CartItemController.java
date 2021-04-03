package com.twolak.emusicstore.controller.cart;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twolak.emusicstore.model.Customer;
import com.twolak.emusicstore.services.CustomerService;

@Controller
@RequestMapping("/customer/cart")
public class CartItemController {
	
	private final CustomerService customerService;
	
	public CartItemController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping
	public String getCartForActiveCustomer(@AuthenticationPrincipal User activeUser) {
		Customer customer = this.customerService.getCustomerByUsername(activeUser.getUsername());
		String cartId = this.customerService.getActiveCartForCustomer(customer);
		return "redirect:/customer/cart/" + cartId;
	}
	
//	@GetMapping
//	public String get(HttpServletRequest httpServletRequest) {
//		return "redirect:/cart/" + httpServletRequest.getSession(true).getId();
//	}
	
	@GetMapping("/{cartId}")
	public String getCart(@PathVariable("cartId") String cartId, Model model) {
		model.addAttribute("cartId", cartId);
		
		return "cart/cart";
	}

}
