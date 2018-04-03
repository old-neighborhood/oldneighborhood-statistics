package com.oldneighborhood.demo.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipartConfig {
	
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//文件大小限制
		factory.setMaxFileSize("10MB");
		//总上传数据大小
		factory.setMaxRequestSize("10MB");
		//设置文件临时文件夹路径
		factory.setLocation("/file");
		return factory.createMultipartConfig();
	}

}
