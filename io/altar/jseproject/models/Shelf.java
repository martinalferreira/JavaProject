package io.altar.jseproject.models;

public class Shelf extends Entity {

	private int capacity;
	private long productId;
	private float dailyPrice;
	
	
	public Shelf() {}

	public Shelf(int capacity, float dailyPrice) {
		this.capacity = capacity;
		this.dailyPrice = dailyPrice;
	}

	public Shelf(int capacity, long productId, float dailyPrice) {
		this.capacity = capacity;
		this.productId = productId;
		this.dailyPrice = dailyPrice;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public float getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(float dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	@Override
	public String toString() {
		return "Shelf [id=" + super.getID() + " capacity=" + capacity + ", productId=" + productId + ", dailyPrice=" + dailyPrice + "]";
	}
}
