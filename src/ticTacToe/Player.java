package ticTacToe;

public abstract class Player {
    private final String name;
    private final Piece sign;

    public Player(String name, Piece sign) {
        this.name = name;
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public Piece getSign() {
        return sign;
    }

    public abstract Position move();
}
