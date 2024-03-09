package com.example.demo14.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.faces.bean.ManagedBean;
import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor

@ManagedBean
public class Employee {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private LocalDate birthday;
    private String departement;
    private boolean edit;//false


    public Employee(int id, String nom, String prenom, String email, LocalDate birthday, String departement){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.birthday=birthday;
        this.departement = departement;
    }
    public Employee(String nom, String prenom, String email, LocalDate birthday, String departement){
        this.id = -1;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.birthday=birthday;
        this.departement = departement;
    }


    public void switchEdit(){
        edit = !edit;
        System.out.println(this.edit);
    }

    public boolean getEdit(){
        return edit;
    }

}
