package com.briup.bean;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class ArticleCategory {
	private Integer id;
	private String author;
	private int clickTimes;
	private String content;
	private Date publishDate;
	private String title;
	private String CategoryName;
	public ArticleCategory() {}
	public ArticleCategory(Integer id, String author, int clickTimes, String content, Date publishDate, String title,
			String categoryName) {
		super();
		this.id = id;
		this.author = author;
		this.clickTimes = clickTimes;
		this.content = content;
		this.publishDate = publishDate;
		this.title = title;
		CategoryName = categoryName;
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
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	@Override
	public String toString() {
		return "ArticleCategory [id=" + id + ", author=" + author + ", clickTimes=" + clickTimes + ", content="
				+ content + ", publishDate=" + publishDate + ", title=" + title + ", CategoryName=" + CategoryName
				+ "]";
	}
	

}
