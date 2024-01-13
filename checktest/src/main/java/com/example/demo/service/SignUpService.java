package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SignUpRequest;
import com.example.demo.entity.SignUpEntity;
import com.example.demo.repository.SignUpRepository;

/**
 * ユーザー情報 Service
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class SignUpService {

	/**
	 * ユーザー情報 Repository
	 */
	  @Autowired
	  private SignUpRepository signUpRepository;
	  
	  /**
	   * ユーザー情報 全検索
	   * @return  検索結果
	   */
	    public List<SignUpEntity> searchAll() {
	    	// TODO 自動生成されたメソッド・スタブ
	  	  return signUpRepository.findAll();
	    }
	    
//	    public void save(SignUpEntity signUpEntity) {
//	    	signUpRepository.save(signUpEntity);
//	    }
	    
	  public void update(SignUpRequest signUpRequest) {
		  SignUpEntity signup = new SignUpEntity();
		  signup.setUserid(signUpRequest.getUserid());
		  signup.setUsername(signUpRequest.getUsername());
		  signup.setEmail(signUpRequest.getEmail());
		  signUpRepository.save(signup);
		 
	  }
}
