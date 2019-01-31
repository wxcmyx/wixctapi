package com.wixct.blogapi.jfinal.gen;

import com.jfinal.plugin.activerecord.generator.MetaBuilder;
import com.jfinal.plugin.activerecord.generator.TableMeta;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyMetaBuilder extends MetaBuilder {

    private List<String> includedTables = new ArrayList<>();
    private List<TableMeta> tableMetas = new ArrayList<>();

    public List<TableMeta> getTableMetas() {
        return tableMetas;
    }

    public MyMetaBuilder(DataSource dataSource) {
        super(dataSource);
    }

    public void addIncludedTable(String name) {
        includedTables.add(name);
    }
    @Override
    protected void buildTableNames(List<TableMeta> ret) throws SQLException {
        ResultSet rs = getTablesResultSet();
        while (rs.next()) {
            String tableName = rs.getString("TABLE_NAME");
            if (includedTables.contains(tableName)) {
                TableMeta tableMeta = new TableMeta();
                tableMeta.name = tableName;
                tableMeta.remarks = rs.getString("REMARKS");

                tableMeta.modelName = buildModelName(tableName);
                tableMeta.baseModelName = buildBaseModelName(tableMeta.modelName);
                tableMetas.add(tableMeta);
                ret.add(tableMeta);
            }
        }
        rs.close();
    }
}
