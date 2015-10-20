/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtsw.bootprimBootefaces.domain;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author 
 * 
 * @RepositoryRestResource - Automatically exposes this repository as a
 * RESTful resource
 */
@RepositoryRestResource
public interface EmployeeRepository extends MongoRepository<Employee, String>{
    List<Employee> findByLastName(@Param("lastName")String lastName);
    List<Employee> findByFirstName(@Param("firstName")String firstName);
}
