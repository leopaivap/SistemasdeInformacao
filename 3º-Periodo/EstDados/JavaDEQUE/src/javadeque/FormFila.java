package javadeque;
import java.util.*;
import javax.swing.JOptionPane;

public class FormFila extends javax.swing.JFrame {
    Deque<Pessoa> minhaDeque = new LinkedList<>();

    public FormFila() {
        initComponents();
        prox();   
    }
    
    int x = 0;
    void mostra(){
        if(!minhaDeque.isEmpty() && x == 1){
              btnMostraInvertida.setLabel("Mostrar invertida");
              x = 0;
         }
        
        listFilaDupla.setText("");
        if(!minhaDeque.isEmpty())
                for(Pessoa p: minhaDeque)
                    listFilaDupla.append(p + "\n");
    }
    
    void mostraInvertido(){
         listFilaDupla.setText("");
         if(!minhaDeque.isEmpty() && x == 1){
              btnMostraInvertida.setLabel("Mostrar invertida");
              x = 0;
              mostra();
              return;
         }
         
         Iterator meuIterator = minhaDeque.descendingIterator(); // iterador para inverter a lista
         if(!minhaDeque.isEmpty()&& x == 0){
             x = 1;
             btnMostraInvertida.setLabel("Mostrar normal");
             while(meuIterator.hasNext())
                 listFilaDupla.append(meuIterator.next() + "\n");
         }else if(minhaDeque.isEmpty())
             JOptionPane.showMessageDialog(null, "Fila vazia!");
         
             
    }
    
    void prox(){
        if(!minhaDeque.isEmpty())
            txtProx.setText("Prox: " + minhaDeque.peekFirst() + "\n");
        else
            txtProx.setText("Prox: Fila Vazia!\n");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtProx = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        txtRG = new javax.swing.JTextField();
        txtIdade = new javax.swing.JTextField();
        btnAddFirst = new javax.swing.JButton();
        btnAddLast = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listFilaDupla = new javax.swing.JTextArea();
        btnAtenderIni = new javax.swing.JButton();
        btnAtenderFim = new javax.swing.JButton();
        btnMostraInvertida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javadeque/immune.png"))); // NOI18N

        txtProx.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        txtProx.setForeground(new java.awt.Color(255, 255, 255));
        txtProx.setText("Prox:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProx, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2208, 2208, 2208))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(txtProx, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicionar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 0, 24))); // NOI18N

        txtNome.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtNome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 0, 18))); // NOI18N

        txtRG.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtRG.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 0, 18))); // NOI18N

        txtIdade.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtIdade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Idade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 0, 18))); // NOI18N

        btnAddFirst.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnAddFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javadeque/ambulance.png"))); // NOI18N
        btnAddFirst.setText("Urgência");
        btnAddFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFirstActionPerformed(evt);
            }
        });

        btnAddLast.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnAddLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javadeque/add-user.png"))); // NOI18N
        btnAddLast.setText("Add Fim");
        btnAddLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddFirst)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(63, 63, 63)
                            .addComponent(btnAddLast, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddLast, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DEQUE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 0, 24))); // NOI18N

        listFilaDupla.setEditable(false);
        listFilaDupla.setColumns(20);
        listFilaDupla.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        listFilaDupla.setRows(5);
        listFilaDupla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DEQUE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 0, 24))); // NOI18N
        jScrollPane1.setViewportView(listFilaDupla);

        btnAtenderIni.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnAtenderIni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javadeque/doctor-atend.png"))); // NOI18N
        btnAtenderIni.setText("Atender");
        btnAtenderIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtenderIniActionPerformed(evt);
            }
        });

        btnAtenderFim.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnAtenderFim.setText("Remover do fim");
        btnAtenderFim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtenderFimActionPerformed(evt);
            }
        });

        btnMostraInvertida.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnMostraInvertida.setText("Mostrar invertida");
        btnMostraInvertida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostraInvertidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnAtenderIni, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAtenderFim)
                            .addComponent(btnMostraInvertida)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAtenderFim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMostraInvertida))
                    .addComponent(btnAtenderIni, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFirstActionPerformed
        if(!txtNome.getText().equals("") && !txtRG.getText().equals("") && !txtIdade.getText().equals("")){
            Pessoa novaPessoa = new Pessoa();
            novaPessoa.setNome(txtNome.getText());
            novaPessoa.setRg(txtRG.getText());
            novaPessoa.setIdade(Integer.parseInt((txtIdade.getText())));
            minhaDeque.addFirst(novaPessoa);

            txtNome.setText("");
            txtRG.setText("");
            txtIdade.setText("");
            mostra();
            prox();
        } else
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
    }//GEN-LAST:event_btnAddFirstActionPerformed

    private void btnAddLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLastActionPerformed
        if(!txtNome.getText().equals("") && !txtRG.getText().equals("") && !txtIdade.getText().equals("")){
            Pessoa novaPessoa = new Pessoa();
            novaPessoa.setNome(txtNome.getText());
            novaPessoa.setRg(txtRG.getText());
            novaPessoa.setIdade(Integer.parseInt((txtIdade.getText())));
            minhaDeque.addLast(novaPessoa);

            txtNome.setText("");
            txtRG.setText("");
            txtIdade.setText("");
            mostra();
            prox();
        } else
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
    }//GEN-LAST:event_btnAddLastActionPerformed

    private void btnMostraInvertidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostraInvertidaActionPerformed
        mostraInvertido();
    }//GEN-LAST:event_btnMostraInvertidaActionPerformed

    private void btnAtenderIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtenderIniActionPerformed
        if(!minhaDeque.isEmpty()){
            Pessoa p = minhaDeque.removeFirst();
            mostra();
            prox();
        }else
             JOptionPane.showMessageDialog(null, "Fila vazia!");
           
    }//GEN-LAST:event_btnAtenderIniActionPerformed

    private void btnAtenderFimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtenderFimActionPerformed
            if(!minhaDeque.isEmpty()){
                Pessoa p = minhaDeque.removeLast();
                mostra();
                prox();
        }else
             JOptionPane.showMessageDialog(null, "Fila vazia!");
    }//GEN-LAST:event_btnAtenderFimActionPerformed

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
            java.util.logging.Logger.getLogger(FormFila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormFila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormFila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormFila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormFila().setVisible(true);
              /*
                FormFila form = new FormFila();
                form.setLocationRelativeTo(null);
                form.setVisible(true);
               */
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFirst;
    private javax.swing.JButton btnAddLast;
    private javax.swing.JButton btnAtenderFim;
    private javax.swing.JButton btnAtenderIni;
    private javax.swing.JButton btnMostraInvertida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea listFilaDupla;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JLabel txtProx;
    private javax.swing.JTextField txtRG;
    // End of variables declaration//GEN-END:variables
}
