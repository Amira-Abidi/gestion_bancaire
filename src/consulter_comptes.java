
import com.sun.security.ntlm.Client;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



public class consulter_comptes extends javax.swing.JDialog {
    static String nom_clt;
    static String prenom_clt;
    static String numero_clt;
    static int numC;
    static int numclient;
    private consulter_comptes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(700,500);
        show_compte();
       
       }

    public  consulter_comptes (){
   
                    initComponents(); 
                    setSize(700,500);
                    show_compte();
                    Color c = new Color(51,51,51);
                    jPanel5.setBackground(c);
                    jPanel6.setBackground(c);
    }

        
        public ArrayList<Compte> compteList(){
        ArrayList<Compte> compteList = new ArrayList<>();
        Espaceclient esc = new Espaceclient();
        numclient = esc.numClient;
          try{
         java.sql.Connection cnx = DriverManager.getConnection
        ("jdbc:mysql://localhost/projetbd","root","");
            String sql="SELECT * FROM compte Cpt  INNER JOIN user C ON C.numéro = Cpt.client WHERE type like 'client' and C.numéro='"+numclient+"' ";
            Statement st=cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Compte compte;
            while(rs.next()){
                compte=new Compte(rs.getInt("num_Cpt"),
                        rs.getInt("client"),
                        rs.getDouble("solde"),
                        rs.getString("date_creation"));
             compteList.add(compte);
             
            }
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
          return compteList; 
    }
   public void show_compte(){
        ArrayList<Compte> list = compteList();
        DefaultTableModel model= (DefaultTableModel)jTable_Display_Comptes.getModel();
        Object[] row = new Object[4];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getNum_Cpt();
            row[1]=list.get(i).getSolde();
            row[2]=list.get(i).getClient();
            row[3]=list.get(i).getDate_creation();
            model.addRow(row);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Display_Comptes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setFocusable(false);

        jTable_Display_Comptes.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTable_Display_Comptes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero du compte", "Solde", "Client", "Date de création"
            }
        ));
        jTable_Display_Comptes.setAutoscrolls(false);
        jTable_Display_Comptes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable_Display_Comptes.setFillsViewportHeight(true);
        jTable_Display_Comptes.setFocusable(false);
        jTable_Display_Comptes.setGridColor(new java.awt.Color(0, 0, 0));
        jTable_Display_Comptes.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable_Display_Comptes.setMinimumSize(new java.awt.Dimension(80, 60));
        jTable_Display_Comptes.setPreferredSize(new java.awt.Dimension(300, 250));
        jTable_Display_Comptes.setRowHeight(35);
        jTable_Display_Comptes.setSelectionBackground(new java.awt.Color(153, 0, 0));
        jTable_Display_Comptes.setSelectionForeground(new java.awt.Color(255, 251, 248));
        jTable_Display_Comptes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_Display_Comptes.getTableHeader().setReorderingAllowed(false);
        jTable_Display_Comptes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTable_Display_ComptesMouseMoved(evt);
            }
        });
        jTable_Display_Comptes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_ComptesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable_Display_ComptesMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Display_Comptes);
        if (jTable_Display_Comptes.getColumnModel().getColumnCount() > 0) {
            jTable_Display_Comptes.getColumnModel().getColumn(0).setHeaderValue("Numero du compte");
            jTable_Display_Comptes.getColumnModel().getColumn(1).setHeaderValue("Solde");
            jTable_Display_Comptes.getColumnModel().getColumn(2).setHeaderValue("Client");
            jTable_Display_Comptes.getColumnModel().getColumn(3).setHeaderValue("Date de création");
        }

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Déconnexion");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\AMIRA\\Documents\\NetBeansProjects\\Projetbd\\src\\bank.jpg")); // NOI18N

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Acceuil");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(31, 31, 31))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jLabel7.setText("Nom du client");

        jLabel9.setText("Numéro");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fl1.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(597, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(130, 130, 130))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(61, 61, 61))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(625, 625, 625)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(314, 314, 314))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered

    }//GEN-LAST:event_jLabel1MouseEntered

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        consulter_comptes.this.setVisible(false);
        login lg = new login();
        lg.setVisible(true);
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered

        jPanel5.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        consulter_comptes.this.setVisible(false);
        Acceuil acc = new Acceuil();
        acc.setVisible(true);
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered

        jPanel6.setBackground(Color.darkGray);
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jTable_Display_ComptesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_ComptesMouseEntered

    }//GEN-LAST:event_jTable_Display_ComptesMouseEntered

    private void jTable_Display_ComptesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_ComptesMouseClicked

        String num = jLabel10.getText();
        String nom = jLabel8.getText();
        int index = jTable_Display_Comptes.getSelectedRow();
        TableModel model = jTable_Display_Comptes.getModel();
        numC = Integer.parseInt(model.getValueAt(index, 0).toString());
        String clientC = model.getValueAt(index, 2).toString();
        double solde =  Double.parseDouble(model.getValueAt(index, 1).toString());

        try{
            java.sql.Connection cnx = DriverManager.getConnection
            ("jdbc:mysql://localhost/projetbd","root","");

            String query="SELECT numéro,nom FROM user C INNER JOIN compte Cpt ON C.numéro = Cpt.client WHERE C.numéro='"+num+"'";

            Statement st=cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            String nom_clt = null;
            //String prenom_clt = null;
            String numero_clt = null;

            while(rs.next()){

                nom_clt = rs.getString("nom");
                numero_clt = rs.getString("numéro");
                jLabel2.setText(nom_clt);
                jLabel2.setVisible(false);
                jLabel3.setText(prenom_clt);
                jLabel3.setVisible(false);
                jLabel4.setText(numero_clt);
                jLabel4.setVisible(false);

                // JOptionPane.showMessageDialog(null,"le compte est ='"+ nom_clt+"'");
            }}

            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            prenom_clt = jLabel3.getText();
            nom_clt= jLabel2.getText();
            numero_clt= jLabel4.getText();
            //new info_compte_client(numC,solde,nom_clt,prenom_clt,numero_clt).setVisible(true);

            ListSelectionModel selectionModel = jTable_Display_Comptes.getSelectionModel(); // on récupère le modèle de sélection de la table
            int selectedRow = jTable_Display_Comptes.convertColumnIndexToModel(jTable_Display_Comptes.getSelectedRow()); // l'index de ligne sélectionnée dans le modèle
            Object[] selectedValues = new Object[jTable_Display_Comptes.getColumnCount()]; // on créé un tableau pour récupérer les valeurs de colonnes (sans type particulier donc le type Object)
            for (int column = 0; column < jTable_Display_Comptes.getColumnCount(); column++) { // on parcourt toutes les colonnes
            selectedValues[column] = jTable_Display_Comptes.getValueAt(selectedRow, column);// on copie dans le tableau la valeur correspondant à la ligne et la colonne

            }
            consulter_comptes.this.setVisible(false);
            menu m= new menu();
            m.setVisible(true);
            m.jLabel16.setText((String) nom);
            m.jLabel17.setText((String) num);
    }//GEN-LAST:event_jTable_Display_ComptesMouseClicked

    private void jTable_Display_ComptesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_ComptesMouseMoved

    }//GEN-LAST:event_jTable_Display_ComptesMouseMoved

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        consulter_comptes.this.setVisible(false);
        Espaceclient cl = new Espaceclient();
        cl.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked
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
            java.util.logging.Logger.getLogger(Acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                consulter_comptes dialog = new consulter_comptes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable_Display_Comptes;
    // End of variables declaration//GEN-END:variables

    private void addWindowListener(WindowAdapter windowAdapter) {
          }
}
