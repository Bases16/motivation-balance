package edu.arf4.motivationbalance.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

        rootContext.register(WebConfig.class, DatabaseConfig.class, SecurityConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));
        ServletRegistration.Dynamic appServlet = servletContext
                .addServlet("dispatcher", new DispatcherServlet(new GenericWebApplicationContext()));

        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");
    }

}
