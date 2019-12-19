package io.altar.jseproject.business.interfaces;

import java.util.List;

import io.altar.jseproject.models.Product;

public interface ProductInterface extends BusinessInterface<Product> {
	
	void updateShelvesIds (Product product, List<Long> updatedShelves);

}
