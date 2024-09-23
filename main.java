import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Board board = new Board();
        board.initBoard();
        board.printBoard();
        System.out.println();
        for(int i = 0; i < board.board.length; i++){
            board.changeVal(1, 'x');
            board.changeVal(2, 'x');
            board.changeVal(3, 'x');
            board.changeVal(4, 'x');
            board.changeVal(5, 'x');
            board.changeVal(6, 'o');
            
            board.printBoard();
            System.out.println();
        }
        for (int i = 0; i < board.board.length - 1; i++){
            board.changeVal(7, 'x');
            board.printBoard();
            System.out.println();
        }

        boolean result = board.isFull();
        System.out.println(result); // Should be false
        board.changeVal(7, 'x');
        result = board.isFull();
        System.out.println(result); // Should be true
    }
}
