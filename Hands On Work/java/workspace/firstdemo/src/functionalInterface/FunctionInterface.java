package functionalInterface;

import java.util.function.Function;

public class FunctionInterface {

	public FunctionInterface() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Function<Integer, Double> f = (n) -> Math.sqrt(n);
		System.out.println(f.apply(4));
		
		Function<Integer, Double> ff = Math::sqrt;
		System.out.println(ff.apply(16));
	
		Function<Integer,Integer> fff = Math::abs;
		System.out.println(fff.apply(-5));
	}
}
