package catalogue;

import java.io.Serializable;
import middle.StockReader;
import clients.cashier.BetterCashierModel;

/**
 * Write a description of class BetterBasket here.
 * 
 * @author  Your Name 
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable
{
  private static final long serialVersionUID = 1L;
  private static long lastUpdate = 0;
  private static final long EXPIRYTIME = 60000;
  boolean flag = true;
  

  public BetterBasket() {
	  super();
  }
  
  @Override
  public boolean add(Product pr) {
	  	  
	  lastUpdate = System.currentTimeMillis();
	  
      // Check if the product already exists in the basket
      for (Product existingProduct : this) {
    	  
          if (existingProduct.getProductNum().equals(pr.getProductNum())) {
              // If the product exists, update the quantity
              int newQuantity = existingProduct.getQuantity() + pr.getQuantity();
              existingProduct.setQuantity(newQuantity);
              
              return true;
          }
      } 
      
      //Goes through the products in the array
      for (int i = 0; i < this.size(); i++) {
    	  //checks them against the products in the array
          if (pr.getProductNum().compareTo(this.get(i).getProductNum()) < 0) {
        	  //Adds the product when it gets to the correct part.
              this.add(i, pr);
              return true;
          }
      }
      
      
      // If the product does not exist, add it to the basket
      return super.add(pr);
      
  }
  
  public void isExpired() {
	  if ((System.currentTimeMillis() - lastUpdate) > EXPIRYTIME) {
		  super.clear();
	  }
  }
  
  public void clearBasket() {
	  super.clear();
  }
  
  
}
