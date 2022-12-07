import java.util.HashMap;
import javax.swing.table.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author jmulh
 */
public class supply extends javax.swing.JFrame {
    Backend backend = new Backend();
    String serialNumber = "";
    String type;
    
    /**
     * 
     * @param serialNumber 
     */
    public supply(String serialNumber) {
        this.serialNumber = serialNumber;
        HashMap<String, String> deviceHashMap = backend.getDeviceInformation(serialNumber);
        initComponents();
        fillFields(deviceHashMap);
    }

    public void fillFields(HashMap<String, String> info){
        
        jBarcode.setText(info.get("barcode"));
        jBrand.setText(info.get("brand"));
        jColor.setText(info.get("color"));
        jCost.setText(info.get("cost"));
        jCondition.setText(info.get("condition"));
        jGraphic.setText(info.get("graphic_card"));
        jIssues.setText(info.get("issue"));
        jMemory.setText(info.get("memory"));
        jModel.setText(info.get("model"));
        jProcessor.setText(info.get("processor"));
        jScreenSize.setText(info.get("screen_size"));
        jSupplier.setText(info.get("supplier"));
        jMemory1.setText(info.get("location"));
        jMemory2.setText(info.get("status"));
        jOS.setText(info.get("os"));
        jWarranty.setText(info.get("warranty"));
        jWeight.setText(info.get("weight"));
        jPurchaseDate.setText(info.get("purchase_date"));
        jTitle.setText(info.get("type") + " - "+ info.get("serial_number"));
        this.type = info.get("type");
        
        if (type.equals("PC")) {
            jLabel29.setText("Username");
            jLabel27.setText("Password");
            jLabel28.setVisible(false);
            jTextField22.setVisible(false);
        }
        
        if (type.equals("Chromebook")) {
            jLabel29.setText("Username");
            jLabel27.setText("Password");
            jLabel28.setText("eMCC");
        }
        
        if (type.equals("IPad")) {
            jLabel29.setText("Model Number");
            jLabel27.setText("Passcode");
            jLabel28.setText("Software Version");
        }
        
        jTextField10.setText(info.get("extraField1"));
        jMemory3.setText(info.get("extraField2"));
        System.out.println(info.get("extraField3"));
        System.out.println(info.get("type"));
        if (info.get("type").equals("IPad") || info.get("type").equals("Chromebook")) {
            jTextField22.setText(info.get("extraField3"));
        }
        
        // Accessories
        if (info.containsKey("keyboard")) {
            jRadioButton4.setSelected(true);
        }
        if (info.containsKey("mouse")) {
            jRadioButton6.setSelected(true);
        }
        if (info.containsKey("headphones")) {
            jRadioButton8.setSelected(true);
        }
        if (info.containsKey("stylus")) {
            jRadioButton10.setSelected(true);
        }
        
        // Maintenance (issue, location, by, at, cost)
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        for (int i =1; i < 4; i++) {
            if (info.containsKey("mRecord"+i+".issue")) {
                model.setValueAt(info.get("mRecord"+i+".issue"), i-1, 0);
            }
            if (info.containsKey("mRecord"+i+".location")) {
                model.setValueAt(info.get("mRecord"+i+".location"), i-1, 1);
            }
            if (info.containsKey("mRecord"+i+".by")) {
                model.setValueAt(info.get("mRecord"+i+".by"), i-1, 2);
            }
            if (info.containsKey("mRecord"+i+".at")) {
                model.setValueAt(info.get("mRecord"+i+".at"), i-1, 3);
            }
            if (info.containsKey("mRecord"+i+".cost")) {
                model.setValueAt(info.get("mRecord"+i+".cost"), i-1, 4);
            }
        }
        
        // Checkout (time, admin, to, condition, return time, admin, condition)
        model = (DefaultTableModel)jTable2.getModel();
        
        if (info.containsKey("checkout_time")) {
                model.setValueAt(info.get("checkout_time"), 0, 0);
        }
        if (info.containsKey("admin_out")) {
                model.setValueAt(info.get("admin_out"), 0, 1);
        }
        if (info.containsKey("checked_to")) {
                model.setValueAt(info.get("checked_to"), 0, 2);
        }
        if (info.containsKey("out_condition")) {
                model.setValueAt(info.get("out_condition"), 0, 3);
        }
        if (info.containsKey("return_time")) {
                model.setValueAt(info.get("return_time"), 0, 4);
        }
        if (info.containsKey("admin_in")) {
                model.setValueAt(info.get("admin_in"), 0, 5);
        }
        if (info.containsKey("in_condition")) {
                model.setValueAt(info.get("in_condition"), 0, 6);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jCost = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jCondition = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jWeight = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSupplier = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jBrand = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jColor = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jIssues = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jGraphic = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jMemory = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScreenSize = new javax.swing.JTextField();
        jWarranty = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBarcode = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jProcessor = new javax.swing.JTextField();
        jModel = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jOS = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPurchaseDate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jMemory1 = new javax.swing.JTextField();
        jMemory2 = new javax.swing.JTextField();
        jMemory3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTitle.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jTitle.setText("Type-serial number");

        jLabel27.setText("Software Version");

        jLabel28.setText("eMMC:");

        jTextField22.setEnabled(false);

        jCost.setText("0.0");
        jCost.setEnabled(false);

        jLabel9.setText("Condition");

        jCondition.setText("New");
        jCondition.setEnabled(false);

        jLabel10.setText("Weight (lb)");

        jWeight.setText("0.0");
        jWeight.setEnabled(false);

        jLabel11.setText("Supplier");

        jSupplier.setText("Apple");
        jSupplier.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel12.setText("Maintenance History (Latest 3):");

        jTextField10.setEnabled(false);

        jBrand.setEnabled(false);

        jLabel19.setText("Color:");

        jColor.setEnabled(false);

        jLabel21.setText("Issues:");
        jLabel21.setToolTipText("");

        jIssues.setEnabled(false);

        jLabel20.setText("Graphics Card:");

        jGraphic.setEnabled(false);

        jLabel22.setText("Memory:");
        jLabel22.setToolTipText("");

        jMemory.setEnabled(false);

        jLabel23.setText("Screen Size");

        jScreenSize.setText("0.0");
        jScreenSize.setEnabled(false);

        jWarranty.setEnabled(false);

        jLabel24.setText("Status");

        jLabel4.setText("Barcode");

        jBarcode.setEnabled(false);

        jLabel25.setText("Processor");

        jLabel5.setText("Model");

        jProcessor.setEnabled(false);

        jModel.setEnabled(false);

        jLabel26.setText("Location");

        jLabel6.setText("OS");

        jOS.setEnabled(false);

        jLabel7.setText("Purchase Date");

        jPurchaseDate.setText("2020-01-01");
        jPurchaseDate.setToolTipText("YYYY-MM-DD");
        jPurchaseDate.setEnabled(false);

        jLabel8.setText("Cost");

        jLabel18.setText("Brand:");

        jLabel3.setText("Warranty");

        jLabel13.setText("Has Keyboard:");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Yes");
        jRadioButton4.setEnabled(false);

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setSelected(true);
        jRadioButton5.setText("No");
        jRadioButton5.setEnabled(false);

        jLabel14.setText("Has Mouse:");

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("Yes");
        jRadioButton6.setEnabled(false);

        buttonGroup2.add(jRadioButton7);
        jRadioButton7.setSelected(true);
        jRadioButton7.setText("No");
        jRadioButton7.setEnabled(false);

        jLabel16.setText("Has Headphones:");

        buttonGroup3.add(jRadioButton8);
        jRadioButton8.setText("Yes");
        jRadioButton8.setEnabled(false);

        buttonGroup3.add(jRadioButton9);
        jRadioButton9.setSelected(true);
        jRadioButton9.setText("No");
        jRadioButton9.setEnabled(false);

        jLabel17.setText("Has Stylus:");

        buttonGroup4.add(jRadioButton10);
        jRadioButton10.setText("Yes");
        jRadioButton10.setEnabled(false);

        buttonGroup4.add(jRadioButton11);
        jRadioButton11.setSelected(true);
        jRadioButton11.setText("No");
        jRadioButton11.setEnabled(false);

        jMemory1.setEnabled(false);

        jMemory2.setEnabled(false);

        jMemory3.setEnabled(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Issue", "Location", "Fixed By", "Fix Date", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel29.setText("Passcode");

        jLabel15.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel15.setText("Last Checkout");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Checkout Time", "Checkout Admin", "Checked out to", "Checkout Condition", "Return Time", "Return Admin", "Return Condition"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jBtn.setText("Edit");
        jBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(498, 498, 498))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSupplier, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jWeight, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCondition, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCost, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPurchaseDate, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jOS, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jModel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBarcode, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jWarranty, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jMemory1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jProcessor, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jMemory2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jMemory3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel19))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jBrand, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jColor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jIssues, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jGraphic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScreenSize, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jMemory, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(378, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton8)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton10)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton11))))
                            .addComponent(jLabel16)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(jBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jTitle)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jWarranty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jPurchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel21))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jGraphic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jIssues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jMemory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScreenSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jMemory2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jProcessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jMemory1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jMemory3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton4)
                        .addComponent(jRadioButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton8)
                        .addComponent(jRadioButton9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton10)
                        .addComponent(jRadioButton11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        System.out.println(jBtn.getText());
        if (jBtn.getText().equals("Edit")) {
            jCost.setEnabled(true);
            jCondition.setEnabled(true);
            jWeight.setEnabled(true);
            jSupplier.setEnabled(true);
            jTextField10.setEnabled(true);
            jBrand.setEnabled(true);
            jColor.setEnabled(true);
            jIssues.setEnabled(true);
            jGraphic.setEnabled(true);
            jMemory.setEnabled(true);
            jScreenSize.setEnabled(true);
            jWarranty.setEnabled(true);
            jBarcode.setEnabled(true);
            jProcessor.setEnabled(true);
            jModel.setEnabled(true);
            jOS.setEnabled(true);
            jPurchaseDate.setEnabled(true);
            jMemory1.setEnabled(true);
            jMemory2.setEnabled(true);
            jMemory3.setEnabled(true);
            jRadioButton4.setEnabled(true);
            jRadioButton5.setEnabled(true);
            jRadioButton6.setEnabled(true);
            jRadioButton7.setEnabled(true);
            jRadioButton8.setEnabled(true);
            jRadioButton9.setEnabled(true);
            jRadioButton10.setEnabled(true);
            jRadioButton11.setEnabled(true);
            jTextField22.setEnabled(true);

            jLabel12.setVisible(false);
            jLabel15.setVisible(false);
            jScrollPane1.setVisible(false);
            jScrollPane2.setVisible(false);

            jBtn.setText("Update");

        } else {
            double cost = Double.parseDouble(jCost.getText());
            double weight = Double.parseDouble(jWeight.getText());
            double screenSize = Double.parseDouble(jScreenSize.getText());
            backend.updateDeviceInformation(type, this.serialNumber, jSupplier.getText(), jPurchaseDate.getText(),
                                 jBarcode.getText(), jBrand.getText(), jCondition.getText(),
                                 jColor.getText(), cost, jIssues.getText(), jGraphic.getText(),
                                 jMemory.getText(), jModel.getText(), jProcessor.getText(), screenSize, jMemory1.getText(), jOS.getText(),
                                 jWarranty.getText(), jMemory1.getText(), weight, jTextField10.getText(), jMemory3.getText(),
                                 jTextField22.getText(), 
                                 jRadioButton4.isSelected(),
                                 jRadioButton6.isSelected(),
                                 jRadioButton8.isSelected(),
                                 jRadioButton10.isSelected());
            this.setVisible(false);
        }
    }                                         

    
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
            java.util.logging.Logger.getLogger(supply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supply.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new supply().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JTextField jBarcode;
    private javax.swing.JTextField jBrand;
    private javax.swing.JButton jBtn;
    private javax.swing.JTextField jColor;
    private javax.swing.JTextField jCondition;
    private javax.swing.JTextField jCost;
    private javax.swing.JTextField jGraphic;
    private javax.swing.JTextField jIssues;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jMemory;
    private javax.swing.JTextField jMemory1;
    private javax.swing.JTextField jMemory2;
    private javax.swing.JTextField jMemory3;
    private javax.swing.JTextField jModel;
    private javax.swing.JTextField jOS;
    private javax.swing.JTextField jProcessor;
    private javax.swing.JTextField jPurchaseDate;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JTextField jScreenSize;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jSupplier;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JLabel jTitle;
    private javax.swing.JTextField jWarranty;
    private javax.swing.JTextField jWeight;
    // End of variables declaration//GEN-END:variables
}
