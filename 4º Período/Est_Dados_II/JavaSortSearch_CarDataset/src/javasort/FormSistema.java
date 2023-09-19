package javasort;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormSistema extends javax.swing.JFrame {

    ArrayList<Dados> carList = new ArrayList<>();
    // Definir os comparadores
    Comparator<Dados> compareCylinders = (Dados d1, Dados d2) -> d1.getCylinders() - d2.getCylinders();
    Comparator<Dados> compareHp = (Dados d1, Dados d2) -> (d1.getHorsepower() - d2.getHorsepower());
    Comparator<Dados> compareYear = (Dados d1, Dados d2) -> d1.getYear() - d2.getYear();
    Comparator<Dados> compareOrigin = (Dados d1, Dados d2) -> d1.getOrigin().compareTo(d2.getOrigin());
    Comparator<Dados> compareName = (Dados d1, Dados d2) -> d1.getName().compareTo(d2.getName());

    public FormSistema() {
        initComponents();
        carregaArquivo();
        mostra();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSearch = new javax.swing.ButtonGroup();
        buttonGroupType = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblProx = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnOrdNome = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDados = new javax.swing.JTable();
        cbOrdena = new javax.swing.JComboBox<>();
        txtBusca = new javax.swing.JTextField();
        btnBusca = new javax.swing.JButton();
        rbLinear = new javax.swing.JRadioButton();
        rbBinaria = new javax.swing.JRadioButton();
        rbName = new javax.swing.JRadioButton();
        rbOrigin = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        lblProx.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        lblProx.setForeground(new java.awt.Color(255, 255, 255));
        lblProx.setText("Car Search Dataset");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javasort/carro-esporte.png"))); // NOI18N
        jLabel2.setDoubleBuffered(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(239, 239, 239)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(lblProx, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblProx, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 0, 24))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnOrdNome.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnOrdNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javasort/check-list (1).png"))); // NOI18N
        btnOrdNome.setText("Ordenar");
        btnOrdNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdNomeActionPerformed(evt);
            }
        });

        tabelaDados.setAutoCreateRowSorter(true);
        tabelaDados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabelaDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Cylinders", "Horsepower", "Year", "Origin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaDados);

        cbOrdena.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Cylinders", "Horsepower", "Year", "Origin" }));
        cbOrdena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOrdenaActionPerformed(evt);
            }
        });

        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javasort/task.png"))); // NOI18N
        btnBusca.setText("Buscar");
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        buttonGroupSearch.add(rbLinear);
        rbLinear.setText("Linear");

        buttonGroupSearch.add(rbBinaria);
        rbBinaria.setText("Binária");

        buttonGroupType.add(rbName);
        rbName.setText("Name");
        rbName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNameActionPerformed(evt);
            }
        });

        buttonGroupType.add(rbOrigin);
        rbOrigin.setText("Origin");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOrdNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbOrdena, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbLinear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(rbBinaria))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbOrigin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(btnBusca)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(cbOrdena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOrdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbLinear)
                            .addComponent(rbBinaria))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbName)
                            .addComponent(rbOrigin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void carregaArquivo() {
        String csvFile = "Automobile_import.csv";
        String line = "";
        String[] leitura = null;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                Dados car = new Dados();
                leitura = line.split(",");
                car.setName(leitura[0]);

                // Verifique se as strings não estão vazias antes de convertê-las em inteiros
                if (!leitura[2].isEmpty()) {
                    car.setCylinders(Integer.parseInt(leitura[2]));
                }
                if (!leitura[4].isEmpty()) {
                    car.setHorsepower(Integer.parseInt(leitura[4]));
                }
                if (!leitura[7].isEmpty()) {
                    car.setYear(Integer.parseInt(leitura[7]));
                }

                car.setOrigin(leitura[8]);

//                System.out.println("Modelo: " + leitura[0]);
//                System.out.println("cyl: " + leitura[2]);
//                System.out.println("hp: " + leitura[4]);
//                System.out.println("year: " + leitura[7]);
//                System.out.println("origin: " + leitura[8]);
//                System.out.println("-------------------");
                carList.add(car);
            }// fim percurso no arquivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //https://1bestcsharp.blogspot.com/2016/03/java-populate-jtable-from-arraylist.html
    void mostra() {
        //limpando a tabela
        tabelaDados.setModel(new DefaultTableModel(null, new String[]{"Name", "Cylinders", "HorsePower", "Year", "Origin"}));

        DefaultTableModel model
                = (DefaultTableModel) tabelaDados.getModel();
        Object rowData[] = new Object[9];// qtd colunas
        for (Dados car : carList) {
            rowData[0] = car.getName();
            rowData[1] = car.getCylinders();
            rowData[2] = car.getHorsepower();
            rowData[3] = car.getYear();
            rowData[4] = car.getOrigin();

            model.addRow(rowData);
        }// fim preenche modelo
    }// fim mostra


    private void btnOrdNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdNomeActionPerformed
        // switch case para escolher por qual comparador ordenar
        switch (cbOrdena.getSelectedIndex()) {
            case 0:
                carList.sort(compareName);
                break;

            case 1:
                carList.sort(compareCylinders);
                break;

            case 2:
                carList.sort(compareHp);
                break;

            case 3:
                carList.sort(compareYear);
                break;

            case 4:
                carList.sort(compareOrigin);
                break;

        }
        mostra();

    }//GEN-LAST:event_btnOrdNomeActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        String search;
        search = txtBusca.getText();
        int resp = -1;
        ArrayList<Dados> carListCopy = new ArrayList<>(carList);

        if (rbLinear.isSelected() && rbName.isSelected()) {
            resp = Search.linearSearchCarName(carList, search);
        } else if (rbLinear.isSelected() && rbOrigin.isSelected()) {
            resp = Search.linearSearchCarOrigin(carList, search);
        } else if (rbBinaria.isSelected() && rbName.isSelected()) {
            Collections.sort(carListCopy, compareName);
            resp = Search.binarySearchCarName(carListCopy, search);
        } else if (rbBinaria.isSelected() && rbOrigin.isSelected()) {
            Collections.sort(carListCopy, compareOrigin);
            resp = Search.binarySearchCarOrigin(carListCopy, search);
        }

        if (resp > -1 && !(rbBinaria.isSelected() && rbOrigin.isSelected())) {
            JOptionPane.showMessageDialog(null, "Encontrado com [" + resp + "] comparações!");
        } else if (resp > -1) {
            JOptionPane.showMessageDialog(null, "Encontrado o primeiro registro com [" + resp + "] comparações!");
        } else {
            JOptionPane.showMessageDialog(null, "Nao Encontrado!");
        }

    }//GEN-LAST:event_btnBuscaActionPerformed

    private void cbOrdenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOrdenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbOrdenaActionPerformed

    private void rbNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNameActionPerformed

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
            java.util.logging.Logger.getLogger(FormSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnOrdNome;
    private javax.swing.ButtonGroup buttonGroupSearch;
    private javax.swing.ButtonGroup buttonGroupType;
    private javax.swing.JComboBox<String> cbOrdena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblProx;
    private javax.swing.JRadioButton rbBinaria;
    private javax.swing.JRadioButton rbLinear;
    private javax.swing.JRadioButton rbName;
    private javax.swing.JRadioButton rbOrigin;
    private javax.swing.JTable tabelaDados;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
