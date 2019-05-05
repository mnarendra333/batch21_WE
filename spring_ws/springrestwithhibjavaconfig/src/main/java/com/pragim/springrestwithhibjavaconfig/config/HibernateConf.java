package com.pragim.springrestwithhibjavaconfig.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
public class HibernateConf {
	
	 @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	      //  sessionFactory.setAnnotatedPackages("com.pragim.springrestwithhibjavaconfig.model");
	        sessionFactory.setPackagesToScan("com.pragim.springrestwithhibjavaconfig.model");
	        sessionFactory.setHibernateProperties(hibernateProperties());
	 
	        return sessionFactory;
	    }
	 
	    @Bean
	    public DataSource dataSource() {
	        BasicDataSource dataSource = new BasicDataSource();
	        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	        dataSource.setUsername("system");
	        dataSource.setPassword("system");
	 
	        return dataSource;
	    }
	 
	    @Bean
	    public PlatformTransactionManager hibernateTransactionManager() {
	        HibernateTransactionManager transactionManager
	          = new HibernateTransactionManager();
	        transactionManager.setSessionFactory(sessionFactory().getObject());
	        return transactionManager;
	    }
	 
	    private final Properties hibernateProperties() {
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.setProperty(
	          "hibernate.hbm2ddl.auto", "update");
	        hibernateProperties.setProperty(
	          "hibernate.dialect", "org.hibernate.dialect.OracleDialect");
	 
	        return hibernateProperties;
	    }

}
