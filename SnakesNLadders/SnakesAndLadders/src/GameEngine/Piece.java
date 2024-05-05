package GameEngine;

public final class Piece
{
    private final String name;
    private final PieceType pieceType;

    private Cell cell;

    public Piece(String name, PieceType pieceType)
    {
        this.name = name;
        this.pieceType = pieceType;
    }

    public String getName() {
        return name;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void assignCell(Cell cell)
    {
        this.cell = cell;
    }

    public int getPosition()
    {
        return (cell == null ? -1 : cell.getPosition());
    }
}