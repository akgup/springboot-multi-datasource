package com.buzzybrains.database.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * akshay gupta
 * 
 * 19-Mar-2019
 * 
 **/

@Configuration
@EnableJpaRepositories(basePackages = "com.buzzybrains.dao.product", 
entityManagerFactoryRef = "productEntityManager",
transactionManagerRef = "productTransactionManager")
public class ProductConfig {
	@Bean(name = "productDataSource")
	@ConfigurationProperties(prefix = "spring.productdatasource")
	public DataSource productDataSource() {

		return DataSourceBuilder.create().build();

	}

	@Bean(name = "productEntityManager")
	public LocalContainerEntityManagerFactoryBean productEntityManager(EntityManagerFactoryBuilder builder,
			@Qualifier("productDataSource") DataSource productDataSource) {

		return builder
				.dataSource(productDataSource)
				.packages("com.buzzybrains.entity.product")
				.persistenceUnit("product")
				.build();
	}

	
	@Bean(name = "productTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("productEntityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
