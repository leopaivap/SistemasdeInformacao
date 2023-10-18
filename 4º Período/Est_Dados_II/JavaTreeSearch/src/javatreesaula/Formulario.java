package javatreesaula;

import java.io.*;
import javax.swing.JOptionPane;

public class Formulario extends javax.swing.JFrame {

    BinarySearchTree tree = new BinarySearchTree();

    public Formulario() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLoadFile3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMostraDados = new javax.swing.JTextArea();
        btnPosOrder = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnLoadFile = new javax.swing.JButton();
        btnPreOrder = new javax.swing.JButton();
        btnInOrder = new javax.swing.JButton();

        btnLoadFile3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javatreesaula/csv.png"))); // NOI18N
        btnLoadFile3.setText("Load file");
        btnLoadFile3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadFile3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 0, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Trees");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("________________________________");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(388, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 490));

        jPanel1.setBackground(new java.awt.Color(51, 0, 102));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javatreesaula/banco.png"))); // NOI18N
        jLabel3.setText("Conta Bancária - Binary Search Tree");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 407, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 930, 100));

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder("Conta Bancária"));
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 120, -1));

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNome.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome Correntista"));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 560, -1));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javatreesaula/adicionar-botao.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 120, 40));

        listMostraDados.setEditable(false);
        listMostraDados.setColumns(20);
        listMostraDados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        listMostraDados.setRows(5);
        jScrollPane1.setViewportView(listMostraDados);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 680, 250));

        btnPosOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javatreesaula/diagrama.png"))); // NOI18N
        btnPosOrder.setText("PosOrder");
        btnPosOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btnPosOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 120, 40));
        btnPosOrder.getAccessibleContext().setAccessibleName("CSV");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javatreesaula/procurar.png"))); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 130, 110, 40));

        btnLoadFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javatreesaula/csv.png"))); // NOI18N
        btnLoadFile.setText("Load file");
        btnLoadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadFileActionPerformed(evt);
            }
        });
        getContentPane().add(btnLoadFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 120, 40));

        btnPreOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javatreesaula/diagrama.png"))); // NOI18N
        btnPreOrder.setText("PreOrder");
        btnPreOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btnPreOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 120, 40));

        btnInOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javatreesaula/diagrama.png"))); // NOI18N
        btnInOrder.setText("InOrder");
        btnInOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btnInOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 120, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void carregaArquivo(BinarySearchTree tree) {
        String csvFile = "dados.csv";
        String line = "";
        String[] leitura = null;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                Correntista correntista = new Correntista();
                leitura = line.split(",");
                System.out.println(leitura[0] + " " + leitura[1]);
                correntista.setContaBancaria(Integer.parseInt(leitura[0]));
                correntista.setNome(leitura[1]);
                tree.add(correntista);
            }// fim percurso no arquivo

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int cont = tree.add(new Correntista(Integer.parseInt(txtCodigo.getText()), txtNome.getText()));
        JOptionPane.showMessageDialog(null, "Novo Correntista inserido com sucesso!\nComparacoes realizadas: " + cont);

        txtCodigo.setText("");
        txtNome.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnPosOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosOrderActionPerformed
        listMostraDados.setText("");
        tree.postOrderList(listMostraDados);
    }//GEN-LAST:event_btnPosOrderActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        boolean encontrado = tree.contains(new Correntista(Integer.parseInt(txtCodigo.getText()), ""));
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Encontrado na Arvore!");
        } else {
            JOptionPane.showMessageDialog(null, "Nao encontrado na Arvore!");
        }

        txtCodigo.setText("");
        txtNome.setText("");
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnLoadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadFileActionPerformed
        carregaArquivo(tree);
    }//GEN-LAST:event_btnLoadFileActionPerformed

    private void btnPreOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreOrderActionPerformed
        listMostraDados.setText("");
        tree.preOrderList(listMostraDados);
    }//GEN-LAST:event_btnPreOrderActionPerformed

    private void btnLoadFile3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadFile3ActionPerformed

    }//GEN-LAST:event_btnLoadFile3ActionPerformed

    private void btnInOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInOrderActionPerformed
        listMostraDados.setText("");
        tree.inOrderList(listMostraDados);
    }//GEN-LAST:event_btnInOrderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnInOrder;
    private javax.swing.JButton btnLoadFile;
    private javax.swing.JButton btnLoadFile3;
    private javax.swing.JButton btnPosOrder;
    private javax.swing.JButton btnPreOrder;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea listMostraDados;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
