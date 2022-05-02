package com.demo.blog;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: HelloControler.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.demo.blog
 * @Time: 2022-05-02 22:27
 */
@Path("/hello")
public class HelloControler extends Controller {
    /**
     * 访问方式http://localhost/hello/hello12
     */
    public void hello12(){
        renderText("hello world12");
    }

    public void hello34(){
        renderText("hello world34");
    }

    public void helloHtml(){
//        renderHtml("hello.html");
        render("hello.html");
    }
}
