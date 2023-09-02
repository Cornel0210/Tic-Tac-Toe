package ticTacToe;

public class Game {
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;
    private boolean isX = true;

    public Game() {
        gameBoard = new GameBoard();
        player1 = new HumanPlayer();
        player2 = new HumanPlayer("AI", Piece.O);
    }

    public void run(){
        gameBoard.printBoard();
        while (!gameBoard.getFreePos().isEmpty()){
            Player current = isX ? player1 : player2;
            System.out.println("Time for " + current.getName() + " to move.");
            Position pos = current.move();
            while (!gameBoard.put(pos, current.getSign())){
                pos = current.move();
            }
            if (gameBoard.isAWin(pos, current.getSign())){
                System.out.println("Congratulations! " +  current.getName() + " has won!");
                break;
            }
            isX = !isX;
            gameBoard.printBoard();
        }
    }
}
