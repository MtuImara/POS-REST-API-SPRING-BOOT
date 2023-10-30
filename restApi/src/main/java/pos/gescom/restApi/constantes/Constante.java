package pos.gescom.restApi.constantes;

public class Constante {
    
    public enum typeLangue {
        FRENCH {
            @Override
            public String toString() {
                return "French";
            }
        },
        ENGLISH {
            @Override
            public String toString() {
                return "English";
            }
        }
    }

    public enum typeMouvementStock {
        STOCK_INITIAL {
            @Override
            public String toString() {
                return "Stock Initial";
            }
        },
        ENTREE_STOCK {
            @Override
            public String toString() {
                return "Mouvement d'entrée en Stock";
            }
        },
        SORTIE_STOCK {
            @Override
            public String toString() {
                return "Mouvement de Sortie en Stock";
            }
        },
        TRANSFERT_STOCK {
            @Override
            public String toString() {
                return "Mouvement de transfert entre Stock";
            }
        },
        RETOUR_STOCK {
            @Override
            public String toString() {
                return "Mouvement de retour en Stock";
            }
        },
        DEPRECIATION_STOCK {
            @Override
            public String toString() {
                return "Dépréciation du stock";
            }
        },
        CONSOMMATION_INTERNE {
            @Override
            public String toString() {
                return "Consommation Interne";
            }
        }
    }

    public enum typeStatut {

        ANNULER {
            @Override
            public String toString() {
                return "annulé(e)";
            }
        },
        EFFECTUER {
            @Override
            public String toString() {
                return "Effectué(e)";
            }
        },
        EN_ATTENTE {
            @Override
            public String toString() {
                return "En Attente";
            }
        },
        ACTIF {
            @Override
            public String toString() {
                return "Actif(ve)";
            }
        },
        DESACTIVER {
            @Override
            public String toString() {
                return "Desactivé(e)";
            }
        }

    }
    
}
