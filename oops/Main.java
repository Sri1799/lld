import java.util.*;

import TicTacToe.TicTacToe;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello World!");
        TicTacToe game = new TicTacToe(3, scanner);
        game.play();
        scanner.close();
    }
}