package io.altar.jseproject.repositories;

import io.altar.jseproject.models.Product;

public class ProductRepository extends EntityRepository<Product> {
	
	private ProductRepository() {}
	
	private static final ProductRepository INSTANCE = new ProductRepository();
	
	public static ProductRepository getInstance() {
		return INSTANCE;
	}
}
