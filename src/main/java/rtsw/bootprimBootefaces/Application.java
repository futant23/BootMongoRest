/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtsw.bootprimBootefaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@SpringBootApplication
@Import(RepositoryRestMvcConfiguration.class)
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    EmployeeRepository repository;

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        log.info("run()");

        repository.deleteAll();

        for (int i = 0; i < 10000; i++) {
            repository.save(new Employee("Skinner", "Walter"));
            repository.save(new Employee("Skinner", "Tatiana"));
            repository.save(new Employee("Skinner", "Ethan"));
            repository.save(new Employee("Skinner", "Ian"));
        }
    }

}
