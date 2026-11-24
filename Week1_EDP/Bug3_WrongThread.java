import java.awt.*;
import java.util.Date;
import javax.swing.*;
public class Bug3_WrongThread extends JFrame {
private JLabel timeLabel;
private JButton startButton;
private boolean running = false;

public Bug3_WrongThread() {
setTitle("Bug 3 - Wrong Thread");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new FlowLayout());

timeLabel = new JLabel("Time: ");
timeLabel.setFont(new Font("Arial", Font.BOLD, 16));

startButton = new JButton("Start Clock");

startButton.addActionListener(e -> {
running = true;
new Thread(() -> {
while (running) {
// BUG: Updating GUI from background thread!
timeLabel.setText("Time: " + new Date());
try {
Thread.sleep(1000);
} catch (InterruptedException ex) {
ex.printStackTrace();
}
}
}).start();
});

add(timeLabel);
add(startButton);
setSize(350, 150);
setLocationRelativeTo(null);
}

public static void main(String[] args) {
SwingUtilities.invokeLater(() -> {
new Bug3_WrongThread().setVisible(true);
});

}
}