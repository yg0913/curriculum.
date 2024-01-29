package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SubjectEntity;
import com.example.demo.form.SubjectForm;
import com.example.demo.repository.SubjectRepository;

/**
 * ユーザー情報 Service
 */
@Service
public class SubjectService {
	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	private SubjectRepository subjectRepository;

	/**
	 * ユーザー情報 全検索
	 * @return  検索結果
	 */
	public List<SubjectEntity> searchAll() {
		return subjectRepository.findAll();
	}
	
	/**
	 * ユーザー情報 新規登録
	 * @param  test ユーザー情報
	 */
	public void create(SubjectForm subjectRequest) {
		SubjectEntity test = new SubjectEntity();
		test.setName(subjectRequest.getName());
		test.setAddress(subjectRequest.getAddress());
		test.setPhone(subjectRequest.getPhone());
		subjectRepository.save(test);
	}
	
	/**
	 * ユーザー情報 主キー検索
	 * @return  検索結果
	 */
	public SubjectEntity findById(Integer id) {
		return subjectRepository.getOne(id);
	}
	
	/**
	 * ユーザー情報 更新
	 * @param  subject 科目情報
	 */
	public void update(SubjectForm subjectUpdateRequest) {
		SubjectEntity test = findById(subjectUpdateRequest.getId());
		test.setName(subjectUpdateRequest.getName());
		test.setAddress(subjectUpdateRequest.getAddress());
		test.setPhone(subjectUpdateRequest.getPhone());
		subjectRepository.save(test);
	}
	
	/**
	 * ユーザー情報 物理削除
	 * @param  id ID
	 */
	public void delete(Integer id) {
		SubjectEntity test = findById(id);
		subjectRepository.delete(test);
	}
}