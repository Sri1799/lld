package GameEngine;

public abstract class Die {
    
    private final int faces;

    public Die(int faces)
    {
        this.faces = faces;
    }

    public int roll()
    {
        return (int)(Math.random() * (faces - 1)) + 1;
    }

    public int getFaces() {
        return faces;
    }
}
