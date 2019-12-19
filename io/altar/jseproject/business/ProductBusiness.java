package io.altar.jseproject.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import io.altar.jseproject.business.interfaces.ProductInterface;
import io.altar.jseproject.models.Product;
import io.altar.jseproject.models.Shelf;
import io.altar.jseproject.repositories.ProductRepository;

public class ProductBusiness extends EntityBusiness<ProductRepository,Product> implements ProductInterface {
	private ProductRepository prodRep = ProductRepository.getInstance();
	private static final ShelfBusiness shelfBus = new ShelfBusiness();
	
	@Override
	public Product get(Long id) {
		return prodRep.showEntityId(id);
	}

	@Override
	public Set<Long> getAllIds() {
		
		return null;
	}

	@Override
	public void add(Product entity) {
		prodRep.addEntity(entity);
	}

	@Override
	public void update(Product entity) {
		prodRep.editEntity(entity);
	}

	@Override
	public void delete(Long id) {
		prodRep.removeEntity(id);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateShelvesIds(Product product, List<Long> updatedShelves) {
		System.out.println(updatedShelves);
		for (Long prateleira : updatedShelves) {
			shelfBus.get(prateleira).setProductId(product.getID());
		}
	}
	
	public List<Long> getShelvesByProductId (Long productId) {
		Collection<Shelf> shelves = shelfBus.getAll();
		List<Long> shelvesIds = new ArrayList<Long>();
		for (Shelf shelf : shelves) {
			if (shelf.getProductId() == productId) {
				shelvesIds.add(shelf.getID());
			} 
		}
		return shelvesIds;
	}

}
