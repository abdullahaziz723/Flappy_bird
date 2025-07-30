package src;
import javax.swing.*;


public class App {
    // This is the main entry point of the application

public static void main(String[] args) throws Exception {
  int borderWidth = 360;
  int borderHeight = 640;

  JFrame frame = new JFrame("Flappy Bird");
//   frame.setVisible(true);
  frame.setSize(borderWidth, borderHeight);
  frame.setLocationRelativeTo(null);
  frame.setResizable(false);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  Flappy_bird gamePanel = new Flappy_bird();
  frame.add(gamePanel);
  frame.pack();
  frame.setVisible(true);



   }
}