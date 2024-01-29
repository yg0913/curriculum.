package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.SubjectEntity;
import com.example.demo.form.SubjectForm;
import com.example.demo.service.SubjectService;

/**
 * 科目情報 Controller
 */
@Controller
public class SubjectController {

	/**
	 * ユーザー情報 Service
	 */
	@Autowired
	SubjectService subjectService;

	/**
	 * ユーザー情報一覧画面を表示
	 * @param  model Model
	 * @return  ユーザー情報一覧画面のHTML
	 */
	@GetMapping("/user/list")
	public String userList(Model model) {
		List<SubjectEntity> testlist = subjectService.searchAll();
		model.addAttribute("testlist", testlist);
		return "user/list";
	}
	
	/**
	 * ユーザー新規登録画面を表示
	 * @param  model Model
	 * @return  ユーザー情報一覧画面
	 */
	@GetMapping("/user/add")
	public String userRegister(Model model) {
		model.addAttribute("subjectRequest", new SubjectForm());
		return "user/add";
	}
	/**
	 * ユーザー新規登録
	 * @param  userRequest リクエストデータ
	 * @param  model Model
	 * @return  ユーザー情報一覧画面
	 */
	@PostMapping("/user/create")
	public String userCreate(@Validated  @ModelAttribute  SubjectForm subjectRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("subjectRequest", new SubjectForm());
			model.addAttribute("validationError", errorList);
			return "user/add";
		}
		// ユーザー情報の登録
		subjectService.create(subjectRequest);
		return "redirect:/user/list";
	}	
	
	/**
	 * ユーザー情報詳細画面を表示
	 * @param  id 表示するユーザーID
	 * @param  model Model
	 * @return  ユーザー情報詳細画面
	 */
	@GetMapping("/user//{id}")
	public String userDetail(@PathVariable  Integer id, Model model) {
		SubjectEntity test = subjectService.findById(id);
		model.addAttribute("test", test);
		return "user/detail";
	}
	/**
	 * ユーザー編集画面を表示
	 * @param  id 表示するユーザーID
	 * @param  model Model
	 * @return  ユーザー編集画面
	 */
	@GetMapping("/user/{id}/edit")
	public String userEdit(@PathVariable  Integer id, Model model) {
		SubjectEntity test = subjectService.findById(id);
		SubjectForm subjectUpdateRequest = new SubjectForm();
		subjectUpdateRequest.setId(test.getId());
		subjectUpdateRequest.setName(test.getName());
		subjectUpdateRequest.setAddress(test.getAddress());
		subjectUpdateRequest.setPhone(test.getPhone());
		model.addAttribute("subjectUpdateRequest", subjectUpdateRequest);
		return "user/edit";
	}
	/**
	 * ユーザー更新
	 * @param  userRequest リクエストデータ
	 * @param  model Model
	 * @return  ユーザー情報詳細画面
	 */
	@PostMapping("/user/update")
	public String subjectUpdate(@Validated  @ModelAttribute  SubjectForm subjectUpdateRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("subjectUpdateRequest", new SubjectForm());
			model.addAttribute("validationError", errorList);
			return "user/edit";
		}
		// ユーザー情報の更新
		subjectService.update(subjectUpdateRequest);
		return String.format("redirect:/user/%d", subjectUpdateRequest.getId());
	}
	
	/**
	 * ユーザー情報削除
	 * @param  id 表示するID
	 * @param  model Model
	 * @return  ユーザー情報詳細画面
	 */
	@GetMapping("/user/{id}/delete")
	public String subjectDelete(@PathVariable Integer id, Model model) {
		// 科目情報の削除
		subjectService.delete(id);
		return "redirect:/user/list";
	}
}