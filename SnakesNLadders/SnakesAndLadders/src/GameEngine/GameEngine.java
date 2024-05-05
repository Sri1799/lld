package GameEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameEngine {
    
    private Board board;
    private List<Player> players;
    private List<Die> dice;

    public GameEngine(List<Player> players, Board board)
    {
        this.players = players;
        this.board = board;

        dice = new ArrayList<>();
        dice.add(new SixSidedDie());
        dice.add(new SixSidedDie());
    }

    public void play()
    {
        placePlayers();

        System.out.println("\n============== Commencing PLAY!! =================\n");

        int numPlayers = players.size();
        int playerIndex = 0;

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            printBoard();
            System.out.println("Player " + playerIndex + " is now rolling the dice");
            
            int roll = rollDice();
            scanner.nextLine();

            System.out.println("Player " + playerIndex + " has rolled " + roll);

            int currentPosition = players.get(playerIndex).getPosition();
            int newPosition = Math.min(board.fullsize - 1, currentPosition + roll);
            Cell newCell = board.getCell(newPosition);

            while (!newCell.isNormal())
            {
                if (newCell.getType() == CellType.Ladder)
                {
                    System.out.println("Player " + playerIndex + " has hit a LADDER. Will go up " + newCell.getMoveDifference() + " places");
                }
                else if (newCell.getType() == CellType.Snake)
                {
                    System.out.println("Player " + playerIndex + " has hit a SNAKE. Will go down " + newCell.getMoveDifference() + " places");
                }

                newPosition = Math.min(board.fullsize - 1, Math.max(0, newPosition + newCell.getMoveDifference()));
                newCell = board.getCell(newPosition);
            }

            players.get(playerIndex).piece.assignCell(newCell);

            if (newPosition == board.fullsize - 1)
            {
                System.out.println("Player " + playerIndex + " is the winnner!!!!!!!!!");
                printBoard();
                System.out.println("\n============== Ending PLAY!! =================\n");
                break;
            }

            playerIndex = (playerIndex + 1) % numPlayers;
            System.out.println();
        }

        scanner.close();
    }

    private void placePlayers()
    {
        for (int i=0;i<players.size();i++)
        {
            players.get(i).piece.assignCell(board.getCell(0));
        }
    }

    private int rollDice()
    {
        int roll = 0;
        for (int i=0;i<dice.size();i++)
        {
            roll += dice.get(i).roll();
        }

        return roll;
    }

    public void printBoard()
    {
        for (int i=0;i<board.fullsize;i++)
        {
            if (i<10)
                System.out.print(i + "  ");
            else
                System.out.print(i + " ");
        }
        System.out.println();

        for (int i=0;i<board.fullsize;i++)
        {
            CellType cellType = board.getCell(i).getType();
            if (cellType == CellType.Snake)
                System.out.print("S  ");
            else if (cellType == CellType.Ladder)
                System.out.print("L  ");
            else
                System.out.print("_  ");
        }

        System.out.println();

        for (int i=0;i<board.fullsize;i++)
        {
            Cell cell = board.getCell(i);
            CellType cellType = cell.getType();
            if (cellType == CellType.Snake)
                System.out.print(Math.abs(cell.getMoveDifference()) + "  ");
            else if (cellType == CellType.Ladder)
                System.out.print(cell.getMoveDifference() + "  ");
            else
                System.out.print("_  ");
        }

        System.out.println();

        for (int i=0;i<players.size();i++)
        {
            for (int j=0;j<board.fullsize;j++)
            {
                if (j == players.get(i).getPosition())
                {
                    System.out.print(i + "  ");
                }
                else
                {
                    System.out.print("   ");
                }
            }

            System.out.println();
        }
    }
}
