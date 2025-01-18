package classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class SignUpForm extends JFrame {

    public SignUpForm() {
        setTitle("Flying Ticket Booking Site");
        setSize(1080,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JLabel backgroundLabel = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\pic\\airport (2).jpg"));
        backgroundLabel.setLayout(new BorderLayout());
        setContentPane(backgroundLabel);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);

        ImageIcon logo = new ImageIcon("");
        JLabel imageLabel = new JLabel(logo);
        imageLabel.setBounds(350, 350, 20, 20); 
        add(imageLabel);

        JLabel titleLabel = new JLabel("Signup Page", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.black); 
        headerPanel.add(titleLabel, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(8, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(150, 40, 20, 40));
        formPanel.setOpaque(false);

        
        JLabel usernameLabel = new JLabel("User Name:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        usernameLabel.setForeground(new Color(255,255,255));
        formPanel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        formPanel.add(usernameField);

        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        passwordLabel.setForeground(new Color(255,255,255));
        formPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        formPanel.add(passwordField);

        add(formPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);
        JButton confirmButton = new JButton("Confirm>>");
        confirmButton.setPreferredSize(new Dimension(100, 40));
        confirmButton.setBackground(new Color(71,75,78));
        confirmButton.setForeground(Color.WHITE);
        bottomPanel.add(confirmButton, BorderLayout.EAST);

        JButton backButton = new JButton("<<Back");
        backButton.setPreferredSize(new Dimension(100, 40));
        backButton.setBackground(new Color(71,75,78));
        backButton.setForeground(Color.WHITE);
        bottomPanel.add(backButton, BorderLayout.WEST);

        add(bottomPanel, BorderLayout.SOUTH);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (usernameField.getText().trim().isEmpty() || passwordField.getPassword().length == 0) {
                        throw new IllegalArgumentException("All fields must be filled up!");
                    }

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Administrator/OneDrive - American International University-Bangladesh/Code/Prctice/java/JavaProject/signup.txt", true))) {
                        writer.write("User Name:" + usernameField.getText().trim() + "\n");
                        writer.write("Password:" + new String(passwordField.getPassword()).trim() + "\n");
                    }

                    setVisible(false);
                    new LoginForm();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(SignUpForm.this, "Error writing to file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(SignUpForm.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent eb) {
                setVisible(false);
                new LoginForm();
            }
        });

        setVisible(true);
    }
}
