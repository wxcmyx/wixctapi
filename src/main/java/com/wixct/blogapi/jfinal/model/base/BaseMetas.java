package com.wixct.blogapi.jfinal.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseMetas<M extends BaseMetas<M>> extends Model<M> implements IBean {

	public void setMid(java.lang.Long mid) {
		set("mid", mid);
	}
	
	public java.lang.Long getMid() {
		return getLong("mid");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	public java.lang.String getName() {
		return getStr("name");
	}

	public void setSlug(java.lang.String slug) {
		set("slug", slug);
	}
	
	public java.lang.String getSlug() {
		return getStr("slug");
	}

	public void setType(java.lang.String type) {
		set("type", type);
	}
	
	public java.lang.String getType() {
		return getStr("type");
	}

	public void setDescription(java.lang.String description) {
		set("description", description);
	}
	
	public java.lang.String getDescription() {
		return getStr("description");
	}

	public void setSort(java.lang.Long sort) {
		set("sort", sort);
	}
	
	public java.lang.Long getSort() {
		return getLong("sort");
	}

	public void setParent(java.lang.Long parent) {
		set("parent", parent);
	}
	
	public java.lang.Long getParent() {
		return getLong("parent");
	}

}
