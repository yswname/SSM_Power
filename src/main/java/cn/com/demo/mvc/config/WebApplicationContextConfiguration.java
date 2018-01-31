package cn.com.demo.mvc.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement// 支持注解事务配置
@ComponentScan(basePackages = { "cn.com.demo.service.impl" })
@PropertySource(value = "classpath:db.properties")
@MapperScan(basePackages="cn.com.demo.mybatis.dao")
public class WebApplicationContextConfiguration {
	@Autowired
	private Environment evn;

	@Bean(name = "dataSource", destroyMethod = "close")
	public DataSource createDataSorce() {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(evn.getRequiredProperty("jdbc.url"));
		ds.setUsername(evn.getRequiredProperty("jdbc.username"));
		ds.setPassword(evn.getRequiredProperty("jdbc.password"));
		ds.setDriverClassName(evn.getRequiredProperty("jdbc.driverClassName"));
		return ds;
	}

	@Bean(name = "sqlSessionFactory")
	@Autowired
	public SqlSessionFactoryBean createSqlSessionFactory(DataSource ds) {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		try {
			// 设置数据源
			factory.setDataSource(ds);
			// 设置别名
			factory.setTypeAliasesPackage("cn.com.demo.mybatis.entity");
			// 加载映射文件
			PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			Resource[] res = resolver
					.getResources("classpath:cn/com/demo/mybatis/entity/*.xml");
			factory.setMapperLocations(res);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return factory;
	}
	
	@Bean(name="transactionManager")  
	@Autowired
    public DataSourceTransactionManager txManager(DataSource dataSource) {  
        return new DataSourceTransactionManager(dataSource);  
    } 
}
