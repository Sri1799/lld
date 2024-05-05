package GameEngine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Board
{
    private final int size;
    public final int fullsize;
    private final List<Cell> cells;
    
    public Board(int size)
    {
        this.size = size;
        this.fullsize = size * size;
        cells = new ArrayList<>();
        
        populateCells();
    }

    private void populateCells()
    {
        int numberOfSnakes = getRandomNumber(2 * size);
        int numberOfLadder = getRandomNumber(2 * size);

        System.out.println("Adding " + numberOfSnakes + " snakes");
        System.out.println("Adding " + numberOfLadder + " ladders");

        HashSet<Integer> snakesPositions = new HashSet<>();
        HashSet<Integer> ladderPositions = new HashSet<>();

        while (snakesPositions.size() != numberOfSnakes)
        {
            int position = getRandomNumber(size * size);
            if (position == size * size - 1 || position == 0)
                continue;

            snakesPositions.add(position);
        }

        while (ladderPositions.size() != numberOfLadder)
        {
            int position = getRandomNumber(size * size);
            if (position == size * size - 1 || position == 0)
                continue;

            ladderPositions.add(position);
        }

        for (int i=0;i<size*size;i++)
        {
            if (snakesPositions.contains(i))
            {
                cells.add(new Snake(i, -1 * getRandomNumber(size)));
            }
            else if (ladderPositions.contains(i))
            {
                cells.add(new Ladder(i, getRandomNumber(size)));
            }
            else
            {
                cells.add(new Cell(i));
            }
        }
    }

    public Cell getCell(int position)
    {
        return cells.get(position);
    }

    private int getRandomNumber(int max)
    {
        return (int)(Math.random() * (max - 1)) + 1;
    }
}