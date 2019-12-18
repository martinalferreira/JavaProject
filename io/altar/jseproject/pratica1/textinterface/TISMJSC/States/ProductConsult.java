package io.altar.jseproject.pratica1.textinterface.TISMJSC.States;

public class ProductConsult extends State {

	@Override
	public int run() {
		long productId = sc.getLong("What Product to consult? Insert Id");
		System.out.println(prodRep.showEntityId(productId));
		return 1;
	}

}
