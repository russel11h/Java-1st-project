package classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WelcomeFrame extends JFrame {

    public WelcomeFrame() {
        
        setTitle("Flying Ticket Booking Site");
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\Administrator\\Desktop\\pic\\ticket.jpg");
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setLayout(new BorderLayout()); 

        
        Image scaledImage = backgroundImage.getImage().getScaledInstance(1080, 720, Image.SCALE_SMOOTH);
        backgroundLabel.setIcon(new ImageIcon(scaledImage));
        setContentPane(backgroundLabel);

        
        setLayout(new BorderLayout());

        
        JPanel welcomePanel = new JPanel();
        welcomePanel.setOpaque(false); 
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));

        
        JLabel thankYouLabel = new JLabel("Thank You for booking from our site!", JLabel.CENTER);
        thankYouLabel.setFont(new Font("Arial", Font.BOLD, 30));
        thankYouLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        thankYouLabel.setForeground(Color.black);
        
        JLabel ticketBookedLabel = new JLabel("Your ticket has been booked.", JLabel.CENTER);
        ticketBookedLabel.setFont(new Font("Arial", Font.BOLD, 30));
        ticketBookedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ticketBookedLabel.setForeground(Color.black);

        welcomePanel.add(Box.createVerticalStrut(150)); 
        welcomePanel.add(thankYouLabel);
        welcomePanel.add(ticketBookedLabel);
        
        add(welcomePanel, BorderLayout.NORTH);

        
        JButton finishButton = new JButton("Finish");
        finishButton.setBackground(new Color(5,124,164));
        finishButton.setForeground(Color.WHITE);
        finishButton.setFocusPainted(false);
        finishButton.setPreferredSize(new Dimension(100, 40));

        
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); 
                new FlightBookingUI();
            }
        });

        
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        buttonPanel.add(finishButton, gbc); 
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true); 
    }

    
    public static void main(String[] args) {
         new WelcomeFrame();
     }
}
