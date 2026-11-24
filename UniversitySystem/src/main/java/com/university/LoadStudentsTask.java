
package com.university;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

// A Task that returns an ObservableList of Student objects
public class LoadStudentsTask extends Task<ObservableList<Student>> {

    // This method runs entirely on a BACKGROUND THREAD
    @Override
    protected ObservableList<Student> call() throws Exception {

        // Create an empty list to store the students
        ObservableList<Student> students =
                FXCollections.observableArrayList();

        // The SQL query to get all students
        String sql = "SELECT * FROM students";

        // Connect to database and execute query
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Loop through every row returned by the database
            while (rs.next()) {

                // Create a new Student object
                Student student = new Student(
                        rs.getInt("student_id"),
                        rs.getString("registration_number"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                );

                // Add the new student to our ObservableList
                students.add(student);
            }
        }

        // Return the completed list back to the UI thread
        return students;
    }
}
