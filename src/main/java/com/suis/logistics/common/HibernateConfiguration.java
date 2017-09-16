package com.suis.logistics.common;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@EnableWebMvc
@Configuration
@EnableTransactionManagement
@EnableCaching
@ComponentScan({ "com.suis.logistics" })
@PropertySource(value = { "classpath:application.properties" })
@PropertySource(value = { "classpath:errormsg.properties" })
public class HibernateConfiguration extends WebMvcConfigurerAdapter {

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

	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		return cmfb;
	}
	/*
	 * @Bean
	 *
	 * @Primary
	 *
	 * @Autowired(required=true) public Jackson2ObjectMapperBuilder
	 * objectMapperBuilder() { Jackson2ObjectMapperBuilder builder = new
	 * Jackson2ObjectMapperBuilder();
	 * builder.serializationInclusion(JsonInclude.Include.NON_NULL); return
	 * builder; }
	 */
	/*
	 * @Bean public MappingJackson2HttpMessageConverter
	 * customJackson2HttpMessageConverter() {
	 * MappingJackson2HttpMessageConverter jsonConverter = new
	 * MappingJackson2HttpMessageConverter(); ObjectMapper objectMapper = new
	 * ObjectMapper();
	 * objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
	 * false); objectMapper.setSerializationInclusion(Include.NON_NULL);
	 * jsonConverter.setObjectMapper(objectMapper); return jsonConverter; }
	 *
	 * @Override public void
	 * configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	 * converters.add(customJackson2HttpMessageConverter());
	 *
	 * }
	 */
	/*
	 * @Bean
	 *
	 * @Primary public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder
	 * builder) { System.out.println("Config is starting."); ObjectMapper
	 * objectMapper = builder.createXmlMapper(false).build();
	 * objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
	 * false); return objectMapper; }
	 */
	/*
	 * @Override public void
	 * configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	 * Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	 * builder.indentOutput(true).dateFormat(new SimpleDateFormat(
	 * "yyyy-MM-dd HH:mm"));
	 *
	 * builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
	 * ; converters.add(new
	 * MappingJackson2HttpMessageConverter(builder.build()));
	 *
	 * }
	 */
	/*
	 * @Override public void
	 * extendMessageConverters(List<HttpMessageConverter<?>> converters) {
	 * MappingJackson2HttpMessageConverter converter2 = null;
	 * for(HttpMessageConverter converter : converters){ if(converter instanceof
	 * MappingJackson2HttpMessageConverter){ converter2 =
	 * (MappingJackson2HttpMessageConverter) converter;
	 * //converters.remove(converter); ObjectMapper objectMapper =
	 * converter2.getObjectMapper();
	 * objectMapper.setSerializationInclusion(Include.NON_NULL);
	 * converter2.setObjectMapper(objectMapper); } } converters.add(0,
	 * converter2); System.out.println(converters); //
	 * converters.add(mappingJackson2HttpMessageConverter()); }
	 */
	/*
	 * public MappingJackson2HttpMessageConverter
	 * mappingJackson2HttpMessageConverter() {
	 * MappingJackson2HttpMessageConverter converter = new
	 * MappingJackson2HttpMessageConverter(); ObjectMapper objectMapper = new
	 * ObjectMapper(); objectMapper.setSerializationInclusion(Include.NON_NULL);
	 *
	 * converter.setObjectMapper(objectMapper); return converter; }
	 *
	 * @Override public void addReturnValueHandlers(final
	 * List<HandlerMethodReturnValueHandler> returnValueHandlers) {
	 * List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
	 * messageConverters.add(mappingJackson2HttpMessageConverter());
	 * returnValueHandlers.add(new
	 * ResultResponseHandlerMethodProcessor(messageConverters)); }
	 */
	/*
	 * @Bean public MappingJackson2HttpMessageConverter
	 * customJackson2HttpMessageConverter() {
	 * MappingJackson2HttpMessageConverter jsonConverter = new
	 * MappingJackson2HttpMessageConverter(); ObjectMapper objectMapper = new
	 * ObjectMapper();
	 * objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
	 * false); objectMapper.findAndRegisterModules();
	 * objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
	 * true); objectMapper.configure(SerializationFeature.
	 * WRITE_DATE_KEYS_AS_TIMESTAMPS, true);
	 * objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	 * objectMapper.setSerializationInclusion(Include.NON_NULL);
	 * SerializationConfig se = objectMapper.getSerializationConfig();
	 * jsonConverter.setObjectMapper(objectMapper); return jsonConverter; }
	 *
	 * @Override public void
	 * configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	 * converters.add(customJackson2HttpMessageConverter()); }
	 */
	/*
	 * @Override public void
	 * extendMessageConverters(List<HttpMessageConverter<?>> converters) {
	 * converters.add(customJackson2HttpMessageConverter());
	 *
	 * }
	 */
}
