package product;

import java.util.Arrays;

// el을 사용할 때로 beans 형식의 클래스가 필요하다.
// 상품 정보를 저장
public class Product {
	
	// 상품 목록 : 배열로 저장
	private String[] productList = {"item1", "item2", "item3", "item4", "item5"};
	
	// 변수 : el 테스트용
	private int price = 100;
	private int amount = 1000;
	
	public String[] getProductList() {
		return productList;
	}
	public int getPrice() {
		return price;
	}
	public int getAmount() {
		return amount;
	}
	
	public String getDisplay() {
		return "price : " + this.price + ", amount : " + this.amount;
	}
	@Override
	public String toString() {
		return "Product [productList=" + Arrays.toString(productList) + ", price=" + price + ", amount=" + amount + "]";
	}
}
