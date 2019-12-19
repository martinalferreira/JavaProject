package io.altar.jseproject.business.interfaces;

import io.altar.jseproject.models.Shelf;

public interface ShelfInterface extends BusinessInterface<Shelf> {
	
	void updateProductId (Shelf shelfToUptade, Long newProductId);
	
}
