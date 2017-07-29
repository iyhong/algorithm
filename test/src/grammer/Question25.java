package grammer;

public class Question25 {
	
	public static void main(String[] args){
		A x = new B();
		C y = new C();
		A z = new C();

		x.a2();	//a
		z.a2(); //b
		//z.c1(); //c
		z.a1(); //d 
		y.c1(); //e
		x.a1(); //f
	}
}

abstract class A {
	abstract void a1();

	void a2() {
	}
}

class B extends A {
	void a1() {
	}

	void a2() {
	}
}

class C extends B {
	void c1() {
	}
}