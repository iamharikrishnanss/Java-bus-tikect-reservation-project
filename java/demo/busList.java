/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;
import java.sql.Statement;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.*;

/**
 *
 * @author Golden
 */
public class busList extends javax.swing.JFrame {

   public Connection cn=null;
    public Statement stmt = null;
    public ResultSet rs=null;
    public String pas=null;
    
     public Connection cn2=null;
    public Statement stmt2 = null;
    public ResultSet rs2=null;
    public String pas2=null;
    public String name =null;
    
    public busList(String name) {
        this.name=name;
        initComponents();
        connectServer();
        setAvailable1();
        setAvailable2();
        setAvailable3();
        setAvailable4();
        connectServer2();
        userWelcome(name);
        jButton3.setVisible(false);
        
    
    }
    
    public void setAvailable2()
    { try{
        Class.forName("org.postgresql.Driver");
            Connection cn4=DriverManager.getConnection("jdbc:postgresql://localhost:5432/project","postgres", "root");
            Statement stmt4 = cn4.createStatement();
            System.out.println("Opened database");
        
        ResultSet r2 = stmt4.executeQuery("select count(status) from aabb where status='Available '");
        
        while (r2.next()) {
                     int count = r2.getInt("count");
                    
                stmt4.executeUpdate("update bus set available_seats="+count+"where owner='aabb'");
                
                
                
        }
                r2.close();
                stmt4.close();
                cn4.close();
                
                }catch(Exception e){System.out.println(e.getMessage());} 
        
        
    }    
    
    public void setAvailable3()
    { try{
        Class.forName("org.postgresql.Driver");
            Connection cn5=DriverManager.getConnection("jdbc:postgresql://localhost:5432/project","postgres", "root");
            Statement stmt5 = cn5.createStatement();
            System.out.println("Opened database");
        
        ResultSet r3= stmt5.executeQuery("select count(status) from aabc where status='Available '");
        while (r3.next()) {
                     int count = r3.getInt("count");
                    
               stmt5.executeUpdate("update bus set available_seats="+count+"where owner='aabc'");
               
                
                
                
               
        }
        r3.close();
                stmt5.close();
                cn5.close();
                
                }catch(Exception e){System.out.println(e.getMessage());} 
        
        
    } 
    public void setAvailable4()
    { try{
        Class.forName("org.postgresql.Driver");
            Connection cn6=DriverManager.getConnection("jdbc:postgresql://localhost:5432/project","postgres", "root");
            Statement stmt6 = cn6.createStatement();
            System.out.println("Opened database");
        
        ResultSet r4= stmt6.executeQuery("select count(status) from bcbc where status='Available '");
        while (r4.next()) {
                     int count = r4.getInt("count");
                    
               stmt6.executeUpdate("update bus set available_seats="+count+"where owner='bcbc'");
               
                
                
                
               
        }
        r4.close();
                stmt6.close();
                cn6.close();
                
                }catch(Exception e){System.out.println(e.getMessage());} 
        
        
    }
    
    
    
    public void setAvailable1(){
        
//select count(status) from aabb where status='Available ';
//select count(status) from aabc where status='Available ';
//select count(status) from bcbc where status='Available ';

        try{
            
            Class.forName("org.postgresql.Driver");
            Connection cn3=DriverManager.getConnection("jdbc:postgresql://localhost:5432/project","postgres", "root");
            Statement stmt3 = cn3.createStatement();
            System.out.println("Opened database");
            
            
            
            
            
            
            
       ResultSet r1 = stmt3.executeQuery("select count(status) from abcd where status='Available';");
        while (r1.next()) {
                     int count = r1.getInt("count");
                    
                stmt3.executeUpdate("update bus set available_seats="+count+"where owner='abcd'");
                
                
                
                
        }
        
        r1.close();
                stmt3.close();
                cn3.close();
        
        
        
        }catch(Exception e){System.out.println(e.getMessage());}  
                 
      
                    
                   
                    
    }
    
    
        
        
        
        
        
        
    public void userWelcome(String name){
        jLabel4.setText("Welcome,"+name);
    }
    
    
    
    
    
    public void updatePrice() throws SQLException{
        
        try{
    
                int selectedindex1 = box1.getSelectedIndex();
                int selectedindex2 = jComboBox3.getSelectedIndex();
                
                int a= selectedindex1-selectedindex2;
                
                int x = Math.abs(a);
                
                String s = "select price,no from bus;";
                rs2 = stmt.executeQuery(s);
                
                while (rs2.next()) {
                    int price = rs2.getInt("price");
                    int no = rs2.getInt("no");
                    
                    
                    int price2 = (price*(x+1));
                    System.out.println(price2);
                    
                    stmt2.executeUpdate("update bus set price="+price2+"where no="+no);
                    
                    
                    
           
       
    }
                
                
        }catch(Exception e){System.out.println(e.getMessage());}
         finally {
            
        }
        
        
        
    }
    
    public void connectServer2(){
       try {
             
            Class.forName("org.postgresql.Driver");
            cn2=DriverManager.getConnection("jdbc:postgresql://localhost:5432/project","postgres", "root");
            stmt2 = cn2.createStatement();
            System.out.println("Opened database2");
            
            }catch (Exception e) {System.out.println(e);} 
       
        
        
        
    }
    public void connectServer(){
         try {
             
            Class.forName("org.postgresql.Driver");
            cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/project","postgres", "root");
            stmt = cn.createStatement();
            System.out.println("Opened database");
            
            }catch (Exception e) {System.out.println(e);}
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        box1 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Date :");

        jDateChooser1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("To :");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("From: ");

        box1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        box1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thiruvananthapuram", "Kollam", "Alappuzha", "Pathanamthitta", "Kottayam", "Idukki", "Ernakulam", "Thrissur", "Palakkad", "Malappuram", "Kozhikode", "Wayanad", "Kannur", "Kasaragod" }));
        box1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                box1ItemStateChanged(evt);
            }
        });
        box1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box1ActionPerformed(evt);
            }
        });

        jComboBox3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thiruvananthapuram", "Kollam", "Alappuzha", "Pathanamthitta", "Kottayam", "Idukki", "Ernakulam", "Thrissur", "Palakkad", "Malappuram", "Kozhikode", "Wayanad", "Kannur", "Kasaragod" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });
        jComboBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBox3MouseReleased(evt);
            }
        });
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 3, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 213, 90));

        jButton2.setBackground(new java.awt.Color(0, 102, 204));
        jButton2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Show");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Next");
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(box1, 0, 174, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(36, 36, 36)
                                .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(99, 99, 99))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(box1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bus No", "Type", "No.Seats available", "Owner", "Price"
            }
        ));
        jTable1.setEditingColumn(1);
        jTable1.setEditingRow(1);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(994, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void box1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box1ActionPerformed
int selectedindex = box1.getSelectedIndex();
        System.out.println(selectedindex);
        jComboBox3.removeItemAt(selectedindex);    //
    }//GEN-LAST:event_box1ActionPerformed
String date =null;
public String from = null;
public String to = null;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            from = box1.getSelectedItem().toString();
            to = jComboBox3.getSelectedItem().toString();
            updatePrice();
            SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
             date= df.format(jDateChooser1.getDate());
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            System.out.println(date);
            
            
            String s = "select * from bus";
            rs = stmt.executeQuery(s);
            
            while (rs.next()) {
                Vector v2 = new Vector();
                
                for (int i=1;i<=20;i++){
                    v2.add(rs.getString("no"));
                    v2.add(rs.getString("type"));
                    v2.add(rs.getString("available_seats"));
                    v2.add(rs.getString("owner"));
                    v2.add(rs.getString("price"));
                    
                }
                
                d.addRow(v2);
                
                
            }
            
            rs.close();
            stmt.executeUpdate("update bus set price=600 where type='AC'" );
            stmt.executeUpdate("update bus set price=400 where type='NON AC'" );

        }catch (Exception e) {System.out.println(e);}
        finally{
        
        }
        
        
           

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox3MouseReleased
       
                
    }//GEN-LAST:event_jComboBox3MouseReleased

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
       


        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    String type =null;
    String number = null;
    String price =null;
    String owner =null;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
jButton3.setVisible(true);        
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        
        int row = jTable1.getSelectedRow();
                
        number = d1.getValueAt(row,0).toString();
        type   = d1.getValueAt(row,1).toString();
        owner  = d1.getValueAt(row,3).toString();
        price  = d1.getValueAt(row,4).toString();
        




    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        new seatSelect(number,owner,date,name,from,to).setVisible(true);

        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void box1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_box1ItemStateChanged
       
        
        
    }//GEN-LAST:event_box1ItemStateChanged

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
 

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ItemStateChanged

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
            java.util.logging.Logger.getLogger(busList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(busList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(busList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(busList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
