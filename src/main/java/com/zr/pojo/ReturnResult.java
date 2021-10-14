package com.zr.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnResult {
   private String msg;
   private Object object;
   private Boolean flag;
}
