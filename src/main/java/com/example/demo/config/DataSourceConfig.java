package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://bj-cynosdbmysql-grp-cyh0uqac.sql.tencentcdb.com:22037/ak74m?useSSL=false&amp;serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("88292865ldqLDQ");
        return dataSource;
    }
}