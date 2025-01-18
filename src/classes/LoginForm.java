package classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class LoginForm extends JFrame {

    public LoginForm() {
        setTitle("Flying Ticket Booking Site");
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        ImageIcon backgroundImageIcon = new ImageIcon("resource/pic/ticket.jpg");
        Image backgroundImage = backgroundImageIcon.getImage();
        Image scaledImage = backgroundImage.getScaledInstance(1080, 720, Image.SCALE_SMOOTH); 
        JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));

        
        backgroundLabel.setLayout(new BorderLayout());
        setContentPane(backgroundLabel);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        JLabel titleLabel = new JLabel("Login Page", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLACK); 
        headerPanel.add(titleLabel, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(8, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(150, 40, 20, 40));
        formPanel.setOpaque(false); 
        
        JLabel usernameLabel = new JLabel("User Name:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
        usernameLabel.setForeground(new Color(0,0,0)); 
        formPanel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        formPanel.add(usernameField);

        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
        passwordLabel.setForeground(new Color(0,0,0)); 
        formPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        formPanel.add(passwordField);

        add(formPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false); 

        JButton signupButton = new JButton("Sign Up");
        signupButton.setPreferredSize(new Dimension(100, 40));
        signupButton.setBackground(new Color(5,124,164));
        signupButton.setForeground(Color.WHITE);
        bottomPanel.add(signupButton, BorderLayout.WEST);

        JButton nextButton = new JButton("Next>>");
        nextButton.setPreferredSize(new Dimension(100, 40));
        nextButton.setBackground(new Color(5,124,164));
        nextButton.setForeground(Color.WHITE);
        bottomPanel.add(nextButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        signupButton.addActionListener(e1 -> {
            setVisible(false);
            new SignUpForm(); 
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticateUser(usernameField.getText().trim(), new String(passwordField.getPassword()).trim());
            }
        });

        setVisible(true); 
    }

    private void authenticateUser(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in both fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Administrator/OneDrive - American International University-Bangladesh/Code/Prctice/java/JavaProject/signup.txt"))) {
            String line;
            boolean validUser = false;

            while ((line = reader.readLine()) != null) {
                if (line.equals("User Name:" + username)) {
                    String passwordLine = reader.readLine();
                    if (passwordLine != null && passwordLine.equals("Password:" + password)) {
                        validUser = true; 
                        break;
                    }
                }
            }

            if (validUser) {
                setVisible(false);
                new FlightBookingUI();
            } else {
                JOptionPane.showMessageDialog(this, "Wrong username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading user data.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace(); 
        }
    }
}
