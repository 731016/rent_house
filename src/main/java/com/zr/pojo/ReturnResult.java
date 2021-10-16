package com.zr.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnResult {
   private String msg;  //前台弹出的消息
   private Object object; //前台需要的对象
   private Boolean flag;  //处理结果
   private Integer state;  //返回的状态码 [200,登陆成功; 404,登陆失败; 201,注册成功,500,已经是房东]
   public ReturnResult(String msg,Object object,Boolean flag){
      this.msg=msg;
      this.flag=flag;
      this.object=object;
   }
}
