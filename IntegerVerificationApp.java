import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntegerVerificationApp extends JFrame {
    private JTextField textField;
    private JLabel resultLabel;

    public IntegerVerificationApp() {
        setTitle("Integer Verification");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        try {
            // Set the Nimbus look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 240, 240));

        JLabel label = new JLabel("Enter an integer:");
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        label.setForeground(new Color(50, 50, 50));
        panel.add(label, BorderLayout.NORTH);

        textField = new JTextField();
        textField.setBackground(Color.WHITE);
        textField.setForeground(new Color(50, 50, 50));
        panel.add(textField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(240, 240, 240));

        Color buttonColor = new Color(0, 153, 204);
        Color buttonTextColor = Color.WHITE;

        JButton verifyButton = new JButton("Verify");
        verifyButton.setBackground(buttonColor);
        verifyButton.setForeground(buttonTextColor);
        verifyButton.setFocusPainted(false);
        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                try {
                    int number = Integer.parseInt(input);
                    resultLabel.setText(number + " is a valid integer.");
                } catch (NumberFormatException ex) {
                    resultLabel.setText(input + " is not a valid integer.");
                }
            }
        });
        buttonPanel.add(verifyButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(buttonColor);
        cancelButton.setForeground(buttonTextColor);
        cancelButton.setFocusPainted(false);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPanel.add(cancelButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        resultLabel = new JLabel();
        resultLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        resultLabel.setForeground(new Color(50, 50, 50));
        panel.add(resultLabel, BorderLayout.NORTH);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                IntegerVerificationApp app = new IntegerVerificationApp();
                app.setVisible(true);
            }
        });
    }
}
