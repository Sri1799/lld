package TicTacToe;

public final class Cell
{
	private char token;
	private boolean isFree;

	public Cell()
	{
		this.token = '_';
		this.isFree = true;
	}

	public void mark(char token)
	{
		this.token = token;
		this.isFree = false;		
	}

	public boolean isCellFree()
	{
		return this.isFree;
	}

	public char getToken()
	{
		return this.token;
	}
}