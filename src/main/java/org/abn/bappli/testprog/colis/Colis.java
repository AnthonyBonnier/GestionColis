package org.abn.bappli.testprog.colis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Modèle objet du Colis à sauvegarder en base.
 * Created by anthony on 07/12/2017.
 */
@Entity
public class Colis {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private int numero;

    private String expedition;

    private String livraison;

    // Getters / setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getExpedition() {
        return expedition;
    }

    public void setExpedition(String expedition) {
        this.expedition = expedition;
    }

    public String getLivraison() {
        return livraison;
    }

    public void setLivraison(String livraison) {
        this.livraison = livraison;
    }
}
