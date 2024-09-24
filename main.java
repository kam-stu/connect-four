import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Board board = new Board();
        board.initBoard();
        board.printBoard();
        board.changeVal(7, 'o');
        board.changeVal(7, 'o');
        board.changeVal(7, 'o');
        board.changeVal(7, 'x');
        board.changeVal(7, 'x');
        board.changeVal(7, 'x');
        board.printBoard();
        System.out.println(board.checkWin());
        board.changeVal(7, 'x');
        board.printBoard();
        System.out.println(board.checkWin());
        board.checkMove(7);
}   }
