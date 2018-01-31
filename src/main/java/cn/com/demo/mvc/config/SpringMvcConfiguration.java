package cn.com.demo.mvc.config;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration // beans
@EnableWebMvc // mvc:annotation-driven
@ComponentScan(basePackages="cn.com.demo.mvc.controller")//<context:component-scan
public class SpringMvcConfiguration extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/static/**").addResourceLocations(
				"/static/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/bootstrap/**").addResourceLocations("/bootstrap/");
		//registry.addResourceHandler("/*.html").addResourceLocations("/*.html");
		// http://xxdsafdsa/test.js
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		super.configureViewResolvers(registry);
		// 注册一个试图渲染器
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		
		registry.viewResolver(viewResolver);
	}
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.extendMessageConverters(converters);
		// 解决@ResponseBody乱码问题
		StringHttpMessageConverter httpConverter = new StringHttpMessageConverter(
				Charset.forName("UTF-8"));
		httpConverter.setSupportedMediaTypes(Arrays.asList(
				MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN, 
				MediaType.TEXT_HTML));
		converters.add(0, httpConverter);// 需要添加到第一个，避免使用前面的msgConverter

		// 响应json
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		converters.add(jsonConverter);

	}
}
