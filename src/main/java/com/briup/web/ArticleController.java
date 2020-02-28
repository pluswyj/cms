package com.briup.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Article;
import com.briup.bean.ArticleCategory;
import com.briup.bean.Category;
import com.briup.service.IArticleService;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private IArticleService articleService;
	
	
	@PutMapping("/saveOrUpdate")
	@ApiOperation(value="/保存或更新一个文章",notes = "category.code,category.name可以不用写")
	public Message<String> saveOrUpdate(Article article){
		Message<String> message = null;
		try {
			articleService.saveOrUpdate(article);
			message = MessageUtil.success("保存成功");
		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		
		return message;
	}
	
	@GetMapping("/findById")
	@ApiOperation("根据id查询文章并且关联栏目信息")
	@ApiImplicitParam(name="id",value="文章id",paramType = "query",dataType = "int",required = true)
	public Message<ArticleCategory> findById(int id) {
		Message<ArticleCategory> message = null;
		try {
			Article article = articleService.findById(id);
			//article category
			ArticleCategory ac = new ArticleCategory
			(article.getId(), article.getAuthor(), article.getClickTimes(), 
					article.getContent(), article.getPublishDate(), article.getTitle(),
					article.getCategory().getName());
			message = MessageUtil.success(ac);
		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		System.out.println("--------"+message.getData());
		return message;
	}
	
	@GetMapping("/findAll")
	@ApiOperation("查询所有的文章信息")
	public Message<List<ArticleCategory>> findAll(){
		List<Article> articlelist = articleService.findAll();
		List<ArticleCategory> aclist = new ArrayList<ArticleCategory>();
		for(Article a:articlelist) {
			System.out.println(a.getCategory());
			ArticleCategory ac = new ArticleCategory
			(a.getId(), a.getAuthor(), a.getClickTimes(), a.getContent(), 
			a.getPublishDate(), a.getTitle(), a.getCategory().getName());
			aclist.add(ac);
		}
		return MessageUtil.success(aclist);
	}
	@DeleteMapping("/deleteById")
	@ApiOperation("根据id删除文章")
	public Message<String> deleteById(int id) {
		Message<String> message = null;
		try {
			articleService.deleteById(id);
			message = MessageUtil.success("删除成功");
		} catch (Exception e) {
			message = MessageUtil.error(500, e.getMessage());
		}
		return message;
	}
	
}

