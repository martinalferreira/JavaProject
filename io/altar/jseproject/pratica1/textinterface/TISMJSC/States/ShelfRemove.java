package io.altar.jseproject.pratica1.textinterface.TISMJSC.States;

import java.util.List;

import io.altar.jseproject.models.Product;
import io.altar.jseproject.models.Shelf;

public class ShelfRemove extends State {

	@Override
	public int run() {
		long shelfId = sc.getLong("What Shelf to remove? Insert Id");
		removeShelfFromShelvesIds(shelfId);
		shelfRep.removeEntity(shelfId);
		System.out.println("Deleted");
		return 1;
	}
	
	private void removeShelfFromShelvesIds(Long shelfId) {
		Shelf prateleira = shelfRep.showEntityId(shelfId);
		long productId = prateleira.getProductId();
		Product produto = prodRep.showEntityId(productId);
		produto.removeShelfId(shelfId);
	}

}