package seconddemo;

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
//		Parents p1 = new Parents();
//		Childrens c = (Childrens) p1; //Class Cast Exception
		Childrens ccc = new Childrens();
		Parents upcastedVar = ccc; //Upcasting 
		Childrens downcastedVar = (Childrens) upcastedVar; //Downcasting/
		System.out.println(ccc);
		System.out.println(upcastedVar);
		System.out.println(downcastedVar);
		System.out.println(downcastedVar.a);
		System.out.println(downcastedVar.b);
		System.out.println(downcastedVar.c);
		
	}

}
