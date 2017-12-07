package org.abn.bappli.testprog.colis;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de manipulation du modèle.
 * L'implémentation est générée automatiquement par Spring JPA.
 * Created by anthony on 07/12/2017.
 */
public interface ColisRepository extends JpaRepository<Colis, Integer> {

    /**
     * Récupère un colis par son numéro.
     * @param numero du colis
     * @return l'objet Colis depuis la base de données
     */
    public Colis findByNumero(int numero);
}
