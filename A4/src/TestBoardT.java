/**
 * @file: TestBoardT.java
 * @Author: Bill Song - songb10
 * @Date: March.31th, 2020
 * @Description: Tests the public interfaces of BoardT
 */

package src;

import org.junit.*;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.ArrayList;

public class TestBoardT{

    private int[][] emptyBoard;
    private int[][] winningBoard;
    private int[][] losingBoard;
    private int[][] fullBoard;
    private int[][] board1;

    private BoardT B1;
    private BoardT B2;
    private BoardT B3;
    private BoardT B4;
    private BoardT B5;

    @Before
    public void setUp(){
        emptyBoard = new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        winningBoard = new int[][] {{0,0,0,0},{0,2048,0,0},{0,0,2,0},{0,0,0,0}};
        losingBoard = new int[][] {{2,16,4,2},{4,32,256,8},{8,4,16,32},{4,16,2,4}};
        fullBoard = new int[][] {{2,4,2,2},{2,16,4,4},{8,8,8,8},{2,2,4,32}};
        board1 = new int[][]{{0,2,0,4},{2,0,4,2},{2,16,4,8},{0,2,16,16}};
        
        B1 = new BoardT(emptyBoard);
        B2 = new BoardT(winningBoard);
        B3 = new BoardT(losingBoard);
        B4 = new BoardT(fullBoard);
        B5 = new BoardT(board1);
    }

    @After
    public void tearDown(){
        emptyBoard = null;
        winningBoard = null;
        losingBoard = null;
        fullBoard = null;
        board1 = null;

        B1 = null;
        B2 = null;
        B3 = null;
        B4 = null;
        B5 = null;
    }

    @Test 
    public void testgetBoard(){
        int[][] board = new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        assertArrayEquals(board, B1.getBoard());
    }

    @Test 
    public void initializeBoard1(){
        int before = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(B1.getBoard()[i][j] == 2 || B1.getBoard()[i][j] == 4) {
                    before++;
                }
            }
        }

        B1.initializeBoard();
        int after = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(B1.getBoard()[i][j] == 2 || B1.getBoard()[i][j] == 4) {
                    after++;
                }
            }
        }
        assertEquals((after - before), 2);


    }

    @Test 
    public void initializeBoard2(){
        int before = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(B5.getBoard()[i][j] == 2 || B5.getBoard()[i][j] == 4) {
                    before++;
                }
            }
        }

        B5.initializeBoard();
        int after = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(B5.getBoard()[i][j] == 2 || B5.getBoard()[i][j] == 4) {
                    after++;
                }
            }
        }
        assertEquals((after - before), 0);
    }

    @Test 
    public void testaddNumber(){
        int before = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(B5.getBoard()[i][j] != 0) {
                    before++;
                }
            }
        }

        B5.addNumber();
        int after1 = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(B5.getBoard()[i][j] != 0) {
                    after1++;
                }
            }
        }
        assertEquals((after1 - before), 1);

        B5.addNumber();
        int after2 = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(B5.getBoard()[i][j] != 0) {
                    after2++;
                }
            }
        }
        assertEquals((after2 - before), 2);
    }

    @Test 
    public void testmoveUp1(){
        int[][] expected = new int[][] {{4,2,8,4},{0,16,16,2},{0,2,0,8},{0,0,0,16}};
        B5.moveUp();
        assertArrayEquals(expected, B5.getBoard());
    }

    @Test 
    public void testmoveUp2(){
        int[][] expected = new int[][] {{4,4,2,2},{8,16,4,4},{2,8,8,8},{0,2,4,32}};
        B4.moveUp();
        assertArrayEquals(expected, B4.getBoard());
    }

    @Test 
    public void testmoveUp3(){
        int[][] expected1 = new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        int[][] expected2 = new int[][] {{2,16,4,2},{4,32,256,8},{8,4,16,32},{4,16,2,4}};
        B1.moveUp();
        B3.moveUp();
        assertArrayEquals(expected1, B1.getBoard());
        assertArrayEquals(expected2, B3.getBoard());
    }

    @Test 
    public void testmoveDown1(){
        int[][] expected = new int[][] {{0,0,0,4},{0,2,0,2},{0,16,8,8},{4,2,16,16}};
        B5.moveDown();
        assertArrayEquals(expected, B5.getBoard());
    }

    @Test 
    public void testmoveDown2(){
        int[][] expected = new int[][] {{0,4,2,2},{4,16,4,4},{8,8,8,8},{2,2,4,32}};
        B4.moveDown();
        assertArrayEquals(expected, B4.getBoard());
    }

    @Test 
    public void testmoveDown3(){
        int[][] expected1 = new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        int[][] expected2 = new int[][] {{2,16,4,2},{4,32,256,8},{8,4,16,32},{4,16,2,4}};
        B1.moveDown();
        B3.moveDown();
        assertArrayEquals(expected1, B1.getBoard());
        assertArrayEquals(expected2, B3.getBoard());
    }

    @Test 
    public void testmoveLeft1(){
        int[][] expected = new int[][] {{2,4,0,0},{2,4,2,0},{2,16,4,8},{2,32,0,0}};
        B5.moveLeft();
        assertArrayEquals(expected, B5.getBoard());
    }

    @Test 
    public void testmoveLeft2(){
        int[][] expected = new int[][] {{2,4,4,0},{2,16,8,0},{16,16,0,0},{8,32,0,0}};
        B4.moveLeft();
        assertArrayEquals(expected, B4.getBoard());
    }

    @Test 
    public void testmoveLeft3(){
        int[][] expected1 = new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        int[][] expected2 = new int[][] {{2,16,4,2},{4,32,256,8},{8,4,16,32},{4,16,2,4}};
        B1.moveLeft();
        B3.moveLeft();
        assertArrayEquals(expected1, B1.getBoard());
        assertArrayEquals(expected2, B3.getBoard());
    }

    @Test 
    public void testmoveRight1(){
        int[][] expected = new int[][] {{0,0,2,4},{0,2,4,2},{2,16,4,8},{0,0,2,32}};
        B5.moveRight();
        assertArrayEquals(expected, B5.getBoard());
    }

    @Test 
    public void testmoveRight2() {
        int[][] expected = new int[][] {{0,0,2,8},{0,2,16,8},{0,0,16,16},{0,4,4,32}};
        B4.moveRight();
        assertArrayEquals(expected, B4.getBoard());
    }

    @Test 
    public void testmoveRight3(){
        int[][] expected1 = new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        int[][] expected2 = new int[][] {{2,16,4,2},{4,32,256,8},{8,4,16,32},{4,16,2,4}};
        B1.moveRight();
        B3.moveRight();
        assertArrayEquals(expected1, B1.getBoard());
        assertArrayEquals(expected2, B3.getBoard());
    }


    @Test 
    public void winChecker1(){
        assertTrue(B2.winChecker());
    }

    @Test 
    public void winChecker2(){
        assertFalse(B1.winChecker());
        assertFalse(B3.winChecker());
        assertFalse(B4.winChecker());
        assertFalse(B5.winChecker());
    }

    @Test 
    public void loseChecker1(){
        assertTrue(B3.loseChecker());
    }

    @Test 
    public void loseChecker2(){
        assertFalse(B1.loseChecker());
        assertFalse(B2.loseChecker());
        assertFalse(B4.loseChecker());
        assertFalse(B5.loseChecker());
    }


    @Test 
    public void getScore1(){
        assertEquals(B1.getScore(), 0);
    }

    @Test
    public void getScore2(){
        B5.moveRight();
        assertEquals(B5.getScore(), 32);
    }

    @Test
    public void getScore3(){
        B5.moveUp();
        assertEquals(B5.getScore(), 12);
    }
}