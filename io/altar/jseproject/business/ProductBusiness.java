package io.altar.jseproject.business;

import java.util.Set;

import io.altar.jseproject.models.Product;
import io.altar.jseproject.repositories.ProductRepository;

public class ProductBusiness extends EntityBusiness<ProductRepository,Product> {

	@Override
	public ProductRepository get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Long> getAllIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Product entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Product entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
