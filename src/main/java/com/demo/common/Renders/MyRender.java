package com.demo.common.Renders;

import com.jfinal.render.Render;
import com.jfinal.render.RenderFactory;
import com.jfinal.render.TextRender;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: MyRender.java
 * @Description: 自定义Render 接管RenderFactory
 * @Package com.demo.common.Renders
 * @Time: 2022-05-29 21:25
 */
public class MyRender extends RenderFactory {

    @Override
    public Render getRender(String view) {
        return new TextRender("My Render Factory+ "+view);
    }
}
