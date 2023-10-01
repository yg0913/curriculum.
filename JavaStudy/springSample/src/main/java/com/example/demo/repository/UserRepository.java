package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;

/**
 * ユーザー情報 Repository
 */


@Repository
//1行追加
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
}
//Controllerクラスの作成
//フロントエックエンドの入出力の管理を行うControllerクラスを作成します。