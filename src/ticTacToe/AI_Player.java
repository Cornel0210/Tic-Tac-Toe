package ticTacToe;

import java.util.List;

public class AI_Player extends Player{

    public AI_Player() {
        super("AI Player", Piece.O);
    }

    public AI_Player(String name, Piece sign) {
        super(name, sign);
    }

    @Override
    public Position move() {
        List<Position> positions = Game.getInstance().getGameBoard().getFreePos();
        Position bestPos = null;
        int bestVal = Integer.MIN_VALUE;
        for (Position position : positions){
            int value;
            GameBoard clone = Game.getInstance().getGameBoard().clone();
            clone.put(position, this.getSign());
            value = check(clone, 0, true);
            if (value > bestVal){
                bestVal = value;
                bestPos = position;
            }
        }
        return bestPos;
    }

    private int check(GameBoard gameBoard, int depth, boolean isAITurn){
        if (gameBoard.isAWin(this.getSign())){
            return 10 - depth;
        }
        Piece opponent = Game.getInstance().isX() ? Piece.O : Piece.X;
        if (gameBoard.isAWin(opponent)){
            return -10 + depth;
        }
        List<Position> positions = gameBoard.getFreePos();
        if (positions.isEmpty()){
            return 0;
        }

        int bestOption;
        if (isAITurn){
            bestOption = Integer.MAX_VALUE;
            for (Position position : positions){
                GameBoard clone = gameBoard.clone();
                clone.put(position, opponent);
                int value = check(clone, depth + 1, !isAITurn);
                bestOption = Math.min(value, bestOption);
            }
        } else {
            bestOption = Integer.MIN_VALUE;
            for (Position position : positions){
                GameBoard clone = gameBoard.clone();
                clone.put(position, this.getSign());
                int value = check(clone, depth + 1, !isAITurn);
                bestOption = Math.max(value, bestOption);
            }
        }
        return bestOption;
    }
}
