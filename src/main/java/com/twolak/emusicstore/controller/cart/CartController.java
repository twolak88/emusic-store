package com.twolak.emusicstore.controller.cart;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/rest/cart")
public class CartController {
	
	private final CartService cartService;
	
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping("/{cartId}")
	public @ResponseBody Cart read(@PathVariable("cartId") String cartId) {
		return this.cartService.readCart(cartId);
	}
	
	@PutMapping("/{cartId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable("cartId") String cartId, @RequestBody Cart cart) {
		this.cartService.update(cartId, cart);
	}
	
	@DeleteMapping("/{cartId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("cartId") String cartId) {
		this.cartService.delete(cartId);
	}
	
	@PutMapping("/add/{productId}")
	public @ResponseBody Cart addItem(@PathVariable("productId") Long productId, HttpServletRequest httpServletRequest) {
		String sessionId = httpServletRequest.getSession(true).getId();
		return this.cartService.addItem(sessionId, productId);
	}
	
	@PutMapping("/remove/{productId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable("productId") Long productId, HttpServletRequest httpServletRequest) {
		String sessionId = httpServletRequest.getSession(true).getId();
		this.cartService.removeItem(sessionId, productId);
	}
	
	@PutMapping("/items/remove")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItems(HttpServletRequest httpServletRequest) {
		String sessionId = httpServletRequest.getSession(true).getId();
		this.cartService.removeItems(sessionId);
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
	public void handleServerError(Exception e) {}
}
