package game;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by katermar on 8/1/2017.
 */
public class GameOfLifeTest {

    @Test
    public void testCreateObject() {
        GameOfLife gameOfLife = new GameOfLife(new boolean[3][3]);
    }

    @Test
    public void testMethodStep(){
        GameOfLife gameOfLife = new GameOfLife(new boolean[3][3]);

        gameOfLife.makeStep();
    }

    @Test
    public void testAllDead() {
        GameOfLife game = new GameOfLife(new boolean[3][3]);
        assertTrue(Arrays.deepEquals(new boolean[3][3], game.makeStep()));
    }

    @Test
    public void testStableGrid(){
        boolean[][] grid = {
                {false, false, false, false},
                {false, true, true, false},
                {false, true, true, false},
                {false, false, false, false},
        };
        GameOfLife gameOfLife = new GameOfLife(grid);
        assertTrue(Arrays.deepEquals(grid, gameOfLife.makeStep()));
    }

    @Test
    public void testCyclicStableGrid(){
        boolean[][] grid = {
                {false, false, false, false},
                {true, false, false, true},
                {true, false, false, true},
                {false, false, false, false},
        };
        GameOfLife gameOfLife = new GameOfLife(grid);
        assertTrue(Arrays.deepEquals(grid, gameOfLife.makeStep()));
    }
}