package com.arsan.expense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.arsan.expense.filter.AuthFilter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableSwagger2
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<AuthFilter> filterRegistrationBean() {
		FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
		AuthFilter authFilter = new AuthFilter();
		registrationBean.setFilter(authFilter);
		registrationBean.addUrlPatterns("/api/categories/*");
		return registrationBean;
	}
}
