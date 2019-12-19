package io.altar.jseproject.pratica1.textinterface.TISMJSC.States;

import io.altar.jseproject.models.Product;
import io.altar.jseproject.models.Shelf;

public class ShelfEdit extends State {

	@Override
	public int run() {
		long shelfId = sc.getLong("What Shelf to edit? Insert Id");
		Shelf shelfToEdit = shelfBus.get(shelfId);
		
		long prodId = sc.getLong("What Product? Insert Id");
		shelfBus.updateProductId(shelfToEdit, prodId);
//		if (prodBus.get(prodId) != null) {
//			removeShelfFromShelvesIds(shelfToEdit);
//			shelfToEdit.setProductId(prodId);
//			addShelfToShelvesIds(shelfToEdit);
//		} else if (prodId == 0) {
//			removeShelfFromShelvesIds(shelfToEdit);
//			shelfToEdit.setProductId(prodId);
//		} else {
//			System.out.println("Product doesn't exist!");
//		}
		
		int capacity = sc.getInt("Edit Capacity?");
		shelfToEdit.setCapacity(capacity);

		float dailyPrice = sc.getFloat("Edit Daily Price?");
		shelfToEdit.setDailyPrice(dailyPrice);
		
		shelfBus.update(shelfToEdit);
		return 1;
	}
	
//	private void removeShelfFromShelvesIds(Shelf shelf) {
//		long productId = shelf.getProductId();
//		if (productId == 0) { return; }
//		Product produto = prodBus.get(productId);
//		produto.removeShelfId(shelf.getID());
//	}
//	
//	private void addShelfToShelvesIds(Shelf shelf) {
//		long prodId = shelf.getProductId();
//		Product produto = prodBus.get(prodId);
//		produto.addShelfId(shelf.getID());
//	}

}
