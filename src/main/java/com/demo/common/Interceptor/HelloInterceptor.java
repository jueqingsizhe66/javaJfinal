package com.demo.common.Interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: HelloInterceptor.java
 * @Description: 编写自己的一个拦截器
 * inv.get
 * @Package com.demo.common.Interceptor
 * @Time: 2022-04-24 0:52
 */
public class HelloInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        System.out.println("Open Intercept ... ");
        inv.invoke();
//        inv.getController().redirect("/hello") //拦截器可以重定向
        System.out.println("Out Intercept ... ");
    }
}
