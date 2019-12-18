package io.altar.jseproject.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import io.altar.jseproject.models.Entity;

public abstract class EntityRepository <T extends Entity> {
	
	Map<Long,T> myDataBase = new HashMap<Long, T>();
	private Long biggestId = 0L;
	
	private Long getNextId() {
		return ++biggestId;
	}
	
	public Long addEntity(T t) {
		Long id = getNextId();
		t.setID(id);
		myDataBase.put(id, t);
		return id;
	}
	
	public Collection<T> getAll() {
		return myDataBase.values();
	}
	
	public void printAll() {
		Iterator<T> prodInterator = getAll().iterator();
		while (prodInterator.hasNext()) {
			T t = (T) prodInterator.next();
			System.out.println(t);
		}
	}
			
	public T showEntityId(Long id) {
		return myDataBase.get(id);
	}
	
	public void editEntity(T t) {
		myDataBase.replace(t.getID(), t);
	}
	
	public void removeEntity (Long id) {
		myDataBase.remove(id, showEntityId(id));
	}
}
