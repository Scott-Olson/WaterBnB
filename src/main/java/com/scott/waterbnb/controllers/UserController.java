package com.scott.waterbnb.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.scott.waterbnb.models.Pool;
import com.scott.waterbnb.models.User;
import com.scott.waterbnb.services.UserService;
import com.scott.waterbnb.validators.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
	
	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	@GetMapping("/users/signin")
    public String registerForm(@ModelAttribute("user") User user) {
        return "/users/loginRegPage.jsp";
    }
    
    @PostMapping(value="/users/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
    	userValidator.validate(user,  result);
    	if(result.hasErrors()) {
    		return "/users/loginRegPage.jsp";
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	}else {
    		User u = userService.registerUser(user);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/pools/listings";
    		
    	}
    }
    
    @PostMapping(value="/users/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, @ModelAttribute("user") User user) {
        // if the user is authenticated, save their user id in session
    	boolean isAuthenticated = userService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User u = userService.findByEmail(email);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/pools/listings";
    	}else {
    		
    		model.addAttribute("error", "Invalid credentials, please try again");
    		return "/users/loginRegPage.jsp";
    	}
        // else, add error messages and return the login page
    }
    
    @GetMapping("/users/dashboard")
    public String dashboard(HttpSession session, Model model) {
    	User u =  userService.findUserById((Long) session.getAttribute("userId"));
    	session.setAttribute("user", u);
    	List<Pool> pools = u.getListings();
    	session.setAttribute("pools", pools);
    	
    	return "/users/userdashboard.jsp";
    }
    
    
    
    @GetMapping("/")
    public String home() {
    	return "<a href='/user/signin'> Temp landing index </a>";
    }
    @RequestMapping("/users/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/users/signin";
    }
}
