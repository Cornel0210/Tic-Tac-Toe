package ticTacToe;

import java.util.LinkedList;
import java.util.List;

public class GameBoard {
    private Piece[][] board;

    public GameBoard() {
        board = new Piece[3][3];
        loadBoard();
    }

    public GameBoard(int dimension) {
        this.board = new Piece[dimension][dimension];
        loadBoard();
    }

    private GameBoard(GameBoard gameBoard){
        this.board = new Piece[gameBoard.board.length][gameBoard.board[0].length];
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                board[i][j] = gameBoard.board[i][j];
            }
        }
    }

    private void loadBoard(){
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[0].length; j++) {
                board[i][j] = Piece.EMPTY;
            }
        }
    }

    public boolean put(Position position, Piece piece){
        if (isValid(position)) {
            int x = position.getX();
            int y = position.getY();
            if (board[x][y] != Piece.EMPTY){
                return false;
            }
            board[x][y] = piece;
            return true;
        }
        return false;
    }
    public boolean isAWin(Position position, Piece piece){
        int countLength = 0;
        int countHeight = 0;
        for (int i = 0; i < board.length; i++) { //checks the line and the column;
            if (board[position.getX()][i] == piece){
                countLength++;
            }
            if (board[i][position.getY()] == piece){
                countHeight++;
            }
        }
        if (countLength == board.length || countHeight == board.length){
            return true;
        }
        countLength = 0;
        countHeight = 0;
        for (int i = 0; i < board.length; i++) { //checks the diagonals;
            if (board[i][i] == piece){
                countLength++;
            }
            if (board[board.length-1-i][i] == piece){
                countHeight++;
            }
        }
        return countLength == board.length || countHeight == board.length;
    }

    public List<Position> getFreePos(){
        List<Position> freePos = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == Piece.EMPTY){
                   freePos.add(new Position(i,j));
                }
            }
        }
        return freePos;
    }

    private boolean isValid(Position position){
        int x = position.getX();
        int y = position.getY();
        if (x<0 || x >= board.length ||
                y<0 || y >= board[0].length){
            return false;
        }
        return true;
    }
    public void printBoard(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   ");
        for (int i = 0; i < this.board[0].length; i++) {
            stringBuilder.append(" ").append(i).append(" |");
        }
        stringBuilder.replace(stringBuilder.length()-1, stringBuilder.length(), "");
        stringBuilder.append("\n");
        for (int i = 0; i < this.board.length; i++) {
            stringBuilder.append(" ").append(i).append(" ");
            for (int j = 0; j < this.board[0].length; j++) {
                stringBuilder.append(" ").append(board[i][j]).append(" |");
            }
            stringBuilder.replace(stringBuilder.length()-1, stringBuilder.length(), "");
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    public GameBoard clone(){
        return new GameBoard(this);
    }
}
