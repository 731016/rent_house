# 出租房屋信息管理系统

#### 介绍
出租房交易平台

暂时存放项目代码

## <ins>提交项目禁止提交`.idea`和`target目录` !!!</ins>

## 任务进度和每日任务：
https://docs.qq.com/sheet/DQk5qSmZFbWR3Y0NE?groupUin=4ffoQqsgdrk51OP5JTQ3ng%253D%253D&tab=0stqpd

## 用例图
https://gitee.com/LovelyHzz/rent_house/blob/master/%E7%A7%9F%E6%88%BF%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9F%E7%94%A8%E4%BE%8B%E5%9B%BE.html

### 在线租房项目开发注意事项
1. ajax后台返回时，同意使用pojo包中的ReturnResult类的实例作为返回对象，使用JSON类实现JSON与对象的互转：
```java
JSON.toJSONString:对象-->JSON字符串
JSON.parse:JSON字符串-->对象
```
2. 前端网页在使用外部的css、js等文件时，引用应到本地文件，并且应用的路径必须以“`/resource`”开头，避免因相对定位导致资源找不到的情况
3. 尽量做到css、js与网页分离，增强网页的维护性
4. 项目中的Utils类是除数据操作之外的所有工具类，其中有静态的方法可使用，需增加功能请自行添加
5. 因为tomcat编码问题，目前所有使用response的地方需要自己设置编码格式，否则会导致css、js等文件的中文乱码
6. 如有建议，可在本文档后增加事项
