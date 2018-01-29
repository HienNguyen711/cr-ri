package project.userservice.config.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
public class FlywayInit {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${Connect.database}")
    private String database;

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        String urlWithoutDatabaseName= url.substring(0,url.lastIndexOf("/"));
        Flyway flyway = new Flyway();
        flyway.setDataSource(urlWithoutDatabaseName, userName, password);
        flyway.setSchemas(database);
        flyway.setBaselineOnMigrate(true);
        return flyway;
    }
}
