package ticTacToe;

public class Game {
    private static Game INSTANCE;
    private final GameBoard gameBoard;
    private final Player player1;
    private final Player player2;
    private boolean isX = true;

    public Game() {
        gameBoard = new GameBoard();
        //player1 = new AI_Player("ai", Piece.X);
        player1 = new HumanPlayer();
        player2 = new AI_Player();
    }

    public void run(){
        System.out.println(gameBoard);
        while (!gameBoard.getFreePos().isEmpty()){
            Player current = isX ? player1 : player2;
            System.out.println("Time for " + current.getName() + " to move.");
            Position pos = current.move();
            while (!gameBoard.put(pos, current.getSign())){
                pos = current.move();
            }
            System.out.println(gameBoard);
            if (gameBoard.isAWin(current.getSign())){
                System.out.println("Congratulations! " +  current.getName() + " has won!");
                break;
            } else if (gameBoard.getFreePos().isEmpty()){
                System.out.println("It is a draw! Seems that it was a tough game!");
            }
            isX = !isX;
        }
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public static Game getInstance() {
        if (INSTANCE == null){
            INSTANCE = new Game();
        }
        return INSTANCE;
    }

    public boolean isX() {
        return isX;
    }
}
