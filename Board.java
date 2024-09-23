public class Board {
    private int rows;
    private int columns;
    public char[][] board;
    private boolean isDraw;

    public Board(){
        this.rows = 6;
        this.columns = 7;
        this.board = new char[rows][columns];
        this.isDraw = false;
    }
    
    public void initBoard(){
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                board[row][col] = '_';
            }
        }
    }
    
    public void printBoard(){
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Changes the lowest point in the column to value
    // Off-by-one error for col parameter
    public void changeVal(int col, char value){
        // Start from the bottom of the board and go up
        for(int row = board.length - 1; row >= 0; row--){
            if(board[row][col - 1] == '_'){
                board[row][col - 1] = value;
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
        return true;
    }

    // Checks to see if 4 of the same values are next to each other in the array
    // Values can be next to each other horizontally, vertically, or diagonally
    // Returns the value 
    public String checkWin(){
        return "None";  // If no winner is found
    }

    // Returns the winner or Draw
    public String getWinner(){
        return "Draw";
    }

    // Changes the "player" or x/o value
    public void switchPlayer(){}


}
