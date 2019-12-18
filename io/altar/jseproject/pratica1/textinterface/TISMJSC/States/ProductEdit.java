package io.altar.jseproject.pratica1.textinterface.TISMJSC.States;

import java.util.ArrayList;
import java.util.List;

import io.altar.jseproject.models.Product;

public class ProductEdit extends State {

	@Override
	public int run() {
		long productId = sc.getLong("What Product to edit? Insert Id");
		Product productToEdit = prodRep.showEntityId(productId);
		
		editShelvesIds (productToEdit);
		
		editDiscount (productToEdit);
		
		editIva (productToEdit);
		
		editPvp (productToEdit);
		
		prodRep.editEntity(productToEdit);
		return 1;
	}
	
// HELPERS ################################################################
	
	private void editShelvesIds (Product product) {
		long shelfId = sc.getLong("What Shelf? Insert Id");
		if (shelfRep.showEntityId(shelfId) != null) {
			List<Long> shelvesIds = new ArrayList<Long>();
			shelvesIds.add(shelfId);
			product.setShelvesIds(shelvesIds);
			for (Long prateleira : shelvesIds) {
				shelfRep.showEntityId(prateleira).setProductId(product.getID());
			}
		} else {
			System.out.println("Shelf doesn't exist!");
		}
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
