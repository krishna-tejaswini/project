package com.niit.sportsback.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.sportsback.model.CartItems;
import com.niit.sportsback.model.Category;
import com.niit.sportsback.model.Product;
import com.niit.sportsback.model.Supplier;
import com.niit.sportsback.model.User;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class DbConfig {
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/sports");
		datasource.setUsername("sa");
		datasource.setPassword("");
		System.out.println("DataSource");
		return datasource;
	}

	private Properties getHibernateProperties() {
		Properties pro = new Properties();
		pro.put("hibernate.show_sql", "true");
		pro.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		pro.put("hibernate.hbm2ddl.auto", "update");
		return pro;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionfactory = new LocalSessionFactoryBuilder(dataSource);
		sessionfactory.addProperties(getHibernateProperties());
		sessionfactory.addAnnotatedClass(User.class);
		sessionfactory.addAnnotatedClass(Category.class);
		sessionfactory.addAnnotatedClass(Supplier.class);
		sessionfactory.addAnnotatedClass(Product.class);
		sessionfactory.addAnnotatedClass(CartItems.class);
		System.out.println("session factory ");
		return sessionfactory.buildSessionFactory();

	}
@Bean(name="txManager")
public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
{
	System.out.println("===========================HibernateTransactionMAnager====================");
	return new HibernateTransactionManager(sessionFactory);
}
}
