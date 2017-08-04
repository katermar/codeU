package game;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by katermar on 8/1/2017.
 */
public class GameOfLife {

    private boolean firstGrid[][];
    private List<Coordinates> directions = new ArrayList<Coordinates>() {{
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                add(new Coordinates(i, j));
            }
        }
    }};

    public static class Coordinates {

        public int x;
        public int y;
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public GameOfLife(boolean[][] firstGrid) {
        this.firstGrid = firstGrid;
    }

    private int countNeighbours(Coordinates coords) {
        int counter = 0;
        for (Coordinates dir : directions) {
            if (firstGrid[(coords.x + dir.x + getCols()) % getCols()][(coords.y + dir.y + getRows()) % getRows()]) counter++;
        }
        return  counter;
    }

    public boolean[][] makeStep() {
        boolean secondGrid[][] = new boolean[getCols()][getRows()];

        for (int i = 0; i < getCols(); i++) {
            for (int j = 0; j < getRows(); j++) {
                int neighs = countNeighbours(new Coordinates(i, j));
                secondGrid[i][j] = firstGrid[i][j] && neighs == 2 || neighs == 3;
            }
        }
        firstGrid = secondGrid.clone();

        return secondGrid;
    }

    private int getCols(){
        return firstGrid.length;
    }

    private int getRows() {
        return firstGrid[0].length;
    }
}
