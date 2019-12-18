package io.altar.jseproject.business.interfaces;

import java.util.Set;

import io.altar.jseproject.models.Entity;
import io.altar.jseproject.repositories.EntityRepository;

public interface BusinessInterface <T extends EntityRepository<S>, S extends Entity> {

	T get (Long id);
	
	Set<Long> getAllIds();
	
	void add(S entity);
	
	void update (S entity);
	
	void delete (Long id);
	
	boolean isEmpty();
	
	
	
}
