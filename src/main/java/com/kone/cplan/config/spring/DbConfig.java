package com.kone.cplan.config.spring;

import com.kone.cplan.config.AppSettings;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * This class is used to configure connection to DB in Spring app.
 * 
 * @author Gennadiy Pervukhin
 * @created 20-11-2018
 */
@Configuration
public class DbConfig {
	
	@Bean
	public DataSource dataSource() throws URISyntaxException {
		URI dbUri = new URI(AppSettings.DATABASE_URL);

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort()
			+ dbUri.getPath() + "?sslmode=require";

		return DataSourceBuilder.create()
			.url(dbUrl).username(username).password(password)
			.build();
	}
}