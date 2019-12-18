package io.altar.jseproject.business;

import java.util.Set;

import io.altar.jseproject.business.interfaces.BusinessInterface;
import io.altar.jseproject.models.Entity;
import io.altar.jseproject.repositories.EntityRepository;

public abstract class EntityBusiness <T extends EntityRepository<S>, S extends Entity> implements BusinessInterface<T, S> {
	
	public T get (Long id) {
		return null;
		
	}
	
	public Set<Long> getAllIds() {
		return null;
		
	}
	
	public void add(S entity) {
		
	}
	
	public void update (S entity) {
		
	}
	
	public void delete (Long id) {
		
	}
	
	public boolean isEmpty() {
		return false;
		
	}
	
}
