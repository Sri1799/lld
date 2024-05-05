import java.util.ArrayList;
import java.util.List;

import GameEngine.Board;
import GameEngine.GameEngine;
import GameEngine.Piece;
import GameEngine.PieceType;
import GameEngine.Player;

public class App {
    public static void main(String[] args) throws Exception {
        
        Piece piece1 = new Piece("Alice Piece", PieceType.QUEEN);
        Piece piece2 = new Piece("Bob Piece", PieceType.KING);

        Player player1 = new Player("Alice", 1, piece1);
        Player player2 = new Player("Bob", 2, piece2);

        Board board = new Board(5);

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        
        GameEngine game = new GameEngine(players, board);

        game.printBoard();

        game.play();
   }
}
