package com.demo.common.Handler;

import com.jfinal.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: HelloHandler.java
 * @Description: 编写自己的处理器
 * @Package com.demo.common.Handler
 * @Time: 2022-04-24 0:03
 */
public class HelloHandler extends Handler {

    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
        System.out.println("Enter Handler .............");
        next.handle(target,request,response,isHandled);
        System.out.println("Exit Handler .............");
    }
}
