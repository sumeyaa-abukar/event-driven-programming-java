import java.awt.*;
import javax.swing.*;

public class Bug2_MissingListener extends JFrame {

private JLabel countLabel;

private JButton incrementButton;
private int count = 0;

public Bug2_MissingListener() {
setTitle("Bug 2 - Missing Listener");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new FlowLayout());

countLabel = new JLabel("Count: 0");
countLabel.setFont(new Font("Arial", Font.BOLD, 20));

incrementButton = new JButton("Increment");

// BUG: No ActionListener added to the button!
// The button does nothing when clicked.

add(countLabel);
add(incrementButton);
setSize(300, 150);
setLocationRelativeTo(null);
}

public static void main(String[] args) {
SwingUtilities.invokeLater(() -> {
new Bug2_MissingListener().setVisible(true);
});

}
}