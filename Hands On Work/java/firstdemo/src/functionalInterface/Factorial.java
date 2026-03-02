package functionalInterface;

@FunctionalInterface
interface Fact{
	int calcFact(int a);
}
public class Factorial {

	public Factorial() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Fact fact = (int n) -> {
			int factorial=1;
			for(int i=1;i<=n;i++) {
				factorial=factorial*i;
			}
			return factorial;
		};
		System.out.println(fact.calcFact(5));
	}
}