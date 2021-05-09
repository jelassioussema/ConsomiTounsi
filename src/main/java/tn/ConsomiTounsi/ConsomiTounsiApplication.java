package tn.ConsomiTounsi;

import java.util.EnumSet;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.DispatcherType;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import tn.ConsomiTounsi.Config.LoginFilter;





@SpringBootApplication
@EnableScheduling

public class ConsomiTounsiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsomiTounsiApplication.class, args);
	}
	@Bean
	public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
	FacesServlet servlet = new FacesServlet();
	return new ServletRegistrationBean(servlet, "*.jsf"); }

	@Bean
	public FilterRegistrationBean rewriteFilter() {
	FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
	rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST, DispatcherType.ASYNC, DispatcherType.ERROR));
	rwFilter.addUrlPatterns("/*");
	return rwFilter;
	}
	@Bean
	public FilterRegistrationBean loginFilter() {
	FilterRegistrationBean registration = new FilterRegistrationBean();
	registration.setFilter(new LoginFilter());
	registration.addUrlPatterns("/pages/*");
	return registration;
	

	}

}
