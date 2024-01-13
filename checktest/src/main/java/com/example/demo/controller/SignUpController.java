package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.SignUpRequest;
import com.example.demo.service.SignUpService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class SignUpController {
	
	/**
	   * ユーザー情報 Service
	   */
	  @Autowired
	  private SignUpService signUpService;
	  
	  /**
	   * ユーザー情報一覧画面を表示
	   *
	   * @param  model Model
	   * @return  ユーザー情報一覧画面のHTMLのパス
	   */
//	  @GetMapping(value = "/user/list")
//	  public String displayList(Model model) {
//	    List<SignUpEntity> userlist = signUpService.searchAll();
//	    model.addAttribute("userlist", userlist);
//	    return "user/SignUp";
	  /**
	   * ユーザー新規登録画面を表示
	   *
	   * @param  model Model
	   * @return  ユーザー情報一覧画面のHTMLのパス
	   */
	  @GetMapping("/user/SignUp")
	  public String displayAdd(Model model) {
		  model.addAttribute("signUpEntity", new SignUpRequest());
		  return "user/SignUp";
	  }
	  
	  /**
		 * データベースへの登録
		 * @param userRequest リクエストデータ
		 * @param model Model
		 * @return ユーザー一覧画面
		 */
//	  @PostMapping("expense/complete")
//		public String create(@ModelAttribute @Validated SignUpRequest signUpRequest, BindingResult result, Model model) {
//
//			if (result.hasErrors()) {
//				// 入力チェックエラーの場合
//				List<String> errorList = new ArrayList<String>();
//				for (ObjectError error : result.getAllErrors()) {
//					errorList.add(error.getDefaultMessage());
//				}
//				model.addAttribute("validationError", errorList);
//				return "expense/add";
//			}
//			// 経費情報の登録
////			signUpService.update(signUpRequest);
////			return "expense/complete";
//	  }
}
