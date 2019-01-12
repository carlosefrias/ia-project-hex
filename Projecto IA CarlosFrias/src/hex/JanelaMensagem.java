/*
 * JanelaMensagem.java
 *
 * Created on 9/Abr/2011, 14:38:27
 */
package hex;
/**
 * Classe Janela Mensagem.
 * @author Carlos Frias
 */
public class JanelaMensagem extends javax.swing.JFrame {
    /**
     * Construtor por defeito da Classe JanelaMensagem.
     */
    public JanelaMensagem() {
        initComponents();
    }
    /**
     * Construtor da classe
     * @param msg mensagem a mostrar
     * @param nome nome da Janela.
     */
    public JanelaMensagem(String msg, String nome){
        super(nome);
        initComponents();
        this.areatexto.setText(msg);
        this.areatexto.setEditable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areatexto = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areatexto.setColumns(20);
        areatexto.setRows(5);
        jScrollPane1.setViewportView(areatexto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Função main.
     * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaMensagem jan = new JanelaMensagem();
                jan.setVisible(true);
                jan.setDefaultCloseOperation(JanelaMensagem.EXIT_ON_CLOSE);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areatexto;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
