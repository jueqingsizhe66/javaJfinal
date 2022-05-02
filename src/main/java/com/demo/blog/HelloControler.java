package com.demo.blog;

import com.demo.common.model.Article;
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
        //render("/hello.html") 表示在webapp目录下
    }

    /**
     * 访问方式： http://localhost/hello/helloGetPara/?key1="zhaoliang"&key2="lady"
     */
    public void helloGetPara(){
//        renderHtml("hello.html");
        String para=getPara();
        System.out.println("para: "+ para);
        System.out.println("para0: "+ getPara(0,"zero?"));
        System.out.println("para1: "+getPara(1,"first?")); //如果1为空 范围first?
        String title=getPara("title");
        String subtitle=getPara("subtitle");
        String content=getPara("content");
        renderText("hello "+ title+" \t" + subtitle+"\t"+content);
        //render("helloForm.html");
        //render("/hello.html") 表示在webapp目录下
    }


    public void helloForm(){
//        renderHtml("hello.html");
        String title=getPara("title");
        String subtitle=getPara("subtitle");
        String content=getPara("content");
        System.out.println("hello "+ title+" \t" + subtitle+"\t"+content);
        render("helloForm.html");
        //render("/hello.html") 表示在webapp目录下
    }


    public void helloArticle(){
//        renderHtml("hello.html");
        String title=getPara("title");
        String subtitle=getPara("subtitle");
        String content=getPara("content");
        //Article article=getBean(Article.class);
        Article article=getBean(Article.class,"ar1"); //别名是ar1 那么对应html必须也是这样写
        System.out.println(article);
        System.out.println("hello "+ article.title+" \t" + article.subtitle+"\t"+article.content);
        render("helloArticle.html");

        //render("/hello.html") 表示在webapp目录下
    }
}
