package ex;

public class BuyerMain {

	public static void main(String[] args) {
		
		Buyer buyer = new Buyer();
		
		Tv tv = new Tv(1000);
		Computer com = new Computer(300);
		
		// 구매
		buyer.buy(tv);
		buyer.buy(com);
		buyer.buy(tv);
		buyer.buy(com);
		
		// 결과 지표
//		System.out.println("현재 소지한 금액은 " + buyer.getMoney() + "원입니다.");
//		System.out.println("현재 보유한 보너스 포인트는 " + buyer.getBonusPoint() + "점입니다.");
		
		//구매 지표 출력
		buyer.summary();

	}

}
