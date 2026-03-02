package functionalInterface;

@FunctionalInterface
interface Add{
	void sum(int a,int b);
}
@FunctionalInterface
interface Sub{
	void min(int a,int b);
}
@FunctionalInterface
interface Mul{
	void mul(int a,int b);
}
@FunctionalInterface
interface Div{
	void div(int a,int b);
}
public class Calculator {

	public static void main(String[] args) {
		Add add = (int a,int b) -> {
			System.out.println(a+b);
		};
		add.sum(5, 10);
		Sub sub = (int a,int b) -> {
			System.out.println(a-b);
		};
		sub.min(10, 5);
		Mul mul = (int a,int b) -> {
			System.out.println(a*b);
		};
		mul.mul(5, 6);
		Div div = (int a,int b) -> {
			System.out.println(a/b);
		};
		div.div(10, 2);
	}
}
