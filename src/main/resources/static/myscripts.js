/**
 * Chargement et construction de la liste des colis.
 */
function listColis() {
    $.ajax({
        url: "/colis",
        type: "GET",
        contentType: "application/json;charset=UTF-8",
        dataType: "json",
        success: function(data) {
            if (data && data.length > 0) {
                $("#listColis").html("");
                for (var c in data) {
                    if (data.hasOwnProperty(c)) {
                        let colis = data[c];
                        $("#listColis").append(
                        '<div><span class="colisCell">' + colis.numero +
                        '</span><span class="colisCell">' + colis.expedition +
                        '</span><span class="colisCell">' + colis.livraison + "</span>" +

                       // actions
                       '<input class="btn selectBtn" type="button" value="Suivre ce colis" onclick="selectColis(' + colis.numero + ');" title="Choisir ce colis" /></div>');
                    }
                }
             }
        }
    });
}

// Appel initial
listColis();

/**
 * Permet de charger les donnees du colis selectionné dans le tableau.
 */
function selectColis(numero) {
    $.ajax({
        url: "/colis/" + numero,
        type: "GET",
        contentType: "application/json;charset=UTF-8",
        dataType: "json",
        success: function(data) {
            if (data && data.hasOwnProperty("id")) {
                setColis(data);
                listColis();
            }
        }
    });
}

/**
 * Methode utilitaire qui affecte les valeurs du colis dans le formulaire de saisie.
 */
function setColis(colis) {
    $("#idColis").val(colis.id);
    $("#numero").val(colis.numero);
    $("#expedition").val(colis.expedition);
    $("#livraison").val(colis.livraison);
}

/**
 * Reset les valeurs du formulaire de saisie.
 */
function initColis() {
    setColis({
        numero: "",
        expedition: "",
        livraison: ""
    });
    listColis();
}

/**
 * Méthode de sauvegarde du colis saisi dans le formulaire.
 */
function saveColis() {
    var colis = getCurrentColis();
    if (colis.numero) {
        $.ajax({
            url: "/colis",
            type: "POST",
            data: JSON.stringify(getCurrentColis()),
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            success: function(data) {
                if (data && data.hasOwnProperty("id")) {
                    initColis();
                }
            }
        });
    } else {
         alert("Aucun colis à sauvegarder.");
    }
}

/**
 * Méthode utilitaire qui construit l'objet colis depuis le formumlaire.
 */
function getCurrentColis() {
    var colis = {};
    colis.id = $("#idColis").val();
    colis.numero = $("#numero").val();
    colis.expedition = $("#expedition").val();
    colis.livraison = $("#livraison").val();
    return colis;
}

/**
 * Méthode de suppression du colis correspondant au formulaire.
 */
function deleteColis(element) {
    var colis = getCurrentColis();
    if (colis.numero) {
        $.ajax({
            url: "/colis",
            type: "DELETE",
            data: JSON.stringify(colis),
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            success: function() {
                initColis();
            }
        });
    } else {
        alert("Aucun colis à supprimer.");
    }
}
