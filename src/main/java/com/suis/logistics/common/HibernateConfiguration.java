package com.suis.logistics.common;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.SerializationFeature;

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.suis.logistics" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration extends WebMvcConfigurerAdapter{

	@Autowired
	private Environment environment;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { environment.getRequiredProperty("entity.packages.to.scan") });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url") + "?useLegacyDatetimeCode=false");
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}

	/*@Bean
	@Primary
	public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
		System.out.println("Config is starting.");
		ObjectMapper objectMapper = builder.createXmlMapper(false).build();
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		return objectMapper;
	}*/

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.indentOutput(true).dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm"));

	        builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		converters.add(new MappingJackson2HttpMessageConverter(builder.build()));

	}


	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		// This property is used with above code in line no 47 -
		// useLegacyDatetimeCode=false, to store all date in mysql database in
		// UTC timezone.
		properties.put("hibernate.jdbc.time_zone", "UTC");
		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
}
