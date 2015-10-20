/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtsw.bootprimBootefaces.domain;

import org.springframework.data.annotation.Id;

/**
 *
 * @author 
 */
public class Employee {
    
    @Id
    String id;
    
    String lastName;
    
    String firstName;

    public Employee() {}

    public Employee(String lastName, String firstName) {
        this();
        this.lastName = lastName;
        this.firstName = firstName;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    
}
