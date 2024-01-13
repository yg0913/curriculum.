package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SignUpRequest;
import com.example.demo.entity.SignUpEntity;
import com.example.demo.repository.SignUpRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class SignUpService {
	
	@Autowired
    private SignUpRepository signUpRepository;

    public List<SignUpEntity> searchAll() {
        return signUpRepository.findAll();
    }

    public SignUpEntity getUserById(Long id) {
        return signUpRepository.findById(id).orElse(null);
    }

    public void save(SignUpRequest signUpRequest) {
    	signUpRepository.save(SignUpEntity);
    }

    public void delete(Long id) {
    	signUpRepository.deleteById(id);
    }
}
