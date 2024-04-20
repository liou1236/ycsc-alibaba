package com.zrrd.spring;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource({"classpath:jdbc.properties"})
public class JDBCConfig {
    @Value("${jdbc.driver}")
    private String dirverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.username}")
    private String username;



    @Bean
    public QueryRunner createQueryRunner(@Qualifier("dataSource") DataSource ds) {
        QueryRunner queryRunner = new QueryRunner(ds);
        return queryRunner;
    }

    @Bean("dataSource")
    public DataSource createDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(dirverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setPassword(password);
        druidDataSource.setUsername(username);
        return druidDataSource;
    }
}
