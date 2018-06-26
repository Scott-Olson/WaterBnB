package com.scott.waterbnb.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.scott.waterbnb.models.Pool;
import com.scott.waterbnb.models.User;
import com.scott.waterbnb.services.PoolService;
import com.scott.waterbnb.services.ReviewService;
import com.scott.waterbnb.services.UserService;

@Controller
public class PoolController {
	private final PoolService poolService;
	private final UserService userService;
	private final ReviewService reviewService;
	
	public PoolController(PoolService poolService, UserService userService, ReviewService reviewService) {
		this.poolService = poolService;
		this.userService = userService;
		this.reviewService = reviewService;
	}
	
	@GetMapping("/pools/listings")
	public String index(HttpSession session, Model model) {
		try{
			session.getAttribute("userId");
		}
		catch(IllegalArgumentException e){
			return "redirect:/users/login";
		}
		Long userId = (Long) session.getAttribute("userId");
    	User u = userService.findUserById(userId);
    	model.addAttribute("user", u);
    	model.addAttribute("pools", poolService.findAllPools());
    	return "/pools/index.jsp";
		
	}
	
	@GetMapping("/pools/new")
	public String newPoolForm(HttpSession session, Model model, @ModelAttribute("pool") Pool pool) {
		Long userId = (Long) session.getAttribute("userId");
    	User u = userService.findUserById(userId);
    	model.addAttribute("user", u);
		return "/pools/new.jsp";
	}
	
	@PostMapping("/pools/new")
	public String createPool(@Valid @ModelAttribute("pool") Pool pool, HttpSession session, Model model, BindingResult result) {
		System.out.println("oi");
		if(result.hasErrors()) {
			System.out.println("errors are present");
			return "/pools/new.jsp";
		}else {
			System.out.println("Down yonder");
			Pool p = poolService.createPool(pool);
			User u = userService.findUserById((Long) session.getAttribute("userId"));
			p.setHost(u);
			session.setAttribute("pool", p);
			return "redirect:/pools/listings";
		}
	}
	
	@GetMapping("/pools/{id}")
	public String viewPool(@PathVariable("id") Long id,HttpSession session, Model model ) {
		Pool p = poolService.findById(id).get();
		User host = p.getHost();
		session.setAttribute("pool", p);
		session.setAttribute("host", host);
		
		return "/pools/show.jsp";
	}
	
	
}





