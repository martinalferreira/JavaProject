package io.altar.jseproject.pratica1.textinterface.TISMJSC.States;

import io.altar.jseproject.models.Product;
import io.altar.jseproject.models.Shelf;

public class ShelfEdit extends State {

	@Override
	public int run() {
		System.out.println(" In Shelf Edit");
		long shelfId = sc.getLong("What Shelf to edit? Insert Id");
		Shelf shelfToEdit = shelfRep.showEntityId(shelfId);
		
		long prodId = sc.getLong("What Product? Insert Id");
		if (prodRep.showEntityId(prodId) != null) {
			removeShelfFromShelvesIds(shelfToEdit);
			shelfToEdit.setProductId(prodId);
			addShelfToShelvesIds(shelfToEdit);
		} else if (prodId == 0) {
			removeShelfFromShelvesIds(shelfToEdit);
			shelfToEdit.setProductId(prodId);
		} else {
			System.out.println("Product doesn't exist!");
		}
		
		int capacity = sc.getInt("Edit Capacity?");
		shelfToEdit.setCapacity(capacity);

		float dailyPrice = sc.getFloat("Edit Daily Price?");
		shelfToEdit.setDailyPrice(dailyPrice);
		
		shelfRep.editEntity(shelfToEdit);
		return 1;
	}
	
	private void removeShelfFromShelvesIds(Shelf shelf) {
		long productId = shelf.getProductId();
		if (productId == 0) { return; }
		Product produto = prodRep.showEntityId(productId);
		produto.removeShelfId(shelf.getID());
	}
	
	private void addShelfToShelvesIds(Shelf shelf) {
		System.out.println("kegrwj");
		long prodId = shelf.getProductId();
		System.out.println(prodId);
		Product produto = prodRep.showEntityId(prodId);
		produto.addShelfId(shelf.getID());
	}

}
