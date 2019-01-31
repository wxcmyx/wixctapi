package com.wixct.blogapi.web.contents;


import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wixct.blogapi.web.rest.Result;
import com.wixct.blogapi.web.util.DateUtil;
import com.wixct.blogapi.jfinal.model.Contents;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.wixct.blogapi.web.util.TaleUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * ContentsController
 * 
 */
@Api(tags="Contents")
@RestController
public class ContentsController extends Controller {

	/**
	* Logger for this class
	*/
	private static final Logger logger = LoggerFactory.getLogger(ContentsController.class.getName());



	public void index() {
		render("/page/contents/contentsList.html");
	}

	@ApiOperation("内容列表")
	@RequestMapping(value="/contents/show",method= RequestMethod.GET)
	@ResponseBody
	public Result show(@ApiParam("排序类型") @RequestParam(value="tag",defaultValue="",required=false) String tag,
		@ApiParam("第几页") @RequestParam(value="page",defaultValue="1",required=false) int page,
		@ApiParam("每页多少条") @RequestParam(value="limit",defaultValue="10",required=false) int limit){

		List<Object> params = new ArrayList<Object>();
		Result result= new Result();

		int pageNum=page;
		int pageSize=limit;
		StringBuffer sql_select = new StringBuffer();
		StringBuffer sql_exp = new StringBuffer();
		sql_select.append("select * ");
		sql_exp.append("from t_contents a where (type='post' and  status='publish') ");
//		if(StringUtils.isNoneBlank(searchKey)){
//			sql_exp.append("and LANG=? ");
//			params.add(searchKey);
//		}( type = ? and status = ? )
		if("pills-latest".equals(tag)){
			sql_exp.append("order by a.created desc");
			result.put("pillsName","最新添加");
		}else if("pills-view".equals(tag)){
			sql_exp.append("order by a.hits,a.created desc");
			result.put("pillsName","观看最多");
		}else if("pills-comment".equals(tag)){
			sql_exp.append("order by a.comments_num,a.created desc");
			result.put("pillsName","评论最多");
		}else if("pills-like".equals(tag)){
			sql_exp.append("order by a.likes,a.created desc");
			result.put("pillsName","最受欢迎");
		}else{
			sql_exp.append("order by a.created desc");
			result.put("pillsName","最新添加");
		}
		logger.info(sql_exp.toString());
		Page<Contents> pages= Contents.dao.paginate(pageNum,pageSize,sql_select.toString(),sql_exp.toString(),params.toArray());
		for(Contents content:pages.getList()){
			String contentStr=content.getContent();
			String introduction=StringUtils.substring(TaleUtils.mdToText(contentStr),0,110);
			content.setIntroduction(introduction);
		}
		result.put("data", pages.getList());
		result.put("tag", tag);
		result.put("count", pages.getTotalRow());
		result.put("code", 0);
		result.put("msg", "");

		return result;
	}
	@ApiOperation("内容")
	@RequestMapping(value="/contents/showone",method= RequestMethod.GET)
	@ResponseBody
	public Object showOne(@ApiParam("内容id") @RequestParam(value="cid",defaultValue ="-1",required=false) int cid){

		List<Object> params = new ArrayList<Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		StringBuffer sql_exp = new StringBuffer();
		sql_exp.append("select * from t_contents a where (type='post' and  status='publish') ");

		if(cid!=-1){
			sql_exp.append("and a.cid=?");
			params.add(cid);
		}else{
			resultMap.put("msg", "文章不存在！");
			resultMap.put("code",1);
			return resultMap;
		}
		logger.info(sql_exp.toString());

		Contents content= Contents.dao.findFirst(sql_exp.toString(),params.toArray());
		if(null==content){
			resultMap.put("msg", "文章不存在！");
			resultMap.put("code",1);
			return resultMap;
		}
		content.updateHits();
		content.setContent(TaleUtils.mdToHtml(content.getContent()));
		resultMap.put("content", content);
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		return resultMap;


	}
	public void add() {

	}
	public void save() {

	}

	public void edit() {

	}

	public void update() {

	}

	public void delete() {

	}
}


