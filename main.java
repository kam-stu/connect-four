import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Board board = new Board();
        board.initBoard();
        board.printBoard();
        board.changeVal(1, 'x');
        System.out.println();
        board.printBoard();
    }
}
