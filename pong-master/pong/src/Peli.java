
import javax.swing.JFrame;

public class Peli extends JFrame {
	private static final long serialVersionUID = 1L;
	private final static int LEVEYS = 800, PITUUS = 600;
    private RuutuPanel panel;

    public Peli() {
        setSize(LEVEYS, PITUUS);
        setTitle("Pong");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new RuutuPanel(this);
        add(panel);
    }

    public RuutuPanel getPanel() {
        return panel;
    }

    public static void main(String[] args) {
        new Peli();
    }
}