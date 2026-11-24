package com.example;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaskDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label statusLabel = new Label("Ready");
        Button startButton = new Button("Start Background Task");

        startButton.setOnAction(e -> {

            statusLabel.setText("Processing...");
            startButton.setDisable(true);

            // 1. Create a Background Task
            Task<Void> task = new Task<>() {

                @Override
                protected Void call() throws Exception {

                    // This runs in the background thread
                    Thread.sleep(5000);

                    return null;
                }
            };

            // 2. What to do when the task succeeds
            task.setOnSucceeded(event -> {

                statusLabel.setText("Task Complete!");
                startButton.setDisable(false);

            });

            // 3. Start the task on a new Thread
            Thread backgroundThread = new Thread(task);
            backgroundThread.setDaemon(true);
            backgroundThread.start();
        });

        VBox root = new VBox(20, startButton, statusLabel);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 400, 200);

        primaryStage.setTitle("Task Demo - The Fix");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
