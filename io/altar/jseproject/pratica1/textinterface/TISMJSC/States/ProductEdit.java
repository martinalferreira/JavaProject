package io.altar.jseproject.pratica1.textinterface.TISMJSC.States;

import java.util.ArrayList;
import java.util.List;

import io.altar.jseproject.models.Product;

public class ProductEdit extends State {

	@Override
	public int run() {
		long productId = sc.getLong("What Product to edit? Insert Id");
		Product productToEdit = prodBus.get(productId);
		
		editShelvesIds (productToEdit);
		
		editDiscount (productToEdit);
		
		editIva (productToEdit);
		
		editPvp (productToEdit);
		
		prodBus.update(productToEdit);
		return 1;
	}
	
	private void editShelvesIds (Product product) {
		List<Long> shelvesIds = prodBus.getShelvesByProductId(0L);
		long shelfId = sc.getValidLong("What Shelf? Insert Id", shelvesIds);
		List<Long> productShelvesIds = new ArrayList<Long>();
		while (shelfId != 0) {
			productShelvesIds.add(shelfId);
			shelfId = sc.getLong("What Shelf? Insert Id or press 0 to Finish");
		}
		product.setShelvesIds(productShelvesIds);
		prodBus.updateShelvesIds(product, productShelvesIds);
	}
	
	private void editDiscount (Product product) {
		int discount = sc.getInt("Edit Discount?");
		product.setDiscount(discount);
	}
	
	private void editIva (Product product) {
		int[] ivas = {6, 13, 23};
		int iva = sc.getValidInt("Edit Iva?", ivas);
		product.setIva(iva);
	}
	
	private void editPvp (Product product) {
		float pvp = sc.getFloat("Edit PVP?");
		product.setPvp(pvp);
	}

}
