package com.demo.common.Interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: HelloInterceptor.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.demo.common.Interceptor
 * @Time: 2022-04-24 0:52
 */
public class HelloInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        System.out.println("Open Intercept ... ");
        inv.invoke();
        System.out.println("Out Intercept ... ");
    }
}
