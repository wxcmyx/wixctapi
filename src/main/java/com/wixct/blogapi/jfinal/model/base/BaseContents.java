package com.wixct.blogapi.jfinal.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseContents<M extends BaseContents<M>> extends Model<M> implements IBean {

	public void setCid(java.lang.Long cid) {
		set("cid", cid);
	}
	
	public java.lang.Long getCid() {
		return getLong("cid");
	}

	public void setTitle(java.lang.String title) {
		set("title", title);
	}
	
	public java.lang.String getTitle() {
		return getStr("title");
	}

	public void setSlug(java.lang.String slug) {
		set("slug", slug);
	}
	
	public java.lang.String getSlug() {
		return getStr("slug");
	}

	public void setCreated(java.lang.Long created) {
		set("created", created);
	}
	
	public java.lang.Long getCreated() {
		return getLong("created");
	}

	public void setModified(java.lang.Long modified) {
		set("modified", modified);
	}
	
	public java.lang.Long getModified() {
		return getLong("modified");
	}

	public void setContent(java.lang.String content) {
		set("content", content);
	}
	
	public java.lang.String getContent() {
		return getStr("content");
	}

	public void setAuthorId(java.lang.Long authorId) {
		set("author_id", authorId);
	}
	
	public java.lang.Long getAuthorId() {
		return getLong("author_id");
	}

	public void setType(java.lang.String type) {
		set("type", type);
	}
	
	public java.lang.String getType() {
		return getStr("type");
	}

	public void setStatus(java.lang.String status) {
		set("status", status);
	}
	
	public java.lang.String getStatus() {
		return getStr("status");
	}

	public void setTags(java.lang.String tags) {
		set("tags", tags);
	}
	
	public java.lang.String getTags() {
		return getStr("tags");
	}

	public void setCategories(java.lang.String categories) {
		set("categories", categories);
	}
	
	public java.lang.String getCategories() {
		return getStr("categories");
	}

	public void setHits(java.lang.Long hits) {
		set("hits", hits);
	}
	
	public java.lang.Long getHits() {
		return getLong("hits");
	}

	public void setLikes(java.lang.Long likes) {
		set("likes", likes);
	}
	
	public java.lang.Long getLikes() {
		return getLong("likes");
	}

	public void setCommentsNum(java.lang.Long commentsNum) {
		set("comments_num", commentsNum);
	}
	
	public java.lang.Long getCommentsNum() {
		return getLong("comments_num");
	}

	public void setAllowComment(java.lang.Boolean allowComment) {
		set("allow_comment", allowComment);
	}
	
	public java.lang.Boolean getAllowComment() {
		return get("allow_comment");
	}

	public void setAllowPing(java.lang.Boolean allowPing) {
		set("allow_ping", allowPing);
	}
	
	public java.lang.Boolean getAllowPing() {
		return get("allow_ping");
	}

	public void setAllowFeed(java.lang.Boolean allowFeed) {
		set("allow_feed", allowFeed);
	}
	
	public java.lang.Boolean getAllowFeed() {
		return get("allow_feed");
	}

	public void setIntroduction(java.lang.String introduction) {
		set("introduction", introduction);
	}
	
	public java.lang.String getIntroduction() {
		return getStr("introduction");
	}

}
