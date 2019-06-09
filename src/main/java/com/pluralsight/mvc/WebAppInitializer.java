package com.pluralsight.mvc;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		WebApplicationContext webApplicationContext = getWebContext();
		servletContext.addListener(new ContextLoaderListener(webApplicationContext));
		servletContext.setInitParameter("thimisetty", "Vinodh Kumar Thimmisetty");

		FilterRegistration.Dynamic filter = servletContext.addFilter("entityManagerFilter",
				new OpenEntityManagerInViewFilter());
		filter.setInitParameter("some-key", "some-value");
		filter.addMappingForUrlPatterns(null, true, "/*");

		ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("DispatcherServlet",
				new DispatcherServlet(webApplicationContext));
		dispatcherServlet.setLoadOnStartup(1);
		dispatcherServlet.addMapping("/");

	}

	private WebApplicationContext getWebContext() {
		AnnotationConfigWebApplicationContext acwac = new AnnotationConfigWebApplicationContext();
		acwac.register(WebConfig.class);
		return acwac;
	}

}
