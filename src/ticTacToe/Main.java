package ticTacToe;

public class Main {
    public static void main(String[] args) {
        GameBoard bg = new GameBoard();
        bg.put(new Position(1,1), Piece.X);
        bg.printBoard();
    }
}
