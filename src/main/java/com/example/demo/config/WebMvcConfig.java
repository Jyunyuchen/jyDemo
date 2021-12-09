package com.example.demo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	//設定路徑對應的視圖，不需要建一個controller的mapping
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/validUser").setViewName("validUser");
	}

}
