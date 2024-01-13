package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class SignUpRequest implements Serializable {
	
	@NotNull(message = "名前を入力してください")
	private String username;
	
	@NotNull(message = "メールアドレスは必須項目です")
    private String email;
}
