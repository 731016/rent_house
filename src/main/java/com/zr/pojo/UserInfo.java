package com.zr.pojo;

import lombok.*;

import java.rmi.StubNotFoundException;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserInfo {
   private String account;    //用户名
   private String password;   //密码
   private String userName;   //用户姓名
   private String nickName;   //昵称
   private String email;      //邮箱
   private String phone;      //手机号
   private String img;        //头像图片
   private Integer state;  //状态（0：禁用 1：普通用户 2：管理员）
}
