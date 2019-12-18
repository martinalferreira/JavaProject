package io.altar.jseproject.business;

import io.altar.jseproject.models.Entity;
import io.altar.jseproject.repositories.EntityRepository;

public abstract class EntityBusiness <T extends EntityRepository<S>, S extends Entity> {
	
	public  void addToEntityRepository (S s) {
		
	}
	
	public void updateEntity (Long id) {
		
	}
	
	public void consultEntity (Long id) {
		
	}
	
	public void removeFromEntityRepository (Long id) {
		
	}
	
}
