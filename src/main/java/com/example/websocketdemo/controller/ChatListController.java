/*
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
import org.springframework.web.bind.annotation.RestController;
import com.example.websocketdemo.domain.User;
import com.example.websocketdemo.service.UserService;
import com.example.websocketdemo.HttpSessionUtils;

@Controller
@RequestMapping("/users")
public class ChatListController {
	@Autowired UserService userService; 
	// 의존성 주입(Dependency Injection)
	// @Component, @Controller, @Repository, @Service 표시된 클래스형 빈 객체를 스프링이 스캔하여 등록하고, @Autowired 등 요청시 주입 	
	
	// 유저 로그인
	@GetMapping("")
	public String index(Model model, HttpSession session) {
		model.addAttribute("users", userService.getUsers());
		User sessionUser = (User) session.getAttribute("user");
		if (HttpSessionUtils.isLogined(sessionUser)) {
			return "login.html";
		}
		else {
			return "chatlist.html";
		}
	}
	
	@GetMapping("/{id}")
	public String getUserById(@PathVariable(value = "id") Long id, Model model, HttpSession session) {
		User sessionUser = (User) session.getAttribute("user");
		if (HttpSessionUtils.isLogined(sessionUser)) {
			return "redirect:/users/login-form";
		}
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "userinfo.html";
	}

	
	@PostMapping("/users/login")
	public String loginUser(@Valid User user, HttpSession session) {
		System.out.println("login process : ");
		User sessionUser = userService.getUserByUserId(user.getUserId()); 
		if(sessionUser == null) {
			System.out.println("id error : ");
			return "redirect:/users/login-form";
		}
		if(!sessionUser.getUserPw().equals(user.getUserPw())) {
			System.out.println("pw error : ");
			return "redirect:/users/login-form";
		}
		session.setAttribute("user", sessionUser);
		return "redirect:/users/login-success";
	}	
	
	// 유저 등록
	@PostMapping("")
	public String createUser(@Valid User formUser, Model model) {
		userService.saveUser(formUser); 
		model.addAttribute("user", formUser);
		
		return "login.html";
	}
	
	// 유저 수정
	@PutMapping("/{id}")
	public String updateUserById(@PathVariable(value = "id") Long id, @Valid User formUser, Model model, HttpSession session) {
		User user = userService.getUserById(id);
		user.setName(formUser.getName());
		userService.updateUser(user);		
		model.addAttribute("user", user);
		session.setAttribute("user", user);
		return "updateuser.html";
	}
	
	// 유저 삭제
	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable(value = "id") Long id, @Valid User formUser, Model model, HttpSession session) {
		userService.deleteUser(formUser);
		model.addAttribute("name", formUser.getName());
			session.invalidate();
			return "redirect:/";
	}
}
*/