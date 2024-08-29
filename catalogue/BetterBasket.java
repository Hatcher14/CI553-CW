package catalogue;

import java.io.Serializable;

/**
 * Write a description of class BetterBasket here.
 * 
 * @author  Your Name 
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable
{
  private static final long serialVersionUID = 1L;
  

  public BetterBasket() {
	  super();
  }
  
  @Override
  public boolean add(Product pr) {
      // Check if the product already exists in the basket
      for (Product existingProduct : this) {
          if (existingProduct.getProductNum().equals(pr.getProductNum())) {
              // If the product exists, update the quantity
              int newQuantity = existingProduct.getQuantity() + pr.getQuantity();
              existingProduct.setQuantity(newQuantity);
              return true;
          }
      } 
      
      for (int i = 0; i < this.size(); i++) {
          if (pr.getProductNum().compareTo(this.get(i).getProductNum()) < 0) {
              this.add(i, pr);
              return true;
          }
      }
      
      
      // If the product does not exist, add it to the basket
      return super.add(pr);
  }
  
}
