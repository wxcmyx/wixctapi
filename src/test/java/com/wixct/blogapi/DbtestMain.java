package com.wixct.blogapi;

import com.alibaba.fastjson.JSON;
import com.wixct.blogapi.jfinal.model.Contents;
import com.wixct.blogapi.web.rest.Result;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class DbtestMain {
    public static void main(String[] args) {
        System.out.println(new Result().failure().setErcode("404").toJsonString());
        System.out.println(HttpStatus.BAD_REQUEST);
    }
    public static void main1(String[] args) {
        DbUtils.initDb();
//        Record r=Db.findFirst("select * from t_contents a where (type='post' and  status='publish') and cid=2");
//        System.out.print(r);
        int cid=2;
        List<Object> params = new ArrayList<Object>();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        StringBuffer sql_exp = new StringBuffer();
        sql_exp.append("select * from t_contents a where (type='post' and  status='publish') ");

        if(cid!=-1){
            System.out.println("------>"+cid);
            sql_exp.append("and a.cid=?");
            params.add(cid);
        }else{
            resultMap.put("msg", "文章不存在！");
            resultMap.put("code",1);
            System.out.println(JSON.toJSON(resultMap));
            return ;
        }
//        logger.info(sql_exp.toString());
        Contents content= Contents.dao.findFirst(sql_exp.toString(),params.toArray());
        if(null==content){
            resultMap.put("msg", "文章不存在！");
            resultMap.put("code",1);
            System.out.println(JSON.toJSON(resultMap));
            return;
        }
        System.out.println(JSON.toJSON(content));
    }
}
