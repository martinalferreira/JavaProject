package io.altar.jseproject.pratica1.textinterface.TISMJSC.States;

import io.altar.jseproject.models.Product;

public class ProductAdd extends State {

	@Override
	public int run() {
		int discount = sc.getInt("What Discount?");
		int[] ivas = {6, 13, 23};
		int iva = sc.getValidInt("What Iva?", ivas);
		float pvp = sc.getFloat("What PVP?");
		Product newProduct = new Product(discount, iva, pvp);
		prodBus.add(newProduct);
		return 1;
	}

}
