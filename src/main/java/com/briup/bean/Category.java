package com.briup.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="cms_category")
@Api
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value="栏目id")
	private Integer id;
	@ApiModelProperty(value="栏目编码")
	private long code;
	@ApiModelProperty(value="栏目名")
	private String name;
	
   public Category() {}
public Category(long code, String name) {
	super();
	this.code = code;
	this.name = name;
}

public Category(Integer id, long code, String name) {
	super();
	this.id = id;
	this.code = code;
	this.name = name;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public long getCode() {
	return code;
}
public void setCode(long code) {
	this.code = code;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


@Override
public String toString() {
	return "Category [id=" + id + ", code=" + code + ", name=" + name + "]";
}
   
}
