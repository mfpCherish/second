/*
package com.leyou.controller;

import com.leyou.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//下面的注解相当于@Controller以及@ResponseBody
@RestController
@Slf4j
public class UserController {

    @Autowired
    private User user;

    //该注解相当于@RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    @GetMapping("/hello")
    public User sayhello(){

        //注意在用日志进行输出时候的特点,controller中的值是在访问controller路径的时候进行输出的
        //MyApplication中的日志是在容器加载的时候进行输出的

        log.debug("hello中的"+user.getUsername());
        //如果配置文件这个这里的扫瞄输出级别是info,那么最后也不会进行打印
        return user;

    }
}
*/
