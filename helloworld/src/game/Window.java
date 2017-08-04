package game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.ForkJoinPool;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by katermar on 8/1/2017.
 */

class DrawPanel extends JPanel {

    GameOfLife gameOfLife;
    private boolean isEnd = false;

    private void mainLoop() {
        while (!isEnd) {
            repaint();
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public DrawPanel(boolean[][] map) throws Exception {
        gameOfLife = new GameOfLife(map);
        ForkJoinPool.commonPool().execute(this::mainLoop);
    }

    @Override
    protected void paintComponent(Graphics g) {
        boolean end = true;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight()); //<-- clear the background
        boolean[][] map = gameOfLife.makeStep();
        int size = 40;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
//                Rectangle grid = new Rectangle(100 + i * size, 100 + j * size, size, size);
                if (map[i][j]) {
                    g2d.setColor(new Color((int)(Math.random() * 0x1000000)));
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
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Animation");
        boolean[][] grid = {
                {true, false, false, false, false, true},
                {true, false, false, false, false, true},
                {false, false, true, false, false, false},
                {false, true, true, false, false, true},
                {false, true, true, false, false, true},
                {false, false, true, false, false, false},
                {false, true, true, false, false, true},
                {false, false, true, false, false, false},
                {false, false, true, false, false, false},
                {false, false, true, false, false, false},
                {false, false, true, false, false, false},
        };
        frame.add(new DrawPanel(grid));
        frame.setTitle("Simple example");
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}