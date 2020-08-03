package main;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import operations.Evaluator;

/**
 *
 * @author larios
 */
public class TruthTable extends javax.swing.JFrame {

    private final DefaultTableModel model;
    
    public TruthTable() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        model = (DefaultTableModel) tblTruth.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtExpression = new javax.swing.JTextArea();
        btnP = new javax.swing.JButton();
        btnQ = new javax.swing.JButton();
        btnR = new javax.swing.JButton();
        btnAnd = new javax.swing.JButton();
        btnOr = new javax.swing.JButton();
        btnThen = new javax.swing.JButton();
        btnIfOnlyIf = new javax.swing.JButton();
        btnParenthesisO = new javax.swing.JButton();
        btnParenthesisC = new javax.swing.JButton();
        btnNot = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnEqual = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTruth = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tablas de Verdad");

        jPanel1.setBackground(new java.awt.Color(25, 25, 25));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese una expresión:");

        txtExpression.setEditable(false);
        txtExpression.setColumns(20);
        txtExpression.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        txtExpression.setForeground(new java.awt.Color(0, 0, 0));
        txtExpression.setRows(5);
        jScrollPane2.setViewportView(txtExpression);

        btnP.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        btnP.setText("p");
        btnP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPActionPerformed(evt);
            }
        });

        btnQ.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        btnQ.setText("q");
        btnQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQActionPerformed(evt);
            }
        });

        btnR.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        btnR.setText("r");
        btnR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRActionPerformed(evt);
            }
        });

        btnAnd.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        btnAnd.setText("^");
        btnAnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndActionPerformed(evt);
            }
        });

        btnOr.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        btnOr.setText("∨");
        btnOr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrActionPerformed(evt);
            }
        });

        btnThen.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        btnThen.setText("→");
        btnThen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThenActionPerformed(evt);
            }
        });

        btnIfOnlyIf.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        btnIfOnlyIf.setText("↔");
        btnIfOnlyIf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIfOnlyIfActionPerformed(evt);
            }
        });

        btnParenthesisO.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        btnParenthesisO.setText("(");
        btnParenthesisO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParenthesisOActionPerformed(evt);
            }
        });

        btnParenthesisC.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        btnParenthesisC.setText(")");
        btnParenthesisC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParenthesisCActionPerformed(evt);
            }
        });

        btnNot.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        btnNot.setText("¬");
        btnNot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotActionPerformed(evt);
            }
        });

        btnDel.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        btnDel.setText("DEL");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnEqual.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        btnEqual.setText("=");
        btnEqual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEqualActionPerformed(evt);
            }
        });

        btnClean.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        btnClean.setText("CLN");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(btnClean))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNot)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnAnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnParenthesisO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnP, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnParenthesisC, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnOr)
                        .addGap(18, 18, 18)
                        .addComponent(btnIfOnlyIf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnQ)
                        .addGap(18, 18, 18)
                        .addComponent(btnR)
                        .addGap(18, 18, 18)
                        .addComponent(btnThen))
                    .addComponent(btnEqual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 105, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnP)
                    .addComponent(btnQ)
                    .addComponent(btnR)
                    .addComponent(btnThen))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnd)
                    .addComponent(btnOr)
                    .addComponent(btnIfOnlyIf))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnParenthesisO)
                    .addComponent(btnParenthesisC)
                    .addComponent(btnDel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNot)
                    .addComponent(btnEqual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClean)
                .addContainerGap())
        );

        tblTruth.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        tblTruth.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblTruth);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        model.setRowCount(0);
        model.setColumnCount(0);
        txtExpression.setText("");
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPActionPerformed
        txtExpression.setText(txtExpression.getText() + btnP.getText());
    }//GEN-LAST:event_btnPActionPerformed

    private void btnQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQActionPerformed
        txtExpression.setText(txtExpression.getText() + btnQ.getText());
    }//GEN-LAST:event_btnQActionPerformed

    private void btnRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRActionPerformed
        txtExpression.setText(txtExpression.getText() + btnR.getText());
    }//GEN-LAST:event_btnRActionPerformed

    private void btnThenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThenActionPerformed
        txtExpression.setText(txtExpression.getText() + btnThen.getText());
    }//GEN-LAST:event_btnThenActionPerformed

    private void btnAndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndActionPerformed
        txtExpression.setText(txtExpression.getText() + btnAnd.getText());
    }//GEN-LAST:event_btnAndActionPerformed

    private void btnOrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrActionPerformed
        txtExpression.setText(txtExpression.getText() + btnOr.getText());
    }//GEN-LAST:event_btnOrActionPerformed

    private void btnIfOnlyIfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIfOnlyIfActionPerformed
        txtExpression.setText(txtExpression.getText() + btnIfOnlyIf.getText());
    }//GEN-LAST:event_btnIfOnlyIfActionPerformed

    private void btnParenthesisOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParenthesisOActionPerformed
        txtExpression.setText(txtExpression.getText() + btnParenthesisO.getText());
    }//GEN-LAST:event_btnParenthesisOActionPerformed

    private void btnParenthesisCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParenthesisCActionPerformed
        txtExpression.setText(txtExpression.getText() + btnParenthesisC.getText());
    }//GEN-LAST:event_btnParenthesisCActionPerformed

    private void btnNotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotActionPerformed
        txtExpression.setText(txtExpression.getText() + btnNot.getText());
    }//GEN-LAST:event_btnNotActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        if (txtExpression.getText().length() != 0)
            txtExpression.setText(txtExpression.getText().substring(0, txtExpression.getText().length() - 1));
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnEqualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEqualActionPerformed
        new Evaluator(model, txtExpression.getText()).resolve();
    }//GEN-LAST:event_btnEqualActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new TruthTable().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnd;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEqual;
    private javax.swing.JButton btnIfOnlyIf;
    private javax.swing.JButton btnNot;
    private javax.swing.JButton btnOr;
    private javax.swing.JButton btnP;
    private javax.swing.JButton btnParenthesisC;
    private javax.swing.JButton btnParenthesisO;
    private javax.swing.JButton btnQ;
    private javax.swing.JButton btnR;
    private javax.swing.JButton btnThen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblTruth;
    private javax.swing.JTextArea txtExpression;
    // End of variables declaration//GEN-END:variables
}
