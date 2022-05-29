package com.demo.common.Interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: uploadIntercept.java
 * @Description: (用一句话描述该文件做什么 ?)
 * @Package com.demo.common.Interceptor
 * @Time: 2022-05-04 18:41
 */
public class uploadIntercept implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        //inv.getController().getRequest().setAttribute("Content-Type","text/plain;charset=UTF-8");
        inv.getController().getRequest().setAttribute("Content-Type","multipart/form-data");
        inv.invoke();
    }
}
