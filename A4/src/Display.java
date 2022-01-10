/**
 * @file: Display.java
 * @Author: Hamrish Saravanakumar
 * @Date: April 12th, 2021
 * @Description: View module for visually representing the contents and status of the game
 */

package src;

import src.BoardT;

public class Display {

      private static final int[][] BOARD = new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
      
      private static BoardT B = new BoardT(BOARD);


      /**
      * @brief Prints a welcome message and the rules for user input 
      */
      public static void printWelcome() {

            System.out.println();
            System.out.println("Welcome to 2048!");
            System.out.println("1 = Up, 2 = Down, 3 = Left, 4 = Right, 0 = Exit");
            System.out.println();

      }

      /**
      * @brief Prints the current score of the current game
      */
      public static void printScore() {

            System.out.println("Score: ");
            System.out.println(B.getScore());
            System.out.println();

      }

      /**
      * @brief Prints the current status of the board
      * @details The board is initialized if it starts off empty, checked whether if in its current state if the user has won or lost, and then processes the next move.  
      */
      public static void printBoard() {

            B.initializeBoard();
            for(int i = 0; i < 4; i++) {
                  for(int j = 0; j < 4; j++) {
                        System.out.printf("%4d", B.getBoard()[i][j]);
                  }
                  System.out.println();
              }
            if (B.loseChecker()) {
                  System.out.println("You Lose!");
                  System.exit(0);
            }
            if (B.winChecker()) {
                  System.out.println("You Won!");
                  System.exit(0);
            }
            System.out.println();
            System.out.println("Next Move: ");
            MoveController.nextMove(B);
            System.out.println();
            
      }
  
}