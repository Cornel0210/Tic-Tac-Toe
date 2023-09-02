package ticTacToe;

public class GameBoard {
    private Piece[][] board;

    public GameBoard() {
        board = new Piece[3][3];
        loadBoard();
    }

    public GameBoard(Piece[][] board) {
        this.board = board;
        loadBoard();
    }

    public GameBoard(int dimension) {
        this.board = new Piece[dimension][dimension];
        loadBoard();
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
}
