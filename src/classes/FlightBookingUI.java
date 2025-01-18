package classes;

import java.awt.*;
import javax.swing.*;

 
public class FlightBookingUI extends JFrame {
 
    private ButtonGroup flightGroup;
    private JRadioButton selectedRadioButton = null; 
 
    public FlightBookingUI() {
        
        setTitle("Flying Ticket Booking Site");
        setSize(1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel backgroundLabel = new JLabel(new ImageIcon("resource/pic/ticket.jpg"));
        backgroundLabel.setLayout(new BorderLayout()); 
        setContentPane(backgroundLabel); 

        setLayout(new BorderLayout());
 
        
        flightGroup = new ButtonGroup();
 
        
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false); 
        JLabel titleLabel = new JLabel("Select Your Flight", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20)); 
        titleLabel.setForeground(Color.black);
        headerPanel.add(titleLabel, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);
 
        
        JPanel bottomPanel = new JPanel(new BorderLayout());
 
        
        JPanel nextButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        nextButtonPanel.setOpaque(false);
        JButton nextButton = new JButton("Next>>");
        nextButton.setPreferredSize(new Dimension(100, 40)); 
        nextButton.setBackground(new Color(5,124,164)); 
        nextButton.setForeground(Color.WHITE);
        nextButtonPanel.add(nextButton);
 
        
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backPanel.setOpaque(false);
        JButton backButton = new JButton("<<Back");
        backButton.setPreferredSize(new Dimension(100, 40));
        backButton.setBackground(new Color(5,124,164)); 
        backButton.setForeground(Color.WHITE);
        backPanel.add(backButton);
 
        
        bottomPanel.add(backPanel, BorderLayout.WEST);
        bottomPanel.add(nextButtonPanel, BorderLayout.EAST); 
        bottomPanel.setOpaque(false);
 
        add(bottomPanel, BorderLayout.SOUTH);
 
    
        JPanel flightListPanel = new JPanel();
        flightListPanel.setLayout(new BoxLayout(flightListPanel, BoxLayout.Y_AXIS));
 
        
        String flights[][] = 
        {
                {"Novoair", "NA - 576", "17:20", "18:20  ", "$4,000  ",   "Dhaka to Madrid"},
                {"BD-Biman", "BB - 575", "08:00", "09:00  ", "$5,500  ",  "Dhaka to Barcelona"},
                {"US-Bangla", "UB - 163", "13:00", "14:00  ", "$2,100  ", "Dhaka to Liverpool"},
                {"US-Bangla", "UB - 183", "10:00", "11:00  ", "$10,000  ","Dhaka to Paris"},
                {"US-Bangla", "UB - 163", "13:00", "14:00  ", "$2,100  ", "Dhaka to New York"},
                {"US-Bangla", "UB - 165", "01:00", "03:00  ", "$7,000  ", "Dhaka to Dubai"}
        };
 
        for (String flight[] : flights) 
        {
            flightListPanel.add(createFlightOption(flight[0], flight[1], flight[2], flight[3], flight[4], flight[5]));
        }
 
        
        JScrollPane scrollPane = new JScrollPane(flightListPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(450, 500));
        add(scrollPane, BorderLayout.CENTER);
 
       
        backButton.addActionListener(e -> 
        {
            setVisible(false); 
            new LoginForm(); 
        });
 
       
        nextButton.addActionListener(e -> 
        {
            if (flightGroup.getSelection() == null) 
            {
                
                JOptionPane.showMessageDialog(FlightBookingUI.this,"Please select a flight !","No Flight Selected",JOptionPane.ERROR_MESSAGE);
            } 
            else 
            {
                
                new FlightBookingForm(); 
                setVisible(false); 
            }
        });
 
        setVisible(true);
    }
 
    private JPanel createFlightOption(String airline, String flightNumber, String depTime, String arrTime, String price, String destination) 
    {
        JPanel flightPanel = new JPanel();
        flightPanel.setLayout(new BorderLayout());
        flightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        flightPanel.setBackground(Color.GRAY);
        flightPanel.setPreferredSize(new Dimension(400, 100)); 
 
        
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton selectButton = new JRadioButton();
        flightGroup.add(selectButton); 
        radioPanel.add(selectButton); 
 
        selectButton.addActionListener(e -> selectedRadioButton = selectButton); 
 
        
        JPanel leftPanel = new JPanel(new GridLayout(2, 1));
        JLabel airlineLabel = new JLabel(airline, JLabel.CENTER); 
        JLabel flightnumJLabel = new JLabel(flightNumber, JLabel.CENTER);
        JLabel destenyTypeLabel = new JLabel(destination, JLabel.CENTER); 
        destenyTypeLabel.setForeground(new Color(5,124,164)); 
        flightnumJLabel.setForeground(Color.RED);
        leftPanel.add(airlineLabel);
        leftPanel.add(flightnumJLabel);
        leftPanel.add(destenyTypeLabel);
 
       
        JPanel rightPanel = new JPanel(new GridLayout(2, 1));
        JLabel priceLabel = new JLabel(price, JLabel.RIGHT); 
        JLabel arrTimeLabel = new JLabel("Time:  " + depTime + "    to    " + arrTime, JLabel.LEFT); 
        
        rightPanel.add(priceLabel);
        rightPanel.add(arrTimeLabel);
 
        
        flightPanel.add(radioPanel, BorderLayout.WEST);   
        flightPanel.add(leftPanel, BorderLayout.CENTER);  
        flightPanel.add(rightPanel, BorderLayout.EAST);  
 
        return flightPanel;
    }
}