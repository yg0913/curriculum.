package com.example.demo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class SubjectForm {
  /**
   * ID
   */
  private Integer id;
  
  /**
   * 科目
   */
  @NotEmpty(message = "名前を入力してください")
  @Size(max = 20, message = "名前は20文字以内で入力してください")
  private String name;

  @NotEmpty(message = "アドレスを入力してください")
  private String address;
  
  @NotEmpty(message = "電話番号を入力してください")
  private String phone;
}