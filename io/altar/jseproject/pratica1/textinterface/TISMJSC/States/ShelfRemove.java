package io.altar.jseproject.pratica1.textinterface.TISMJSC.States;

import java.util.List;

import io.altar.jseproject.models.Product;
import io.altar.jseproject.models.Shelf;

public class ShelfRemove extends State {

	@Override
	public int run() {
		long shelfId = sc.getLong("What Shelf to remove? Insert Id");
		Shelf shelfToEdit = shelfBus.get(shelfId);
		shelfBus.updateProductId(shelfToEdit, 0L);
//		removeShelfFromShelvesIds(shelfId);
		shelfBus.delete(shelfId);
		System.out.println("Deleted");
		return 1;
	}
	
//	private void removeShelfFromShelvesIds(Long shelfId) {
//		Shelf prateleira = shelfBus.get(shelfId);
//		long productId = prateleira.getProductId();
//		Product produto = prodBus.get(productId);
//		produto.removeShelfId(shelfId);
//	}

}