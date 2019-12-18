package io.altar.jseproject.pratica1.textinterface.TISMJSC.States;

import java.util.Iterator;

import io.altar.jseproject.models.Product;

public class ProductDelete extends State {

	@Override
	public int run() {
		long productId = sc.getLong("What Product to remove? Insert Id");
		Product produto = prodRep.showEntityId(productId);
		deleteFromShelf(produto);
		prodRep.removeEntity(productId);
		System.out.println("Deleted");
		return 1;
	}
	
	private void deleteFromShelf(Product produto) {
		Iterator<Long> shelfIdInterator = produto.getShelvesIds().iterator();
		while (shelfIdInterator.hasNext()) {
			Long shelfId = shelfIdInterator.next();
			shelfRep.showEntityId(shelfId).setProductId(0);
		}
	}

}
