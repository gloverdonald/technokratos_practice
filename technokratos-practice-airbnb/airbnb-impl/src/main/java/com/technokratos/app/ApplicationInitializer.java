package com.technokratos.app;

import com.technokratos.config.DataBaseConfig;
import com.technokratos.config.WebWvcConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext springWebContext = new AnnotationConfigWebApplicationContext();
        springWebContext.register(DataBaseConfig.class);
        springWebContext.register(WebWvcConfig.class);
        ContextLoaderListener listener = new ContextLoaderListener(springWebContext);
        servletContext.addListener(listener);
        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcher",
                new DispatcherServlet(springWebContext));
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");
    }
}