# 出租房屋信息管理系统

## 说明
项目采用本地的`tomcat`作为服务器
使用`maven`管理jar文件
jdk版本为 `11`

sql文件内的管理员账号为
```
username：root
password：root
```
### 遇到问题提交Issue


### <ins>提交项目禁止提交`.idea`和`target目录` !!!</ins>

## 任务进度和每日任务：
<del>https://docs.qq.com/sheet/DQk5qSmZFbWR3Y0NE?groupUin=4ffoQqsgdrk51OP5JTQ3ng%253D%253D&tab=0stqpd</del><br >
 :white_check_mark: 已完成！

## 常用的代码
### 弹出层消息模块
```html
<script src="/resource/js/jquery-3.6.0.min.js"></script>
<script src="/resource/js/coco-message.js"></script>
<script>
cocoMessage.config({
        duration: 2000,
    });
function example(n) {
        let div = document.createElement("div");
        switch (n) {
          case 0:
            cocoMessage.info(3000, "请先登录！", function () {
              console.log("close");
            });
            break;

          case 1:
            div.innerText = "修改成功！";
            cocoMessage.success(div);
            break;

          case 2:
            cocoMessage.warning("需要手动关闭", 0);
            break;

          case 3:
            cocoMessage.error("修改失败！", 3000);
            break;

          case 4:
            var closeMsg = cocoMessage.loading(true);
            setTimeout(function () {
              closeMsg();
            }, 4000);
            break;

          case 5:
            cocoMessage.destroyAll();
            break;

          default:
            break;
        }
      }
</script>
```



### header头部登录模块和退出
```html
<link rel="stylesheet" href="/resource/css/public.css">
<script src="/resource/js/jquery-3.6.0.min.js"></script>
<script src="/resource/js/public_login.js"></script>
<%--头部 START--%>
    <header>
        <ul>
            <li><a href="#" class="nav_header current">首页</a></li>
            <li><a href="renting.jsp" class="nav_header">租房</a></li>
            <li><a href="rent.jsp" class="nav_header">出租</a></li>
            <li class="reg_log">
                <a href="fdregister.jsp" class="nav_header landlord">成为房东</a>
            </li>
            <li class="reg_log" id="show_register">
                <a href="register.jsp" class="nav_header">注册</a>
            </li>
            <li class="reg_log nav_header vertical_line" style="color: #fff;">|</li>
            <li class="reg_log" id="show_login">
                <a href="login.jsp" class="nav_header">登录</a>
            </li>
        </ul>
    </header>
<%--头部 END--%>
```

### JavaScript

```javascript
//中文的正则
/^[\u4e00-\u9fa5]+$/;
//本地图片转在线
let objUrl = getObjectURL(this.files[0]);//this为图片控件
function getObjectURL(file) {
            let url = null;
            if (window.createObjectURL != undefined) {
                url = window.createObjectURL(file);
            } else if (window.URL != undefined) {
                url = window.URL.createObjectURL(file);
            } else if (window.webkitURL != undefined) {
                url = window.webkitURL.createObjectURL(file);
            }
            return url;
        }
```

### Java

```java
/**
     * 消息摘要方法，md5加密
     *
     * @param msg
     * @return
     */
    public static String msgEncrypt(String msg) {
        String result = "";
        try {
            byte[] digest = null;
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest = md5.digest(msg.getBytes("utf-8"));
            result = new BigInteger(1, digest).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 产生不重复的文件名
     *
     * @param extension
     * @return
     */
    public static String randomFileName(String extension) {
        Random random = new Random();
        int randomNum = random.nextInt(90000) + 10000;
        return String.valueOf(new Date().getTime()) + randomNum + "." + extension;
    }
```

## 在线租房项目开发注意事项
-----
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
-----

### ER图
![输入图片说明](https://images.gitee.com/uploads/images/2021/1014/103454_09c723c8_8254421.jpeg "er图.jpg")

### 用例图
![输入图片说明](https://images.gitee.com/uploads/images/2021/1014/103614_8077cf44_8254421.png "系统总体用例图.png")

![输入图片说明](https://images.gitee.com/uploads/images/2021/1014/103628_467f8ac2_8254421.png "租户注册，登录用例图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/1014/103637_5ad1221e_8254421.png "租户租房流程.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/1014/103544_3e0ce51a_8254421.png "房东发布房源流程.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/1014/103602_3f01b638_8254421.png "管理员用例图.png")
