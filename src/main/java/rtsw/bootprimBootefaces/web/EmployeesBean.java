/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtsw.bootprimBootefaces.web;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import rtsw.bootprimBootefaces.domain.Employee;
import rtsw.bootprimBootefaces.domain.EmployeeRepository;

/**
 *
 * @author b1050502
 */
@Component(value = "employeesView")
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="session")
public class EmployeesBean {
    
    private static final Logger log =LoggerFactory.getLogger(EmployeesBean.class);

    
    @Autowired
    EmployeeRepository repository;
    
    private List<Employee> employees =new ArrayList<>();
    
    Employee selectedEmployee;
    
    @PostConstruct
    public void init() {
        log.info("init()");
        employees =repository.findAll();
    }

    public Employee getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(Employee selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
    
     public void onRowSelect(SelectEvent event) {
        log.debug("onRowSelect");
        Employee employee =(Employee)event.getObject();
        setSelectedEmployee(employee);
        FacesMessage msg = new FacesMessage("Employee Selected", ((Employee) event.getObject()).toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
//        FacesMessage msg = new FacesMessage("Car Unselected", ((Car) event.getObject()).getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
}
