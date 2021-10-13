package com.zr.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//朝向类
public class Toward {
   private Integer towardId;    //朝向ID
   private String towardName;   //朝向名称
}
