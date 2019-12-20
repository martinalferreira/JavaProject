package io.altar.jseproject.pratica1.textinterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.altar.jseproject.models.Product;
import io.altar.jseproject.models.Shelf;
import io.altar.jseproject.pratica1.textinterface.ScannerUtils.ScannerUtils;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class TextInterface {
	ScannerUtils sc = new ScannerUtils();
	ProductRepository prodRep = ProductRepository.getInstance();
	ShelfRepository shelfRep = ShelfRepository.getInstance();

	public void ecraInicio() {
		int option = 0;
		do {
			System.out.println("1)\t Listar Produtos");
			System.out.println("2)\t Listar Shelves");
			System.out.println("3)\t Sair");
			int[] options = { 1, 2, 3 };
			option = sc.getValidInt("Selecionar opção : ", options);
			switch (option) {
			case 1:
				ecraLProducts();
				break;
			case 2:
				ecraLShelves();
				break;
			case 3:
				System.out.println("Saida");
				break;
			}
		} while (option != 3);
	}

	private void ecraLShelves() {
		int option = 0;
		do {
			shelfRep.printAll();
			System.out.println("1)\t Criar Shelves");
			System.out.println("2)\t Editar Shelves");
			System.out.println("3)\t Consultar Shelves");
			System.out.println("4)\t Remover Shelves");
			System.out.println("5)\t Voltar");
			int[] options = { 1, 2, 3, 4, 5 };
			option = sc.getValidInt("Selecionar opção : ", options);
			switch (option) {
			case 1:
				addShelfHelper();
				break;
			case 2:
				editShelfHelper();
				break;
			case 3:
				consultShelfHelper();
				break;
			case 4:
				removeShelfHelper();
				break;
			}
		} while (option != 5);
	}
	
	private void addShelfHelper() {
		int capacity = sc.getInt("What Capacity?");
		float dailyPrice = sc.getFloat("What Daily Price?");
		Shelf newShelf = new Shelf(capacity, dailyPrice);
		shelfRep.add(newShelf);
	}
	
	private void editShelfHelper() {
		long shelfId = sc.getLong("What Shelf to edit? Insert Id");
		Shelf shelfToEdit = shelfRep.get(shelfId);
		
		long prodId = sc.getLong("What Product? Insert Id");
		if (prodRep.get(prodId) != null) {
			shelfToEdit.setProductId(prodId);
		} else {
			System.out.println("Product doesn't exist!");
		}
		
		int capacity = sc.getInt("Edit Capacity?");
		shelfToEdit.setCapacity(capacity);

		float dailyPrice = sc.getFloat("Edit Daily Price?");
		shelfToEdit.setDailyPrice(dailyPrice);
		
		shelfRep.update(shelfToEdit);	
	}
		
	private void consultShelfHelper() {
		long shelfId = sc.getLong("What Shelf to consult? Insert Id");
		System.out.println(shelfRep.get(shelfId));
	}
	
	private void removeShelfHelper() {
		long shelfId = sc.getLong("What Shelf to remove? Insert Id");
		shelfRep.delete(shelfId);
		System.out.println("Deleted");
	}
	
	

	private void ecraLProducts() {
		int option = 0;
		do {
			prodRep.printAll();
			System.out.println("1)\t Criar Products");
			System.out.println("2)\t Editar Products");
			System.out.println("3)\t Consultar Products");
			System.out.println("4)\t Remover Products");
			System.out.println("5)\t Voltar");
			int[] options = { 1, 2, 3, 4, 5 };
			option = sc.getValidInt("Selecionar opção : ", options);
			switch (option) {
			case 1:
				addProductHelper();
				break;
			case 2:
				editProductHelper();
				break;
			case 3:
				consultProductHelper();
				break;
			case 4:
				deleteProductHelper();
				break;
			}
		} while (option != 5);
	}
	
	private void addProductHelper() {
		int discount = sc.getInt("What Discount?");
		int[] ivas = {6, 13, 23};
		int iva = sc.getValidInt("What Iva?", ivas);
		float pvp = sc.getFloat("What PVP?");
		Product newProduct = new Product(discount, iva, pvp);
		prodRep.add(newProduct);
	}
	
	private void editProductHelper() {
		long productId = sc.getLong("What Product to edit? Insert Id");
		Product productToEdit = prodRep.get(productId);
		
		editShelvesIds (productToEdit);
		
		editDiscount (productToEdit);
		
		editIva (productToEdit);
		
		editPvp (productToEdit);
		
		prodRep.update(productToEdit);
	}
	
//	editProductHelper Helpers
	
	private void editShelvesIds (Product product) {
		long shelfId = sc.getLong("What Shelf? Insert Id");
		if (shelfRep.get(shelfId) != null) {
			List<Long> shelvesIds = new ArrayList<Long>();
			shelvesIds.add(shelfId);
			product.setShelvesIds(shelvesIds);
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
	
//	end of editProductHelper Helpers
	
	private void consultProductHelper() {
		long productId = sc.getLong("What Product to consult? Insert Id");
		System.out.println(prodRep.get(productId));
	}
	
	private void deleteProductHelper() {
		long productId = sc.getLong("What Product to remove? Insert Id");
		Product produto = prodRep.get(productId);
		deleteFromShelf(produto);
		prodRep.delete(productId);
		System.out.println("Deleted");
	}
	
	private void deleteFromShelf(Product produto) {
		Iterator<Long> shelfIdInterator = produto.getShelvesIds().iterator();
		while (shelfIdInterator.hasNext()) {
			Long shelfId = shelfIdInterator.next();
			shelfRep.get(shelfId).setProductId(0);
		}
	}

}
