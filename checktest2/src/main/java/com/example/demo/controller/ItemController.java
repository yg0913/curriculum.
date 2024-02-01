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

import com.example.demo.entity.ItemEntity;
import com.example.demo.form.ItemForm;
import com.example.demo.service.ItemService;

/**
 * 備品情報 Controller
 */
@Controller
public class ItemController {

	/**
	 * 備品情報 Service
	 */
	@Autowired
	ItemService itemService;

	/**
	 * 備品情報一覧画面を表示
	 * @param  model Model
	 * @return  備品情報一覧画面のHTML
	 */
	@GetMapping("/item/list")
	public String itemList(Model model) {
		List<ItemEntity> itemlist = itemService.searchAll();
		model.addAttribute("itemlist", itemlist);
		return "item/list";
	}
	
	/**
	 * 備品新規登録画面を表示
	 * @param  model Model
	 * @return  備品情報一覧画面
	 */
	@GetMapping("/item/add")
	public String itemRecord(Model model) {
		model.addAttribute("itemRequest", new ItemForm());
		return "item/add";
	}
	
	/**
	 * 備品新規登録
	 * @param  itemRequest リクエストデータ
	 * @param  model Model
	 * @return  備品情報一覧画面
	 */
	@PostMapping("/item/create")
	public String itemCreate(@Validated  @ModelAttribute  ItemForm itemRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("itemRequest", new ItemForm());
			model.addAttribute("validationError", errorList);
			return "item/add";
		}
		// 備品情報の登録
		itemService.create(itemRequest);
		return "redirect:/item/list";
	}
	
	/**
	 * 備品情報詳細画面を表示
	 * @param  id 表示する備品ID
	 * @param  model Model
	 * @return  備品情報詳細画面
	 */
	@GetMapping("/item/{id}")
	public String itemDetail(@PathVariable  Integer id, Model model) {
		ItemEntity item = itemService.findById(id);
		model.addAttribute("itemData", item);
		return "item/detail";
	}
	
	/**
	 * 備品編集画面を表示
	 * @param  id 表示する備品ID
	 * @param  model Model
	 * @return  備品編集画面
	 */
	@GetMapping("/item/{id}/edit")
	public String itemEdit(@PathVariable  Integer id, Model model) {
		ItemEntity item = itemService.findById(id);
		ItemForm itemUpdateRequest = new ItemForm();
		itemUpdateRequest.setId(item.getId());
		itemUpdateRequest.setItemName(item.getItemName());
		itemUpdateRequest.setStock(item.getStock());
		itemUpdateRequest.setName(item.getName());
		model.addAttribute("itemUpdateRequest", itemUpdateRequest);
		return "item/edit";
	}
	
	/**
	 * 更新
	 * @param  itemRequest リクエストデータ
	 * @param  model Model
	 * @return  備品情報詳細画面
	 */
	@PostMapping("/item/update")
	public String itemUpdate(@Validated  @ModelAttribute  ItemForm itemUpdateRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "item/edit";
		}
		// 備品情報の更新
		itemService.update(itemUpdateRequest);
		return String.format("redirect:/item/%d", itemUpdateRequest.getId());
	}
}