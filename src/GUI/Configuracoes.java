/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Configuracao;
import Util.acessoArquivo;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */
public class Configuracoes extends javax.swing.JFrame {

    /**
     * Creates new form Configuracoes
     */
    public Configuracoes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        U = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PW = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        BC = new javax.swing.JButton();
        SRV = new javax.swing.JTextField();
        BS = new javax.swing.JButton();
        P = new javax.swing.JTextField();
        BD = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurações de acesso ao banco de dados");
        setBackground(new java.awt.Color(180, 242, 242));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(103, 190, 253));

        U.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        jLabel1.setText("Servidor/IP:");

        jLabel2.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        jLabel2.setText("Porta:");

        jLabel3.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        jLabel3.setText("Banco:");

        jLabel4.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        jLabel4.setText("Usuário:");

        PW.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        jLabel5.setText("Senha:");

        BC.setBackground(new java.awt.Color(213, 252, 255));
        BC.setFont(new java.awt.Font("SF Pro Display", 1, 14)); // NOI18N
        BC.setText("Cancelar");
        BC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCActionPerformed(evt);
            }
        });

        SRV.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N

        BS.setBackground(new java.awt.Color(213, 252, 255));
        BS.setFont(new java.awt.Font("SF Pro Display", 1, 14)); // NOI18N
        BS.setText("Salvar");
        BS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSActionPerformed(evt);
            }
        });

        P.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N

        BD.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BS))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SRV, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(U, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(P, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(4, 4, 4)
                                .addComponent(PW, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BD, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SRV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(BD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(U, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BC)
                    .addComponent(BS))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCActionPerformed
        dispose();
    }//GEN-LAST:event_BCActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Configuracao CF = new Configuracao();
        CF = acessoArquivo.le();
        SRV.setText(CF.getServer());
        P.setText(CF.getPorta());
        BD.setText(CF.getBanco());
        U.setText(CF.getUser());
        PW.setText(CF.getPassword());
    }//GEN-LAST:event_formComponentShown

    private void BSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSActionPerformed
        Configuracao CF = new Configuracao();
        CF.setServer(SRV.getText());
        CF.setPorta(P.getText());
        CF.setBanco(BD.getText());
        CF.setUser(U.getText());
        CF.setPassword(PW.getText());
        try {
            acessoArquivo.grava(CF);
            JOptionPane.showMessageDialog(rootPane, "Alterações gravas com sucesso!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Erro na gravaçào do arquivo de configurações!!");
        }

        dispose();
    }//GEN-LAST:event_BSActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BC;
    private javax.swing.JTextField BD;
    private javax.swing.JButton BS;
    private javax.swing.JTextField P;
    private javax.swing.JPasswordField PW;
    private javax.swing.JTextField SRV;
    private javax.swing.JTextField U;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
