package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Data
@Entity
@Table(name = "test")
public class SubjectEntity  {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	/**
	 * 名前
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * アドレス
	 */
	@Column(name = "address")
	private String address;
	
	/**
	 * 電話番号
	 */
	@Column(name = "phone")
	private String phone;
}