package ex;

public class Buyer {

	private int money;
	private int bonusPoint;
	private Product[] item;
	private int cnt; // 구매한 제품의 개수 -> 배열의 입력 index 값

	public Buyer() {
		this.money = 10000;
		this.bonusPoint = 0;
		this.item = new Product[10];
		this.cnt = 0;
	}
	
	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getBonusPoint() {
		return this.bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public Product[] getItem() {
		return item;
	}

	public void setItem(Product[] item) {
		this.item = item;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public void buy(Product p) {
		
		if (this.money < p.getPrice()) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		
		this.money -= p.getPrice();
		this.bonusPoint += p.getBonusPoint();
		
		// 구매내역에 제품을 추가
		
		item[cnt++] = p;
		
		System.out.println(p + " 구매");
	}
	
	public void summary() {
		// 구매 상품 리스트, 구매 금액의 총합 출력
		
		int sum = 0; // 구매 총액
		int sumBonusPoint = 0;
		StringBuilder itemList = new StringBuilder();
		
		for (int i = 0; i < cnt; i++) {
			// 금액의 합
			sum += item[i].getPrice();
			// 적립될 보너스 포인트
			sumBonusPoint += item[i].getBonusPoint();
			// 구매 상품 이름
			itemList.append(item[i] + ", ");
		}
		
		System.out.println("구매하신 제품은 " + itemList + "입니다.");
		System.out.println("구매하신 제품의 총 금액은 " + sum + "원 입니다.");
		System.out.println("구매하신 제품의 총 보너스 포인트는 " + sumBonusPoint + "원 입니다.");
	}
	
}
