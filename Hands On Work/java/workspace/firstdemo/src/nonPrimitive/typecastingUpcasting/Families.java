package nonPrimitive.typecastingUpcasting;

public class Families {

	public static void main(String[] args) {
		Parents pp = new Parents();
		Childrens cc = new Childrens();
		System.out.println(pp.a);
		System.out.println(pp.b);
		System.out.println(pp);
		//System.out.println(pp.c);
		System.out.println(cc.a);
		System.out.println(cc.b);
		System.out.println(cc.c);
		System.out.println(cc);
		Parents p = new Childrens(); //Upcasting  Variable Access Parent
		System.out.println(p.a);
		System.out.println(p.b);
		System.out.println(p);
		//System.out.println(p.c);
	}

}
