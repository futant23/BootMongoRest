/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtsw.bootprimBootefaces;

import javax.faces.webapp.FacesServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import rtsw.bootprimBootefaces.domain.Employee;
import rtsw.bootprimBootefaces.domain.EmployeeRepository;

/**
 *
 * @author 
 * 
 * 
 */
@Configuration
@ComponentScan(basePackages = {""})
@EnableAutoConfiguration
@Import(RepositoryRestMvcConfiguration.class)
public class Application  extends SpringBootServletInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    EmployeeRepository repository;

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

     @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(new Class[]{Application.class});
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
        return servletRegistrationBean;
    }
    
    @Override
    public void run(String... strings) throws Exception {
        log.info("run()");

        repository.deleteAll();

        for (int i = 0; i < 50; i++) {
            log.info(String.valueOf(i));
            repository.save(new Employee("Jones", "Walter"));
            repository.save(new Employee("Beetle", "Tatiana"));
            repository.save(new Employee("Barnabus", "Ethan"));
            repository.save(new Employee("High", "Ian"));
        }
    }

}
