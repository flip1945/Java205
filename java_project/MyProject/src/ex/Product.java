package ex;

public class Product {
	
	private final int price;
	private int bonusPoint;
	
	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public int getPrice() {
		return price;
	}

	public Product(int price) {
		this.price = price;
		this.bonusPoint = (int)(price / 10.0);
	}
	
}
