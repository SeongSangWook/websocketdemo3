package com.example.websocketdemo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.websocketdemo.domain.User;
import com.example.websocketdemo.service.UserService;
import com.example.websocketdemo.HttpSessionUtils;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired UserService userService; 
	// 의존성 주입(Dependency Injection)
	// @Component, @Controller, @Repository, @Service 표시된 클래스형 빈 객체를 스프링이 스캔하여 등록하고, @Autowired 등 요청시 주입 	
	
	@PostMapping("")
	public String createUser(@Valid User formUser, Model model) {
		userService.saveUser(formUser); 
		model.addAttribute("user", formUser);
		return "welcome";
	}	
	@GetMapping("")
	public String getUsers(Model model, HttpSession session, Long pageNo) { //@PathVariable(value = "pageNo") Long pageNo) {
		System.out.println(pageNo);
		if(!HttpSessionUtils.isLoginUser(session))
			return "redirect:/users/login-form";
		model.addAttribute("users", userService.getUsers());
		// model.addAttribute("users", userService.getUsers(pageNo));
		return "/users/list";
	}	
	@GetMapping("/{id}")
	public String getUserById(@PathVariable(value = "id") Long id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "/users/info";
	}
	
	@PutMapping("/{id}")
	public String updateUserById(@PathVariable(value = "id") Long id, @Valid User formUser, Model model, HttpSession session) {
		User user = userService.getUserById(id);
		user.setUserPw(formUser.getUserPw());
		user.setName(formUser.getName());
		userService.updateUser(user);		
		model.addAttribute("user", user);
		session.setAttribute("user", user);
		return "/users/info";
	}	
	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable(value = "id") Long id, @Valid User formUser, Model model) {
		userService.deleteUser(formUser);
		model.addAttribute("name", formUser.getName());
		return "/users/withdrawal";
	}
}