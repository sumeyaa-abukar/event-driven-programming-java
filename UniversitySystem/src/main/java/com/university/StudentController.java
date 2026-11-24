package com.university;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentController {

    // FXML components
    @FXML private TextField regField;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;

    @FXML private TableView<Student> studentTable;
    @FXML private TableColumn<Student, String> colReg;
    @FXML private TableColumn<Student, String> colFirst;
    @FXML private TableColumn<Student, String> colLast;

    @FXML private Label statusLabel;
    @FXML private Button saveButton;

    // List holding student records
    private ObservableList<Student> studentList =
            FXCollections.observableArrayList();

    // Automatically called when FXML loads
    @FXML
    public void initialize() {

        colReg.setCellValueFactory(
                cellData -> cellData.getValue().regNumberProperty());

        colFirst.setCellValueFactory(
                cellData -> cellData.getValue().firstNameProperty());

        colLast.setCellValueFactory(
                cellData -> cellData.getValue().lastNameProperty());

        studentTable.setItems(studentList);

        // Disable Save button when fields are empty
        saveButton.disableProperty().bind(
                regField.textProperty().isEmpty()
                .or(firstNameField.textProperty().isEmpty())
                .or(lastNameField.textProperty().isEmpty())
        );

        // Load initial database records
        loadStudents();
    }

    // Handle Save Student button
    @FXML
    private void handleSaveStudent() {

        String reg = regField.getText();
        String fName = firstNameField.getText();
        String lName = lastNameField.getText();

        // Background task for saving
        Task<Void> saveTask = new Task<>() {

            @Override
            protected Void call() throws Exception {

                String sql = "INSERT INTO students "
                        + "(registration_number, first_name, last_name, email) "
                        + "VALUES (?, ?, ?, ?)";

                try (Connection conn = DatabaseUtil.getConnection();
                     PreparedStatement stmt = conn.prepareStatement(sql)) {

                    stmt.setString(1, reg);
                    stmt.setString(2, fName);
                    stmt.setString(3, lName);
                    stmt.setString(4, reg + "@university.edu");

                    stmt.executeUpdate();
                }

                return null;
            }
        };

        // When saving succeeds
        saveTask.setOnSucceeded(e -> {

            statusLabel.setText("Student saved successfully!");

            regField.clear();
            firstNameField.clear();
            lastNameField.clear();

            loadStudents();
        });

        // When saving fails
        saveTask.setOnFailed(e -> {

            statusLabel.setText("Error saving student: "
                    + saveTask.getException().getMessage());
        });

        // Start background thread
        new Thread(saveTask).start();
    }

    // Load students from database
    private void loadStudents() {

        LoadStudentsTask task = new LoadStudentsTask();

        task.setOnSucceeded(e -> {

            studentList.setAll(task.getValue());

            statusLabel.setText(
                    "Loaded " + studentList.size()
                    + " students from database."
            );
        });

        task.setOnFailed(e -> {

            statusLabel.setText("Error loading students: "
                    + task.getException().getMessage());
        });

        new Thread(task).start();
    }
}
