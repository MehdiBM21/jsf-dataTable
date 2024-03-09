package com.example.demo14.service;

import com.example.demo14.bean.EmployeeBean;
import com.example.demo14.dao.EmployeeDaoImpl;
import com.example.demo14.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@Data

@AllArgsConstructor
@ManagedBean
@RequestScoped
public class EmployeeService {
    private EmployeeDaoImpl employeeDao;
    public EmployeeService(){
        this.employeeDao = new EmployeeDaoImpl();
    }
    public List<Employee> getAllUsers(){
        System.out.println(employeeDao.getAll());
        return employeeDao.getAll();
    }
    public void deleteUser(int employeeId){
        try {
            employeeDao.delete(employeeId);
            String language = FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage();
            String message = language.equals("fr") ? "Employé supprimé avec succès. Cliquez sur le bouton REFRESH pour voir le changement si celui-ci n'est pas appliqué." : "Employee deleted successfully. Click the REFRESH button to see the change if it is not applied.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
        }catch(Exception e){
            e.printStackTrace();
        }
//        new UserBean().init();
    }
    public void updateUser(Employee employee){
        System.out.println(employee);
        employeeDao.update(employee);
        System.out.println("update  done"+ employee);
        employee.switchEdit();
    }
    public void addEmployee(Employee employee) {
        try {
            employeeDao.add(employee);
            String language = FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage();
            String message = language.equals("fr") ? "Employé ajouté avec succès. Cliquez sur le bouton REFRESH pour voir le changement si celui-ci n'est pas appliqué." : "Employee added successfully. Click the REFRESH button to see the change if it is not applied.";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
        } catch (Exception e) {
            e.printStackTrace();        }
    }

}
