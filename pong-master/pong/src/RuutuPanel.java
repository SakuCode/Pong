import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import java.awt.BasicStroke;

import javax.swing.JPanel;
import javax.swing.Timer;

public class RuutuPanel extends JPanel implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private Peli peli;
    private Pallo pallo;
    private Maila oikeaMaila, vasenMaila;
    private int vasenPisteet, oikeaPisteet;

    public RuutuPanel(Peli peli) {
        setBackground(Color.LIGHT_GRAY);
        this.peli = peli;
        pallo = new Pallo(peli);
        oikeaMaila = new Maila(peli, KeyEvent.VK_UP, KeyEvent.VK_DOWN, peli.getWidth() - 35);
        vasenMaila = new Maila(peli, KeyEvent.VK_W, KeyEvent.VK_S, 10);
        Timer timer = new Timer(5, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    public Maila getPlayer(int mailaNum) {
        if (mailaNum == 1)
            return oikeaMaila;
        else
            return vasenMaila;
    }

    public void increaseScore(int mailaNum) {
        if (mailaNum == 1)
            oikeaPisteet++;
        else
        	vasenPisteet++;
    }

    public int getScore(int playerNo) {
        if (playerNo == 1)
            return vasenPisteet;
        else
            return oikeaPisteet;
    }

    private void update() {
        pallo.update();
        oikeaMaila.update();
        vasenMaila.update();
    }

    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
    	
    	int n = e.getKeyCode();
    	if (n==KeyEvent.VK_ESCAPE) {
    		System.exit(0);
    	}
    	
        oikeaMaila.pressed(e.getKeyCode());
        vasenMaila.pressed(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        oikeaMaila.released(e.getKeyCode());
        vasenMaila.released(e.getKeyCode());
    }

    public void keyTyped(KeyEvent e) {}

    @Override
    public void paintComponent(Graphics g) {    	
        super.paintComponent(g);
        
        g.setFont(new Font("TimesRoman", Font.BOLD, 42)); 
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(8));
        g.drawLine(peli.getWidth() / 2, 0, peli.getWidth() / 2, peli.getHeight());
        g.drawString(String.valueOf(peli.getPanel().getScore(1)), peli.getWidth() / 13, 50);
        g.drawString(String.valueOf(peli.getPanel().getScore(2)), peli.getWidth() - 75, 50);
        pallo.paint(g);
        oikeaMaila.paint(g);
        vasenMaila.paint(g);
    }
}