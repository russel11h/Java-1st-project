package classes;

import javax.swing.JFrame;

public class frame { 

    public frame() { 
        JFrame j = new JFrame("Fly"); 
        j.setSize(1000, 800);
        j.setVisible(true);
        j.setLayout(null); 

        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        j.setLocationRelativeTo(null); 
    }

}
