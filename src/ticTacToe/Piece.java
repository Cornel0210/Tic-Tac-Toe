package ticTacToe;

public enum Piece {
    X (" X "), O (" O "), EMPTY ("   ");

    private String name;

    Piece(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
