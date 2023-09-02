package ticTacToe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private static Input INSTANCE;
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }
    public static Input getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Input();
        }
        return INSTANCE;
    }

    public int getInt(){
        System.out.println("Insert an int value:");
        while (scanner.hasNextLine()){
            try {
                int i = scanner.nextInt();
                scanner.nextLine();
                return i;
            } catch (InputMismatchException e){
                System.out.println("Add an integer value:");
                scanner.nextLine();
            }
        }
        return -1;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        scanner.close();
    }
}
