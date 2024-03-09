package com.example.demo14.bean;

import com.example.demo14.model.Employee;
import com.example.demo14.service.EmployeeService;
import lombok.Data;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Data

@ManagedBean
@ApplicationScoped
public class EmployeeBean {
    private Locale locale;
    private List<Employee> employees;
    private static boolean form;

    public EmployeeBean() {
        this.employees = new ArrayList<>();
        EmployeeService employeeService = new EmployeeService();
        this.employees = employeeService.getAllUsers();
        locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    }

    public void refresh(){
        this.employees.clear();
        this.employees =new EmployeeService().getAllUsers();
    }
    public void switchForm(){
        form = !form;
        System.out.println(form);
    }
    public boolean getForm(){
        return form;
    }

    public void changeLanguage(String languageCode) {
        locale = new Locale(languageCode);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

}
