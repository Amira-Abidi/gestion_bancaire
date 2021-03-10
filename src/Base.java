
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AMIRA
 */
public class Base {
    public Connection conn;
    public void connexionBD(){
        
        /*  Chargement de la Base de données  */
            try{
                 
                Class.forName("com.mysql.jdbc.Driver");
                 
            } catch (Exception e) {
                 
                System.out.println(" Erreur de chargement de la Base de données");
                e.getMessage();
                System.exit(0);
                 
            }
         
         
            /*    Connexion de la Base de données  */
            try {
                 
                String url = "jdbc:mysql://localhost/projetbd";
                String user = "root";
                String passwd ="";
                conn = DriverManager.getConnection(url, user, passwd);
                System.out.println("done");
            } catch (Exception e) {
                System.out.println(" Erreur de Connexion à la Base de données ");
            }  
             
        }
     
            /*   */
            public Connection getConnect(){
                 
                return conn;
            }
     
             
            /*   Deconnexion  */
            public void Deconnexion(){
             
                try {
                    conn.close();
                     
                } catch (Exception e) {
                    System.out.println(" Déconnexion Impossible ");
                }
            }
            public void createt(){
                try {
                    Statement stm = (PreparedStatement) conn.createStatement();
               
                String createtable = "CREATE TABLE auth "+ "(username VARCHAR(30), password VARCHAR(30))";
                stm.executeUpdate(createtable);
                System.out.println("table created");
                }catch (SQLException e4) {
             
                System.out.println(e4.getMessage());
            }
            }
 public static void main(String[] args) throws SQLException  {
        // TODO code application logic here
        Connection connexion = null;
try {
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Le pilote JDBC MySQL a été chargé");
connexion = DriverManager.getConnection("jdbc:mysql://localhost/projetbd", "root", "");
Statement state = connexion.createStatement();
  String createtable = "CREATE TABLE auth "+ "(username VARCHAR(30), password VARCHAR(30))";
  state.executeUpdate(createtable);
  System.out.println("table created");
ResultSet result = state.executeQuery("SELECT * FROM gestionbancaire");
ResultSetMetaData resultMeta = result.getMetaData();
for(int i = 1; i <= resultMeta.getColumnCount(); i++)
System.out.print(resultMeta.getColumnName(i).toUpperCase() + " | ");
System.out.println();
while(result.next()){
for(int i = 1; i <= resultMeta.getColumnCount(); i++)
System.out.print(result.getObject(i).toString() + " | ");
System.out.println();
}
result.close();
state.close();
connexion.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}