package pos.gescom.restApi.constantes;

import java.util.ArrayList;
import java.util.List;

import pos.gescom.restApi.constantes.Constante.typeLangue;
import pos.gescom.restApi.constantes.Constante.typeMouvementStock;
import pos.gescom.restApi.constantes.Constante.typeStatut;

public class StaticListOfValues {
    
    private List<StaticValue> staticValues = new ArrayList<>();

    public List<StaticValue> getTypeLangue() {
        staticValues.clear();
        int i = 1;
        for (typeLangue lang : typeLangue.values()) {
            StaticValue sv = new StaticValue(" " + i, lang.toString());
            staticValues.add(sv);
            i++;
        }
        return staticValues;
    }

    public List<StaticValue> getTypeDeMouvementDuStock() {
        staticValues.clear();
        int i = 1;
        for (typeMouvementStock mouvement : typeMouvementStock.values()) {
            StaticValue sv = new StaticValue(" " + i, mouvement.toString());
            staticValues.add(sv);
            i++;
        }
        return staticValues;
    }

    public List<StaticValue> getTypeStatut() {
        staticValues.clear();
        int i = 1;
        for (typeStatut statut : typeStatut.values()) {
            StaticValue sv = new StaticValue(" " + i, statut.toString());
            staticValues.add(sv);
            i++;
        }
        return staticValues;
    }
}
