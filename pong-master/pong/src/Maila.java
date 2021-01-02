import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Maila {
    private static final int LEVEYS = 20, KORKEUS = 80;
    private Peli game;
    private int up, down;
    private int x;
    private int y, ya;

    public Maila(Peli game, int up, int down, int x) {
        this.game = game;
        this.x = x;
        y = game.getHeight() / 2;
        this.up = up;
        this.down = down;
    }

    public void update() {
        if (y > 0 && y < game.getHeight() - KORKEUS-37)
            y += 3*ya;
        else if (y == 0)
            y+=3;
        else if (y == game.getHeight() - KORKEUS-37)
            y-=3;
    }

    public void pressed(int keyCode) {
        if (keyCode == up) {
            ya = -1;
        }
        else if (keyCode == down) {
            ya = 1;
        }
    }

    public void released(int keyCode) {
        if (keyCode == up || keyCode == down)
            ya = 0;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, LEVEYS, KORKEUS);
    }

    public void paint(Graphics g) {
    	g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, LEVEYS, KORKEUS);
    }
}