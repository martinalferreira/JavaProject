package io.altar.jseproject.models;

public class Entity {
	
	private Long ID;
	
	public Entity() {
		super();
	}
	
	public Entity(Long ID) {
		super();
		this.ID = ID;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "Entity [ID=" + ID + "]";
	}
	
	
}
