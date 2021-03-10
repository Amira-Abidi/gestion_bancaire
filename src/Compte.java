
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AMIRA
 */
public class Compte {
     private int num_Cpt;
    private int client;
    private double solde;
    private String date_creation;

    public Compte(int num_Cpt, int client, double solde) {
        this.num_Cpt = num_Cpt;
        this.client = client;
        this.solde = solde;
        this.date_creation =date_creation;
    }

    public Compte(int num_Cpt, int client, double solde, String date_creation) {
        this.num_Cpt = num_Cpt;
        this.client = client;
        this.solde = solde;
        this.date_creation = date_creation;
    }


    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }



    public int getNum_Cpt() {
        return num_Cpt;
    }

    public void setNum_Cpt(int num_Cpt) {
        this.num_Cpt = num_Cpt;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
    
    
}
