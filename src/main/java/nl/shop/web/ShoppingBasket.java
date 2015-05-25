package nl.shop.web;

import java.util.ArrayList;
import java.util.List;

import nl.shop.domain.Product;

public class ShoppingBasket {

	public List<BasketItem> getItems() {
		return items;
	}

	public void setItems(List<BasketItem> items) {
		this.items = items;
	}



	private List<BasketItem> items = new ArrayList<>();

	public void addProduct(Product product) {
		BasketItem productBasketItem = findExistingBasketItem(product);
		if (productBasketItem == null) {
			productBasketItem = new BasketItem(product);
			items.add(productBasketItem);
		}
		productBasketItem.incrementamount();
	}

	private BasketItem findExistingBasketItem(Product product) {
		BasketItem productBasketItem = null;
		for (BasketItem item : items) {
			if (item.getProduct().equals(product)) {
				productBasketItem = item;
				break;
			}
		}
		return productBasketItem;
	}

}
