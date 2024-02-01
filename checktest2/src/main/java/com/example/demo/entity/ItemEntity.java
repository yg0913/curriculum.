package com.example.demo.entity;

import java.util.Date;

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
@Table(name = "item")
public class ItemEntity  {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	/**
	 * 備品名
	 */
	@Column(name = "item_name")
	private String itemName;
	
	/**
	 * 在庫数
	 */
	@Column(name = "stock")
	private Integer stock;
	
	/**
	 * 登録者名
	 */
	@Column(name = "person_name")
	private String name;
	
	/**
	 * 登録日時
	 */
	@Column(name = "reg_date")
	private Date regDate;
}