package com.university;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App extends Application {

    private ScheduledExecutorService scheduler;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // 1. Load the FXML file
      Parent root = FXMLLoader.load(
        getClass().getResource("/com/university/MainView.fxml")
);

        // 2. Set up the Scene and Stage
        primaryStage.setTitle("University Management System");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

        // 3. Create a scheduler with one background thread
        scheduler = Executors.newScheduledThreadPool(1);

        // 4. Define the background task
        Runnable heartbeat = () -> {

            System.out.println(
                    "System Heartbeat: Checking for updates at "
                    + new java.util.Date()
            );

            // Use Platform.runLater() if updating JavaFX controls
        };

        // 5. Run immediately, then every 5 seconds
        scheduler.scheduleAtFixedRate(
                heartbeat,
                0,
                5,
                TimeUnit.SECONDS
        );
    }

    @Override
    public void stop() {

        // Shut down the scheduler when the application closes
        if (scheduler != null) {
            scheduler.shutdown();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
