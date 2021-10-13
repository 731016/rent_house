package com.zr.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//房东
public class Landlord {
   private Integer lId;    //房东ID
   private String lName;   //房东名称
   private String phone;   //手机号
   private String address; //住址
   private String idCard;  //身份证
}
