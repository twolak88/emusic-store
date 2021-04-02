package com.twolak.emusicstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(@RequestParam(value="error", required = false) String error,
						@RequestParam(value = "logout", required = false) String logout, Model model,
						HttpServletRequest request) {
        String errorMessge = null;
        String messge = null;
        if(error != null) {
            errorMessge = (String) request.getSession().getAttribute("AUTH_ERROR");
        }
        if(logout != null) {
        	messge = "You have been successfully logged out.";
        }
        model.addAttribute("errorMessge", errorMessge);
        model.addAttribute("messge", messge);
        return "login/login";
	}
	
	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
		return "redirect:/login?logout=true";
	}
}
