package src;

import java.awt.*;
import java.awt.event.*;
import java.security.Key;

import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;

public class Flappy_bird extends JPanel implements ActionListener,KeyListenerke {
    int boardWidth = 360;
    int boardHeight = 640;

    /// Images
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;

    // bird
    int birdX = boardWidth / 8;
    int birdY = boardHeight / 2;
    int birdHeight = 24;
    int birdWidth = 34;

    class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;

        Bird(Image img) {
            this.img = img;
        }
    }

    // game logic
    Bird bird;
    int velocityY = -9;
    int gravity=1;

    Timer gameLoop;

    Flappy_bird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        // setBackground(Color.blue);

        // load images
        birdImg = new ImageIcon(getClass().getResource("/src/assets/flappybird.png")).getImage();
        backgroundImg = new ImageIcon(getClass().getResource("/src/assets/flappybirdbg.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("/src/assets/toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("/src/assets/bottompipe.png")).getImage();

        // bird
        bird = new Bird(birdImg);

        // game loop
        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        draw(g);
    }

    public void draw(Graphics g) {

        System.out.println("draw");
        // Draw background
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);

        // bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);

    }

    public void jump() {
        // bird         
        velocityY +=gravity;
        bird.y += velocityY;
        bird.y =Math.max(bird.y, 0); // Prevent bird from going above the top
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jump();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

}
