package com.week14graded.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;


@Configuration
@EnableWebMvc
@ComponentScan("com.week14graded.controller")
public class SpringConfig {
	
	@Autowired
	private ApplicationContext c1;
	
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver r1=new SpringResourceTemplateResolver();
		r1.setPrefix("/WEB-INF/page/");
		r1.setSuffix(".html");
		r1.setTemplateMode(TemplateMode.HTML);
		r1.setApplicationContext(c1);
		return r1;
	}
	
	@Bean
	public SpringTemplateEngine tempEngine() {
		SpringTemplateEngine e1=new SpringTemplateEngine();
		e1.setTemplateResolver(templateResolver());
		e1.setEnableSpringELCompiler(true);
		return e1;
		
	}
	
	@Bean
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver res1=new ThymeleafViewResolver();
		res1.setTemplateEngine(tempEngine());
		return res1;
	}
}
