package com.example.ex02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class TaskController {
// 아이디와 비밀번호를 입력받은 후 아이디가 admin일 경우 admin.html로 이동
//	아이디가 user일 경우 user.html로 이동
	
//	- admin.html
//	- user.html
	
	@GetMapping("/loginForm")
	public String goLoginForm() {
		return "task/task01/login";
	}
	
	@PostMapping("/login")
//	외부에서 전달받은 아이디와 패스워드를 매개변수르 받는다.
	public String login(@ModelAttribute("id") String id, String pw) {
		// 만약 아이디가 admin인 경우
		if(id.equals("admin")) {
			//admin.jsp로 이동
			return "task/task01/admin";
		}
//		만약 아이디가 admin이 아닐 경우 user.jsp로 이동
		return	"task/task01/user";
	}
	
	
	
}
