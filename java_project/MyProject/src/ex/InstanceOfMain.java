package ex;

public class InstanceOfMain {
	
	public static void main(String[] args) {
		
		Box box1 = new Box();
		PaperBox box2 = new PaperBox();
		GoldPaperBox box3 = new GoldPaperBox();
		
		wrapBox(box1);
		wrapBox(box2);
		wrapBox(box3);
		
	}
	
	public static void wrapBox(Box box) {
//		if (box instanceof GoldPaperBox) {
//			((GoldPaperBox)box).goldPaperWrap();
//		} else if (box instanceof PaperBox) {
//			((PaperBox)box).paperWrap();
//		} else {
//			box.simpleWrap();			
//		}
		box.wrap();
	}
}

class Box {
	
	public void simpleWrap() {
		System.out.println("SimpleWrap");
	}
	
	public void wrap() {
		System.out.println("SimpleWrap");		
	}
}

class PaperBox extends Box {
	public void paperWrap() {
		System.out.println("PaperWrap");
	}
	
	@Override
	public void wrap() {
		System.out.println("PaperWrap");		
	}
}

class GoldPaperBox extends PaperBox {
	public void goldPaperWrap() {
		System.out.println("GoldPaperWrap");
	}
	
	@Override
	public void wrap() {
		System.out.println("GoldPaperWrap");		
	}
}