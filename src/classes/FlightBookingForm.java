package classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

 public class FlightBookingForm extends JFrame {

    public FlightBookingForm() {
        
        setTitle("Flying Ticket Booking Site");
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        JLabel backgroundLabel = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\pic\\ticket.jpg"));
        backgroundLabel.setLayout(new BorderLayout()); 
        setContentPane(backgroundLabel); 

        
        JPanel headerPanel = new JPanel(new BorderLayout());
        
        headerPanel.setOpaque(false); 
        JLabel titleLabel = new JLabel("Flight Booking Form", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
        titleLabel.setForeground(Color.black); 
        headerPanel.add(titleLabel, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(8, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(200, 40, 20, 40)); 
        formPanel.setOpaque(false); 

        
        JLabel titleFormLabel = new JLabel("Title:");
        titleFormLabel.setFont(new Font("Arial", Font.BOLD, 18));
        formPanel.add(titleFormLabel);
        String titles[] = {"Mr.", "Mrs.", "Ms.", "Dr.", "Prof.","Md."};
        JComboBox<String> titleComboBox = new JComboBox<>(titles);
        titleComboBox.setPreferredSize(new Dimension(50, 30));
        formPanel.add(titleComboBox);

        
        JLabel firstNameLabel = new JLabel("Name:");
        firstNameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        formPanel.add(firstNameLabel);
        JTextField firstNameField = new JTextField();
        formPanel.add(firstNameField);

       
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setFont(new Font("Arial", Font.BOLD, 18));
        formPanel.add(dobLabel);
        JTextField dobField = new JTextField();
        formPanel.add(dobField);

        
        JLabel mobileLabel = new JLabel("Mobile No:");
        mobileLabel.setFont(new Font("Arial", Font.BOLD, 18)); 
        formPanel.add(mobileLabel);
        JTextField mobileField = new JTextField();
        formPanel.add(mobileField);

        
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 18)); 
        formPanel.add(emailLabel);
        JTextField emailField = new JTextField();
        formPanel.add(emailField);

        add(formPanel, BorderLayout.CENTER);

       
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false); 

        
        JPanel nextPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        nextPanel.setOpaque(false); 
        JButton nextButton = new JButton("Next>>");
        nextButton.setPreferredSize(new Dimension(100, 40)); 
        nextButton.setBackground(new Color(5,124,164)); 
        nextButton.setForeground(Color.WHITE); 
        nextButton.setFont(new Font("Arial", Font.BOLD, 12)); 
        nextPanel.add(nextButton);

       
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backPanel.setOpaque(false); 
        JButton backButton = new JButton("<<Back");
        backButton.setPreferredSize(new Dimension(100, 40)); 
        backButton.setBackground(new Color(5,124,164));
        backButton.setForeground(Color.WHITE); 
        backButton.setFont(new Font("Arial", Font.BOLD, 12)); 
        backPanel.add(backButton);

        
        bottomPanel.add(backPanel, BorderLayout.WEST);
        bottomPanel.add(nextPanel, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

       
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    if (firstNameField.getText().trim().isEmpty() || dobField.getText().trim().isEmpty() || 
                        mobileField.getText().trim().isEmpty() || emailField.getText().trim().isEmpty()) {
                        throw new IllegalArgumentException("All fields must be filled up!");
                    }

                    
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/Administrator/OneDrive - American International University-Bangladesh/Code/Prctice/java/JavaProject/userdetails.txt", true))) {
                        writer.write("Name: " + firstNameField.getText().trim() + "\n");
                        writer.write("Date of Birth: " + dobField.getText().trim() + "\n");
                        writer.write("Mobile No: " + mobileField.getText().trim() + "\n");
                        writer.write("Email: " + emailField.getText().trim() + "\n");
                    }

                    
                    String name = firstNameField.getText().trim();
                    String dob = dobField.getText().trim();
                    String mobile = mobileField.getText().trim();
                    String email = emailField.getText().trim();

                    
                    setVisible(false);
                    new PassengerDetailsUI(name, dob, mobile, email);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(FlightBookingForm.this, "Error writing to file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(FlightBookingForm.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new FlightBookingUI();
            }
        });

        setVisible(true); 
    }

    public static void main(String[] args) {
        new FlightBookingForm(); 
    }
}
