package bigdecimal;

import java.math.BigDecimal;

public class TestPrecision {

	public TestPrecision() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		double a=0.1;
		double b=0.2;
		System.out.println("Double :"+ (a+b));
		BigDecimal aa= new BigDecimal(0.1);
		BigDecimal bb= new BigDecimal(0.2);
		System.out.println(aa.add(bb));
		BigDecimal aaa= new BigDecimal("0.1");
		BigDecimal bbb= new BigDecimal("0.2");
		System.out.println(aaa.add(bbb));
	}

}
