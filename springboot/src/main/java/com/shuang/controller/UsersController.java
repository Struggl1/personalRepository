package com.shuang.controller;

import com.shuang.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * 用户表单校验
 * 解决异常的方式，可以在跳转的方法中注入一个users对象
 * 注意：用于springMVC会将该对象放到Model中进行传递，key的名称会使用该对象的驼峰命名法来作为key，所以参数的变量名需要与对象的名称相同
 *
 * 如果想为传递的对象更改名称，可以使用@ModelAttribute（“aa”）这表示当前传递的对象key为aa
 * n那么在页面中获取该对象的可以也需要更改为aa
 *
 */
@Controller
public class UsersController {
    @RequestMapping("/addUser")
    public String showPage(Users users){
        System.out.println("12345678");
        return "addUser";
    }

    /**
     *
     * @param users
     * @return
     * Valid 开启对users对象的数据校验
     * BindingResult:封装了校验的结果
     */
    @RequestMapping("/save")
    public String save(@Valid Users users, BindingResult result){
        if(result.hasErrors()){
            return "addUser";
        }else {
            System.out.println(users.toString());
            return "ok";
        }
    }
}
