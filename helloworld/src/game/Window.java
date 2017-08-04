package game;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by katermar on 8/1/2017.
 */

class DrawPanel extends JPanel {

    GameOfLife gameOfLife;

    public DrawPanel(boolean[][] map) {
        gameOfLife = new GameOfLife(map);
        new java.util.Timer().schedule(
                new TimerTask() {
                    public void run() {
                        repaint();
                    }
                },
                1000);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight()); //<-- clear the background
        boolean[][] map = gameOfLife.makeStep();
        int size = 40;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
//                Rectangle grid = new Rectangle(100 + i * size, 100 + j * size, size, size);
                if (map[i][j]) {
                    g2d.setColor(Color.black);
                    g2d.fillRect(100 + i * size, 100 + j * size, size, size);
                } else {
                    g2d.setColor(Color.white);
                    g2d.fillRect(100 + i * size, 100 + j * size, size, size);
                }
            }
        }
    }

}

public class Window {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation");
        boolean[][] grid = {
                {false, false, false, false, false},
                {false, false, true, false, false},
                {false, false, true, false, false},
                {false, false, true, false, false},
                {false, false, false, false, false},
        };
        frame.add(new DrawPanel(grid));
        frame.setTitle("Simple example");
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}