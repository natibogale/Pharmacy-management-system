/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy;
import java.util.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author NathanaelB
 */
public class employeew extends javax.swing.JFrame {

    /**
     * Creates new form employeew
     */
    static String employee;
    private Object DateTimeFormatter;
    public employeew(String fx) {
        initComponents();
        setIcon();
        employee = fx.toUpperCase();
        jTextField38.setText(employee);
        jTextField38.setEditable(false);
    }
 //String pt="C:\\Users\\NathanaelB\\Documents\\NetBeansProjects\\xyz\\Pharmacy Management System\\src\\image.png";
        public void showProfile(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root","");
            Statement st = con.createStatement();
           
              String query = "select users.firstname,users.lastname,users.age,users.sex,users.email,users.phone,users.address,users.marital,"
                    + "users.username,users.passwd,users_description.qualification,users_description.salary,"
                    + "users_description.date_of_hire from users,users_description where users.username ="
                    + " '" + employee + "' and users.username = users_description.username";
            ResultSet rs = st.executeQuery(query);
            
            if(rs.next()){
                jTextField4.setText(rs.getString(1));
                jTextField2.setText(rs.getString(2));
                jTextField12.setText(Integer.toString(rs.getInt(3)));
                jTextField1.setText(rs.getString(4));
                jTextField3.setText(rs.getString(5));
                jTextField5.setText(rs.getString(6));
                jTextField6.setText(rs.getString(7));
                jTextField8.setText(rs.getString(8));
                jTextField7.setText(rs.getString(9));
                jTextField10.setText(rs.getString(10));
                jTextField9.setText(rs.getString(11));
                jTextField11.setText(Double.toString(rs.getDouble(12)));
                jTextField29.setText(rs.getString(13));
                
                /*byte[] img = rs.getBytes(15);
                
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImage = im.getScaledInstance(photo.getWidth(), photo.getHeight(), Image.SCALE_SMOOTH);
                
                photo.setIcon(new ImageIcon(myImage));
                */
            }
            
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR ocurred while displaying profile", "NEWLIFE PHARMACEUTICALS", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }}
        
        
        
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
    
        
        
        
        
        
        
    /*
    public ImageIcon ResizeImage(String imagePath,byte[] pic)
    {
        ImageIcon myImage = null;
        if(imagePath != null)
        {
            myImage = new ImageIcon(imagePath);
            
        }
        else
        {
            myImage = new ImageIcon(pic);
        }
        
        
        Image img = myImage.getImage();
        Image img2=img.getScaledInstance(photo.getWidth(),photo.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
         return image;    
    
    }
    
    */
    
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
            Logger.getLogger(employeew.class.getName()).log(Level.SEVERE, null, ex);
        }
            
          
        return medlist;
        
    }
    
    
     
     
     
     
      
      public void show(int index) throws ClassNotFoundException
    {
        String r = "select * from medicines";
        pdec.setText(getmedlist(r).get(index).getDescription());
    
    }
    
    
    /**
     * 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablee1 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        qu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        medtable1 = new javax.swing.JTable();
        medsearch1 = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        pdec = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        medtable3 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        ctab = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        medtable = new javax.swing.JTable();
        medsearch = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NEWLIFE PHARMACEUTICALS-EMPLOYEES WINDOW");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel41.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 36)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 102, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("WELCOME TO NEWLIFE PHARMACEUTICALS");

        jLabel42.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 36)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 102, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("DEAR EMPLOYEE");

        jTextField38.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jTextField38.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton17.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_logout_rounded_up_37px_1.png"))); // NOI18N
        jButton17.setText("LOG OUT");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(265, 265, 265)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 56, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("WELCOME", new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_enter_2_37px.png")), jPanel9); // NOI18N

        jPanel5.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel5ComponentShown(evt);
            }
        });
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

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 60, 30));
        jPanel5.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 180, 30));

        jLabel8.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel8.setText("USER NAME:");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 90, 30));

        jLabel9.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel9.setText("PASSWORD:");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 90, 30));

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
        jPanel5.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 240, 30));
        jPanel5.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 180, 30));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 180, 30));

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 180, 30));
        jPanel5.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 180, 30));
        jPanel5.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 180, 30));
        jPanel5.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 180, 30));

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 180, 30));

        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 80, 30));

        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 70, 30));

        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_update_left_rotation_30px.png"))); // NOI18N
        jButton1.setText("UPDATE");
        jButton1.setToolTipText("update values you edited");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 130, 50));

        jLabel36.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel36.setText("DATE OF HIRE:");
        jPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, 30));
        jPanel5.add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 180, 30));

        jTabbedPane3.addTab("PROFILE", new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_user_male_circle_37px_1.png")), jPanel5, "view and update profile"); // NOI18N

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel20.setText("Search");
        jPanel10.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 70, 20));

        tablee1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine Id", "Medicine Name", "Type", "Dose", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablee1.setToolTipText("you can edit the dose and quantity here");
        tablee1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                tablee1MouseWheelMoved(evt);
            }
        });
        jScrollPane3.setViewportView(tablee1);

        jPanel10.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 280, 330));

        jButton9.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_add_20px_1.png"))); // NOI18N
        jButton9.setText("ADD");
        jButton9.setToolTipText("add selected items");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 110, 50));

        qu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quActionPerformed(evt);
            }
        });
        jPanel10.add(qu, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 80, 30));

        jLabel2.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel2.setText("QUANTITY");
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 70, -1));

        jLabel34.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        jLabel34.setText("DESCRIPTION AND HOW TO USE:");
        jPanel10.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 260, 30));

        medtable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Medicine Name", "Type", "Dose", "Quantity", "Price", "Expiration date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
        medtable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medtable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                medtable1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                medtable1MousePressed(evt);
            }
        });
        medtable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                medtable1FocusGained(evt);
            }
        });
        medtable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                medtable1KeyPressed(evt);
            }
        });
        jScrollPane11.setViewportView(medtable1);
        if (medtable1.getColumnModel().getColumnCount() > 0) {
            medtable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        jPanel10.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 460, 220));

        medsearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medsearch1ActionPerformed(evt);
            }
        });
        jPanel10.add(medsearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 210, 30));

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_37px.png"))); // NOI18N
        jButton20.setToolTipText("search sale records");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 50, 40));

        jScrollPane12.setViewportView(pdec);

        jPanel10.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 360, 230, 110));

        jTabbedPane2.addTab("SELECTION ", new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_search_more_20px_1.png")), jPanel10); // NOI18N

        jPanel6.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 520));

        medtable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Medicine Name", "Type", "Dose", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        medtable3.setToolTipText("you can edit the dose and quantity here");
        medtable3.getTableHeader().setReorderingAllowed(false);
        medtable3.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                medtable3MouseWheelMoved(evt);
            }
        });
        jScrollPane4.setViewportView(medtable3);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 360, 350));

        jButton4.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_clear_symbol_37px.png"))); // NOI18N
        jButton4.setText("CLEAR");
        jButton4.setToolTipText("remove selected item");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 140, 40));

        jButton12.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_bill_37px.png"))); // NOI18N
        jButton12.setText("CONFIRM");
        jButton12.setToolTipText("calculate total price");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 140, 40));
        jPanel6.add(ctab, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, 130, 40));

        jLabel14.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 12)); // NOI18N
        jLabel14.setText("YOU CAN EDIT DOSE AND QUANTITY HERE ON THE TABLE");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 360, -1));

        jLabel19.setForeground(new java.awt.Color(0, 0, 204));
        jLabel19.setText("BIRR");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 460, 40, -1));

        jTabbedPane3.addTab("SELL MEDICINES", new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_pill_filled_37px.png")), jPanel6, "sell medicines to customers"); // NOI18N
        jPanel6.getAccessibleContext().setAccessibleParent(this);

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
                false, false, false, true, false, false, true
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

        jTabbedPane1.addTab("VIEW MEDICINES", new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_pill_20px.png")), jPanel3, "update the stock"); // NOI18N

        jPanel7.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 520));

        jTabbedPane3.addTab("VIEW IN STOCK", new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_filing_cabinet_filled_37px.png")), jPanel7, "view and update stock"); // NOI18N

        getContentPane().add(jTabbedPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                           JFrame frame = new JFrame("Exit");
       
     if(JOptionPane.showConfirmDialog(frame, "Do you update your profile ?","Newlife Pharmaceuticals",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
     {
        
     
        try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root","");
                String sql = "UPDATE users SET firstname = ?, lastname = ?, age = ?, email = ?, phone = ?, address = ?, marital = ?," + 
                            "passwd = ? where username = '" + jTextField7.getText()+"'";
                
                PreparedStatement st = con.prepareStatement(sql);
                
                //MyException.validateName(jTextField4.getText());
                st.setString(1, jTextField4.getText());
                
                //MyException.validateName(jTextField2.getText());
                st.setString(2, jTextField2.getText());
                
                //MyException.validateAge(jTextField12.getText());
                st.setInt(3, Integer.parseInt(jTextField12.getText()));
                
                st.setString(4, jTextField3.getText());
                st.setString(5, jTextField5.getText());
                st.setString(6, jTextField6.getText());
                st.setString(7, jTextField8.getText());
                st.setString(8, jTextField10.getText());
              System.out.println(st);
                st.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Update was successful", "NEWLIFE PHARMACEUTICALS", JOptionPane.INFORMATION_MESSAGE);
                
        }catch (Exception me){
             JOptionPane.showMessageDialog(null, "Fields are blank to update!","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);
        }
     }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTabbedPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane3MouseClicked
        // TODO add your ha0000ndling code here:
   
    }//GEN-LAST:event_jTabbedPane3MouseClicked

    private void jTabbedPane3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane3MouseEntered

    public void clear(int ps)
    {
        DefaultTableModel dm = (DefaultTableModel) medtable.getModel();
        int coun = ps;
        for(int i=coun-1;i>=0;i--)
        {
            dm.removeRow(i);
        }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) medtable3.getModel();
        
   model.setRowCount(0);
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void medtable3MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_medtable3MouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_medtable3MouseWheelMoved

    private void tablee1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_tablee1MouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tablee1MouseWheelMoved

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your han0dling code here:
        //setVisible(false);
                    JFrame frame = new JFrame("Exit");
       
     if(JOptionPane.showConfirmDialog(frame, "Do you want to log out?","Newlife Pharmaceuticals",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
     {
               dispose();
        login1 ui = new login1();
        ui.setVisible(true);
     }
      
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
             
        try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root","");
            Statement stm=con.createStatement();
            
            
            //Transaction
            
            con.setAutoCommit(false);
            
            int ad = medtable3.getRowCount();
           float y= 0f;
           float u;
           float total=0.0f;
           String s1;
            String s2;
             String s3;
              String s4;
               String s5; String s6;String s7=employee;
               String s8="a";
               
          
           
                for(int i=0;i<ad;i++)
                {     s1=(String) medtable3.getValueAt(i,0);
                    s5= String.valueOf(medtable3.getValueAt(i,4));
                     y =  Float.parseFloat(String.valueOf(medtable3.getValueAt(i,4)));
                       u= Float.parseFloat(String.valueOf(medtable3.getValueAt(i,5)));
                     
                      total = y*u;
                      ctab.setText(Float.toString(total));
                     s6= ctab.getText();
                     
                  String h = "insert  into sales values (?,?,?,?,?)";   
                  
                  PreparedStatement qs = con.prepareStatement(h);
                  qs.setString(1,  s1);   qs.setString(2,  s5);  qs.setString(3,  s6); qs.setString(4,  s7);
                  SimpleDateFormat dateformatter = new SimpleDateFormat("MMMM d, yyyy");
                      java.util.Date now = new java.util.Date();
                     
                  s3 = dateformatter.format(now);
                  
                  
                  qs.setString(5,  s3);
                   int op = qs.executeUpdate();
                   
                   System.out.println(op);
                   int q = Integer.parseInt(s5);
                   
                  s2 = "update medicines set quantity = quantity - "+s5+" where medicine_id = '"+s1+"'";    
                  PreparedStatement sm = con.prepareStatement(s2);
                  
                  int up = sm.executeUpdate();
                  
                  if(up==1 && op==1)
                  {
                      con.commit();
                  }
                  else
                  {
                      con.rollback();
                  }
    
                
                //String sr = "update meds set quantity = "+;
                  DefaultTableModel mode = (DefaultTableModel)medtable3.getModel();
        
                     mode.setRowCount(0);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(employeew.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(employeew.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel mte = (DefaultTableModel)medtable3.getModel();
        mte.setRowCount(0);
          if(medtable1.getSelectedRow()>=0)
                 {
     
       
       
                if(qu.getText().equals(""))
                {
                     JOptionPane.showMessageDialog(null,"Please enter the quantity first","Newlife Pharmaceuticals",JOptionPane.YES_NO_OPTION);
                }
                else
                {
                     
                    if(qu.getText().matches("^\\d+(\\.\\d+)?") && Integer.parseInt(qu.getText())>0)
                        {
                        int qw= (int) medtable1.getValueAt(medtable1.getSelectedRow(),4);          
                                 if(Integer.parseInt(qu.getText())>qw)
                                 {
                                      JOptionPane.showMessageDialog(null,"Insufficient quantity","Newlife Pharmaceuticals",JOptionPane.YES_NO_OPTION);
                                 }
                                 else{
                    try {
                        ArrayList<med> list;
                        String b = "Select * from medicines";
                        list = getmedlist(b);
                        int d = medtable1.getSelectedRow();
                        DefaultTableModel model = (DefaultTableModel)medtable3.getModel();
                        Object[] row = new Object[8];
                        row[0] = list.get(d).getId();
                        row[1] = list.get(d).getMedname();
                        row[2] = list.get(d).getType();
                        row[3] = list.get(d).getDose();
                        row[4] = Integer.parseInt(qu.getText());
                        row[5] = list.get(d).getPrice();
                        
                        model.addRow(row);
                          DefaultTableModel mode = (DefaultTableModel)medtable1.getModel();
        
        mode.setRowCount(0);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(employeew.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }}
                else
                    {
                         JOptionPane.showMessageDialog(null,"Quantity can only be a number","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);
                    }}
                pdec.setText("");
               
        }
         else
         {
              JOptionPane.showMessageDialog(null,"Please select an item first","Newlife Pharmaceuticals",JOptionPane.YES_NO_OPTION);
         }
        
        
                 
            
    }//GEN-LAST:event_jButton9ActionPerformed

        
    private void medtable1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_medtable1MouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_medtable1MouseWheelMoved
 public void clear2(int ps)
    {
        DefaultTableModel dm = (DefaultTableModel) medtable1.getModel();
        int coun = ps;
        for(int i=coun-1;i>=0;i--)
        {
            dm.removeRow(i);
        }
    }
    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel d = (DefaultTableModel) medtable1.getModel();
        int qw = d.getRowCount();
       clear2(qw);
        if(medsearch1.getText().equals(""))
        {
             pdec.setText("");
                try {
            // TODO add your handling code here:
            ArrayList<med> list;
            String b = "Select * from medicines where quantity >0";
            list = getmedlist(b);
            
            DefaultTableModel model = (DefaultTableModel)medtable1.getModel();
            Object[] row = new Object[8];
            
            for(int i=0;i<list.size();i++)
            {
                
                row[0] = list.get(i).getId();
                row[1] = list.get(i).getMedname();
                row[2] = list.get(i).getType();
                row[3] = list.get(i).getDose();
                row[4] = list.get(i).getQuantity();
                row[5] = list.get(i).getPrice();
                row[6] = list.get(i).getExpiration();
                
                
                model.addRow(row);
            }
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
        }   
        }
        
        
        else
        {
              pdec.setText("");
             String a= medsearch1.getText();
       
            String b ="SELECT * FROM medicines WHERE medicine_name LIKE '%"+ a +"%' OR medicine_id LIKE '%"+ a +"%' ";
            try {
                // TODO add your handling code here:
                ArrayList<med> list; 
                
                list = getmedlist(b);
                
                DefaultTableModel model = (DefaultTableModel)medtable1.getModel();
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
                Logger.getLogger(employeew.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
         
              if(d.getRowCount()==0)
       {
             JOptionPane.showMessageDialog(null,"Medicine not found!","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);
       }
        
       
    }//GEN-LAST:event_jButton20ActionPerformed

    private void medtable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medtable1MouseEntered
        // TODO add your handling code here:
          /*
        if(medsearch1.getText().equals(""))
        {
                try {
            // TODO add your handling code here:
            ArrayList<med> list;
            String b = "Select * from meds";
            list = getmedlist(b);
            
            DefaultTableModel model = (DefaultTableModel)medtable1.getModel();
            Object[] row = new Object[1000];
            
          
              int u = medtable1.getSelectedRow();
             String yu = list.get(u).getDescription();
             pdec.setText(yu);   
                
            
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
        }   
        }
        */
        
        
    }//GEN-LAST:event_medtable1MouseEntered

  
    private void medtable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medtable1MouseClicked
       
        try {
            int index = medtable1.getSelectedRow();
            show(index);
            
            /*if(medsearch1.getText().equals(""))
            {
            try {
            // TODO add your handling code here:
            ArrayList<med> list;
            String b = "Select * from meds";
            list = getmedlist(b);
            
            DefaultTableModel model = (DefaultTableModel)medtable1.getModel();
            Object[] row = new Object[8];
            
            
            int u = medtable1.getSelectedRow();
            String yu = list.get(u).getDescription();
            pdec.setText(yu);
            
            
            
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
            
            
            else
            {
            
            String a= medsearch1.getText();
       
            String b ="SELECT * FROM meds WHERE medname LIKE '%"+ a +"%' OR id LIKE '%"+ a +"%' ";
            try {
            // TODO add your handling code here:
            ArrayList<med> list;
            
            list = getmedlist(b);
            
            DefaultTableModel model = (DefaultTableModel)medtable1.getModel();
            int rc = model.getRowCount();
            
            Object[] row = new Object[8];
            
            
            
            int u = medtable1.getSelectedRow();
            String yu = list.get(u).getDescription();
            pdec.setText(yu);
            
            
            
            
            
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(admin_window.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            }*/
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(employeew.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_medtable1MouseClicked

    private void medtable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medtable1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_medtable1MousePressed

    private void jPanel5ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel5ComponentShown
        // TODO add your handling code here:
        showProfile();
        jTextField7.setEditable(false);
        jTextField9.setEditable(false);
        jTextField11.setEditable(false);
        jTextField29.setEditable(false);
        jTextField1.setEditable(false);
      
        
    }//GEN-LAST:event_jPanel5ComponentShown

    private void medsearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medsearch1ActionPerformed
        // TODO add your handling code here:
         jButton20ActionPerformed(evt) ;
    }//GEN-LAST:event_medsearch1ActionPerformed

    private void quActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quActionPerformed
        // TODO add your handling code here:
        jButton9ActionPerformed(evt);
    }//GEN-LAST:event_quActionPerformed

    private void medtable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_medtable1KeyPressed
        try {
            int index = medtable1.getSelectedRow();      
            show(index);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(employeew.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_medtable1KeyPressed

    private void medtable1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_medtable1FocusGained
        try {
            // TODO add your handling code here:
            int index = medtable1.getSelectedRow();
            show(index);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(employeew.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_medtable1FocusGained

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d = (DefaultTableModel) medtable.getModel();
        int qw = d.getRowCount();
        clear(qw);
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
                Logger.getLogger(employeew.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(employeew.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if(d.getRowCount()==0)
        {
            JOptionPane.showMessageDialog(null,"Medicine not found!","Newlife Pharmaceuticals",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void medsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medsearchActionPerformed
        // TODO add your handling code here:
        jButton8ActionPerformed(evt);
    }//GEN-LAST:event_medsearchActionPerformed

    private void medtableMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_medtableMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_medtableMouseWheelMoved

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
            java.util.logging.Logger.getLogger(employeew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employeew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employeew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employeew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employeew(employee).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ctab;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField medsearch;
    private javax.swing.JTextField medsearch1;
    private javax.swing.JTable medtable;
    private javax.swing.JTable medtable1;
    private javax.swing.JTable medtable3;
    private javax.swing.JTextPane pdec;
    private javax.swing.JTextField qu;
    private javax.swing.JTable tablee1;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frameicon.png")));
        
    }
}
