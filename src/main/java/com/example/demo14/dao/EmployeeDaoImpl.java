package com.example.demo14.dao;

import com.example.demo14.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    public void add(Employee employee) {
        Connection conn = ConnectionDb.getConnection();
        String sql = "INSERT INTO employee (nom, prenom, email, birthday, departement) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, employee.getNom());
            pst.setString(2, employee.getPrenom());
            pst.setString(3, employee.getEmail());
            pst.setDate(4, java.sql.Date.valueOf(employee.getBirthday()));
            pst.setString(5, employee.getDepartement());
            pst.executeUpdate();
            System.out.println("Ajout réussi");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();
        Connection conn = ConnectionDb.getConnection();
        String sql = "SELECT * FROM employee";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                LocalDate birthday = rs.getDate("birthday").toLocalDate();
                String departement = rs.getString("departement");
                Employee employee = new Employee(id, nom, prenom, email, birthday, departement);
                employeeList.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }

    public Employee getOne(int employeeId) {
        Employee employee = null;
        Connection conn = ConnectionDb.getConnection();
        String sql = "SELECT * FROM employee WHERE id = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, employeeId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                LocalDate birthday = rs.getDate("birthday").toLocalDate();
                String departement = rs.getString("departement");
                employee = new Employee(id, nom, prenom, email, birthday, departement);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    public void delete(int employeeId) {
        Connection conn = ConnectionDb.getConnection();
        String sql = "DELETE FROM employee WHERE id = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, employeeId);
            pst.executeUpdate();
            System.out.println("Suppression réussie");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Employee updatedEmployee) {
        Connection conn = ConnectionDb.getConnection();
        String sql = "UPDATE employee SET nom = ?, prenom = ?, email = ?,  birthday = ?, departement = ? WHERE id = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, updatedEmployee.getNom());
            pst.setString(2, updatedEmployee.getPrenom());
            pst.setString(3, updatedEmployee.getEmail());
            pst.setDate(4, java.sql.Date.valueOf(updatedEmployee.getBirthday()));
            pst.setString(5, updatedEmployee.getDepartement());
            pst.setInt(6, updatedEmployee.getId());
            pst.executeUpdate();
            System.out.println("Mise à jour réussie" + LocalDate.now());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

