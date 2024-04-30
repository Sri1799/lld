package TicTacToe;
import java.io.Console;
import java.util.*;

public final class TicTacToe
{
	private Scanner scanner;
	private Board board;
	private List<Player> players;
	private int playerTurnIdx;

	public TicTacToe(int n, Scanner scanner)
	{
		this.scanner = scanner;
		initializeBoard(n);
		initalizePlayers();
	}

	private void initializeBoard(int n)
	{
		board = new Board(n);
	}

	private void initalizePlayers()
	{
		players = new ArrayList<Player>();

		System.out.println("Enter name of player 1");
		String name = scanner.nextLine();
		
		System.out.println("Enter the token of player 1");
		char token = scanner.next().charAt(0);
		scanner.nextLine();

		players.add(new Player(0, name, token));
		
		System.out.println("Enter name of player 2");
		name = scanner.nextLine();
		
		System.out.println("Enter the token of player 2");
		token = scanner.next().charAt(0);
		scanner.nextLine();

		players.add(new Player(1, name, token));

		System.out.println("Players 0 " + players.get(0).getName() + " " + players.get(0).getToken());
		System.out.println("Players 1 " + players.get(1).getName() + " " + players.get(1).getToken());
	}
	
	public void play()
	{	
		toss();
		
		int invalidMoveCounter = 0;
		
		while (true)
		{
			board.printBoard();

			System.out.println("Player " + playerTurnIdx + " will make a move. Enter (x, y)");
			int x = scanner.nextInt();
			scanner.nextLine();
			int y = scanner.nextInt();
			scanner.nextLine();

			if (board.isMovePossible(x, y) == false)
			{
				invalidMoveCounter++;
				if (invalidMoveCounter == 5)
				{
					System.out.println("Game abandoned due to too many invalid moves. Exiting...");						
					break;
				}
				else
				{
					System.out.println(String.format("Move (%d, %d) is invalid. Please choose another move...", x, y));
				}
			}
			else
			{
				board.makeMove(players.get(playerTurnIdx), x, y);
				
				if (board.isWin())
				{
					board.printBoard();
					System.out.println("Player " + playerTurnIdx + " has won the match");
					break;
				}
				
				if (board.isTie())
				{
					System.out.println("Game is a tie. No more moves can cause Players to win");
					break;
				}
	
				invalidMoveCounter = 0;
				playerTurnIdx = 1 - playerTurnIdx;
			}
		}

		scanner.close();
	}

	private void toss()
	{
		playerTurnIdx = randomNumberGenerator() % 2;
		System.out.println("Player " + playerTurnIdx + " has won the toss and will move first"); 	
	}

	private int randomNumberGenerator()
	{
		Random rand = new Random();
		return rand.nextInt(10000);
	}
}
