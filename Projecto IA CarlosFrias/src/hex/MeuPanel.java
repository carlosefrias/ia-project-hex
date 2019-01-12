package hex;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * Classe MeuPanel
 * @author Carlos Frias
 */
public class MeuPanel extends JPanel{
    /**
     * Construtor da classe
     * @param img imagem a colocar no interior da janela.
     */
    public MeuPanel(Image img){
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }
    /**
     * Construtor da classe.
     * @param img url da imagem.
     */
    public MeuPanel(String img){
        this(new ImageIcon(img).getImage());
    }
    /**
     * Função responsavel por desenhar a imagem no interior da janela.
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
        g.dispose();
    }
    private Image img;
}
