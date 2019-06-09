package com.pluralsight.mvc;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
//@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.pluralsight.mvc.repository")
@PropertySource(value = { "classpath:db.properties" })
public class JPAConfig {

	@Autowired
	Environment environment;

	@Bean
	@Primary
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public DataSource dataSource() {
		DriverManagerDataSource dm = new DriverManagerDataSource();
		dm.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dm.setUrl(environment.getRequiredProperty("jdbc.url"));
		dm.setUsername(environment.getRequiredProperty("jdbc.username"));
		dm.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dm;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource());
		emfb.setPackagesToScan("com.pluralsight.mvc.entity", "com.pluralsight.mvc.model");
		emfb.setJpaVendorAdapter(jpaVendorAdapter());
		emfb.setJpaProperties(hibernateProperties());
		return emfb;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hAdapter = new HibernateJpaVendorAdapter();
//		hAdapter.setShowSql(true);
		return hAdapter;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
//		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}

}
