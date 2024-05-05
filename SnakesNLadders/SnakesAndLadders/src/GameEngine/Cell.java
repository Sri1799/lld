package GameEngine;

public class Cell {
    private final int position;
    private final CellType cellType;

    public Cell(int position)
    {
       this.position = position;
       this.cellType = CellType.Normal;
    }

    public Cell(int position, CellType cellType)
    {
        this.position = position;
        this.cellType = cellType;
    }

    public final int getPosition()
    {
        return position;
    }

    public final CellType getType()
    {
        return cellType;
    }

    public int getMoveDifference()
    {
        return 0;
    }

    public boolean isNormal()
    {
        return this.cellType == CellType.Normal;
    }
}
