package org.example.costbudgeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class CostBudgetingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CostBudgetingApplication.class, args);

        String url = "jdbc:mysql://localhost:3306/cost_budgeting?useSSL=false&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "@Stan-1956";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database!");


        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }

}
