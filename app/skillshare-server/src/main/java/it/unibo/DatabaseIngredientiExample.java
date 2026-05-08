package it.unibo;
import java.util.concurrent.ConcurrentMap;
import org.mapdb.Serializer;
import org.mapdb.DB;


public class DatabaseIngredientiExample {

    /**
     * Prendiamo l'istanza attiva del database.
     * che e' unicica per prevenire accessi contemporanei da thread diversi.
     */
    private static final DB db = DatabaseCore.getDB();

    /**
     * Creiamo una collezione chiamata ricetta che che contiene delle coppie chiave/valore del tipo STRING (ingrediente), STRING (grammi)
     */
    private static final ConcurrentMap<String, Integer> exampleCollection =
            db.hashMap(
                "ricetta",        // Nome della collezione
                Serializer.STRING,   // Tipo della chiave
                Serializer.INTEGER    // Tipo del valore
            ).createOrOpen();
    
    static Boolean aggiungiIngrediente(String ingrediente, Integer grammi){
        // Controlliamo che i valori siano ammissibili
        if (ingrediente == null || ingrediente.trim().isEmpty() ||
            grammi == null || grammi <= 0) {
            System.out.println("Errore nell'aggiunta dell'ingrediente");
            return false;
        }

        // Controlliamo se l'ingrediente e' stato gia' inserito
        if (exampleCollection.containsKey(ingrediente)) {
            System.out.println("Ingrediente gia' presente");
            return false;
        }

        // Aggiungiamo l'ingrediente alla map
        exampleCollection.put(ingrediente, grammi);

        // Facciamo un commit del database per salvare i cambiamenti su disco
        DatabaseCore.commit();

        return true;
    }
    
}
