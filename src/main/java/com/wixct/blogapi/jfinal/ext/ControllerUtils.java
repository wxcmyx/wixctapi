package com.wixct.blogapi.jfinal.ext;

import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yongchao on 2017/2/22.
 */
public class ControllerUtils {

    /**
     * 乐观锁验证
     *
     * @param controller
     * @param tableName  数据库表名
     * @return
     */
    public static String validateIdAndVersion(Controller controller, String tableName) {
        String id = controller.getPara("id");
        if (StrKit.isBlank(id)) {
            id = controller.getPara("id_");
        }
        if (StrKit.isBlank(id))
            return null;
        String version = controller.getPara("version");
        if (StrKit.isBlank(version)) {
            version = controller.getPara("rev");
        }
        if (null == version)
            return null;
        if (!StringUtils.isNumeric(version)) {
            return "version参数只能是数字！";
        }
        Record record = Db.findById(tableName, id);
        if (null == record) {
            return "根据id查询不到数据！";
        }
        if (null == record.get("VERSION"))
            return null;
        if (record.get("VERSION") != Integer.valueOf(version)) {
            return "表单数据版本号和数据库数据版本号不一致，可能数据已经被其他人修改，请重新编辑！";
        }
        return null;
    }

    /**
     * 把model转为map，驼峰命名
     *
     * @param model
     * @return
     */
    public static Map<String, Object> modelToCamelCaseMap(Model model) {
        if (null == model) {
            return null;
        }
        String[] keys = model._getAttrNames();
        Map<String, Object> map = new HashMap<>();
        for (String key : keys) {
            Object value = model.get(key);
            key = StrKit.toCamelCase(key.toLowerCase());
//避免输出null的json，过滤掉空值
            if (null != value) {
                map.put(key, value);
            }

        }
        return map;
    }

    /**
     * Record转为Map，驼峰命名
     *
     * @param record
     * @return
     */
    public static Map<String, Object> recordToCamelCaseMap(Record record) {
        if (null == record) {
            return null;
        }
        String[] keys = record.getColumnNames();
        Map<String, Object> map = new HashMap<>();
        for (String key : keys) {
            Object value = record.get(key);
            key = StrKit.toCamelCase(key.toLowerCase());
//避免输出null的json，过滤掉空值
            if (null != value) {
                map.put(key, value);
            }
        }
        return map;
    }

    /**
     * List<Record>转为List<Map<String, Object>>，驼峰命名
     *
     * @param records
     * @return
     */
    public static List<Map<String, Object>> recordsToCamelCaseMaps(List<Record> records) {
        List<Map<String, Object>> maps = new ArrayList<>();
        for (Record record : records) {
            maps.add(recordToCamelCaseMap(record));
        }
        return maps;
    }

    /**
     * List<? extends Model>转为List<Map<String, Object>>，驼峰命名
     *
     * @param models
     * @return
     */
    public static List<Map<String, Object>> modelsToCamelCaseMaps(List<? extends Model> models) {
        List<Map<String, Object>> maps = new ArrayList<>();
        for (Model model : models) {
            maps.add(modelToCamelCaseMap(model));
        }
        return maps;
    }

    /**
     * Page<Record>转为Page<Map<String, Object>>，驼峰命名
     *
     * @param records
     * @return
     */
    public static Page<Map<String, Object>> recordsToCamelCaseMaps(Page<Record> records) {
        List<Record> recordList = records.getList();
        List<Map<String, Object>> maps = new ArrayList<>();
        for (Record record : recordList) {
            maps.add(recordToCamelCaseMap(record));
        }
        return new Page<Map<String, Object>>(maps, records.getPageNumber(), records.getPageSize(),
            records.getTotalPage(), records.getTotalRow());
    }

    /**
     * Page<Page<? extends Model>转为Page<Map<String, Object>>，驼峰命名
     *
     * @param models
     * @return
     */
    public static Page<Map<String, Object>> modelsToCamelCaseMaps(Page<? extends Model> models) {
        List<? extends Model> modelList = models.getList();
        List<Map<String, Object>> maps = new ArrayList<>();
        for (Model model : modelList) {
            maps.add(modelToCamelCaseMap(model));
        }
        return new Page<Map<String, Object>>(maps, models.getPageNumber(), models.getPageSize(), models.getTotalPage(),
            models.getTotalRow());
    }

}
