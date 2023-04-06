package id.aulab;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("id.aulab")
public class AppConfig {
    
    @Bean
    public DataSource getDataSource() {

        DriverManagerDataSource datasource = new DriverManagerDataSource();

        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/aulab");
        datasource.setUsername("root");
        datasource.setPassword("root");

        return datasource;

    }   

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());        
    }
}
