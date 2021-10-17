package com.zr.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//看房记录
public class CheckHouseRecord {
   private Integer cId;    //编号
   private Integer hId;    //房屋ID
   private String account;//用户账号
   private Date checkDate; //看房日期
}
