package com.university;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class MainController {

    @FXML
    private StackPane centerPane;

    // Display the Dashboard
    @FXML
    private void showDashboard() {
        centerPane.getChildren().setAll(
            new Label("Welcome to the University Dashboard!")
        );
    }

    // Display the Students page
    @FXML
    private void showStudents() {
        try {
            Parent studentView = FXMLLoader.load(
                getClass().getResource("/com/university/StudentView.fxml")
            );

            centerPane.getChildren().setAll(studentView);

            System.out.println("StudentView loaded successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
