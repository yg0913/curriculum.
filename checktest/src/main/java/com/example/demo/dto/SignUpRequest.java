package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class SignUpRequest implements Serializable {

	@NotNull(message = "ユーザーIDを入力してください")
	private Integer userid;
	
	@NotNull(message = "名前を入力してください")
	private String username;
	
	@NotNull(message = "メールアドレスを入力してください")
	private String email;
}
