/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author jmulh
 */
public class CheckInOutSupply extends javax.swing.JFrame {
    Backend backend = new Backend();
    int adminId;
    String serialNumber;

    public CheckInOutSupply() {
        initComponents();
    }
    
    public void initialize(int Id, String deviceType, String serialNumber, boolean checkOut) {
        supplyNameLbl.setText(deviceType);
        supplySNLbl.setText("Serial #: " +serialNumber);
        this.adminId = Id;
        this.serialNumber = serialNumber;
        
        if (checkOut) {
            checkInOutBtn.setText("Check Out");
            jLabel3.setText("Employee ID");
        } else {
            checkInOutBtn.setText("Check In");
            jLabel3.setVisible(false);
            jText.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DeviceCheckGrp = new javax.swing.ButtonGroup();
        supplyNameLbl = new javax.swing.JLabel();
        supplySNLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jText = new javax.swing.JTextField();
        checkInOutBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jCondition = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        supplyNameLbl.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        supplyNameLbl.setText("Supply Name");

        supplySNLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        supplySNLbl.setText("Supply Serial number");

        jLabel3.setText("Employee ID");

        checkInOutBtn.setText("Check Out");
        checkInOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInOutBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Condition");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(supplyNameLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(supplySNLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jText, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkInOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(supplyNameLbl)
                .addGap(18, 18, 18)
                .addComponent(supplySNLbl)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(checkInOutBtn)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkInOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInOutBtnActionPerformed
        if (checkInOutBtn.getText().equals("Check In")) {
            backend.checkInDevice(adminId, this.serialNumber, jCondition.getText());
        } else {
            backend.checkOutDevice(Integer.parseInt(jText.getText()), adminId, this.serialNumber, jCondition.getText());
        }
    }//GEN-LAST:event_checkInOutBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CheckInOutSupply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckInOutSupply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckInOutSupply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckInOutSupply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CheckInOutSupply("","").setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup DeviceCheckGrp;
    private javax.swing.JButton checkInOutBtn;
    private javax.swing.JTextField jCondition;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jText;
    private javax.swing.JLabel supplyNameLbl;
    private javax.swing.JLabel supplySNLbl;
    // End of variables declaration//GEN-END:variables
}
