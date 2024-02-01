package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ItemEntity;
import com.example.demo.form.ItemForm;
import com.example.demo.repository.ItemRepository;

/**
 * 備品情報 Service
 */
@Service
public class ItemService {
	/**
	 * 備品情報 Repository
	 */
	@Autowired
	private ItemRepository itemRepository;

	/**
	 * 備品情報 全検索
	 * @return  検索結果
	 */
	public List<ItemEntity> searchAll() {
		return itemRepository.findAll();
	}
	
	/**
	 * 備品情報 新規登録
	 * @param  item 備品情報
	 */
	public void create(ItemForm itemRequest) {
		Date now = new Date();
		ItemEntity item = new ItemEntity();
		item.setItemName(itemRequest.getItemName());
		item.setStock(itemRequest.getStock());
		item.setName(itemRequest.getName());
		item.setRegDate(now);
		itemRepository.save(item);
	}
	
	/**
	 * 科目情報 主キー検索
	 * @return  検索結果
	 */
	public ItemEntity findById(Integer id) {
		return itemRepository.getOne(id);
	}
	
	/**
	 * 科目情報 更新
	 * @param  subject 科目情報
	 */
	public void update(ItemForm itemUpdateRequest) {
		ItemEntity item = findById(itemUpdateRequest.getId());
		item.setItemName(itemUpdateRequest.getSubject());
		subjectRepository.save(subject);
	}
}