package com.twolak.emusicstore.controller.cart;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.twolak.emusicstore.model.Cart;
import com.twolak.emusicstore.services.CartService;
import com.twolak.emusicstore.services.CustomerService;
import com.twolak.emusicstore.services.security.UserDetailsImpl;

@RestController
@RequestMapping("/rest/cart")
public class CartRestController {
	
	private final CartService cartService;
	private final CustomerService customerService;
	
	public CartRestController(CartService cartService, CustomerService customerService) {
		this.cartService = cartService;
		this.customerService = customerService;
	}

	@GetMapping("/{cartId}")
	public @ResponseBody Cart getCartById(@PathVariable("cartId") Long cartId) {
		Cart cart = this.cartService.getCartById(cartId);
		return cart;
	}
	
	@PutMapping("/{cartId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable("cartId") Long cartId, @RequestBody Cart cart) {
		this.cartService.update(cartId, cart);
	}
	
	@DeleteMapping("/{cartId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("cartId") Long cartId) {
		this.cartService.delete(cartId);
	}
	
	@PutMapping("/add/{productId}")
	public @ResponseBody Cart addItem(@PathVariable("productId") Long productId, @AuthenticationPrincipal UserDetailsImpl activeUser) {
		Cart activeCart = this.customerService.getActiveCartForCustomer(activeUser.getUsername());
		return this.cartService.addItem(activeCart, productId);
	}
	
	@PutMapping("/remove/{productId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable("productId") Long productId, @AuthenticationPrincipal UserDetailsImpl activeUser) {
		Cart activeCart = this.customerService.getActiveCartForCustomer(activeUser.getUsername());
		this.cartService.removeItem(activeCart, productId);
	}
	
	@PutMapping("/items/remove")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItems(@AuthenticationPrincipal UserDetailsImpl activeUser) {
		Cart activeCart = this.customerService.getActiveCartForCustomer(activeUser.getUsername());
		this.cartService.removeItems(activeCart);
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Please verify your request/payload.")
	public void handleClientError(Exception e) {}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error.")
	public void handleServerError(Exception e) {}
}
