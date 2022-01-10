/**
 * @file: Move.java
 * @Author: Hamrish Saravanakumar
 * @Date: April 12th, 2021
 * @Description: Module that holds methods to set the board
 */

package src;

import java.util.Arrays;

public class SetBoard {

  /**
   * @brief Checks if the board is empty
   * @return true if the board is only populated with zeros, and false otherwise
   */
  public static boolean emptyBoardCheck(int[][] board) {
    int[][] emptyBoard = new int[][] {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};
    if (Arrays.deepEquals(emptyBoard, board)) {
      return true;
    }
    else {
      return false;
    }

  }
  /**
   * @brief obtains the value of the cell directly below the selected cell
   * @param board a 2-d array of integers that represents a board
   * @param row the value of the row that the selected cell is in
   * @param col the value of the column that the selected cell is in
   * @return value of the cell directly below the selected cell
   */
  public static int down(int[][] board, int row, int col) {
    if(row < 3) {
      return board[row + 1][col];
    }
    else {
      return 1;
    }
  }

  /**
   * @brief obtains the value of the cell directly above the selected cell
   * @param board a 2-d array of integers that represents a board
   * @param row the value of the row that the selected cell is in
   * @param col the value of the column that the selected cell is in
   * @return value of the cell directly above the selected cell
   */
  public static int up(int[][] board, int row, int col) {
    if (row > 0) {
      return board[row - 1][col];
    }
    else {
      return 1;
    }
  }

  /**
   * @brief obtains the value of the cell directly to the left of the selected cell
   * @param board a 2-d array of integers that represents a board
   * @param row the value of the row that the selected cell is in
   * @param col the value of the column that the selected cell is in
   * @return value of the cell directly to the left of the selected cell
   */
  public static int left(int[][] board, int row, int col) {
    if(col > 0) {
      return board[row][col - 1];
    }
    else {
      return 1;
    }
  }

  /**
   * @brief obtains the value of the cell directly to the right of the selected cell
   * @param board a 2-d array of integers that represents a board
   * @param row the value of the row that the selected cell is in
   * @param col the value of the column that the selected cell is in
   * @return value of the cell directly to the right of the selected cell
   */
  public static int right(int[][] board, int row, int col) {
    if(col < 3) {
      return board[row][col+1];
    }
    else {
      return 1;
    }
  }

}


