package com.university;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {

    // Observable properties
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty regNumber = new SimpleStringProperty();
    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();

    // Constructor
    public Student(int id, String regNumber, String firstName, String lastName) {

        this.id.set(id);
        this.regNumber.set(regNumber);
        this.firstName.set(firstName);
        this.lastName.set(lastName);
    }

    // Property Getters
    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty regNumberProperty() {
        return regNumber;
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    // Standard Getter
    public String getRegNumber() {
        return regNumber.get();
    }
}
