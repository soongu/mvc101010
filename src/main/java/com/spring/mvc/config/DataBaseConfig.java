package com.spring.mvc.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

// DB관련 설정 클래스
@Configuration
@PropertySource("classpath:db_info.properties")
public class DataBaseConfig {

    @Value("${local.db.username}")
    private String username; // 데이터베이스 접속 계정명

    @Value("${local.db.password}")
    private String password; // 접속 비밀번호

    @Value("${local.db.url}")
    private String url; // 데이터베이스 URL

    // DB 접속 정보 설정 (DataSource 설정)
    @Bean
    public DataSource dataSource() {
        // 커넥션 풀 설정
        HikariConfig config = new HikariConfig();

        config.setUsername(username);
        config.setPassword(password);
        config.setJdbcUrl(url);
        config.setDriverClassName("org.mariadb.jdbc.Driver");

        return new HikariDataSource(config);
    }

}
