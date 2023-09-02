package ticTacToe;

public enum Position {
    X (" X "), O (" O "), EMPTY ("   ");

    private String name;

    Position(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
