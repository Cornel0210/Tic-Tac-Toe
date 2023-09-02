package ticTacToe;

public class Main {
    public static void main(String[] args) {
        GameBoard bg = new GameBoard();
        bg.put(new Position(0,2), Piece.X);
        bg.put(new Position(1,1), Piece.X);
        bg.put(new Position(2,0), Piece.X);
        bg.printBoard();
        System.out.println(bg.isAWin(new Position(2,0), Piece.X));
    }
}
