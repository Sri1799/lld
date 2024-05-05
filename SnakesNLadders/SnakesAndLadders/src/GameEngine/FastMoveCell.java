package GameEngine;

public abstract class FastMoveCell extends Cell
{
    private int moveDifference;

    public FastMoveCell(int position, CellType cellType, int moveDifference)
    {
        super(position, cellType);
        this.moveDifference = moveDifference;
    }

    @Override
    public int getMoveDifference()
    {
        return this.moveDifference;
    }
}