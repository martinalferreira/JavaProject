package io.altar.jseproject.pratica1.textinterface.TISMJSC.States;

import io.altar.jseproject.models.Shelf;

public class ShelfAdd extends State {

	@Override
	public int run() {
		int capacity = sc.getInt("What Capacity?");
		float dailyPrice = sc.getFloat("What Daily Price?");
		Shelf newShelf = new Shelf(capacity, dailyPrice);
		shelfRep.addEntity(newShelf);
		return 1;
	}

}
