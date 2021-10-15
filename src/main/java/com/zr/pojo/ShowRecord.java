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
public class ShowRecord {
    private CheckHouseRecord checkHouseRecord; //看房记录对象
    private String title;      //标题
}
