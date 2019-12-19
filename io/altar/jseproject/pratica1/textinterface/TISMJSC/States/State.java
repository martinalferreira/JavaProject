package io.altar.jseproject.pratica1.textinterface.TISMJSC.States;

import io.altar.jseproject.business.ProductBusiness;
import io.altar.jseproject.business.ShelfBusiness;
import io.altar.jseproject.pratica1.textinterface.ScannerUtils.ScannerUtils;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public abstract class State {
	public static final ScannerUtils sc = new ScannerUtils();
	ProductBusiness prodBus = new ProductBusiness();
	ShelfBusiness shelfBus = new ShelfBusiness();
	
	public abstract int run();
}
