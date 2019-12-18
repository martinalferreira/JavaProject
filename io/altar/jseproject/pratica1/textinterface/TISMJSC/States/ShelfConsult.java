package io.altar.jseproject.pratica1.textinterface.TISMJSC.States;

public class ShelfConsult extends State {

	@Override
	public int run() {
		long shelfId = sc.getLong("What Shelf to consult? Insert Id");
		System.out.println(shelfRep.showEntityId(shelfId));
		return 1;
	}

}
