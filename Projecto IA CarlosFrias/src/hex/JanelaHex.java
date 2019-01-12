/*
 * JanelaHex.java
 *
 * Created on 25/Mar/2011, 22:02:14
 */
package hex;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
/**
 * Classe JanelaHex
 * @author Carlos Frias
 */
public class JanelaHex extends javax.swing.JFrame implements MouseListener, MouseMotionListener{
    private Tabuleiro tabuleiro;
    /**
     * Construtor da classe JanelaHex
     */
    public JanelaHex() {
        super("Jogo de Tabuleiro - Hex - Projecto de IA");
        this.tabuleiro = new Tabuleiro();
        initComponents();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    /**
     * Este método é chamado no construtor para inicializar as componentes da janela
     * Código gerado automaticamente pelo Netbeans
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new MeuPanel("src/500px-Hex_board_11x11.png");
        panel1 = new javax.swing.JPanel();
        labelJogador = new javax.swing.JLabel();
        barraestados = new javax.swing.JLabel();
        vencedor = new javax.swing.JLabel();
        nom_vencedor = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelModoJogo = new javax.swing.JLabel();
        labelDificuldade = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_modo_de_jogo = new javax.swing.JMenu();
        menuItemHumanoVsHumano = new javax.swing.JMenuItem();
        MenuItemHumanoVsComputador = new javax.swing.JMenuItem();
        MenuItemCompVsComp = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MenuDificuldade = new javax.swing.JMenu();
        MenuItemFacil = new javax.swing.JCheckBoxMenuItem();
        MenuItemMedio = new javax.swing.JCheckBoxMenuItem();
        MenuItemDificil = new javax.swing.JCheckBoxMenuItem();
        MenuAjuda = new javax.swing.JMenu();
        regrasjogo = new javax.swing.JMenuItem();
        acercajogo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelPrincipal.setLayout(null);

        labelJogador.setText("Jogador 1");

        barraestados.setText("Barra de estados");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(vencedor)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(nom_vencedor))
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(labelJogador)
                        .addComponent(barraestados)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelJogador)
                .addGap(18, 18, 18)
                .addComponent(barraestados, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vencedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nom_vencedor)
                .addGap(31, 31, 31))
        );

        labelModoJogo.setText("Modo de jogo:");

        labelDificuldade.setText("Dificuldade:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelModoJogo)
                    .addComponent(labelDificuldade))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelModoJogo)
                .addGap(33, 33, 33)
                .addComponent(labelDificuldade)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        menu_modo_de_jogo.setText("Modo de Jogo");
        menu_modo_de_jogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu_modo_de_jogoMouseEntered(evt);
            }
        });

        menuItemHumanoVsHumano.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, 0));
        menuItemHumanoVsHumano.setText("Humano vs Humano");
        menuItemHumanoVsHumano.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuItemHumanoVsHumanoMouseEntered(evt);
            }
        });
        menuItemHumanoVsHumano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemHumanoVsHumanoActionPerformed(evt);
            }
        });
        menu_modo_de_jogo.add(menuItemHumanoVsHumano);

        MenuItemHumanoVsComputador.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, 0));
        MenuItemHumanoVsComputador.setText("Humano vs Computador");
        MenuItemHumanoVsComputador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuItemHumanoVsComputadorMouseEntered(evt);
            }
        });
        MenuItemHumanoVsComputador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemHumanoVsComputadorActionPerformed(evt);
            }
        });
        menu_modo_de_jogo.add(MenuItemHumanoVsComputador);

        MenuItemCompVsComp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, 0));
        MenuItemCompVsComp.setText("Computador vs Computador");
        MenuItemCompVsComp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuItemCompVsCompMouseEntered(evt);
            }
        });
        MenuItemCompVsComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCompVsCompActionPerformed(evt);
            }
        });
        menu_modo_de_jogo.add(MenuItemCompVsComp);
        menu_modo_de_jogo.add(jSeparator1);

        MenuDificuldade.setText("Dificuldade");
        MenuDificuldade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuDificuldadeMouseEntered(evt);
            }
        });

        MenuItemFacil.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, 0));
        MenuItemFacil.setText("Fácil");
        MenuItemFacil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuItemFacilMouseEntered(evt);
            }
        });
        MenuItemFacil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemFacilActionPerformed(evt);
            }
        });
        MenuDificuldade.add(MenuItemFacil);

        MenuItemMedio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, 0));
        MenuItemMedio.setText("Médio");
        MenuItemMedio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuItemMedioMouseEntered(evt);
            }
        });
        MenuItemMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemMedioActionPerformed(evt);
            }
        });
        MenuDificuldade.add(MenuItemMedio);

        MenuItemDificil.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, 0));
        MenuItemDificil.setText("Difícil");
        MenuItemDificil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuItemDificilMouseEntered(evt);
            }
        });
        MenuItemDificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemDificilActionPerformed(evt);
            }
        });
        MenuDificuldade.add(MenuItemDificil);

        menu_modo_de_jogo.add(MenuDificuldade);

        jMenuBar1.add(menu_modo_de_jogo);

        MenuAjuda.setText("Ajuda");
        MenuAjuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuAjudaMouseEntered(evt);
            }
        });

        regrasjogo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, 0));
        regrasjogo.setText("Regras do Jogo");
        regrasjogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                regrasjogoMouseEntered(evt);
            }
        });
        regrasjogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regrasjogoActionPerformed(evt);
            }
        });
        MenuAjuda.add(regrasjogo);

        acercajogo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, 0));
        acercajogo.setText("Acerca do Jogo de Hex");
        acercajogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                acercajogoMouseEntered(evt);
            }
        });
        acercajogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acercajogoActionPerformed(evt);
            }
        });
        MenuAjuda.add(acercajogo);

        jMenuBar1.add(MenuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método para controlar o evento associado ao clicar no
     * MenuItem acerca do jogo
     * Mostra uma janela com informações acerca do jogo
     * @param evt
     */
    private void acercajogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acercajogoActionPerformed
        String msg ="Aplicação desenvolvida por:"
                + "\nCarlos Frias\tei04116@fe.up.pt"
                + "\n"
                + "\nno âmbito da disciplina de Inteligência Artificial"
                + "\ndo curso Mestrado Integrado em Engenharia"
                + "\nInformática e Computação  da Faculdade de Engenharia"
                + "\nda Univeridade do Porto.\n\n\nPorto, Junho de 2011.";
        JanelaMensagem jmsg = new JanelaMensagem(msg, "Acerca do Jogo");
        jmsg.setVisible(true);
        jmsg.setResizable(false);
    }//GEN-LAST:event_acercajogoActionPerformed
    /**
     * Método para controlar o evento associado ao clicar em regras do jogo
     * Mostra uma janela com as regras do jogo
     * @param evt
     */
    private void regrasjogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regrasjogoActionPerformed
        String msg =
                    "A cada jogador é atribuída uma cor, azul ou vermelha."
                + "\nO jogadores colocam alternadamente uma peça da sua "
                + "\ncor numa das posições ainda não ocupadas do tabuleiro."
                + "\nO objetivo é formar um caminho de peças da sua cor que "
                + "\nligue dois lados opostos do tabuleiro."
                + "\nO primeiro jogador a completar o caminho ganha o jogo."
                + "\nAs quatro casas dos cantos do tabuleiro pertencem a ambos "
                + "\nos lados adjacentes.Como o primeiro jogador tem uma ligeira "
                + "\nvantagem,o segundo jogador pode escolher se quer ou não "
                + "\ntrocar de posições com o primeiro"
                + "\njogador após este ter feito a primeira jogada.";
        JanelaMensagem jmsg = new JanelaMensagem(msg, "Regras de Jogo");
        jmsg.setVisible(true);
        jmsg.setResizable(false);
    }//GEN-LAST:event_regrasjogoActionPerformed
   /**
     * Método para controlar o evento do rato a entrar no menu modo de jogo.
     * Muda o aspecto do rato
     * @param evt
     */
    private void menu_modo_de_jogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_modo_de_jogoMouseEntered
        this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_menu_modo_de_jogoMouseEntered
   /**
     * Método para controlar o evento do rato a entrar no menu ajuda.
     * Muda o aspecto do rato
     * @param evt
     */
    private void MenuAjudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAjudaMouseEntered
       this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_MenuAjudaMouseEntered
   /**
     * Método para controlar o evento do rato a entrar no menu Humano Vs Humano
     * Muda o aspecto do rato
     * @param evt
     */
    private void menuItemHumanoVsHumanoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuItemHumanoVsHumanoMouseEntered
        this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_menuItemHumanoVsHumanoMouseEntered
   /**
     * Método para controlar o evento do rato a entrar no menu Humano Vs Computador.
     * Muda o aspecto do rato
     * @param evt
     */
    private void MenuItemHumanoVsComputadorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuItemHumanoVsComputadorMouseEntered
         this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_MenuItemHumanoVsComputadorMouseEntered
   /**
     * Método para controlar o evento do rato a entrar no menu Computador vs Computador.
     * Muda o aspecto do rato
     * @param evt
     */
    private void MenuItemCompVsCompMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuItemCompVsCompMouseEntered
         this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_MenuItemCompVsCompMouseEntered
   /**
     * Método para controlar o evento do rato a entrar no menu dificuldade.
     * Muda o aspecto do rato
     * @param evt
     */
    private void MenuDificuldadeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuDificuldadeMouseEntered
         this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_MenuDificuldadeMouseEntered
   /**
     * Método para controlar o evento do rato a entrar no menu Fácil.
     * Muda o aspecto do rato
     * @param evt
     */
    private void MenuItemFacilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuItemFacilMouseEntered
         this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_MenuItemFacilMouseEntered
   /**
     * Método para controlar o evento do rato a entrar no menu Médio.
     * Muda o aspecto do rato
     * @param evt
     */
    private void MenuItemMedioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuItemMedioMouseEntered
         this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_MenuItemMedioMouseEntered
   /**
     * Método para controlar o evento do rato a entrar no menu Difícil.
     * Muda o aspecto do rato
     * @param evt
     */
    private void MenuItemDificilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuItemDificilMouseEntered
         this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_MenuItemDificilMouseEntered
   /**
     * Método para controlar o evento do rato a entrar no menu regras de jogo.
     * Muda o aspecto do rato
     * @param evt
     */
    private void regrasjogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regrasjogoMouseEntered
         this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_regrasjogoMouseEntered
   /**
     * Método para controlar o evento do rato a entrar no menu acerca do jogo.
     * Muda o aspecto do rato
     * @param evt
     */
    private void acercajogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acercajogoMouseEntered
         this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_acercajogoMouseEntered
    /**
     * Método para tratar o evento de clicar no menu item Humano vs Humano.
     * @param evt
     */
    private void menuItemHumanoVsHumanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemHumanoVsHumanoActionPerformed
        modoJogo = 1;
        this.labelModoJogo.setText("Humano vs Humano");
        //TODO colocar o taluleiro vazio
        tabuleiro.restart();
        tabuleiro.trilhos_jog1.removeAllElements();
        tabuleiro.trilhos_jog2.removeAllElements();
        painelPrincipal.repaint();
        tabuleiro.tab = Tabuleiro.restart();
        this.menuItemHumanoVsHumano.setEnabled(false);
        this.MenuItemCompVsComp.setEnabled(false);
        this.MenuItemHumanoVsComputador.setEnabled(false);
    }//GEN-LAST:event_menuItemHumanoVsHumanoActionPerformed
    /**
     * Método para tratar o evento de clicar no menu item Humano vs Computador.
     * @param evt
     */
    private void MenuItemHumanoVsComputadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemHumanoVsComputadorActionPerformed
        modoJogo = 2;
        this.labelModoJogo.setText("Humano vs Computador");
        //TODO colocar o taluleiro vazio
        tabuleiro.restart();
        tabuleiro.trilhos_jog1.removeAllElements();
        tabuleiro.trilhos_jog2.removeAllElements();
        painelPrincipal.repaint();
        tabuleiro.tab = Tabuleiro.restart();
        this.menuItemHumanoVsHumano.setEnabled(false);
        this.MenuItemCompVsComp.setEnabled(false);
        this.MenuItemHumanoVsComputador.setEnabled(false);
        cp2 = new Comp(tabuleiro, 2);
    }//GEN-LAST:event_MenuItemHumanoVsComputadorActionPerformed
    /**
     * Método para tratar o evento de clicar no menu item Computador vs Computador.
     * @param evt
     */
    private void MenuItemCompVsCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCompVsCompActionPerformed
        modoJogo = 3;
        this.labelModoJogo.setText("Computador vs Computador");
        //TODO colocar o taluleiro vazio
        tabuleiro.restart();
        tabuleiro.trilhos_jog1.removeAllElements();
        tabuleiro.trilhos_jog2.removeAllElements();
        painelPrincipal.repaint();
        this.menuItemHumanoVsHumano.setEnabled(false);
        this.MenuItemCompVsComp.setEnabled(false);
        this.MenuItemHumanoVsComputador.setEnabled(false);
        cp1 = new Comp(tabuleiro, 1);
        cp2 = new Comp(tabuleiro, 2);
    }//GEN-LAST:event_MenuItemCompVsCompActionPerformed
    /**
     * Método para tratar o evento de clicar no menu Fácil.
     * @param evt
     */
    private void MenuItemFacilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemFacilActionPerformed
        dificuldade = 1;
        labelDificuldade.setText("Fácil");
    }//GEN-LAST:event_MenuItemFacilActionPerformed
    /**
     * Método para tratar o evento de clicar no menu item Médio.
     * @param evt
     */
    private void MenuItemMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemMedioActionPerformed
        dificuldade = 2;
        labelDificuldade.setText("Médio");
    }//GEN-LAST:event_MenuItemMedioActionPerformed
    /**
     * Método para tratar o evento de clicar no menu item Difícil.
     * @param evt
     */
    private void MenuItemDificilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemDificilActionPerformed
        dificuldade = 3;
        labelDificuldade.setText("Difícil");
    }//GEN-LAST:event_MenuItemDificilActionPerformed
    /**
     * Função main
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaHex jan = new JanelaHex();
                jan.setVisible(true);
                jan.setResizable(false);
                jan.setDefaultCloseOperation(JanelaHex.EXIT_ON_CLOSE);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAjuda;
    private javax.swing.JMenu MenuDificuldade;
    private javax.swing.JMenuItem MenuItemCompVsComp;
    private javax.swing.JCheckBoxMenuItem MenuItemDificil;
    private javax.swing.JCheckBoxMenuItem MenuItemFacil;
    private javax.swing.JMenuItem MenuItemHumanoVsComputador;
    private javax.swing.JCheckBoxMenuItem MenuItemMedio;
    private javax.swing.JMenuItem acercajogo;
    private javax.swing.JLabel barraestados;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel labelDificuldade;
    private javax.swing.JLabel labelJogador;
    private javax.swing.JLabel labelModoJogo;
    private javax.swing.JMenuItem menuItemHumanoVsHumano;
    private javax.swing.JMenu menu_modo_de_jogo;
    private javax.swing.JLabel nom_vencedor;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JPanel panel1;
    private javax.swing.JMenuItem regrasjogo;
    private javax.swing.JLabel vencedor;
    // End of variables declaration//GEN-END:variables
    public void mouseClicked(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) {
    }
    /**
     * Método que procede ao desenho da colocação da peça
     * no tabuleiro independentemente do modo de jogo e
     * do jogador
     * @param gr Graficos do painelPrincipal
     * @param e evento ou ponto
     */
    private void desenhaJogada(Graphics gr, Object e){
        System.out.println("avaliação jog" + jogador + ": " + tabuleiro.avaliaEstado(jogador));
        if(tabuleiro.venceu(jogador)) {
           System.out.println("Vencedor: jogador " + jogador);
           fim_jogo = true;
           vencedor.setText("Vencedor:");
           nom_vencedor.setText("Jogador " + jogador);
        }
        if(jogador == 1){
            gr.setColor(Color.blue);
            jogador = 2;
            labelJogador.setText("Jogador 2");
        }
        else {
             gr.setColor(Color.red);
             jogador = 1;
             labelJogador.setText("Jogador 1");
        }//desenhar as peças
        if(jog_humano) {
            MouseEvent e1 = (MouseEvent)e;
            gr.fillOval(centro_x_peça(e1.getX(), e1.getY()), centro_y_peça(e1.getY()), COMP_CASA, COMP_CASA);
        }else{
            Ponto p1 = (Ponto) e;
            gr.fillOval(centro_x_peça(posRatoX(p1), posRatoY(p1)), centro_y_peça(posRatoY(p1)), COMP_CASA, COMP_CASA);
        }
        System.out.println(tabuleiro);
    }
    /**
     * Método que trata o evento de precionar o rato.
     * Se for jogador humano e o botão é precionado numa posição válida do tabuleiro,
     * então é processada a jogada.
     * Se for jogador computador e botão é pressionado dentro da janela de visualização,
     * então é processada a jogada do computador.
     * @param e
     */
    public void mouseReleased(MouseEvent e) {
        if(fim_jogo){
            this.menuItemHumanoVsHumano.setEnabled(true);
            this.MenuItemHumanoVsComputador.setEnabled(true);
            this.MenuItemCompVsComp.setEnabled(true);
        }
        else if(!fim_jogo) {
            if(modoJogo == 1){//humano vs humano
                jog_humano = true;
                if(calculaAbcissa(e.getX(), e.getY()) != -1 &&
                        tabuleiro.setJogada(calculaAbcissa(e.getX(), e.getY()), calculaOrdenada(e.getY()), jogador)){
                       desenhaJogada(painelPrincipal.getGraphics(), e);
                }
                else System.out.println("Não é possível essa jogada");



            }else if(modoJogo == 2){//Humano vs computador
                if(jogador == 1){//jogador humano
                    if(calculaAbcissa(e.getX(), e.getY()) != -1 &&
                        tabuleiro.setJogada(calculaAbcissa(e.getX(), e.getY()), calculaOrdenada(e.getY()), jogador)){
                        desenhaJogada(painelPrincipal.getGraphics(), e);
                        jog_humano = false;
                    }else {System.out.println("Não é possível essa jogada");}


                }else{//jogador vs computador (Este é o computador)
                    Ponto p;
                    //Modo fácil.
                    if(dificuldade == 1) p = cp2.jogadaGulosa();//calcula a melhor jogada.
                    //Modo médio.
                    else if (dificuldade == 2) {
                        Random gerador = new Random();
                        int i = gerador.nextInt(10);
                        if (i == 1) p = cp2.jogadaAleatoria();//10% das jogadas são aleatórias.
                        else{
                            int r = cp2.minimaxAlfaBeta(jogador, 0, tabuleiro);
                            p = cp2.jogadaMinMax;
                            System.out.println("retorno do minimaxAlfaBeta: " + r);
                        }
                    }
                    //Modo difícil.
                    else{
                        int r = cp2.minimaxAlfaBeta(jogador, 0, tabuleiro);
                        p = cp2.jogadaMinMax;
                        System.out.println("retorno do minimaxAlfaBeta: " + r);
                    }
                    tabuleiro.setJogada(Tabuleiro.charToInt(p.coluna), p.linha - 1, jogador);
                    desenhaJogada(painelPrincipal.getGraphics(), p);
                    System.out.println("jogou para " + p);
                    jog_humano = true;
                }



            }else if(modoJogo == 3){//computador vs computador.
                this.jog_humano = false;
                Comp cp; Ponto p;
                if(jogador == 1) cp = cp1;
                else cp = cp2;
                //Modo fácil.
                if(dificuldade == 1) p = cp.jogadaGulosa();//calcula a melhor jogada.
                //Modo médio.
                else if (dificuldade == 2) {
                    Random gerador = new Random();
                    int i = gerador.nextInt(10);
                    if (i == 1) p = cp.jogadaAleatoria();//10% das jogadas são aleatórias.
                    else{
                        int r = cp.minimaxAlfaBeta(jogador, 0, tabuleiro);
                        p = cp.jogadaMinMax;
                        System.out.println("retorno do minimaxAlfaBeta: " + r);
                    }
                }
                //Modo difícil.
                else{
                    int r = cp.minimaxAlfaBeta(jogador, 0, tabuleiro);
                    p = cp.jogadaMinMax;
                    System.out.println("retorno do minimaxAlfaBeta: " + r);
                }
                tabuleiro.setJogada(Tabuleiro.charToInt(p.coluna), p.linha -1, jogador);
                desenhaJogada(painelPrincipal.getGraphics(), p);
                System.out.println("jogou para " + p);
            }
        }
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mouseDragged(MouseEvent e) {
    }
    /**
     * Método que trata eventos de mover o rato
     * muda o aspecto do rato no tabuleiro
     * coloca as coordenadas da posição a seleccionar na barra de estados
     * @param e
     */
    public void mouseMoved(MouseEvent e) {
        if(calculaAbcissa(e.getX(), e.getY()) != -1){
            barraestados.setText("(" + Tabuleiro.AbcissaToChar(calculaAbcissa(e.getX(), e.getY()))
                    + (1 + calculaOrdenada(e.getY())) + ")");
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else this.setCursor(Cursor.getDefaultCursor());
    }
    /**
     * Método que retorna a abcissa da posição no tabuleiro conhecidas
     * as coordenadas da posição do rato
     * @param x abcissa da posição do rato
     * @param y ordenada da posição do rato
     * @return abcissa da posição do tabuleiro (inteiro de 0 a 10)
     */
    private int calculaAbcissa(int x, int y){
        int x_se_y0 = (x - ESQ) / COMP_CASA;
        int ordenada = calculaOrdenada(y);
        int abcissa = (x_se_y0 - (ordenada / 2));
        return (abcissa < 0 || abcissa > 10 || ordenada < 0 || ordenada > 10) ?  -1 :  abcissa;
    }
    /**
     * Simula uma posição do rato para a jogada
     * do computador para o ponto p
     * @param p Ponto onde o jogador computador quer jogar
     * @return abcissa da posição do rato
     */
    private int posRatoX(Ponto p){
        int x1 = Tabuleiro.charToInt(p.coluna);
        int y1 = p.linha - 1;
        //As seguintes contas foram ajustes feitos para que se obtivesse uma razoável aproximação
        // da abcissa do tabuleiro.
        return ESQ + x1*COMP_CASA + (y1*COMP_CASA)/2 + COMP_CASA/4;
    }
    /**
     * Simula uma posição do rato para a jogada
     * do computador para o Ponto p
     * @param p Ponto onde o jogador computador quer jogar
     * @return ordenada da posição do rato
     */
    private int posRatoY(Ponto p){
        int y1 = p.linha - 1;
        //As seguintes contas foram ajustes feitos para que se obtivesse uma razoável aproximação
        // da ordenada do tabuleiro.
        return CIMA + y1 * ALT_CASA + ALT_CASA/2;
    }
    /**
     * Método que retorna a ordenada da posição no tabuleiro
     * conhecida a ordenada da posição do rato
     * @param y ordenada da posição do rato
     * @return ordenada da posição do tabuleiro (inteiro de 0 a 10)
     */
    private int calculaOrdenada(int y){
        return (y - CIMA) / ALT_CASA;
    }
    /**
     * Método que calcula a abcissa onde ira ficar o centro da peça
     * @param x
     * @param y
     * @return
     */
    private int centro_x_peça(int x, int y){
        int abcissa = calculaAbcissa(x, y);
        int ordenada = calculaOrdenada(y);
        int x1 = (int) ((ESQ + abcissa * COMP_CASA) + (COMP_CASA) * (ordenada * 0.5));
        //As seguintes contas foram ajustes feitos para que se obtivesse uma razoável aproximação
        // da abcissa para o centro da peça a colocar.
        return x1 - (COMP_CASA / 2)+(COMP_CASA/4)-(COMP_CASA/16);
    }
    /**
     * Método que calcula a ordenda onde irá ficar o centro da peça
     * @param y
     * @return
     */
    private int centro_y_peça(int y){
        int ordenada = calculaOrdenada(y);
        int y1 = CIMA + ordenada * ALT_CASA;
        //As seguintes contas foram ajustes feitos para que se obtivesse uma razoável aproximação
        // da ordenada para o centro da peça a colocar.
        return y1-5*ALT_CASA / 2+ALT_CASA/4-ALT_CASA/8;
    }
    private final int COMP_CASA = (337 - 50) / 11 , ALT_CASA = (354-106) / 11, ESQ = 50, CIMA = 106;
    private int jogador = 1;
    private boolean fim_jogo = false, jog_humano = true;
    /**
     * modos de jogo:
     * 0 - stand by (à espera da escolha do tipo de jogo)
     * 1 - Humano vs Humano
     * 2 - Humano vs Computador
     * 3 - Computador vs Computador
     */
    private int modoJogo = 0;
    /**
     * Modo dificuldade do jogo:
     * 1 - Fácil;
     * 2 - Médio;
     * 3 - Difícil;
     * Por defeito é 3 (Difícil).
     */
    private int dificuldade = 3;
    /**
     * Objectos da classe Comp
     * necessários para processarem as jogadas realizadas pelo computador.
     */
    private Comp cp1, cp2;
}

