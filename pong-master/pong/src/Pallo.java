import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JOptionPane;

public class Pallo {
    private static final int LEVEYS = 30, PITUUS = 30;
    private Peli game;
    private int x, y, xa = 2, ya = 2;

    public Pallo(Peli game) {
        this.game = game;
        x = game.getWidth() / 2;
        y = game.getHeight() / 2;
    }

    public void update() {
        x += xa;
        y += ya;
        if (x < 0) {
            game.getPanel().increaseScore(1);
            x = game.getWidth() / 2;
            xa = -xa;
        }
        else if (x > game.getWidth() - LEVEYS - 7) {
            game.getPanel().increaseScore(2);
            x = game.getWidth() / 2;
            xa = -xa;
        }
        else if (y < 0 || y > game.getHeight() - PITUUS - 29)
            ya = -ya;
        if (game.getPanel().getScore(1) == 10) {
            JOptionPane.showMessageDialog(null, "Vasen pelaaja voitti!", "Peli p‰‰ttyi!", JOptionPane.PLAIN_MESSAGE);
        	System.exit(0);
        }
        else if (game.getPanel().getScore(2) == 10) {
            JOptionPane.showMessageDialog(null, "Oikea pelaaja voitti!", "Peli p‰‰ttyi!", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
        checkCollision();
    }

    public void checkCollision() {
        if (game.getPanel().getPlayer(1).getBounds().intersects(getBounds()) || game.getPanel().getPlayer(2).getBounds().intersects(getBounds()))
            xa = -xa;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, LEVEYS, PITUUS);
    }

    public void paint(Graphics g) {
    	g.setColor(Color.BLACK);
        g.fillOval(x, y, LEVEYS, PITUUS);
    }
}