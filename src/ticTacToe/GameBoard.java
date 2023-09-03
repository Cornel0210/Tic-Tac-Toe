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
    public boolean isAWin(Piece sign){
        int count;
        for (int i = 0; i < board.length; i++) { //checks the lines
            count = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == sign){
                    count ++;
                }
            }
            if (count == board.length){
                return true;
            }
        }

        for (int j = 0; j < board.length; j++) { //checks the columns
            count = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == sign) {
                    count++;
                }
            }
            if (count == board.length){
                return true;
            }
        }

        count = 0;
        int diag2 = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == sign){
                count++;
            }
            if (board[board.length-1-i][i] == sign){
                diag2++;
            }
        }
        return diag2 == board.length || count == board.length;
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

    @Override
    public String toString() {
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
        return stringBuilder.toString();
    }

    public GameBoard clone(){
        return new GameBoard(this);
    }
}
