package src;

import java.awt.*;
import java.awt.event.*;
import java.nio.channels.Pipe;
import java.security.Key;

import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;

public class Flappy_bird extends JPanel implements ActionListener, KeyListener {
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

    // pipes
    int pipeX = boardWidth;
    int pipeY = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;

    class pipe {
        int x = pipeX;
        int y = pipeY;
        int width = pipeWidth;
        int height = pipeHeight;
        Image img;
        boolean passed = false;
        Image bottomPipeImg;

        pipe(Image img) {
            this.img = img;
        }
    }

    // game logic
    Bird bird;
    int velocityX = -4;// moves pipe to left side (simulate bird movement)
    int velocityY = 0;
    int gravity = 1;

    ArrayList<pipe> pipes;
    Random random = new Random();

    Timer gameLoop;
    Timer placepipesTimer;

    boolean gameOver = false;

    double score = 0;

    Flappy_bird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setFocusable(true);
        addKeyListener(this);
        // setBackground(Color.blue);

        // load images
        birdImg = new ImageIcon(getClass().getResource("/src/assets/flappybird.png")).getImage();
        backgroundImg = new ImageIcon(getClass().getResource("/src/assets/flappybirdbg.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("/src/assets/toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("/src/assets/bottompipe.png")).getImage();

        // bird
        bird = new Bird(birdImg);
        pipes = new ArrayList<pipe>();

        // place pipe timer
        placepipesTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placepipes();
            }
        });
        placepipesTimer.start();

        // game loop
        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();
    }

    public void placepipes() {
        // (0-1)*peipeHeight/2 -> (0-256)
        int randompipeY = (int) (pipeY - pipeHeight / 4 - Math.random() * (pipeHeight / 2));
        int openingHeight = boardHeight / 4; // Height of the gap between pipes

        pipe topPipe = new pipe(topPipeImg);
        topPipe.y = randompipeY;
        topPipe.x = boardWidth; // Set x only for the new pipe
        pipes.add(topPipe);

        pipe bottomPipe = new pipe(bottomPipeImg);
        bottomPipe.y = topPipe.y + pipeHeight + openingHeight; // Position the bottom pipe below the top pipe
        bottomPipe.x = boardWidth; // Set x only for the new pipe
        pipes.add(bottomPipe);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        draw(g);
    }

    public void draw(Graphics g) {

        // Draw background
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);

        // bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);

        // Draw pipes
        for (int i = 0; i < pipes.size(); i++) {
            pipe pipe = pipes.get(i);
            g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }

        // score

        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 32));
        if (gameOver) {
            g.drawString("Game Over:" + String.valueOf((int) score), 10, 35);

        } else {
            g.drawString(String.valueOf((int) score), 10, 35);
        }

    }

    public void jump() {
        // bird
        velocityY += gravity;
        bird.y += velocityY;
        bird.y = Math.max(bird.y, 0); // Prevent bird from going above the top

        // pipe
        for (int i = 0; i < pipes.size(); i++) {
            pipe pipe = pipes.get(i);
            pipe.x += velocityX; // Move pipe to the left

            // ...existing code...
            if (!pipe.passed && pipe.x + pipe.width < bird.x) {
                pipe.passed = true;
                score += 0.5; // Increment score by 0.5 for each pipe passed
            }
            // ...existing code...

            if (collision(bird, pipe)) {
                gameOver = true;
                System.out.println("Game Over! Bird collided with a pipe.");
            }

        }

        if (bird.y > boardHeight) {
            gameOver = true;

            System.out.println("Game Over! Bird hit the ground.");
        }
    }

    public boolean collision(Bird a, pipe b) {
        // Check if bird collides with any pipe
        return a.x < b.x + b.width &&
                a.x + a.width > b.x &&
                a.y < b.y + b.height &&
                a.y + a.height > b.y;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jump();
        repaint();
        if (gameOver) {
            placepipesTimer.stop();
            gameLoop.stop();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            // Jump when space is pressed
            velocityY = -9; // Reset velocity for jump
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
