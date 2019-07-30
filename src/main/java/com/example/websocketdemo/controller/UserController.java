
package com.example.websocketdemo.controller;
/*
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

@RestController
public class UserController {
	@Autowired UserService userService; 
	// 의존성 주입(Dependency Injection)
	// @Component, @Controller, @Repository, @Service 표시된 클래스형 빈 객체를 스프링이 스캔하여 등록하고, @Autowired 등 요청시 주입 	
	
	// 유저 로그인
	@GetMapping("")
	public String index(@Valid User formUser, Model model) {
		return "index";	
	}
	
	// 유저 등록
	@PostMapping("")
	public String createUser(@Valid User formUser, Model model) {
		System.out.println("asdf");
		System.out.println(formUser.getUserId());
		System.out.println(formUser.getUserPw());
		System.out.println(formUser.getName());
		return "index";
	}
	
	// 유저 삭제
	@DeleteMapping("")
	public String deleteUser(@Valid User formUser, Model model) {
		return "index";
	}
	
	// 유저 수정
	@PutMapping("")
	public String updateUser(@Valid User formUser, Model model) {
		return "index";
	}
}
*/