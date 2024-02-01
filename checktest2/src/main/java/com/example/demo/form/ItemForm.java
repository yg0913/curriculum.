package com.example.demo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 備品情報 リクエストデータ
 */
@Data
public class ItemForm {
  /**
   * ID
   */
  private Integer id;
  
  /**
   * 備品名
   */
  @NotEmpty(message = "備品名は必須です")
  @Size(max = 100, message = "備品名は100文字以内で入力してください")
  private String itemName;

  /**
   * 在庫数
   */
  @NotNull(message = "在庫数は必須です")
  private Integer stock;
  
  /**
   * 登録者名
   */
  @NotEmpty(message = "登録者名は必須です")
  @Size(max = 100, message = "登録者名は100文字以内で入力してください")
  private String name;
  
  /**
   * 登録日
   */
//  @NotEmpty(message = "登録日は必須です")
//  private Date regDate;
}