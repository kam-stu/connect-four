public class Board {
    private int rows;
    private int columns;
    private char[][] board;
    public char playerVal; 
    public boolean gameOver;

    public Board(){
        this.rows = 6;
        this.columns = 7;
        this.board = new char[rows][columns];
        this.playerVal = 'x';
        this.gameOver = false;
    }
    
    public void initBoard(){
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                board[row][col] = '_';
            }
        }
    }
    
    public void printBoard(){
        System.out.println();
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Changes the lowest point in the column to value
    // Off-by-one error for col parameter
    public void changeVal(int col){
        // Start from the bottom of the board and go up
        for(int row = board.length - 1; row >= 0; row--){
            if(board[row][col - 1] == '_'){
                board[row][col - 1] = playerVal;
                return;
            }
        }
    }

    // Checks whether the board is filled or not
    // If the entire top row is full, then the board is filled
    public boolean isFull(){
        for(int currentCol = 0; currentCol < board[0].length; currentCol++){
            if(board[0][currentCol] == '_'){
                return false;
            }
        }
        return true;
    }

    // Checks whether there is a legal move
    // Returns boolean whether there is a move
    public boolean checkMove(int col){
        // Checks if given column is a valid number
        if(col <= 0 || col > columns){
            System.out.println("Enter a valid column.");
            return false;
        }

        // Checks if given column is full
        // Checks the top value of the given colum
        if(board[0][col-1] != '_'){
            System.out.println("Given column is full.  Pick another column.");
            printBoard();
            return false;
        }
        
        return true;
    }

    // Checks to see if 4 of the same values are next to each other in the array
    // Values can be next to each other horizontally, vertically, or diagonally
    // Returns the value 
    public boolean isWin(){
        // Check horizontal
        for (int row = 0; row < board.length ; row++){
            for(int col = 0; col < board[row].length - 3; col++){
                if(board[row][col] == playerVal && 
                board[row][col + 1] == playerVal &&
                board[row][col + 2] == playerVal && 
                board[row][col+3] == playerVal)
                    return true;
            }
        }

        // Check vertically
        for(int col = 0; col < board[0].length; col++){
            for (int row = 0; row < board.length - 3; row++){
                if(board[row][col] == playerVal &&
                board[row + 1][col] == playerVal &&
                board[row + 2][col] == playerVal &&
                board[row + 3][col] == playerVal)
                    return true;
            }
        }
        return false;  // If no winner is found
    }

    // Checks whether there is a win or draw
    public void getWinner(){
        if(isWin()){
            printBoard();
            System.out.println(playerVal + " wins!");
            gameOver = true;
            return;
        }
        
        if(isFull()){
            printBoard();
            System.out.println("It's a draw!");
            gameOver = true;
            return;
        }
    }

    // Switches between 'x' and 'o' so 2 players can play with each other
    public void switchPlayer(){
        if(playerVal == 'x')
            playerVal = 'o';
        else
            playerVal = 'x';
        
    }

    // resets the gamestate
    //clears board and changes game over to false
    public void resetGame(){
        initBoard();
        gameOver = false;
    }
}

