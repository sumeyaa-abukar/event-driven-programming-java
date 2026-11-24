import javax.swing.*;

public class Bug1_BlockingEDT extends JFrame {

private JLabel statusLabel;
private JButton processButton;

public Bug1_BlockingEDT() {
setTitle("Bug 1 - Blocking EDT");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new java.awt.FlowLayout());

statusLabel = new JLabel("Ready");
processButton = new JButton("Process");

processButton.addActionListener(e -> {
// BUG: This blocks the EDT!
try {
Thread.sleep(5000);
} catch (InterruptedException ex) {
ex.printStackTrace();
}
statusLabel.setText("Done!");
});

add(statusLabel);
add(processButton);
setSize(300, 150);
setLocationRelativeTo(null);
}

public static void main(String[] args) {
SwingUtilities.invokeLater(() -> {
new Bug1_BlockingEDT().setVisible(true);
});
}
}