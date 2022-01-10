/**
 * @file: BoardT.java
 * @Author: Hamrish Saravanakumar
 * @Date: April 12th, 2021
 * @Description: Model module for storing the state and status of the board
 */

package src;

import java.util.Arrays;
import java.util.Random;

import src.SetBoard;

public class BoardT {

    private int[][] board;
    private int score;
    private boolean possibleMove;

    public static final int SIZE = 4;

    /**
     * @brief Constructs a game board that holds the state, status and score of the current game
     * @details Generates a board with an initial score of 0, and a populated game board
     * @param board a 2-d array of integers that represents a board
     */
    public BoardT(int[][] board) {
        this.score = 0;
        this.board = board;
        this.possibleMove = false;
    }

    /**
     * @brief Obtains the current state of the board
     * @returns A 2-d array of integers representing the current state of the board
     */
    public int[][] getBoard() {
        return this.board;
    }

    /**
     * @brief Obtains whether a move is possible based on the board's current state
     * @returns true if a move is possible based on the board's current state, false otherwise
     */
    public boolean getPossibleMove() {
        return this.possibleMove;
    }
    

    /**
     * @brief Initializes the game board
     * @details If the game baord is empty, then two random cells are populated with either a 2 or a 4
     */
    public void initializeBoard() {
    
        if(SetBoard.emptyBoardCheck(this.board)) {
            int count = 0;
            Random randomNum = new Random(); 
            String s = "4222222222";
            char num1 = s.charAt(randomNum.nextInt(s.length()));
            String numString1 = String.valueOf(num1);
            char num2 = s.charAt(randomNum.nextInt(s.length()));
            String numString2 = String.valueOf(num2);
        
            for(int i = 0; i < SIZE; i++) {
                for(int j = 0; j < SIZE; j++) {
                    if(this.board[i][j] == 0) {
                        count++;
                    }
                }
            }
            //Local Function valueOf(i) -> converts into string
            String[] storeFreeBlocks = new String[count];
            int localcounter = 0;
            for(int i = 0; i < SIZE; i++) {
                for(int j = 0; j < SIZE; j++) {
                    if(this.board[i][j] == 0) {
                        storeFreeBlocks[localcounter] = String.valueOf(i)+","+String.valueOf(j);
                        localcounter++;
                    }
                }
            }
            //split(i) -> breaks a given string around matches of the given expression 
            //nextInt(i) -> uniformly distributed int value between 0 and the specified value, drawn from this random number generator's sequence
            //-arseInt(string) -> takes in a string and returns the int version of it
            String getFreeBlock1 = storeFreeBlocks[randomNum.nextInt(storeFreeBlocks.length)];
            String[] getRowCol1 = getFreeBlock1.split(",");
            String getFreeBlock2 = storeFreeBlocks[randomNum.nextInt(storeFreeBlocks.length)];
            String[] getRowCol2 = getFreeBlock2.split(",");
            int a = Integer.parseInt(getRowCol1[0]);
            int b = Integer.parseInt(getRowCol1[1]);
            this.board[a][b] = Integer.parseInt(numString1);
            int c = Integer.parseInt(getRowCol2[0]);
            int d = Integer.parseInt(getRowCol2[1]);
            this.board[c][d] = Integer.parseInt(numString2);
        }
    }

    /**
     * @brief Adds a number in the game baord
     * @details Following every valid turn, a random empty cell is populated with either a 2 or 4
     */
    public void addNumber() {

        int count = 0;
        Random randomNum = new Random(); 
        String s = "4222222222";
        char num = s.charAt(randomNum.nextInt(s.length()));
        String numString = String.valueOf(num);

        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if(this.board[i][j] == 0) {
                    count++;
                }
            }
        }
        //Local Function valueOf(i) -> converts into string
        String[] storeFreeBlocks = new String[count];
        int localcounter = 0;
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if(this.board[i][j] == 0) {
                    storeFreeBlocks[localcounter] = String.valueOf(i)+","+String.valueOf(j);
                    localcounter++;
                }
            }
        }
        //split(i) -> breaks a given string around matches of the given expression 
        //nextInt(i) -> uniformly distributed int value between 0 and the specified value, drawn from this random number generator's sequence
        //-arseInt(string) -> takes in a string and returns the int version of it
        String getFreeBlock = storeFreeBlocks[randomNum.nextInt(storeFreeBlocks.length)];
        String[] getRowCol = getFreeBlock.split(",");
        int a = Integer.parseInt(getRowCol[0]);
        int b = Integer.parseInt(getRowCol[1]);
        this.board[a][b] = Integer.parseInt(numString);

    }

    /**
     * @brief Moves the game board up
     * @details Any cell that has a zero above it, will be shifted up in the game baord. 
          If two cells that are on top of one another have the same value, 
          the top value is doubled, and the bottom value becomes zero. 
          The score is updated by adding the new value of the combined cell.
          A new number is added if the move is possible, otherwise the board remains unchanged
     */
    public void moveUp() {
        this.possibleMove = false;
        for(int j=0;j<SIZE;j++) {
            for(int i=0;i<=3;i++) {
                if(this.board[i][j]!=0) {
                    int tempi=i;
                    while(SetBoard.up(this.board, tempi, j)==0) { 
                        tempi--;
                    }
                    if(SetBoard.up(this.board, tempi, j)!=0 && SetBoard.up(this.board, tempi, j)==this.board[i][j]) {
                        this.board[tempi-1][j]+=this.board[i][j];
                        this.board[i][j]=0;
                        this.score += this.board[tempi-1][j];
                        this.possibleMove = true;
                    }
                    if(tempi!=i) {
                        this.board[tempi][j]=this.board[i][j];
                        this.board[i][j]=0;
                        this.possibleMove = true;
                    }
                }
            }
        }
    }

    /**
     * @brief Moves the game board down
     * @details Any cell that has a zero below it, will be shifted down in the game baord. 
          If two cells that are on top of one another have the same value, 
          the bottom value is doubled, and the top value becomes zero. 
          The score is updated by adding the new value of the combined cell.
          A new number is added if the move is possible, otherwise the board remains unchanged
     */
    public void moveDown() {
        this.possibleMove = false;
        for(int j=0;j<SIZE;j++) {
            for(int i=3;i>=0;i--) {
                if(this.board[i][j]!=0) {
                    int tempi = i;
                    while(SetBoard.down(this.board, tempi, j)==0) { 
                        tempi++;
                    }
                    if(SetBoard.down(this.board, tempi, j)!=0 && SetBoard.down(this.board, tempi, j)==this.board[i][j]) {
                        this.board[tempi+1][j]+=this.board[i][j];
                        this.board[i][j]=0;
                        this.score += this.board[tempi+1][j];
                        this.possibleMove = true;
                    }
                    if(tempi!=i) {
                        this.board[tempi][j]=this.board[i][j];
                        this.board[i][j]=0;
                        this.possibleMove = true;
                    }
                }
            }
        }
    }

    /**
     * @brief Moves the game board to the left
     * @details Any cell that has a zero to the left of it, will be shifted leftwards in the game baord. 
          If two cells that are adjacent to one another have the same value, 
          the value to the left is doubled, and the value to the right becomes zero. 
          The score is updated by adding the new value of the combined cell.
          A new number is added if the move is possible, otherwise the board remains unchanged
     */
    public void moveLeft() {
        this.possibleMove = false;
        for(int i=0;i<SIZE;i++) {
            for(int j=0;j<=3;j++) {
                if(this.board[i][j]!=0) {
                    int tempj=j;
                    while(SetBoard.left(this.board, i, tempj)==0) { 
                        tempj--;
                    }
                    if(SetBoard.left(board, i, tempj)!=0 && SetBoard.left(this.board, i, tempj)==this.board[i][j]) {
                        this.board[i][tempj-1]+=this.board[i][j];
                        this.board[i][j]=0;
                        this.score += this.board[i][tempj-1];
                        this.possibleMove = true;
                        
                    }
                    if(tempj!=j) {
                        this.board[i][tempj]=this.board[i][j];
                        this.board[i][j]=0;
                        this.possibleMove = true;
                    }
                }
            }
        }
    }
    
    /**
     * @brief Moves the game board to the right
     * @details Any cell that has a zero to the right of it, will be shifted rightwards in the game baord. 
          If two cells that are adjacent to one another have the same value, 
          the value to the right is doubled, and the value to the left becomes zero. 
          The score is updated by adding the new value of the combined cell.
          A new number is added if the move is possible, otherwise the board remains unchanged
     */
    public void moveRight() {
        this.possibleMove = false;
        for(int i=0;i<SIZE;i++) {
            for(int j=3;j>=0;j--) {
                if(this.board[i][j]!=0) {
                    int tempj=j;
                    while(SetBoard.right(this.board, i, tempj)==0) { 
                        tempj++;
                    }
                    if(SetBoard.right(this.board, i, tempj)!=0 && SetBoard.right(this.board, i, tempj)==this.board[i][j]) {
                        this.board[i][tempj+1]+=this.board[i][j];
                        this.board[i][j] = 0;
                        this.score += this.board[i][tempj+1];
                        this.possibleMove = true;
                    }
                    if(tempj!=j) {
                        this.board[i][tempj] = this.board[i][j];
                        this.board[i][j] = 0;
                        this.possibleMove = true;
                    }
                }
            }
        }
    }

    /**
     * @brief Checks if the user has won based on the current state of the baord
     * @details The board indicates a winner if any one of the values in the baord is equal to 2048
     * @return true if the user has won based on the current state of the board, and false otherwise
     */  
    public boolean winChecker() {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                  if(this.board[i][j] == 2048) {
                        return true;
                  }
            }
        }
        return false;
    }
    /**
     * @brief Checks if the user has lost based on the current state of the baord
     * @details The board indicates a loser if the game board is populated by values other than zero, and all 4 possible moves are not possible
     * @return true if the user has lost based on the current state of the board, and false otherwise
     */  
    public boolean loseChecker() {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if(this.board[i][j] == 0) {
                    return false;
                }
                if (i > 0 && this.board[i-1][j] == this.board[i][j]) {
                  return false;
                }
                if (i < SIZE-1 && this.board[i+1][j] == this.board[i][j]) {
                  return false;
                }

                if (j > 0 && this.board[i][j-1] == this.board[i][j]) {
                  return false;
                }

                if (j < SIZE-1 && this.board[i][j+1] == this.board[i][j]) {
                  return false;
                }
            }
        }
        return true;
    }

    /**
     * @brief Getter method to obtain current score
     * @return integer value of the current score
     */  
    public int getScore(){
        return this.score;
    }
}

