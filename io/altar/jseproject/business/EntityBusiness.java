package io.altar.jseproject.business;

import java.util.Set;

import io.altar.jseproject.business.interfaces.BusinessInterface;
import io.altar.jseproject.models.Entity;
import io.altar.jseproject.repositories.EntityRepository;

public abstract class EntityBusiness <T extends EntityRepository<S>, S extends Entity> implements BusinessInterface<S> {
	
}
