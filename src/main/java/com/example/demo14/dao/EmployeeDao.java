package com.example.demo14.dao;

import com.example.demo14.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public void add(Employee employee);
    public List<Employee> getAll();
    public Employee getOne(int userId);
    public void delete(int userId);
    public void update(Employee updatedEmployee);

}
