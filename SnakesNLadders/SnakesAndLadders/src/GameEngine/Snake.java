package GameEngine;

public class Snake extends FastMoveCell {

    public Snake(int position, int moveDifference)
    {
        super(position, CellType.Snake, moveDifference);
    }
}
