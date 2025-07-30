package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;

public class Flappy_bird extends JPanel {
    int boardWidth = 360;
    int boardHeight = 640;

    /// Images
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;

    Flappy_bird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        // setBackground(Color.blue);

        // load images
        birdImg = new ImageIcon(getClass().getResource("/src/assets/flappybird.png")).getImage();
        backgroundImg = new ImageIcon(getClass().getResource("/src/assets/flappybirdbg.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("/src/assets/toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("/src/assets/bottompipe.png")).getImage();

        // setFocusable(true);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        draw(g);
    }

    public void draw(Graphics g) {
        // Draw background
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);

    }

}
