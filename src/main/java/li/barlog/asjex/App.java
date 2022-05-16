package li.barlog.asjex;

public class App {
	public static void main(String... args) {
		Foo foo = new Foo();
		foo.foo();
		foo.setI(-1);
		foo.setI(42);
		System.out.println("Finally foo.getI()="+foo.getI());
		System.out.println("Distance="+foo.wordDistance("Foo(left)"));
	}
}
