package com.example.demo14.dao;

import com.example.demo14.model.Employee;

import java.time.LocalDate;
import java.util.Random;

public class MainDB {
    public static void main(String[] args) {
        EmployeeDaoImpl eDao = new EmployeeDaoImpl();
        Random random = new Random();


        String firstName1 = "John";
        String lastName1 = "Doe";
        String email1 = "john.doe@example.com";
        LocalDate birthDate1 = LocalDate.of(1980 + random.nextInt(20), random.nextInt(12) + 1, random.nextInt(28) + 1);
        String department1 = "Department" + random.nextInt(5); // Assuming 5 departments
        Employee newEmployee1 = new Employee(firstName1, lastName1, email1, birthDate1, department1);
        eDao.add(newEmployee1);

        String firstName2 = "Jane";
        String lastName2 = "Smith";
        String email2 = "jane.smith@example.com";
        LocalDate birthDate2 = LocalDate.of(1980 + random.nextInt(20), random.nextInt(12) + 1, random.nextInt(28) + 1);
        String department2 = "Department" + random.nextInt(5); // Assuming 5 departments
        Employee newEmployee2 = new Employee(firstName2, lastName2, email2, birthDate2, department2);
        eDao.add(newEmployee2);
        eDao.add(newEmployee1);
        eDao.add(newEmployee2);
        eDao.add(newEmployee1);
        eDao.add(newEmployee1);
        eDao.add(newEmployee2);
        eDao.add(newEmployee2);
        eDao.add(newEmployee1);
        eDao.add(newEmployee2);
        eDao.add(newEmployee1);
        eDao.add(newEmployee2);



//        Employee userJack = eDao.getOne(3);
//        if (userJack != null) {
//            userJack.setNom("Jack");
//            eDao.update(userJack);
//        }

        System.out.println(eDao.getAll());
    }
}
