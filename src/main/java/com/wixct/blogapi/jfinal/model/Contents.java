package com.wixct.blogapi.jfinal.model;

import com.jfinal.plugin.activerecord.Db;
import com.wixct.blogapi.jfinal.model.base.BaseContents;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Contents extends BaseContents<Contents> {
	public static final Contents dao = new Contents().dao();

	/**
	 * 点击+1
	 * @return  影响的记录数，>=1说明更新成功
	 */
	public int updateHits(){
		return Db.update("update t_contents set hits=hits+1 where cid=?",new Object[]{this.getCid()});
	}

	/**
	 * 喜欢+1
	 * @return 影响的记录数，>=1说明更新成功
	 */
	public int updateLikes(){
		return Db.update("update t_contents set likes=likes+1 where cid=?",new Object[]{this.getCid()});
	}
}