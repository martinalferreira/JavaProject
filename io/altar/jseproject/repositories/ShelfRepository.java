package io.altar.jseproject.repositories;

import io.altar.jseproject.models.Shelf;

public class ShelfRepository extends EntityRepository<Shelf> {
	
	private ShelfRepository() {}
	
	private static final ShelfRepository INSTANCE = new ShelfRepository();
	
	public static ShelfRepository getInstance() {
		return INSTANCE;
	}
}
