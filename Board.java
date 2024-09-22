public class Board {
    private int rows;
    private int columns;
    public char[][] board;

    public Board(){
        this.rows = 6;
        this.columns = 7;
        this.board = new char[rows][columns];
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

}
