package gui;
import java.awt.*;
import javax.swing.*;

public class TopLevelWindow {

        private static void createWindow() {
            JFrame frame = new JFrame("Connect Four");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JLabel textLabel = new JLabel("Label Name Goes Here", SwingConstants.CENTER);
            textLabel.setPreferredSize(new Dimension(300, 100));
            frame.getContentPane().add(textLabel, BorderLayout.CENTER);
            
            //Display the window
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);
        }
        
        public static void main(String[] args) {
            createWindow();
        }



}
