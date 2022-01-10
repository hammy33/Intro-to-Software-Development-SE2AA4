/**
 * @file: Move.java
 * @Author: Hamrish Saravanakumar
 * @Date: April 12th, 2021
 * @Description: Controller module that deals with user input and links the model and view modules
 */

package src;

import java.util.Scanner;

public class MoveController {

    private static Scanner input = new Scanner(System.in);

    /**
     * @brief Takes the input from the user through keyboard and initializes the next move
     * @param B game board of type BoardT
     */
    public static void nextMove(BoardT B) {

        int choice = input.nextInt();
    
        if (choice == 0) {
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
        else if (choice == 1) {
            B.moveUp();
            if(B.getPossibleMove()) {
                B.addNumber();
            }
            else {
                System.out.println("Move not possible, try again!");
            }
        }
        else if (choice == 2) {
            B.moveDown();
            if(B.getPossibleMove()) {
                B.addNumber();
            }
            else {
                System.out.println("Move not possible, try again!");
            }
        }
        else if (choice == 3) {
            B.moveLeft();
            if(B.getPossibleMove()) {
                B.addNumber();
            }
            else {
                System.out.println("Move not possible, try again!");
            }
        }
        else if (choice == 4) {
            B.moveRight();
            if(B.getPossibleMove()) {
                B.addNumber();
            }
            else {
                System.out.println("Move not possible, try again!");
            }
        }
        else {
            System.out.println("Invalid entry, try again");
        }
      }

    /**
     * @brief Runs the game
     */
    public static void runGame() {
      Display.printWelcome();
      while (true) {
        Display.printScore();
        Display.printBoard();
      }
    }
}


