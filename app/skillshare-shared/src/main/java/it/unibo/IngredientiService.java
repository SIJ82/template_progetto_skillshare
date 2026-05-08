package it.unibo;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("ingredienti")
public interface IngredientiService extends RemoteService{

    Boolean aggiungiIngrediente(String ingrediente, Integer grammi) throws IllegalArgumentException;
    IngredientiResponse prendiIngredienti() throws IllegalArgumentException;
    
}
