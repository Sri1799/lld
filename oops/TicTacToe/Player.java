package TicTacToe;

public class Player {
    private String name;
    private char token;
    private int id;

    Player(int id, String name, char token)
    {
        this.id = id;
        this.name = name;
        this.token = token;
    }

    public String getName()
    {
        return name;
    }

    public char getToken()
    {
        return token;
    }

    public int getId()
    {
        return id;
    }
}
