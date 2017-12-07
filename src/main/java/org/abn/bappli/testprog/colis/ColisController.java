package org.abn.bappli.testprog.colis;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Exposition REST des méthodes CRUD sur le Colis.
 * Created by anthony on 07/12/2017.
 */
@RestController
public class ColisController {

    /**
     * Binding spring (autowired) du repository des Colis.
     */
    private ColisRepository colisRepository;

    public ColisController(ColisRepository cr) {
        colisRepository = cr;
    }

    /**
     * Service POST de création d'un colis.
     * @param colis a créer / modifier.
     * @return le colis créé (avec son id)
     */
    @ResponseBody
    @PostMapping(path = "/colis", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Colis create(@RequestBody Colis colis) {
        // TODO : controller que le colis n'existe pas, renvoyer une exception dans le cas contraire
        return colisRepository.save(colis);
    }

    /**
     * @return la liste des colis en base de données.
     */
    @ResponseBody
    @GetMapping(path = "/colis", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Colis> getAll() {
        return colisRepository.findAll();
    }

    /**
     * Récupère les données d'un colis par son numéro.
     * @param numero du colis à charger.
     * @return le colis complet.
     */
    @ResponseBody
    @GetMapping(path = "/colis/{numero}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Colis getOne(@PathVariable int numero) {
        return colisRepository.findByNumero(numero);
    }

    /**
     * Méthode non utilisée. Permet de mettre à jour un colis.
     * @param colis à mettre à jour
     * @return le colis mis à jour
     */
    @ResponseBody
    @PutMapping(path = "/colis", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Colis update(@RequestBody Colis colis) {
        // TODO : controller que le colis existe, renvoyer une exception dans le cas contraire
        return colisRepository.save(colis);
    }

    /**
     * Méthode de suppression d'un colis.
     * @param colis à supprimer.
     * @return le colis supprimé
     */
    @ResponseBody
    @DeleteMapping(path = "/colis", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Colis delete(@RequestBody Colis colis) {
        // TODO : controller que le colis existe, renvoyer une exception dans le cas contraire
        final Colis c = colisRepository.findByNumero(colis.getNumero());
        colisRepository.delete(c);
        return c;
    }
}
