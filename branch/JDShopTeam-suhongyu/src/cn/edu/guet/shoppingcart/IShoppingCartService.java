package cn.edu.guet.shoppingcart;

import java.util.List;

import cn.edu.guet.exception.DaoException;
import cn.edu.guet.product.Product;

public interface IShoppingCartService {

	void addProductToCart(ShoppingCart s) throws DaoException;
	
	List<ShoppingCart> selectShoppingCart(String customerId);
}