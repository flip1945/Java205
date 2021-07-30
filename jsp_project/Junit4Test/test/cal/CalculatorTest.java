package cal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	Calculator cal;
	
	@Before
	public void setUp() {
		cal = new Calculator();
	}

	@Test
	public void testAdd() {
		assertEquals(12, cal.add(10, 2));
	}

	@Test
	public void testSubstract() {
		assertEquals(8, cal.substract(10, 2));
	}

	@Test
	public void testMultiply() {
		assertEquals(20, cal.multiply(10, 2));
	}

	@Test
	public void testDivide() {
		assertEquals(5, cal.divide(10, 2));
	}
	
	//예외 타입을 비교해서 테스트

	@Test(expected = RuntimeException.class)
	public void test1() {
		System.out.println("@Test 실행 중 예외 타입을 테스트");
		throw new RuntimeException();
	}
	
	@Test(timeout = 100)
	public void test2() {
		System.out.println("@Test 테스트 중 허용시간 ms 안에 실행이 완료 되어야 함");
		cal.add(100, 200);
	}
	
	@Test
	public void test3() {
		// fail("테스트 미실행");
		assertTrue(true);
	}
}
