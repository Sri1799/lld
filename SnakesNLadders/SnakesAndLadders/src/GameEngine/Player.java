package GameEngine;

public final class Player {
    
    private final String name;
    private final int id;

    public final Piece piece;

    public Player(String name, int id, Piece piece)
    {
        this.name = name;
        this.id = id;
        this.piece = piece;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPosition()
    {
        return (piece == null ? -1 : piece.getPosition());
    }
}
