package classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PassengerDetailsUI extends JFrame {

    public PassengerDetailsUI(String name, String dob, String mobile, String email) {
        
        setTitle("Flying Ticket Booking Site");
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        JLabel backgroundLabel = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\pic\\ticket.jpg"));
        backgroundLabel.setLayout(new BorderLayout());
        setContentPane(backgroundLabel); 
       

        
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        JLabel titleLabel = new JLabel("Passenger Details Page", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.black);
        headerPanel.add(titleLabel, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS)); 
        formPanel.setBorder(BorderFactory.createEmptyBorder(200, 40, 20, 40)); 
        formPanel.setOpaque(false);

        
        addLabelWithValue(formPanel, "Name:", name);
        addLabelWithValue(formPanel, "Date of Birth:", dob);
        addLabelWithValue(formPanel, "Mobile No:", mobile);
        addLabelWithValue(formPanel, "Email:", email);

        add(formPanel, BorderLayout.CENTER); 

        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);

        
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backPanel.setOpaque(false);
        JButton backButton = new JButton("<<Back");
        backButton.setPreferredSize(new Dimension(100, 40));
        backButton.setBackground(new Color(5,124,164));
        backButton.setForeground(Color.WHITE);
        backPanel.add(backButton);
        bottomPanel.add(backPanel, BorderLayout.WEST);

        
        JPanel nextPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        nextPanel.setOpaque(false); 
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setPreferredSize(new Dimension(100, 40));
        confirmButton.setBackground(new Color(5,124,164));
        confirmButton.setForeground(Color.WHITE);
        nextPanel.add(confirmButton);
        bottomPanel.add(nextPanel, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH); 

        
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(PassengerDetailsUI.this, "Booking Confirmed!", "Success", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
                new WelcomeFrame(); 
            }
        });

        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); 
                new FlightBookingForm(); 
            }
        });

        setVisible(true); 
    }

    
    private void addLabelWithValue(JPanel panel, String label, String value) {
        JLabel labelTitle = new JLabel(label);
        labelTitle.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(labelTitle);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
        valueLabel.setForeground(Color.BLUE);
        panel.add(valueLabel);
        
        panel.add(Box.createRigidArea(new Dimension(0, 20))); 
    }

    
}
