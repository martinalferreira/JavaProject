package io.altar.jseproject.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import io.altar.jseproject.business.interfaces.BusinessInterface;
import io.altar.jseproject.models.Entity;

public abstract class EntityRepository <T extends Entity> implements BusinessInterface<T> {
	
	Map<Long,T> myDataBase = new HashMap<Long, T>();
	private Long biggestId = 0L;
	
	private Long getNextId() {
		return ++biggestId;
	}
	
	public void add(T t) {
		Long id = getNextId();
		t.setID(id);
		myDataBase.put(id, t);
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
			
	public T get(Long id) {
		return myDataBase.get(id);
	}
	
	public void update(T t) {
		myDataBase.replace(t.getID(), t);
	}
	
	public void delete (Long id) {
		myDataBase.remove(id, get(id));
	}
	
	public boolean isEmpty() {
		return (myDataBase.size() == 0) ? true : false;
	}
	
	public Set<Long> getAllIds() {
		return myDataBase.keySet();
	}
	
	
}
