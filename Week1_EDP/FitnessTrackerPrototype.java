
import java.awt.*;
import javax.swing.*;

public class FitnessTrackerPrototype extends JFrame {

    private int steps = 0;
    private int heartRate = 0;
    private int calories = 0;

    private JLabel stepsLabel;
    private JLabel heartRateLabel;
    private JLabel caloriesLabel;
    private JLabel statusLabel;

    public FitnessTrackerPrototype() {
        setTitle("Fitness Tracker");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel heading = new JLabel(
            "My Fitness Dashboard", SwingConstants.CENTER
        );
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        add(heading, BorderLayout.NORTH);

        JPanel statsPanel = new JPanel(new GridLayout(4, 1, 5, 5));

        stepsLabel = new JLabel("Steps: 0");
        heartRateLabel = new JLabel("Heart Rate: 0 BPM");
        caloriesLabel = new JLabel("Calories Burned: 0 kcal");
        statusLabel = new JLabel("Status: Ready");

        statsPanel.add(stepsLabel);
        statsPanel.add(heartRateLabel);
        statsPanel.add(caloriesLabel);
        statsPanel.add(statusLabel);

        add(statsPanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        JButton addStepsButton = new JButton("Add Steps");
        JButton heartRateButton = new JButton("Update Heart Rate");
        JButton caloriesButton = new JButton("Burn Calories");
        JButton resetButton = new JButton("Reset");

        // Event 1: Add steps
        addStepsButton.addActionListener(e -> {
            steps += 100;
            stepsLabel.setText("Steps: " + steps);
            statusLabel.setText("Status: Steps added!");
        });

        // Event 2: Update heart rate
        heartRateButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(
                this, "Enter heart rate (40-220 BPM):"
            );

            if (input == null) {
                return;
            }

            try {
                int rate = Integer.parseInt(input.trim());

                if (rate < 40 || rate > 220) {
                    JOptionPane.showMessageDialog(
                        this, "Enter a value between 40 and 220."
                    );
                    return;
                }

                heartRate = rate;
                heartRateLabel.setText(
                    "Heart Rate: " + heartRate + " BPM"
                );
                statusLabel.setText("Status: Heart rate updated!");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    this, "Please enter a valid number."
                );
            }
        });

        // Event 3: Record calories
        caloriesButton.addActionListener(e -> {
            calories += 50;
            caloriesLabel.setText(
                "Calories Burned: " + calories + " kcal"
            );
            statusLabel.setText("Status: Calories recorded!");
        });

        // Event 4: Reset statistics
        resetButton.addActionListener(e -> {
            steps = 0;
            heartRate = 0;
            calories = 0;

            stepsLabel.setText("Steps: 0");
            heartRateLabel.setText("Heart Rate: 0 BPM");
            caloriesLabel.setText("Calories Burned: 0 kcal");
            statusLabel.setText("Status: Statistics reset!");
        });

        buttonsPanel.add(addStepsButton);
        buttonsPanel.add(heartRateButton);
        buttonsPanel.add(caloriesButton);
        buttonsPanel.add(resetButton);

        add(buttonsPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FitnessTrackerPrototype().setVisible(true);
        });
    }
}
