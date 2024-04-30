package TicTacToe;

public final class Board
{
	private int N;
	private Cell[][] board;
	
	public Board(int N)
	{
		this.N = N;
		board = new Cell[N][N];
        for (int i=0;i<N;i++)
        {
            for (int j=0;j<N;j++)
            {
                board[i][j] = new Cell();
            }
        }
	}

	public void printBoard()
	{
        System.out.println();

		for (int i=0;i<N;i++)
		{
			if (i == 0)
				System.out.print("    ");
	
			System.out.print(i + " ");
		}

		System.out.println();
		
		for (int i=0;i<N;i++)
		{
            System.out.print(i + "   ");

			for (int j=0;j<N;j++)
			{
				System.out.print(board[i][j].getToken() + " ");
			}

			System.out.println();
		}

        System.out.println();
	}

	public boolean isMovePossible(int x, int y)
	{
        if (!(x>=0 && x<N && y>=0 && y<N))
            return false;

		return board[x][y].isCellFree();
	}

	public void makeMove(Player p, int x, int y)
	{
		board[x][y].mark(p.getToken());
	}

	public boolean isWin()
	{
		// check all horizontals
        for (int row=0;row<N;row++)
        {
            int col = 1;
            for (;col<N;col++)
            {
                if (board[row][col].isCellFree())
                    break;

                if (board[row][col].getToken() != board[row][col-1].getToken())
                    break;
            }

            if (col == N)
                return true;
        }
        
        // verticals
        for (int col=0;col<N;col++)
        {
            int row = 1;
            for (;row<N;row++)
            {
                if (board[row][col].isCellFree())
                    break;

                if (board[row][col].getToken() != board[row-1][col].getToken())
                    break;
            }

            if (row == N)
                return true;
        }

        // diagonals of size N
        int row = 0, col = 0;
        for (;row<N;row++,col++)
        {
            if (row == 0)
                continue;

            if (board[row][col].isCellFree())
                break;

            if ((board[row][col].getToken() != board[row-1][col-1].getToken())
                && (board[row][N-col-1].getToken() != board[row][N-col-1].getToken()))
                break;
        }

        return row == N;
	}

	public boolean isTie()
	{
        return !availableCellExists();
	}

    private boolean availableCellExists()
    {
        for (int i=0;i<N;i++)
        {
            for (int j=0;j<N;j++)
            {
                if (board[i][j].isCellFree())
                    return true;
            }
        }

        return false;
    }
}