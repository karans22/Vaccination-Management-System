
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Update extends javax.swing.JFrame {

    String usid="";
    /**
     * Creates new form Update
     */
    public Update() {
        initComponents();
    }
    
    public Update(String uid) {
        initComponents();
        usid=uid;
        try
       {
           Class.forName("java.sql.DriverManager");
            Connection con=(Connection)
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccine","root","Karan@22");
                    Statement stmt=(Statement)con.createStatement();
                    String q3="select vacc_date,vacc_time from appointment where app_id='"+usid+"';";
                    ResultSet rs=stmt.executeQuery(q3);
                    if(rs.next())
                    {
                        String p=rs.getString("vacc_date");
                        String q=rs.getString("vacc_time");
                       
                     jTextField1.setText("Your alloted date and time are "+p+" and "+q+"");
                    }
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(this, e.getMessage());
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

        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Update register");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 226, 73, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "10am-12pm", "1pm-3pm", "3pm-5pm", "5pm-7pm" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 141, 130, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Time slot");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 144, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Date");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 89, -1, -1));

        jTextField1.setEditable(false);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 26, 562, 30));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 130, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/WhatsApp Image 2021-05-10 at 1.25.00 AM.jpeg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        try
       {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dt1=jDateChooser1.getDate();
        String str=(String)sdf.format(dt1);
        String time=(String)jComboBox1.getSelectedItem();
        
           Class.forName("java.sql.DriverManager");
            Connection con=(Connection)
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccine","root","mozart26");
                    Statement stmt=(Statement)con.createStatement();
              String q2="Update appointment set vacc_date='"+str+"',vacc_time='"+time+"' where app_id="+usid+";"; 
              stmt.executeUpdate(q2);
              JOptionPane.showMessageDialog(this,"Appointment Updated");
              this.dispose();
        Confirmation nf=new Confirmation(str,time);
        nf.setVisible(true);
       }
          catch(Exception e){
           JOptionPane.showMessageDialog(this, e.getMessage());
       }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}