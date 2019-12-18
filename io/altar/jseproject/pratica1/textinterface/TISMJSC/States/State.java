package io.altar.jseproject.pratica1.textinterface.TISMJSC.States;

import io.altar.jseproject.pratica1.textinterface.ScannerUtils.ScannerUtils;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public abstract class State {
	public static final ScannerUtils sc = new ScannerUtils();
	ProductRepository prodRep = ProductRepository.getInstance();
	ShelfRepository shelfRep = ShelfRepository.getInstance();

	public abstract int run();
}
