package io.altar.jseproject.pratica1.textinterface.TISMJSC.States;

import java.util.Iterator;

import io.altar.jseproject.models.Product;

public class ProductDelete extends State {

	@Override
	public int run() {
		long productId = sc.getLong("What Product to remove? Insert Id");
		Product produto = prodBus.get(productId);
		deleteFromShelf(produto);
		prodBus.delete(productId);
		System.out.println("Deleted");
		return 1;
	}
	
	private void deleteFromShelf(Product produto) {
		Iterator<Long> shelfIdInterator = produto.getShelvesIds().iterator();
		while (shelfIdInterator.hasNext()) {
			Long shelfId = shelfIdInterator.next();
			shelfBus.get(shelfId).setProductId(0);
		}
	}

}
