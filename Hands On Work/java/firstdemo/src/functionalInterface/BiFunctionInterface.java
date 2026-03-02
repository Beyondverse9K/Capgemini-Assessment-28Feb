package functionalInterface;

import java.util.function.BiFunction;

public class BiFunctionInterface {

	public BiFunctionInterface() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		//Lambda Expression
		BiFunction<Double, Double, Double> ff = (m,n) -> Math.pow(m,n);
		System.out.println(ff.apply(6.0, 7.0));
		//Method Reference for static methods
		BiFunction<Double, Double, Double> f = Math::pow;
		System.out.println(f.apply(2.5, 3.5));
		//Method Reference for static methods
		BiFunction<Double, Double, Double> fff = BiFunctionInterface::divide;
		System.out.println(fff.apply(10.0, 0.0));
		//Lambda Expression
		BiFunction<Double, Double, Double> ffff = (m,n) -> BiFunctionInterface.divide(m,n);
		System.out.println(ffff.apply(20.0, 6.0));
	}
	public static double divide(double a,double b) {
		if(b!=0)
			return a/b;
		return Double.NaN;
	}
}
