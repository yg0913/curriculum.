package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.SignUpRequest;
import com.example.demo.entity.SignUpEntity;
import com.example.demo.entity.SignUpEntity.User;
import com.example.demo.service.SignUpService;

public class SignUpContoroller {
	
	@Controller
	@RequestMapping("/users/signup")
	public class SignUpControlleController {
		
		@Autowired
	    private SignUpService signUpService;
		
		//新規登録画面
		/**
		 * 新規登録画面を表示
		 * @param id 表示するユーザー名
		 * @param model Model
		 * @return ユーザー一覧
		 */

	    @GetMapping("/users/add")
	    public String displayAdd(Model model) {
	        List<SignUpEntity> users = signUpService.searchAll();
	        model.addAttribute("users", users);
	        return "user/list";
	    }

	    @GetMapping("/users")
	    public String createUserForm(Model model) {
	    	SignUpRequest signUpRequest = new SignUpRequest();
	        model.addAttribute("SignUpRequest", signUpRequest);//Request
	        return "user/create";
	    }

	    @PostMapping("/users")
	    public String createUser(@ModelAttribute User user) {
	        signUpService.save(users);
	        return "redirect:/users";
	    }
	}
}
