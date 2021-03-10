
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AMIRA
 */
public class authentification implements ActionListener {
    
   public Base b = new Base();
    public Connection conn;
    static JTextField username;
    static JPasswordField pwd;
    PreparedStatement statement = null;
    ResultSet resultat;
    
    public authentification(){}
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    System.out.println("Demande d'authentification");
    String usern = username.getText();
    String pass =  pwd.getSelectedText();
        b.connexionBD();
        conn = b.getConnect();
        try{
                statement = (PreparedStatement) conn.createStatement();
                String sql = "SELECT password FROM authentification WHERE username ='"+username+"'";
                resultat = statement.executeQuery(sql);
                 if(resultat.next()){
                    String motDePasse = resultat.getString(1);
                    
                if(motDePasse.equals(pwd)){
             
                    JOptionPane.showMessageDialog(null,"Connexion réussie ! ","Success",JOptionPane.PLAIN_MESSAGE);
                }else {
                     
                    JOptionPane.showMessageDialog(null,"Mot de passe incorrect ! ","Error",1);
                }
                }else {
                     
                    JOptionPane.showMessageDialog(null,"Login incorrect ! ","Error",1);
                }
 
                    conn.close();
         
            }catch (SQLException e4) {
             
                System.out.println(e4.getMessage());
            }
        }
     
    }

        
