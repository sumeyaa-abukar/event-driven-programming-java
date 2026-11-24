
import javax.swing.*;

public class FirstWindow {

    public static void main(String[] args) {

        // Run Swing code on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            createAndShowWindow();
        });
    }

    private static void createAndShowWindow() {

        // 1. Create the JFrame
        JFrame frame = new JFrame("Sumeya");

        // 2. Close the application when X is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Set the window size
        frame.setSize(800, 600);

        // 4. Center the window on the screen
      frame.setLocation(100, 100);
        // 5. Display the window
        frame.setVisible(true);

        // 6. Print the thread name to the terminal
        System.out.println("Window created on thread: "
                + Thread.currentThread().getName());
    }
}