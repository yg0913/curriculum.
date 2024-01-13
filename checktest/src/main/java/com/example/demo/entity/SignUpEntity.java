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
@Entity
@Data
@Table(name = "users" , schema = "public" )
public class SignUpEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int userid;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "Email")
	private String email;

}
