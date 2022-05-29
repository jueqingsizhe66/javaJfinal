package com.demo.blog;

import com.demo.common.model.Article;

import java.util.List;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: ArticleService.java
 * @Description: 把所有Article业务逻辑放在此处 可以增加@before操作，这样比如可以延迟写入数据库等
 * @Package com.demo.blog
 * @Time: 2022-05-30 0:35
 */
public class ArticleService {
    public static Article DAO = new Article();

    /**
     * 可以增加拦截器操作，当你的写入频率特别高的时候
     * @param article
     * @return
     */
    public boolean save(Article article){
        return article.save();
    }

    public boolean delete(Long id){
        return DAO.deleteById(id);
    }

    public boolean update(Article article){
        return article.update();
    }
    public List<Article> findAll(){
        return DAO.findAll();
    }

    public List<Article> find(String sql){
        return DAO.find(sql);
    }



}
