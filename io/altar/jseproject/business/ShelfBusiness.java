package io.altar.jseproject.business;

import java.util.Collection;

import io.altar.jseproject.business.interfaces.ShelfInterface;
import io.altar.jseproject.models.Product;
import io.altar.jseproject.models.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

public class ShelfBusiness extends EntityBusiness<ShelfRepository,Shelf> implements ShelfInterface {
	private static final ProductBusiness prodBus = new ProductBusiness();
	
	public ShelfBusiness () {
		this.repository = ShelfRepository.getInstance();
	}
	
	@Override
	public Shelf get(Long id) {
		return repository.get(id);
	}

	@Override
	public void add(Shelf entity) {
		repository.add(entity);	
	}

	@Override
	public void update(Shelf entity) {
		repository.update(entity);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	@Override
	public Collection<Shelf> getAll() {
		return repository.getAll();
	}

	@Override
	public void updateProductId(Shelf shelfToUptade, Long newProductId) {
		if (prodBus.get(newProductId) != null) {
			removeShelfFromShelvesIds(shelfToUptade);
			shelfToUptade.setProductId(newProductId);
			addShelfToShelvesIds(shelfToUptade);
		} else if (newProductId == 0) {
			removeShelfFromShelvesIds(shelfToUptade);
			shelfToUptade.setProductId(newProductId);
		} else {
			System.out.println("Product doesn't exist!");
		}
	}
		
	private void removeShelfFromShelvesIds(Shelf shelf) {
		long productId = shelf.getProductId();
		if (productId == 0) { return; }
		Product produto = prodBus.get(productId);
		produto.removeShelfId(shelf.getID());
	}
	
	private void addShelfToShelvesIds(Shelf shelf) {
		long prodId = shelf.getProductId();
		Product produto = prodBus.get(prodId);
		produto.addShelfId(shelf.getID());
	}

}
