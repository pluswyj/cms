package com.briup.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="cms_article")
@ApiModel
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value="文章id")
	private Integer id;
	@ApiModelProperty(value="文章作者")
	private String author;
	@ApiModelProperty(value="点击次数",hidden=true)
	private int clickTimes;//click_times
	@ApiModelProperty(value="文章内容")
	private String content;
	@ApiModelProperty(value="点击次数",hidden=true)
	private Date publishDate;//publish_date
	@ApiModelProperty(value="标题")
	private String title;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	public Article() {}


	public Article(String author, int clickTimes, String content, Date publishDate, String title) {
		super();
		this.author = author;
		this.clickTimes = clickTimes;
		this.content = content;
		this.publishDate = publishDate;
		this.title = title;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getClickTimes() {
		return clickTimes;
	}


	public void setClickTimes(int clickTimes) {
		this.clickTimes = clickTimes;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getPublishDate() {
		return publishDate;
	}


	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Article [id=" + id + ", author=" + author + ", clickTimes=" + clickTimes + ", content=" + content
				+ ", publishDate=" + publishDate + ", title=" + title + "]";
	}
	
	
	
}
