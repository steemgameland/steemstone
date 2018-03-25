package com.gameland.steemstone;

import java.nio.charset.Charset;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
@EnableScheduling
public class SteemStoneApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SteemStoneApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(SteemStoneApplication.class);
	}
	
	@Bean
	public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }
	
	@Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
	
	@Bean
	public ScheduledExecutorFactoryBean scheduledExecutorService() { 
		ScheduledExecutorFactoryBean bean = new ScheduledExecutorFactoryBean(); 
		bean.setPoolSize(5); 
		return bean; 
	}
}

