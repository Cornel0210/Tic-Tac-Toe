package ticTacToe;

public class HumanPlayer extends Player{

    public HumanPlayer() {
        super("Human Player", Piece.X);
    }

    public HumanPlayer(String name, Piece sign) {
        super(name, sign);
    }

    @Override
    public Position move() {
        return new Position(Input.getInstance().getInt(), Input.getInstance().getInt());
    }
}
