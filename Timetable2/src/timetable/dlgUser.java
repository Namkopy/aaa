/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class dlgUser extends javax.swing.JDialog {

    /**
     * Creates new form dlgUser
     */
    public dlgUser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        clsCon.inti();        
        showData();
        lblEmpID.setVisible(false);
        lblConfirm.setVisible(false);
        lblAlertUName.setVisible(false);
        lblAlertPass.setVisible(false);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        inti();
        txtUsername.requestFocus();
         jtblUser.setDefaultEditor(Object.class,null);
    }
    void inti(){        
        cboEmpname.removeAllItems();
        try {    
                clsCon.setRs(clsCon.getStmt().executeQuery("select * from tblEmployee"));
                clsCon.getRs().first();
                 //   lblEmpID.setText(clsCon.getRs().getString("EmpID"));
                if(clsCon.getRs().first())
                    do{
                        cboEmpname.addItem(clsCon.getRs().getString("Name"));
                    }while(clsCon.getRs().next());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    void clear(){
        clsCon.clear(txtUsername);
        clsCon.clear(txtPass);
        clsCon.clear(txtcompass);
        cboEmpname.setSelectedIndex(0);
        txtUsername.requestFocus();  
        lblEmpID.setVisible(false);
        lblConfirm.setVisible(false);
    } 
    void checkData(){
        if(txtPass.getText().equals("")){
            lblAlertPass.setText("Please Fill");
            lblAlertPass.setVisible(true);
            txtPass.requestFocus();
        }
        else
            lblAlertPass.setVisible(false);
        if(txtUsername.getText().equals("")){
            lblAlertUName.setText("Please Fill.");
            lblAlertUName.setVisible(true);
            txtUsername.requestFocus();
        }
        else
            lblAlertUName.setVisible(false);
        // for JPassword: getText() is not recommand, but we can use it to get data
        if(!txtPass.getText().equals(txtcompass.getText())){   
            lblConfirm.setText("Your password is not confirm.");
            lblConfirm.setVisible(true);
            txtcompass.requestFocus();
            return;
        }
        else{
            lblConfirm.setText("aa");
            lblConfirm.setVisible(false);
        }
    }
//    public void CheckUpdate(){
//         try {            
//            clsCon.setRs(clsCon.getStmt().executeQuery("select UserName,Password from tblUser where EmpID='"+cboEmpname.getSelectedItem()+"'"));
//            clsCon.getRs().first();
//         }
//         catch(Exception ex){
//             ex.printStackTrace();
//         }
//    }
    void getEmpID(){
        try{
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from tblEmployee where Name='"+(String) cboEmpname.getSelectedItem()+"'"));
            clsCon.getRs().first();
            lblEmpID.setText(clsCon.getRs().getString("EmpID"));
        }
        catch(Exception e){}
    }
     void showData(){
        DefaultTableModel modeTbl;
        modeTbl = (DefaultTableModel)jtblUser.getModel();
       
        try {
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from qUser"));
            if(clsCon.getRs().first()){  
                do{
                    String name = clsCon.getRs().getString("Name");
                    String UName = clsCon.getRs().getString("UserName");
                    String st[]={name,UName};
                    
                    modeTbl.addRow(st);
                }while(clsCon.getRs().next());
            }
        } catch (Exception e) {
        }
    }
    String n="";
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboEmpname = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtcompass = new javax.swing.JPasswordField();
        txtPass = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblAlertUName = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblEmpID = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblAlertPass = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lblConfirm = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblUser = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(0, 255, 255));

        jLabel1.setFont(new java.awt.Font("Charlemagne Std", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("USER LOGIN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(397, 397, 397)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("User Name");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Employee Name");

        cboEmpname.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cboEmpname.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cboEmpname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEmpnameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Confirm Password");

        btnNew.setBackground(new java.awt.Color(51, 153, 255));
        btnNew.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setText("New");
        btnNew.setBorder(null);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(51, 153, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.setBorder(null);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(51, 153, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.setBorder(null);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(51, 153, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setBorder(null);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtcompass.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtcompass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcompassFocusLost(evt);
            }
        });

        txtPass.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("*");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("*");

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));

        lblAlertUName.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        lblAlertUName.setForeground(new java.awt.Color(255, 0, 51));
        lblAlertUName.setText("AlertUName");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAlertUName, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblAlertUName))
        );

        jPanel8.setBackground(new java.awt.Color(204, 255, 255));

        lblEmpID.setText("Employee ID");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(lblEmpID))
        );

        jPanel9.setBackground(new java.awt.Color(204, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(102, 31));

        lblAlertPass.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        lblAlertPass.setForeground(new java.awt.Color(255, 0, 51));
        lblAlertPass.setText("AlertPass");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAlertPass, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(lblAlertPass))
        );

        jPanel10.setBackground(new java.awt.Color(204, 255, 255));

        lblConfirm.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        lblConfirm.setForeground(new java.awt.Color(255, 0, 51));
        lblConfirm.setText("Confirm");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(lblConfirm))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(19, 19, 19)
                                        .addComponent(cboEmpname, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                                .addGap(45, 45, 45))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcompass, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnNew)
                                .addComponent(btnAdd))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnUpdate)
                                .addComponent(btnDelete)))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(cboEmpname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel7))
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtcompass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))))))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jtblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee", "User Name"
            }
        ));
        jtblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblUser);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 70, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            clsCon.getCon().close();
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            clsCon.getCon().close();
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_formWindowClosing

    private void jtblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblUserMouseClicked
        btnAdd.setEnabled(false);
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);

        int index = jtblUser.getSelectedRow();
        String Name = ""+jtblUser.getValueAt(index, 0); //EmpName
        String UName = ""+jtblUser.getValueAt(index, 1); //UserName
        //String pass = ""+jtblUser.getValueAt(index, 2); //Password
        cboEmpname.setSelectedItem(Name);
        txtUsername.setText(UName);
        n = UName;

    }//GEN-LAST:event_jtblUserMouseClicked

    private void txtPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusLost

    }//GEN-LAST:event_txtPassFocusLost

    private void txtcompassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcompassFocusLost

    }//GEN-LAST:event_txtcompassFocusLost

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
                if(jtblUser.getSelectedRow() == -1)
        return;
        getEmpID();
        if(txtUsername.getText().equals("Admin")||txtUsername.getText().equals("admin")){
            JOptionPane.showMessageDialog(this, "Cannot delete the admin record!");
            return;
        }
        if(JOptionPane.showConfirmDialog(this, "Do you want to delete?","Comfire",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            try{
                int index[] = jtblUser.getSelectedRows();
                clsCon.getStmt().execute("delete from tblUser where EmpID ='"+lblEmpID.getText()+"' and UserName = '"+txtUsername.getText()+"'");
                JOptionPane.showMessageDialog(this, "Delete is successful.");
                clear();

                DefaultTableModel modtable = (DefaultTableModel)jtblUser.getModel();
                for(int i=0; i<index.length; i++)
                modtable.removeRow(index[i]-i);
                if(jtblUser.getRowCount()==0){
                    btnAdd.setEnabled(true);
                    btnDelete.setEnabled(false);
                    btnUpdate.setEnabled(false);

                    cboEmpname.setSelectedIndex(0);
                }
            }catch(Exception e){

            }
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
                checkData();
        getEmpID();
        if(lblAlertUName.getText().equals("Please Fill")||lblAlertPass.getText().equals("Please Fill"))
        {
            return;
        }
        int index = jtblUser.getSelectedRow();
        if(index==-1)
            return;
        String  sql="update tblUser set UserName='"+txtUsername.getText()+"', Password='"+txtPass.getText()+"' where EmpID='"+lblEmpID.getText()+"' and UserName='"+n+"'";
        try {
            clsCon.getStmt().executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Update is successful");

            jtblUser.setValueAt(cboEmpname.getSelectedItem(), index, 0);
            jtblUser.setValueAt(txtUsername.getText(), index, 1);
            clear();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Cannot Update.");
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        checkData();
        if(lblAlertUName.getText().equals("Please Fill")||lblAlertPass.getText().equals("Please Fill")||lblConfirm.getText().equals("Your password is not confirm."))
        {
            return;
        }
        getEmpID();
        String sql = "insert into tblUser(EmpID,UserName,Password) values('"+lblEmpID.getText()+"','"+txtUsername.getText()+"','"+txtPass.getText()+"')";
        try {
            clsCon.getStmt().executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "A new record was saved");
            clear();

            DefaultTableModel modeTbl = (DefaultTableModel)jtblUser.getModel();
            clsCon.setRs(clsCon.getStmt().executeQuery("select * from qUser where EmpID='"+lblEmpID.getText()+"'"));

            clsCon.getRs().first();
            String name = clsCon.getRs().getString("Name");
            String UName = clsCon.getRs().getString("UserName");
            String st[]={name,UName};

            modeTbl.addRow(st);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        btnAdd.setEnabled(true);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);

        cboEmpname.setSelectedIndex(0);
        clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void cboEmpnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEmpnameActionPerformed

    }//GEN-LAST:event_cboEmpnameActionPerformed

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
            java.util.logging.Logger.getLogger(dlgUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgUser dialog = new dlgUser(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                        try {
                            clsCon.getCon().close();
                        } catch (SQLException ex) {
                        }
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboEmpname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblUser;
    private javax.swing.JLabel lblAlertPass;
    private javax.swing.JLabel lblAlertUName;
    private javax.swing.JLabel lblConfirm;
    private javax.swing.JLabel lblEmpID;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JPasswordField txtcompass;
    // End of variables declaration//GEN-END:variables
}
