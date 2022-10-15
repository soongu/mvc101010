package com.spring.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.spring.mvc")
public class MvcApplication {

	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver
				= new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(MvcApplication.class, args);

	}

}
