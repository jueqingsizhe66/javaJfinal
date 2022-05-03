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


    /**
     *      注意版本问题：jfinal 4.9.18 版本支持大于 2G 的文件上传，从该 jfinal 版本开始，
     *      cos 必须升级到 2022.2 及其未来的更高版本，否则文件上传功能无法使用。
     *      这里要注意早于 4.9.18  的 jfinal 只能使用 cos 2020.4 以及更早其的 cos 版本。
     *
     *     特别注意：如果客户端请求为multipart request（form表单使用了enctype="multipart/form-data"），
     *     那么必须先调用getFile系列方法才能使getPara系列方法正常工作，因为multipart request需要通过getFile
     *     系列方法解析请求体中的数据，包括参数。同样的道理在Interceptor、Validator中也需要先调用getFile。
     */
    public void helloUpload(){
        getFile("tx");
        //render("/hello.html") 表示在webapp目录下
    }

    public void httpHeader(){
        /**
         * 获取http文件头
         */
        System.out.println(getRequest());
        System.out.println("Host: \t"+getRequest().getHeader("Host"));
        System.out.println("Cache-Control: \t"+getRequest().getHeader("Cache-Control"));
        System.out.println("Upgrade-Insecure-Requests: \t"+getRequest().getHeader("Upgrade-Insecure-Requests"));
        System.out.println("User-Agent: \t"+getRequest().getHeader("User-Agent"));
        System.out.println("Accept: \t"+getRequest().getHeader("Accept"));
        System.out.println("Accept-Encoding: \t"+getRequest().getHeader("Accept-Encoding"));
        System.out.println("Accept-language: \t"+getRequest().getHeader("Accept-language"));
        System.out.println("Cookie: \t"+getRequest().getHeader("Cookie"));
        renderText(getRequest().toString());
    }
}
