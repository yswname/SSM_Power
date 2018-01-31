package cn.com.demo.mvc.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected void registerContextLoaderListener(ServletContext servletContext) {
		// 不要注释
		super.registerContextLoaderListener(servletContext);

		// 添加事务前置过滤器 begin
//		FilterRegistration.Dynamic sessionFilter = servletContext.addFilter("sessionFilter",
//				OpenSessionInViewFilter.class);
//		sessionFilter.setInitParameter("singleSession", "true");
//		sessionFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

		// 添加一个过滤器
		FilterRegistration.Dynamic encodingFilter = servletContext.addFilter(
				"encodingFilter", CharacterEncodingFilter.class);
		encodingFilter.setInitParameter("encoding", "UTF-8");
		encodingFilter.setInitParameter("forceEncoding", "true");// 启动转码
		encodingFilter.addMappingForUrlPatterns(
				EnumSet.of(DispatcherType.REQUEST), true, "/*");
		// 设置所有的html不经过SpringMVC
		servletContext.getServletRegistration("default").addMapping("*.html");
	}

	// 初始化WebApplicationContext（ApplicationContext）
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebApplicationContextConfiguration.class };
	}

	// 初始化(加载SpringMVC-servlet.xml)DispatherServlet
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringMvcConfiguration.class };
	}

	/**
	 * DispatcherServet的mapping
	 * */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
