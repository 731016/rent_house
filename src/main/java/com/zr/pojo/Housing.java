package com.zr.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//房屋
public class Housing {
   private Integer hId;       //房屋ID
   private String title;      //标题
   private Integer rent;      //租金
   private String houseType;  //户型
   private Double area;       //面积
   private Integer towardId;  //朝向编号
   private String ImgList;    //图片列表
   private Integer lId;       //房东编号
   private Integer typeId;    //类型编号
   private String facilities; //配套设施
   private Integer state; //状态（0：取消发布，1：发布）
   private Integer aid; //区域
}
