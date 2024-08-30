package clients.cashier;

import catalogue.Basket;
import catalogue.BetterBasket;
import catalogue.Product;
import debug.DEBUG;
import middle.MiddleFactory;
import middle.StockReader;

public class BetterCashierModel extends CashierModel {
	StockReader theStock = null;
	Product theProduct = null;
	int currentStock = -1;
	
	
	public BetterCashierModel(MiddleFactory mf) {
		super(mf);
		
		try {      
			theStock = mf.makeStockReadWriter();
		} catch ( Exception e ) {
		      DEBUG.error("CashierModel.constructor\n%s", e.getMessage() );
	    }
	}
	
	protected Basket makeBasket() {
		return new BetterBasket();
	}	
	
	public void doBuy() {
		super.doBuy();
			
	}		
	
	public void doBought() {
		super.doBought();
	}
	
	
}
