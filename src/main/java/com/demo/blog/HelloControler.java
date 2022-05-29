package com.demo.blog;

import com.demo.common.Interceptor.uploadIntercept;
import com.demo.common.Renders.MyRender;
import com.demo.common.model.Article;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.kit.PathKit;
import com.jfinal.render.JsonRender;
import com.jfinal.upload.UploadFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    @Inject
    UserService userService;
    /**
     * 访问方式http://localhost/hello/hello12
     * 我已经会注入字段了
     */
    public void hello12(){
        userService.doSomething();
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
    @Before(uploadIntercept.class)
    public void helloUpload(){

        /**
         * firefox有效
         * chrome无效
         */
//        if (!getRequest().getMethod().equals("OPTIONS"))//先判断请求非options
//        file = getFile("file");//不是options请求在getFile(
        System.out.println(getPara("name"));
//        getFile("tx");
//        render("helloUpload.html");
        //render("/hello.html") 表示在webapp目录下
        render("helloUpload.html");
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

    /**单文件上传
     * 1. getFile(String parameterName, String uploadPath)；
     * 2. uploadPath参数会指定上传路径，但其指定的前提是基础路径，upload，也就是说指定file路径，然后上传的文件的路径为upload/file；
     * 3. 文件上传的基本路径可以在常量进行配置
     *
     */
    public void uploadFile(){
        /*使用UploadFile获取前台文件
         *第一个参数是页面file的name名，第二个参数是指定保存的文件夹，第三个参数是设置文件的最大值，第四个参数是设置文件的编码方式
         *UploadFile  upFile = getFile("fileText", filedir); //或getFile(getPara("fileText"), filedir);
         */
        final int maxSize = 100 * 1024 * 1024;
        String filedir= PathKit.getWebRootPath()+"/text";
        UploadFile  upFile = getFile("fileText","",maxSize,"UTF-8");

        /*对文件进行重命名
         *upFile.getFile().renameTo(dest);可使用file的原生方法去对file进行重命名，
         *jf3.1版本已经添加自定义名称功能，所以这个适合3.1之前的版本使用;
         *根据原文件名使用时间戳和随机数重命名，保存，原来的临时文件会自动删除
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String fileName = upFile.getFileName();
        String lastThreeLetter = fileName.substring(fileName.lastIndexOf("."));
        String sqlName = sdf.format(new Date())+(int)(Math.random()*10000)+lastThreeLetter;
        upFile.getFile().renameTo(new File(PathKit.getWebRootPath()+"/upload/file/"+sqlName));

        /*
         *上传文件的同时，如果包含其他的携带的变量 的话需要先使用getFile方法，之后才能获取其他的变量参数
         */
        String otherParameter = getPara("otherValue");
        System.out.println("获取到的额外的参数："+otherParameter);

        /*
         * jf后台在获取文件的时候可直接获取文件文件的修改名称、原名称、上传保存的路径
         *(getUploadPath(),不包含文件，只到达文件夹；getFile()能够直接获取到文件，包括文件名)、
         * 文件的类型（例如jpeg文件格式，获取到的是image/jpeg）
         */
        System.out.println("1："+upFile.getFileName()+" 2："+upFile.getOriginalFileName()+" 3："+upFile.getUploadPath());
        System.out.println("文件："+upFile.getFile()+" 4："+upFile.getContentType());

        /*
         * jf获取文件根路径的方法：
         */
        String path = PathKit.getWebRootPath();
        System.out.println(path);

        /*
         * 1.返回的是text/html，前台需使用json工具转换成json对象才能获取数据，var htmlToJson = JSON.parse(data);
         * 2.如果不包含文件上传的form表单提交异步刷新，则直接使用renderJSON(params);
         */
        String params = "{\"ifSuccess\":\"success\"}";
        render(new JsonRender(params).forIE());

    }

    /**多文件上传
     *多文件上传需要在src下面添加com.oreilly.servlet包，添加MultipartRequest.java的类，用于处理多文件重命名问题
     */
    public void moreUploadFile(){

        //统一上传到默认的项目根目录
        List<UploadFile> upFile = getFiles("file");

        //循环遍历获取文件重命名，如果不需要重命名则无需此步骤
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String formatTime = sdf.format(new Date());
        for(UploadFile upf: upFile){
            System.out.println("循环获取文件名："+upf.getFileName());
            //根据原文件名使用时间戳和随机数重命名，保存，原来的临时文件会自动删除
            String fileName = upf.getFileName();
            String lastThreeLetter = fileName.substring(fileName.lastIndexOf("."));
            String sqlName =formatTime + (int)(Math.random()*10000)+lastThreeLetter;
            upf.getFile().renameTo(new File(PathKit.getWebRootPath()+"/upload/file/"+sqlName));
        }

        System.out.println("集合长度："+upFile.size());
        String params = "{\"ifSuccess\":\"success\"}";
        render(new JsonRender(params).forIE());
    }

    /**
     * 通过MyRender返回Render
     */
    public void getMyselfRender(){
//        render("hello.html");
        render(new MyRender().getRender("aaa"));
    }

}
