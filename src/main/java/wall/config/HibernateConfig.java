package wall.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	public BasicDataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource
				.setUrl("jdbc:hsqldb:file:wall");
		dataSource.setUsername("SA");
		dataSource.setPassword("");
		return dataSource;
	}
	
	@Bean
	public SessionFactory getSessionFactoryBean() {
		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(
				getDataSource());
		sessionFactoryBuilder.scanPackages("wall.entity.java");
		sessionFactoryBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		sessionFactoryBuilder.setProperty("hibernate.hbm2ddl.auto", "create");
		sessionFactoryBuilder.setProperty("hibernate.show_sql", "true");
		return sessionFactoryBuilder.buildSessionFactory();
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		return new HibernateTransactionManager(getSessionFactoryBean());
	}
}
