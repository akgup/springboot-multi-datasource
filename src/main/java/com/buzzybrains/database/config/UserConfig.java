package com.buzzybrains.database.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * akshay gupta
 * 
 * 19-Mar-2019
 * 
 **/
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.buzzybrains.dao.user",
entityManagerFactoryRef = "userEntityManager",
transactionManagerRef = "transactionManager")
public class UserConfig {

	@Primary
	@Bean(name = "userDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource userDataSource() {

		return DataSourceBuilder.create().build();

	}

	@Primary
	@Bean(name = "userEntityManager")
	public LocalContainerEntityManagerFactoryBean userEntityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("userDataSource") DataSource userDataSource) {

		return builder
				.dataSource(userDataSource)
				.packages("com.buzzybrains.entity.user")
				.persistenceUnit("user")
				.build();
	}

	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("userEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
