import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        int userCol;
        Scanner input = new Scanner(System.in);
        Board board = new Board();
        board.initBoard();

        while(!board.gameOver){
            board.printBoard();

            // Gets the input for which column to place their piece in
            while(true){
                try {
                    System.out.println("Which column would you like to pick?");
                    userCol = input.nextInt();
                    System.out.println();

                    // Checks if the user inputted a valid column
                    if(board.checkMove(userCol)){
                        break;
                    }

                // Checks if the user inputted an integer value
                } catch (Exception e) {
                    System.out.println("Invalid character.  Enter a value 1-7");
                    input.nextLine(); // Clear any invalid input
                }
            }
            board.changeVal(userCol);
            board.getWinner();
            board.switchPlayer();
            // Output for if game is over
            if(board.gameOver){
                while(true){
                    input.nextLine(); // Clear any leftover invalid input
                    try {
                        System.out.println("Would you like to play again? Yes / No");
                        String userInput = input.nextLine(); // Get answer from user
                        System.out.println();

                        // Restarts the game with the opposite player going first
                        if(userInput.equals("Yes")){
                            System.out.println("Player " + board.playerVal + " goes first.");
                            board.resetGame();
                            break;
                        }
                        
                        // Ends the game
                        else if(userInput.equals("No")){
                            System.out.println("See you next time!");
                            input.close();
                            break;
                        }

                        // Catches any String input that isn't "Yes" or "No"
                        else{
                            System.out.println("Enter Yes or No.");
                        }

                        // Catches any non-String input
                    } catch (Exception e) {
                            System.out.println("Inalid character.  Enter Yes or No");
                    }
                }
            }
        }
    } 
}
