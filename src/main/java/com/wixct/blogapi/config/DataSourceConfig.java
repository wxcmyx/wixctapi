package com.wixct.blogapi.config;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.wixct.blogapi.jfinal.model._MappingKit;
import com.wixct.blogapi.jfinal.model._MappingKit2;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * HikariCP连接池配置
 */
@Configuration
public class DataSourceConfig {

    @Value("${spring.redis.host}")
    private String redisHost;
    @Value("${spring.redis.port}")
    private int redisPort;

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.ds1")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "ds1")
    @Primary
    @ConfigurationProperties("spring.datasource.ds1")
    public DataSource firstDataSource() {
        HikariDataSource ds= (HikariDataSource) firstDataSourceProperties().initializeDataSourceBuilder().build();
        return ds;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.ds2")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "ds2")
    @ConfigurationProperties("spring.datasource.ds2")
    public DataSource secondDataSource() {
        HikariDataSource ds= (HikariDataSource) secondDataSourceProperties().initializeDataSourceBuilder().build();
        return ds;
    }
    @Bean
    @DependsOn("ds1")
    public ActiveRecordPlugin activeFirstDatasource() {
        ActiveRecordPlugin arp = new ActiveRecordPlugin("ds1",firstDataSource());
        arp.getEngine().setToClassPathSourceFactory();
//        arp.addSqlTemplate("/sql/all_sqls.sql");
        arp.setShowSql(true);
        _MappingKit.mapping(arp);
        arp.start();
        return arp;
    }
    @Bean
    @DependsOn("ds2")
    public ActiveRecordPlugin activeSecordDatasource() {
        ActiveRecordPlugin arp2 = new ActiveRecordPlugin("ds2",secondDataSource());
        arp2.getEngine().setToClassPathSourceFactory();
//        arp2.addSqlTemplate("/sql2/all_sqls.sql");
        _MappingKit2.mapping(arp2);
        arp2.start();
        return arp2;
    }
}
