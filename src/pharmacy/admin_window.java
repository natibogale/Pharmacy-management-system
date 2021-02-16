/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class admin_window extends javax.swing.JFrame {

    /**
     * Creates new form admin_window
     */
    @SuppressWarnings("PackageVisibleField")
   
     static String admin;
    public admin_window(String tx) {
        
        initComponents();
        setIcon();
        admin = tx.toUpperCase();
        jTextField13.setText(admin);
        jTextField13.setEditable(false);
        showProfile();
          UIManager ui = new UIManager();
         //ui.put("TabbedPane.background", Color.BLUE);
        //ui.put("Panel.background", Color.BLUE);
    }
    
    
    
         public void showProfile(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root","");
            Statement st = con.createStatement();
            
            String query = "select users.firstname,users.lastname,users.age,users.sex,users.email,users.phone,users.address,users.marital,"
                    + "users.username,users.passwd,users_description.qualification,users_description.salary,"
                    + "users_description.date_of_hire from users,users_description where users.username ="
                    + " '" + admin + "' and users.username = users_description.username";

            
            ResultSet rs = st.executeQuery(query);
            
            if(rs.next()){
               
                fnamep.setText(rs.getString(1));
                lnamep.setText(rs.getString(2));
                agep.setText(Integer.toString(rs.getInt(3)));
                sexp.setText(rs.getString(4));
                emailp.setText(rs.getString(5));
                phonep.setText(rs.getString(6));
                addressp.setText(rs.getString(7));
                maritalp.setText(rs.getString(8));
                usernp.setText(rs.getString(9));
                passwdp.setText(rs.getString(10));
                qualp.setText(rs.getString(11));
                salaryp.setText(Double.toString(rs.getDouble(12)));
                datep.setText(rs.getString(13));
                
                // getting the image of he user
                //byte[] img = rs.getBytes(15);
                //ImageIcon image = new ImageIcon(img);
                //Image im = image.getImage();
                //Image myImage = im.getScaledInstance(photo2.getWidth(), photo2.getHeight(), Image.SCALE_SMOOTH);
                
                //photo2.setIcon(new ImageIcon(myImage));
                
            }
            
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR ocurred while displaying profile", "NEWLIFE PHARMACEUTICALS", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }}
    
    
    public ArrayList<med> getmedlist(String b) throws ClassNotFoundException
    {
        ArrayList<med> medlist = new ArrayList<med>();
          String q= b;
        Statement st;
        ResultSet rs;
        try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root","");
      st = con.createStatement();
        rs=st.executeQuery(q);
        med run;
        
        while(rs.next())
        {
            run = new med(rs.getString("medicine_id"),rs.getString("medicine_name"),rs.getString("medicine_type"),rs.getString("dose"),Integer.parseInt(rs.getString("quantity")),Float.parseFloat(rs.getString("price")),rs.getString("expiration"),rs.getString("descrip"));
                medlist.add(run);
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            

        return medlist;
        
    }
    
    
   
            
      public ArrayList<sales> getsalelist(String b) throws ClassNotFoundException
    {
        ArrayList<sales> salelist = new ArrayList<sales>();
          String q= b;
        Statement st;
        ResultSet rs;
        try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root","");
      st = con.createStatement();
        rs=st.executeQuery(q);
        sales run;
        
        while(rs.next())
        {
            run = new sales(rs.getString("medicine_id"),Integer.parseInt(rs.getString("sold_quantity")),Float.parseFloat(rs.getString("total")),rs.getString("sold_by"),rs.getString("sold_on"));
                salelist.add(run);
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            

        return salelist;
        
    }      
            
            
    
    
    
    
    
    
    
    
    
       public ArrayList<employee> getemp(String b) throws ClassNotFoundException
    {
        ArrayList<employee> emplist = new ArrayList<employee>();
          String q= b;
        Statement st;
        ResultSet rss;
        try {
              Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root","");
      st = con.createStatement();
        rss=st.executeQuery(q);
        employee runn;
        
        while(rss.next())
        {
            runn = new employee(rss.getString("firstname"),rss.getString("lastname"),Integer.parseInt(rss.getString("age")),rss.getString("sex"),rss.getString("email"),rss.getString("phone"),rss.getString("address"),rss.getString("marital"),rss.getString("username"),rss.getString("passwd"),rss.getString("qualification"),Double.parseDouble(rss.getString("salary")),rss.getString("date_of_hire"),rss.getString("position"));
            emplist.add(runn);
            
               
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
        
        
        
        return emplist;
        
    }
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        sexp = new javax.swing.JTextField();
        lnamep = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        emailp = new javax.swing.JTextField();
        fnamep = new javax.swing.JTextField();
        phonep = new javax.swing.JTextField();
        addressp = new javax.swing.JTextField();
        usernp = new javax.swing.JTextField();
        maritalp = new javax.swing.JTextField();
        qualp = new javax.swing.JTextField();
        passwdp = new javax.swing.JTextField();
        salaryp = new javax.swing.JTextField();
        agep = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        datep = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        usern = new javax.swing.JTextField();
        passwd = new javax.swing.JTextField();
        salary = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        position = new javax.swing.JComboBox();
        jLabel39 = new javax.swing.JLabel();
        marital = new javax.swing.JComboBox();
        qual = new javax.swing.JComboBox();
        sex = new javax.swing.JComboBox();
        date = new datechooser.beans.DateChooserCombo();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        emptable = new javax.swing.JTable();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        empsearch = new javax.swing.JTextField();
        empbutton = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        medtable = new javax.swing.JTable();
        medsearch = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        med4 = new javax.swing.JTextField();
        med1 = new javax.swing.JTextField();
        med2 = new javax.swing.JTextField();
        med6 = new javax.swing.JTextField();
        med5 = new javax.swing.JTextField();
        med3 = new javax.swing.JComboBox();
        jButton10 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        med8 = new javax.swing.JTextPane();
        med7 = new datechooser.beans.DateChooserCombo();
        jPanel2 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        medtable1 = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NEWLIFE PHARMACEUTICALS-ADMIN WINDOW");
        setResizable(false);

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane3.setToolTipText("");
        jTabbedPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTabbedPane3MouseEntered(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WELCOME TO NEWLIFE PHARMACEUTICALS");

        jLabel14.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("DEAR ADMIN");

        jTextField13.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton4.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_logout_rounded_up_37px_1.png"))); // NOI18N
        jButton4.setText("LOG OUT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("All User's table metadata ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("Column Label");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setText("Table Name");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setText("Column Count");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setText("Column Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(282, 282, 282)
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(297, 297, 297)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(92, 92, 92)
                                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane3.addTab("WELCOME", new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_enter_2_37px.png")), jPanel1); // NOI18N

        jPanel10.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel10ComponentShown(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel15.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel15.setText("SEX:");
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 40, 30));

        jLabel16.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel16.setText("LAST NAME: ");
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 80, 30));

        jLabel17.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel17.setText("AGE:");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 60, 30));

        jLabel18.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel18.setText("QUALIFICATION:");
        jPanel10.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 110, 30));

        jLabel19.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel19.setText("MARITAL:");
        jPanel10.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 60, 30));

        jLabel20.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel20.setText("EMAIL:");
        jPanel10.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 60, 30));

        sexp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexpActionPerformed(evt);
            }
        });
        jPanel10.add(sexp, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 60, 30));
        jPanel10.add(lnamep, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 180, 30));

        jLabel22.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel22.setText("USER NAME:");
        jPanel10.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 90, 30));

        jLabel23.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel23.setText("PASSWORD:");
        jPanel10.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 90, 30));

        jLabel24.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel24.setText("SALARY:");
        jPanel10.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 90, 30));

        jLabel25.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel25.setText("PHONE NUM:");
        jPanel10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 90, 30));

        jLabel34.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel34.setText("ADDRESS:");
        jPanel10.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 80, 30));

        jLabel37.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel37.setText("FIRST NAME: ");
        jPanel10.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 90, 30));
        jPanel10.add(emailp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 240, 30));
        jPanel10.add(fnamep, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 180, 30));

        phonep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonepActionPerformed(evt);
            }
        });
        jPanel10.add(phonep, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 180, 30));

        addressp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addresspActionPerformed(evt);
            }
        });
        jPanel10.add(addressp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 180, 30));
        jPanel10.add(usernp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 180, 30));
        jPanel10.add(maritalp, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 180, 30));
        jPanel10.add(qualp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 180, 30));

        passwdp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwdpActionPerformed(evt);
            }
        });
        jPanel10.add(passwdp, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 180, 30));

        salaryp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salarypActionPerformed(evt);
            }
        });
        jPanel10.add(salaryp, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 80, 30));

        agep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agepActionPerformed(evt);
            }
        });
        jPanel10.add(agep, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 70, 30));

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_update_left_rotation_30px.png"))); // NOI18N
        jButton1.setText("UPDATE");
        jButton1.setToolTipText("update values you edited");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, 150, 90));

        jLabel38.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel38.setText("DATE OF HIRE:");
        jPanel10.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 110, 30));
        jPanel10.add(datep, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 180, 30));

        jTabbedPane3.addTab("PROFILE", new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_user_male_circle_37px_1.png")), jPanel10, "view and update profile"); // NOI18N

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel1.setText("SEX:");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 40, 30));

        jLabel3.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel3.setText("LAST NAME: ");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 80, 30));

        jLabel4.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel4.setText("AGE:");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 60, 30));

        jLabel5.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel5.setText("QUALIFICATION:");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 110, 30));

        jLabel6.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel6.setText("MARITAL:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 60, 30));

        jLabel7.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel7.setText("EMAIL:");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 60, 30));
        jPanel5.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 180, 30));

        jLabel8.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel8.setText("USER NAME:");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 90, 30));

        jLabel9.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel9.setText("POSITION:");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 90, 30));

        jLabel10.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel10.setText("SALARY:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 90, 30));

        jLabel11.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel11.setText("PHONE NUM:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 90, 30));

        jLabel12.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel12.setText("ADDRESS:");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 80, 30));

        jLabel13.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel13.setText("FIRST NAME: ");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, 30));
        jPanel5.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 240, 30));
        jPanel5.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 180, 30));

        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });
        jPanel5.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 180, 30));

        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel5.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 180, 30));
        jPanel5.add(usern, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 180, 30));

        passwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwdActionPerformed(evt);
            }
        });
        jPanel5.add(passwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 180, 30));

        salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryActionPerformed(evt);
            }
        });
        jPanel5.add(salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 80, 30));

        age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageActionPerformed(evt);
            }
        });
        jPanel5.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 70, 30));

        jLabel36.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel36.setText("DATE OF HIRE:");
        jPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, 30));

        add.setBackground(new java.awt.Color(204, 204, 204));
        add.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_add_37px_1.png"))); // NOI18N
        add.setText("ADD");
        add.setToolTipText("add entered values");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel5.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 410, 120, 50));

        jButton18.setBackground(new java.awt.Color(204, 204, 204));
        jButton18.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_clear_symbol_37px.png"))); // NOI18N
        jButton18.setText("CLEAR");
        jButton18.setToolTipText("clear all fields");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 130, 50));

        position.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 11)); // NOI18N
        position.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT POSITION", "ADMIN", "EMPLOYEE" }));
        jPanel5.add(position, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 150, 30));

        jLabel39.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel39.setText("PASSWORD:");
        jPanel5.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 90, 30));

        marital.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 11)); // NOI18N
        marital.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select option", "Married", "Single" }));
        jPanel5.add(marital, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 130, 30));

        qual.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 11)); // NOI18N
        qual.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Option", "B.Sc Degree", "Diploma", "Certificate" }));
        qual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qualActionPerformed(evt);
            }
        });
        jPanel5.add(qual, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 130, 30));

        sex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT", "MALE", "FEMALE" }));
        jPanel5.add(sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 70, -1));

        date.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    date.setWeekStyle(datechooser.view.WeekDaysStyle.FULL);

    org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, date, org.jdesktop.beansbinding.ELProperty.create("dd/MM/yyyy"), date, org.jdesktop.beansbinding.BeanProperty.create("dch_combo_dateFormat"));
    bindingGroup.addBinding(binding);

    jPanel5.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 160, 30));

    jTabbedPane3.addTab("ADD EMPLOYEE", new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_add_37px_1.png")), jPanel5, "view and update profile"); // NOI18N

    jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    jPanel6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

    emptable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "FIRST NAME", "LAST NAME", "AGE", "SEX", "E-MAIL", "PHONE", "ADDRESS", "MARITAL", "USER NAME", "PASSWORD", "QUALIFICATION", "SALARY", "DATE OF HIRE", "POSITION"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false, false, false, false, false, true, true, true, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    emptable.getTableHeader().setReorderingAllowed(false);
    jScrollPane1.setViewportView(emptable);

    jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 860, 380));

    jButton19.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
    jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_update_left_rotation_30px.png"))); // NOI18N
    jButton19.setText("UPDATE");
    jButton19.setToolTipText("update edited row");
    jButton19.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton19ActionPerformed(evt);
        }
    });
    jPanel6.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 460, 150, 50));

    jButton20.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
    jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_remove_administrator_37px.png"))); // NOI18N
    jButton20.setText("REMOVE");
    jButton20.setToolTipText("update edited row");
    jButton20.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton20ActionPerformed(evt);
        }
    });
    jPanel6.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 150, 50));

    empsearch.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            empsearchActionPerformed(evt);
        }
    });
    jPanel6.add(empsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 210, 30));

    empbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_37px.png"))); // NOI18N
    empbutton.setToolTipText("search sale records");
    empbutton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            empbuttonActionPerformed(evt);
        }
    });
    jPanel6.add(empbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 50, 40));

    jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel45.setText("Search");
    jPanel6.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 70, 20));

    jTabbedPane3.addTab("VIEW EMPLOYEES", new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_view_file_37px.png")), jPanel6, "view and update profile"); // NOI18N

    jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    medtable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Id", "Medicine Name", "Type", "Dose", "Quantity", "Price", "Expiration date"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, true, true, true, true
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    medtable.setToolTipText("you can edit the dose and quantity here");
    medtable.getTableHeader().setReorderingAllowed(false);
    medtable.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
        public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
            medtableMouseWheelMoved(evt);
        }
    });
    jScrollPane5.setViewportView(medtable);

    jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 630, 320));

    medsearch.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            medsearchActionPerformed(evt);
        }
    });
    jPanel3.add(medsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 210, 30));

    jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_37px.png"))); // NOI18N
    jButton8.setToolTipText("search sale records");
    jButton8.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton8ActionPerformed(evt);
        }
    });
    jPanel3.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 50, 40));

    jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jLabel21.setText("Search");
    jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 70, 20));

    jButton14.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
    jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_delete_37px.png"))); // NOI18N
    jButton14.setText("REMOVE");
    jButton14.setToolTipText("update edited row");
    jButton14.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton14ActionPerformed(evt);
        }
    });
    jPanel3.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, 140, 50));

    jButton17.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
    jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_update_left_rotation_30px.png"))); // NOI18N
    jButton17.setText("UPDATE");
    jButton17.setToolTipText("update edited row");
    jButton17.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton17ActionPerformed(evt);
        }
    });
    jPanel3.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, 140, 50));

    jTabbedPane1.addTab("VIEW MEDICINES", new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_pill_20px.png")), jPanel3); // NOI18N

    jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel29.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
    jLabel29.setText("MEDICINE ID:");
    jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 110, 30));

    jLabel28.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
    jLabel28.setText("MEDICINE NAME:");
    jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 140, 30));

    jLabel27.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
    jLabel27.setText("MEDICINE TYPE:");
    jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 150, 30));

    jLabel26.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
    jLabel26.setText("DOSE:");
    jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 110, 30));

    jLabel31.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
    jLabel31.setText("QUANTITY:");
    jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 110, 30));

    jLabel30.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
    jLabel30.setText("PRICE:");
    jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 110, 30));

    jLabel33.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
    jLabel33.setText("EXPIRATION DATE:");
    jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 140, 30));

    jLabel32.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
    jLabel32.setText("DESCRIPTION AND HOW TO USE:");
    jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 260, 30));

    med4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            med4ActionPerformed(evt);
        }
    });
    jPanel4.add(med4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 100, 40));

    med1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            med1ActionPerformed(evt);
        }
    });
    jPanel4.add(med1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 230, 40));
    jPanel4.add(med2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 230, 40));
    jPanel4.add(med6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 100, 40));
    jPanel4.add(med5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 150, 40));

    med3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT ITEM", "PILL", "INJECTION", "SYRUP", "CREAM", "OTHER" }));
    jPanel4.add(med3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 120, 30));

    jButton10.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
    jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_add_50px.png"))); // NOI18N
    jButton10.setText("ADD");
    jButton10.setToolTipText("add new medicine");
    jButton10.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton10ActionPerformed(evt);
        }
    });
    jPanel4.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, 120, 50));

    jScrollPane2.setViewportView(med8);

    jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 210, 110));
    jPanel4.add(med7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 170, 30));

    jTabbedPane1.addTab("ADD NEW MEDS", new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_add_20px_1.png")), jPanel4); // NOI18N

    jPanel7.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 520));

    jTabbedPane3.addTab("UPDATE STOCK", new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_filing_cabinet_filled_37px.png")), jPanel7, "view and update stock"); // NOI18N

    jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jPanel2MouseClicked(evt);
        }
    });
    jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jButton15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_37px.png"))); // NOI18N
    jButton15.setText("VIEW");
    jButton15.setToolTipText("search sale records");
    jButton15.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton15ActionPerformed(evt);
        }
    });
    jPanel2.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 220, 40));

    medtable1.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Id", "Quantity", "Total in birr", "Sold by", "Sold on"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    medtable1.setToolTipText("you can edit the dose and quantity here");
    medtable1.getTableHeader().setReorderingAllowed(false);
    medtable1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
        public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
            medtable1MouseWheelMoved(evt);
        }
    });
    jScrollPane6.setViewportView(medtable1);

    jPanel2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 870, 210));

    jLabel35.setText("DB username");
    jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 140, 40));
    jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 180, 40));
    jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 180, 40));

    jLabel40.setText("Driver version");
    jPanel2.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 140, 40));

    jLabel41.setText("Driver name");
    jPanel2.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 140, 40));
    jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 180, 40));

    jLabel42.setText("DB product name");
    jPanel2.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 140, 40));
    jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, 180, 40));

    jLabel43.setText("DB product version");
    jPanel2.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 140, 40));
    jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 180, 40));

    jTabbedPane3.addTab("SALE RECORDS", new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_dossier_37px_1.png")), jPanel2, "view sale records"); // NOI18N

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    bindingGroup.bind();

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void passwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwdActionPerformed

    private void salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salaryActionPerformed

    private void ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageActionPerformed

    private void medtableMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_medtableMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_medtableMouseWheelMoved

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
         DefaultTableModel d = (DefaultTableModel) medtable.getModel();
       d.setRowCount(0);
        if(medsearch.getText().equals(""))
        {
                try {
            // TODO add your handling code here:
            ArrayList<med> list;
            String b = "Select * from medicines";
            list = getmedlist(b);
            
            DefaultTableModel model = (DefaultTableModel)medtable.getModel();
            Object[] row = new Object[8];
            
            for(int i=0;i<list.size();i++)
            {
                System.out.println(list.get(i).getId());
                row[0] = list.get(i).getId();
                row[1] = list.get(i).getMedname();
                row[2] = list.get(i).getType();
                row[3] = list.get(i).getDose();
                row[4] = list.get(i).getQuantity();
                row[5] = list.get(i).getPrice();
                row[6] = list.get(i).getExpiration();
                row[7] = list.get(i).getDescription();
                model.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
        }   
        }
        
        
        else
        {
             
            String a= medsearch.getText();
       
            String b ="SELECT * FROM medicines WHERE medicine_name LIKE '%"+ a +"%' OR medicine_id LIKE '%"+ a +"%' ";
            try {
                // TODO add your handling code here:
                ArrayList<med> list; 
                
                list = getmedlist(b);
                
                DefaultTableModel model = (DefaultTableModel)medtable.getModel();
                   int rc = model.getRowCount();
              
                Object[] row = new Object[8];
           
             
               
                for(int i=0;i<list.size();i++)
                {
                    
                    //System.out.println(list.get(i).getId());
                    row[0] = list.get(i).getId();
                    row[1] = list.get(i).getMedname();
                    row[2] = list.get(i).getType();
                    row[3] = list.get(i).getDose();
                    row[4] = list.get(i).getQuantity();
                    row[5] = list.get(i).getPrice();
                    row[6] = list.get(i).getExpiration();
                    row[7] = list.get(i).getDescription();
                    model.addRow(row);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
            }
      
       if(d.getRowCount()==0)
       {
             JOptionPane.showMessageDialog(null,"Medicine not found!","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);
       }
            
            
        }
         
            
        
       
        
        
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
                               JFrame frame = new JFrame("Exit");
       
     if(JOptionPane.showConfirmDialog(frame, "Do you want to remove meds ?","Newlife Pharmaceuticals",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
     {
        if(medtable.getRowCount()==0)
        {
             JOptionPane.showMessageDialog(null,"No items in the table to update","Newlife Pharmaceuticals",JOptionPane.YES_NO_OPTION);
        }
        else if(medtable.getRowCount()>0)
        {
          
            
              try {
                  Class.forName("com.mysql.jdbc.Driver");
                  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root","");
                  
                  
                  String aq=null;
                  
                  
                  Statement stm12=con.createStatement();
                  
                  
                  DefaultTableModel tm =(DefaultTableModel)medtable.getModel();
                  
                  int ed = medtable.getSelectedRow();
                  Object q = tm.getValueAt(ed,0);
                  
                  
                  
  
                  aq=(String) q;
                    String sq3="delete from medicines where medicine_id = '"+ aq +"'";
                    stm12.executeUpdate(sq3);
                    tm.removeRow(ed); JOptionPane.showMessageDialog(null, "Removed successful", "NEWLIFE PHARMACEUTICALS", JOptionPane.INFORMATION_MESSAGE);
                    
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
              } catch (SQLException ex) {
                  Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
              }
        }
     }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void med4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_med4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_med4ActionPerformed

    private void med1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_med1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_med1ActionPerformed

    private void jTabbedPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane3MouseClicked
        try {
            // TODO add your ha0000ndling code here:
            
                 Class.forName("com.mysql.jdbc.Driver");
                  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root","");
                  
                  
            DatabaseMetaData dbmd=con.getMetaData();
            
            System.out.println("Driver Name: "+dbmd.getDriverName());
            
            
            jTextField3.setText(dbmd.getDriverName());
            
            System.out.println("Driver Version: "+dbmd.getDriverVersion());
            
            jTextField2.setText(dbmd.getDriverVersion());
            
            System.out.println("UserName: "+dbmd.getUserName());
            
             jTextField1.setText(dbmd.getUserName());
             
            System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());
            
            jTextField4.setText(dbmd.getDatabaseProductName());
            
            System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
            
             jTextField5.setText(dbmd.getDatabaseProductVersion());
              
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTabbedPane3MouseClicked

    private void jTabbedPane3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane3MouseEntered

    public boolean validat()
    {
        if(lname.getText().equals("")||fname.getText().equals("")||usern.getText().equals("")||passwd.getText().equals("")
                || salary.getText().equals("")||sex.getSelectedItem().equals("SELECT")||age.getText().equals("")||address.getText().equals("")
                ||qual.getSelectedItem().equals("Select Option")||phone.getText().equals("")|| position.getSelectedItem().toString().equals("SELECT POSITION"))
                
                

        {
            return false;
        }
        else
        {
               return true;
        }
              
       
    }
    
   
   
    
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
         try {
                                     
                            if(validat()){
                             Class.forName("com.mysql.jdbc.Driver");
                             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root","");
                             Statement stm=con.createStatement();
                             String sql = "Insert into users values (?,?,?,?,?,?,?,?,?,?,?)";
                             PreparedStatement st = con.prepareStatement(sql);
                            
                             st.setString(2, fname.getText());
                              st.setString(3, lname.getText());
                            
                                    st.setString(5, sex.getSelectedItem().toString());
                             
                             try
                             {
                                 
                             
                                myex.exception(age.getText());
                                
                                st.setInt(4, Integer.parseInt(age.getText()));
                                 
                     
                              
                             }
                             catch(myex q)
                             {
                                 JOptionPane.showMessageDialog(null,"Only numbers are allowed for age \n Enter again","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);
                             }
                              st.setString(6, email.getText());
                             st.setString(7, phone.getText());
                              st.setString(8, address.getText());
                              if(marital.getSelectedItem().toString()=="Select option")
                              {
                                   st.setString(9, "UNKNOWN");
                              }
                              else
                              {
                                    st.setString(9, marital.getSelectedItem().toString());
                              }
                              
                             
                               String checker = usern.getText();
                                
                                 String check = "Select username from users where username = '"+checker+"'";
                                 Statement stc = con.createStatement();
                                 
                                ResultSet ck = stc.executeQuery(check);
                              if(ck.next())
                              {
                                   JOptionPane.showMessageDialog(null,"Username already exists! \n Enter again","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);
                                   
                              }
                              else
                              {
        
                                  st.setString(1, usern.getText());
                                  String ab = position.getSelectedItem().toString();
                                   if(ab.equals("ADMIN"))
                         {
                                  st.setInt(10, 1);
                         }
                                   else if(ab.equals("EMPLOYEE"))
                                   {
                                       st.setInt(10, 0);
                                   }
                       
                              }
                        
                             st.setString(11, passwd.getText());
                               
                                   String sl = "Insert into users_description values (?,?,?,?,?)";
                             PreparedStatement pt = con.prepareStatement(sl);
                             
                            
                                   pt.setString(1, usern.getText());
                                   
                                    pt.setString(2, qual.getSelectedItem().toString());
                             
                              if(salary.getText().matches("^\\d+(\\.\\d+)?"))
                              {
                                  pt.setDouble(3, Double.parseDouble(salary.getText()));
                                 
                              }
                              else
                              {
                                   
                                   JOptionPane.showMessageDialog(null,"Only numbers are allowed for salary \n Enter again","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);
                              }
                               
                             pt.setString(4, date.getText());
                              
                             pt.setString(5, position.getSelectedItem().toString());
                             st.executeUpdate();
                              pt.executeUpdate();
                             JOptionPane.showMessageDialog(null,"Adding succesfull","Newlife Pharmaceuticals",JOptionPane.INFORMATION_MESSAGE);
                            }    
                            else
                            {
                                JOptionPane.showMessageDialog(null, "One or more fields are empty or unselected","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);
                            }
                             
         }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null, "Adding not successful","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
         }
        
    }//GEN-LAST:event_addActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your han0dling code here:
        //setVisible(false);
        
              JFrame frame = new JFrame("Exit");
       
     if(JOptionPane.showConfirmDialog(frame, "Do you want to log out?","Newlife Pharmaceuticals",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
     {
               dispose();
        login1 ui = new login1();
        ui.setVisible(true);
     }
     
            //JOptionPane.showMessageDialog(null,"Do you want to log out?","New Life Pharmaceuticals",JOptionPane.YES_OPTION);
       
        

      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void sexpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexpActionPerformed

    private void phonepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonepActionPerformed

    private void addresspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addresspActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addresspActionPerformed

    private void passwdpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwdpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwdpActionPerformed

    private void salarypActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salarypActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salarypActionPerformed

    private void agepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agepActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         JFrame frame = new JFrame("Exit");
       
     if(JOptionPane.showConfirmDialog(frame, "Do you want to update your profile ?","Newlife Pharmaceuticals",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
     {
       
             try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root","");
                String sql = "UPDATE users SET firstname = ?, lastname = ?, age = ?, email = ?, phone = ?, "
                        + "address = ?, marital = ?,passwd = ?"
                        + " where username = '" + jTextField13.getText()+"'";
                //String sql2 = "UPDATE users SET password = ?, qualification = ?, salary = ?, picture = ? where username = '" + jTextField13.getText()+"'";
                PreparedStatement st = con.prepareStatement(sql);
                
                //MyException.validateName(jTextField18.getText());
                st.setString(1, fnamep.getText());
                
                //MyException.validateName(jTextField16.getText());
                st.setString(2, lnamep.getText());
                
                //MyException.validateAge(jTextField27.getText());
                st.setInt(3, Integer.parseInt(agep.getText()));
                
                //MyException.validateEmail(jTextField17.getText());
                st.setString(4, emailp.getText());
                
                st.setString(5, phonep.getText());
                st.setString(6, addressp.getText());
                st.setString(7, maritalp.getText());
                st.setString(8, passwdp.getText());
                st.executeUpdate();
                
                String h = "UPDATE users_description SET qualification =?"
                      + " where username = '" + jTextField13.getText()+"'";
                PreparedStatement sp = con.prepareStatement(h);
                sp.setString(1, qualp.getText());
                
              sp.executeUpdate();
            
                JOptionPane.showMessageDialog(null, "Update was successful", "NEWLIFE PHARMACEUTICALS", JOptionPane.INFORMATION_MESSAGE);
                
        } catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fields are blank for update", "NEWLIFE PHARMACEUTICALS", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        
                           JFrame frame = new JFrame("Exit");
       
     if(JOptionPane.showConfirmDialog(frame, "Do you want to update user profile ?","Newlife Pharmaceuticals",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
     {
        
                   if(emptable.getRowCount()==0)
        {
             JOptionPane.showMessageDialog(null,"No items in the table to update","Newlife Pharmaceuticals",JOptionPane.YES_NO_OPTION);
        }
        else if(emptable.getRowCount()>0)
        {
          
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root","");
              
                
                String pass=null;
                String qua=null;
                String sal=null;
                String posi=null;
                String aq=null;
          
                
                  Statement stm2=con.createStatement();
                  Statement stm3=con.createStatement();
          
                 Statement stm4=con.createStatement();
                 Statement stm5=con.createStatement();
                for(int i=0;i<emptable.getRowCount();i++)
                {
                DefaultTableModel tm =(DefaultTableModel)emptable.getModel();
                
                 Object pa = tm.getValueAt(i,9);
                  Object qu = tm.getValueAt(i,10);
                   Object sa = tm.getValueAt(i,11);
                    Object po = tm.getValueAt(i,13);
                    Object q = tm.getValueAt(i,8);
                  
                 
                   
                  
                 pass=(String) pa;
                 qua=(String) qu;
                 sal=String.valueOf(sa);
                 posi=(String) po;
                 aq=(String) q;
                   
                
               
               
               
                 
                 String sq3="update users set passwd = '"+ pass +"' where username= '"+aq+"'";
                 String sq4 = "update users_description set qualification = '"+qua+"' where username= '"+aq+"'";
                 String sql2 = "update users_description set salary = '"+sal+"' where username= '"+aq+"'";
                 String sql5 = "update users_description set position = '"+posi+"' where username= '"+aq+"'";
                   try
                  {
                     Double aw = Double.parseDouble(sal);
                  }
                  catch(Exception e)
                  {
                       JOptionPane.showMessageDialog(null,"Salary can only be a number","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);
                  }
                stm2.executeUpdate(sql2);
                stm3.executeUpdate(sq3);
               stm4.executeUpdate(sq4);
                }
                                JOptionPane.showMessageDialog(null, "Update was successful", "NEWLIFE PHARMACEUTICALS", JOptionPane.INFORMATION_MESSAGE);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(employeew.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(employeew.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           
        }
    }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        
        
                           JFrame frame = new JFrame("Exit");
       
     if(JOptionPane.showConfirmDialog(frame, "Do you want to remove this account ?","Newlife Pharmaceuticals",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
     {
      
          if(emptable.getRowCount()==0)
        {
             JOptionPane.showMessageDialog(null,"No items in the table to remove","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);
        }
        
          else if(emptable.getRowCount()>0)
        {
            
          if(emptable.getSelectedRow()<0)
              {
                  JOptionPane.showMessageDialog(null,"No items is selected ","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);
              }
                  else
                  {
           // JOptionPane.showConfirmDialog(null,"No items is selected ","Newlife Pharmaceuticals",JOptionPane.YES_NO_OPTION);
              try {
                  Class.forName("com.mysql.jdbc.Driver");
                  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root","");
                  
                  
                  String aq=null;
                  
                  
                  Statement stm12=con.createStatement();
                  
                    Statement sa=con.createStatement();
                  DefaultTableModel tm =(DefaultTableModel)emptable.getModel();
                  
                  int ed = emptable.getSelectedRow();
                  Object q = tm.getValueAt(ed,8);
                  aq=(String) q;
                  
                  
                  
                  
  
             
//                    String sq3="delete from users where username = '"+ aq +"'";
//               
//                    stm12.executeUpdate(sq3);
                  
                  
                  //Stored Procedure
                  
                  
                     String procedure = "{CALL deleteUser(?)}";
                    CallableStatement cs = con.prepareCall(procedure);
                    cs.setString(1, aq);
                    cs.executeUpdate();
                  

                    
     
                    tm.removeRow(ed);
                    
                     JOptionPane.showMessageDialog(null, "Removed successfully", "NEWLIFE PHARMACEUTICALS", JOptionPane.INFORMATION_MESSAGE);
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
              } catch (SQLException ex) {
                  Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
              }
        }}
                
               
               
               
    
    }
        
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
         try{
           
              if(med1.getText().equals("")||med5.getText().equals("") || med6.getText().equals("") || med7.getText().equals("") || med8.getText().equals("")||med4.getText().equals("") || med3.getSelectedItem().equals("SELECT ITEM")||med2.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Make sure all fields are filled or selected!","Newlife Pharmaceuticals",JOptionPane.INFORMATION_MESSAGE);
            }
              else
              {
       
                 
             
                   Class.forName("com.mysql.jdbc.Driver");
                             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root","");
                             Statement stm=con.createStatement();
                             String sql = "Insert into medicines values (?,?,?,?,?,?,?,?)";
                             PreparedStatement st = con.prepareStatement(sql);
                             
                             
                               String checker = med1.getText();
                                
                                 String check = "Select medicine_id from medicines where medicine_id = '"+checker+"'";
                                 Statement stc = con.createStatement();
                                ResultSet ck = stc.executeQuery(check);
                              if(ck.next())
                              {
                                   JOptionPane.showMessageDialog(null,"Medicine already exists! \n Enter again","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);
                                  
                              }
                              else
                              {
                              st.setString(1, med1.getText());
                              }
                             
                             
                             
                             
                             
                             st.setString(2, med2.getText());
                           
                           
                             st.setString(3, med3.getSelectedItem().toString());
                                     
                     
                             st.setString(4, med4.getText());
                            
                               if(med5.getText().matches("^\\d+(\\.\\d+)?"))
                             {
                                 st.setInt(5, Integer.parseInt(med5.getText()));
                             }
                             else
                             {
                                JOptionPane.showMessageDialog(null,"Enter number for quantity value! \n Enter again","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);  
                             }
                             
                             
                             
                             if(med6.getText().matches("^\\d+(\\.\\d+)?"))
                             {
                                 st.setFloat(6, Float.parseFloat(med6.getText()));
                             }
                             else
                             {
                                JOptionPane.showMessageDialog(null,"Enter number for price value! \n Enter again","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);  
                             }
                             
                             st.setString(7, med7.getText());
                             st.setString(8, med8.getText());
                             st.executeUpdate();
                            
                                  med1.setText("");med5.setText("");
      med6.setText(""); med7.setText("");
      med8.setText("");med4.setText("");
      med3.setSelectedItem("SELECT ITEM");
      med2.setText("");
       JOptionPane.showMessageDialog(null, "Add was successful", "NEWLIFE PHARMACEUTICALS", JOptionPane.INFORMATION_MESSAGE);
              }
        }
        catch(Exception e)
        {
             
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        lname.setText(""); fname.setText(""); usern.setText(""); passwd.setText(""); email.setText(""); salary.setText(""); 
        age.setText("");address.setText(""); phone.setText(""); qual.setSelectedItem("Select Option");sex.setSelectedItem("SELECT");
        marital.setSelectedItem("Select option");position.setSelectedItem("SELECT POSITION");
       /* photo.setIcon(new ImageIcon("manager.png"))*/;    
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        
                              JFrame frame = new JFrame("Exit");
       
     if(JOptionPane.showConfirmDialog(frame, "Do you want to update meds ?","Newlife Pharmaceuticals",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
     {
        
           if(medtable.getRowCount()==0)
        {
             JOptionPane.showMessageDialog(null,"No items in the table to update","Newlife Pharmaceuticals",JOptionPane.YES_NO_OPTION);
        }
        else if(medtable.getRowCount()>0)
        {
          
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root","");
                
                con.setAutoCommit(false);
                
                String dose=null;
                String exp=null;
                String price=null;
                String quan=null;
                String aq=null;
          
                 Statement stm=con.createStatement();
                 
                
            
                for(int i=0;i<medtable.getRowCount();i++)
                {
                DefaultTableModel tm =(DefaultTableModel)medtable.getModel();
                Object d = tm.getValueAt(i,3);
                 Object e = tm.getValueAt(i,4);
                  Object f = tm.getValueAt(i,5);
                   Object g = tm.getValueAt(i,6);
                    Object q = tm.getValueAt(i,0);
                  
                   dose = (String) d;
                   
               
                   
                  
               
                   quan= String.valueOf(e);
                   price = String.valueOf(f);
                   exp = (String) g;
                   aq = (String) q;
                   
                   
                   
                 String sql = "update medicines set dose = '"+ dose +"' where medicine_id= '"+aq+"'";
                 String sq3="update medicines set expiration = '"+ exp +"' where medicine_id= '"+aq+"'";
                    String sq4 = "update medicines set quantity = '"+quan+"' where medicine_id= '"+aq+"'";
                 String sqll = "update medicines set price = '"+price+"' where medicine_id= '"+aq+"'";
                 
                 
                 
                     try
                  {
                     int qu = Integer.parseInt(quan);
                  }
                  catch(Exception eqa)
                  {
                       JOptionPane.showMessageDialog(null,"Quantity can only be a number","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);
                  }
                         try
                  {
                     float qu = Float.parseFloat(price);
                  }
                  catch(Exception eqa)
                  {
                       JOptionPane.showMessageDialog(null,"Price can only be a number","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);
                  }
//Batch Processing
                stm.addBatch(sql);
                stm.addBatch(sqll);
                stm.addBatch(sq3);
               stm.addBatch(sq4);
               stm.executeBatch();
               
               con.commit();
                }
                
                                JOptionPane.showMessageDialog(null, "Update was successful", "NEWLIFE PHARMACEUTICALS", JOptionPane.INFORMATION_MESSAGE);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(employeew.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(employeew.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           
        }
     }
    }//GEN-LAST:event_jButton17ActionPerformed
 public void clear2(int ps)
    {
        DefaultTableModel dm = (DefaultTableModel) emptable.getModel();
        int coun = ps;
        for(int i=coun-1;i>=0;i--)
        {
            dm.removeRow(i);
        }
    }
    private void empbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empbuttonActionPerformed
        DefaultTableModel d = (DefaultTableModel) emptable.getModel();
        int qw = d.getRowCount();
       clear2(qw);
            if(empsearch.getText().equals(""))
        {
                try {
            // TODO add your handling code here:
            ArrayList<employee> list;
            String b = "select users.firstname,users.lastname,users.age,users.sex,users.email,users.phone,"
                    + "users.address,users.marital,users.username,users.passwd, users_description.qualification,"
                    + "users_description.salary,users_description.date_of_hire,users_description.position "
                    + "from users,users_description where users.username = users_description.username;";
            list = getemp(b);
            
            DefaultTableModel model = (DefaultTableModel)emptable.getModel();
            Object[] row = new Object[14];
            
            for(int i=0;i<list.size();i++)
            {
                //System.out.println(list.get(i).getId());
                row[0] = list.get(i).getFirst();
                row[1] = list.get(i).getLast();
                row[2] = list.get(i).getAge();
                row[3] = list.get(i).getSex();
                row[4] = list.get(i).getEmail();
                row[5] = list.get(i).getPhone();
                row[6] = list.get(i).getAddress();
                row[7] = list.get(i).getMarital();
                row[8] = list.get(i).getUsern();
                row[9] = list.get(i).getPasswd();
                row[10] = list.get(i).getQual();
                row[11] = list.get(i).getSalary();
                row[12] = list.get(i).getDoh();
                row[13] = list.get(i).getPosition();
                
                model.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
        }   
        }
        
        
        else
        {
             
            String a= empsearch.getText();
       
            String b ="select users.firstname,users.lastname,users.age,users.sex,users.email,users.phone,"
                    + "users.address,users.marital,users.username,users.passwd, users_description.qualification,"
                    + "users_description.salary,users_description.date_of_hire,users_description.position "
                    + "from users,users_description where users.username like '%"+ a +"%' and users.username = users_description.username;";
                       
            try {
                // TODO add your handling code here:
                ArrayList<employee> list; 
                
                list = getemp(b);
                
                DefaultTableModel model = (DefaultTableModel)emptable.getModel();
                   int rc = model.getRowCount();
              
                Object[] row = new Object[14];
           
             
                for(int i=0;i<list.size();i++)
            {
                //System.out.println(list.get(i).getId());
                row[0] = list.get(i).getFirst();
                row[1] = list.get(i).getLast();
                row[2] = list.get(i).getAge();
                row[3] = list.get(i).getSex();
                row[4] = list.get(i).getEmail();
                row[5] = list.get(i).getPhone();
                row[6] = list.get(i).getAddress();
                row[7] = list.get(i).getMarital();
                row[8] = list.get(i).getUsern();
                row[9] = list.get(i).getPasswd();
                row[10] = list.get(i).getQual();
                row[11] = list.get(i).getSalary();
                row[12] = list.get(i).getDoh();
                row[13] = list.get(i).getPosition();
                
                model.addRow(row);
            }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
            }
              DefaultTableModel model = (DefaultTableModel)emptable.getModel();
              
            if(model.getRowCount()==0)
            {
                     String z= empsearch.getText();
       
            String c ="select users.firstname,users.lastname,users.age,users.sex,users.email,users.phone,"
                    + "users.address,users.marital,users.username,users.passwd, users_description.qualification,"
                    + "users_description.salary,users_description.date_of_hire,users_description.position "
                    + "from users,users_description where users.firstname like '%"+ a +"%' and users.username = users_description.username;";
                       
            try {
                // TODO add your handling code here:
                ArrayList<employee> list; 
                
                list = getemp(c);
                
                DefaultTableModel modal = (DefaultTableModel)emptable.getModel();
                   int rc = modal.getRowCount();
              
                Object[] row = new Object[14];
           
             
                for(int i=0;i<list.size();i++)
            {
                //System.out.println(list.get(i).getId());
                row[0] = list.get(i).getFirst();
                row[1] = list.get(i).getLast();
                row[2] = list.get(i).getAge();
                row[3] = list.get(i).getSex();
                row[4] = list.get(i).getEmail();
                row[5] = list.get(i).getPhone();
                row[6] = list.get(i).getAddress();
                row[7] = list.get(i).getMarital();
                row[8] = list.get(i).getUsern();
                row[9] = list.get(i).getPasswd();
                row[10] = list.get(i).getQual();
                row[11] = list.get(i).getSalary();
                row[12] = list.get(i).getDoh();
                row[13] = list.get(i).getPosition();
                
                modal.addRow(row);
            }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
          
                 DefaultTableModel modell = (DefaultTableModel)emptable.getModel();
               if(model.getRowCount()==0)
            {
                     String y= empsearch.getText();
       
            String w ="select users.firstname,users.lastname,users.age,users.sex,users.email,users.phone,"
                    + "users.address,users.marital,users.username,users.passwd, users_description.qualification,"
                    + "users_description.salary,users_description.date_of_hire,users_description.position "
                    + "from users,users_description where users.lastname like '%"+ a +"%' and users.username = users_description.username;";
                       
            try {
                // TODO add your handling code here:
                ArrayList<employee> list; 
                
                list = getemp(w);
                
                DefaultTableModel modal = (DefaultTableModel)emptable.getModel();
                   int rc = modal.getRowCount();
              
                Object[] row = new Object[14];
           
             
                for(int i=0;i<list.size();i++)
            {
                //System.out.println(list.get(i).getId());
                row[0] = list.get(i).getFirst();
                row[1] = list.get(i).getLast();
                row[2] = list.get(i).getAge();
                row[3] = list.get(i).getSex();
                row[4] = list.get(i).getEmail();
                row[5] = list.get(i).getPhone();
                row[6] = list.get(i).getAddress();
                row[7] = list.get(i).getMarital();
                row[8] = list.get(i).getUsern();
                row[9] = list.get(i).getPasswd();
                row[10] = list.get(i).getQual();
                row[11] = list.get(i).getSalary();
                row[12] = list.get(i).getDoh();
                row[13] = list.get(i).getPosition();
                
                modal.addRow(row);
            }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
            }
               }
                   
            }
            DefaultTableModel modal = (DefaultTableModel)emptable.getModel();
            if(modal.getRowCount()==0)
            {
                JOptionPane.showMessageDialog(null,"Employee doesn't exist!","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);
            }
        
        
    }//GEN-LAST:event_empbuttonActionPerformed

    private void qualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qualActionPerformed

    private void jPanel10ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel10ComponentShown
        // TODO add your handling code here:
        showProfile();
        usernp.setEditable(false);
         sexp.setEditable(false);
          datep.setEditable(false);
           salaryp.setEditable(false);
    }//GEN-LAST:event_jPanel10ComponentShown

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d = (DefaultTableModel) medtable1.getModel();
      d.setRowCount(0);
       
                try {
            // TODO add your handling code here:
            ArrayList<sales> list;
            String b = "Select * from sales";
            list = getsalelist(b);
            
            DefaultTableModel model = (DefaultTableModel)medtable1.getModel();
            Object[] row = new Object[5];
            
            
            for(int i=0;i<list.size();i++)
            {
         
                row[0] = list.get(i).getMedicine_id();
                row[1] = list.get(i).getSold_quantity();
                row[2] = list.get(i).getTotal();
                row[3] = list.get(i).getSold_by();
                row[4] = list.get(i).getSold_on();
                model.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseClicked

    private void medtable1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_medtable1MouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_medtable1MouseWheelMoved

    private void empsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empsearchActionPerformed
        // TODO add your handling code here:
        empbuttonActionPerformed(evt);
    }//GEN-LAST:event_empsearchActionPerformed

    private void medsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medsearchActionPerformed
        // TODO add your handling code here:
        jButton8ActionPerformed(evt); 
    }//GEN-LAST:event_medsearchActionPerformed
//DBMetadat
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root","");   
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from users");
            
            ResultSetMetaData rsMetaData = rs.getMetaData();

            System.out.println("Number of columns: "+rsMetaData.getColumnCount());
           
            jTextField6.setText(""+rsMetaData.getColumnCount());
            jTextField7.setText(rsMetaData.getColumnLabel(1));
            jTextField8.setText(rsMetaData.getColumnName(1));
            jTextField9.setText(rsMetaData.getTableName(1));

            

            
      
            // TODO add your handling code here:
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed
 
    String pz;
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
            java.util.logging.Logger.getLogger(admin_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_window(admin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField address;
    private javax.swing.JTextField addressp;
    private javax.swing.JTextField age;
    private javax.swing.JTextField agep;
    private datechooser.beans.DateChooserCombo date;
    private javax.swing.JTextField datep;
    private javax.swing.JTextField email;
    private javax.swing.JTextField emailp;
    private javax.swing.JButton empbutton;
    private javax.swing.JTextField empsearch;
    private javax.swing.JTable emptable;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField fnamep;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField lnamep;
    private javax.swing.JComboBox marital;
    private javax.swing.JTextField maritalp;
    private javax.swing.JTextField med1;
    private javax.swing.JTextField med2;
    private javax.swing.JComboBox med3;
    private javax.swing.JTextField med4;
    private javax.swing.JTextField med5;
    private javax.swing.JTextField med6;
    private datechooser.beans.DateChooserCombo med7;
    private javax.swing.JTextPane med8;
    private javax.swing.JTextField medsearch;
    private javax.swing.JTable medtable;
    private javax.swing.JTable medtable1;
    private javax.swing.JTextField passwd;
    private javax.swing.JTextField passwdp;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField phonep;
    private javax.swing.JComboBox position;
    private javax.swing.JComboBox qual;
    private javax.swing.JTextField qualp;
    private javax.swing.JTextField salary;
    private javax.swing.JTextField salaryp;
    private javax.swing.JComboBox sex;
    private javax.swing.JTextField sexp;
    private javax.swing.JTextField usern;
    private javax.swing.JTextField usernp;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frameicon.png")));
    }
}
