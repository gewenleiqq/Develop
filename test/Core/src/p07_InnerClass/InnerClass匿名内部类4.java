package p07_InnerClass;


/**　　
 * 如果你有一个匿名内部类，它要使用一个在它的外部定义的对象，
编译器会要求其参数引用是final 型的，就像dest()中的参数。
如果你忘记了，会得到一个编译期错误信息。如果只是简单地给一个成员变量赋值，
那么此例中的方法就可以了。但是，如果你想做一些类似构造器的行为，该怎么办呢？
在匿名类中不可能有已命名的构造器（因为它根本没名字！），但通过实例初始化，
你就能够达到为匿名内部类“制作”一个构造器的效果。像这样做：
**/

abstract class Base {
	public Base(int i) {
		System.out.println("Base constructor, i = " + i);
	}
	public Base() {
		System.out.println("Base constructor no param" );
	}
	public abstract void f();
}
/**
 * 在此例中，不要求变量i 一定是final 的。因为i 被传递给匿名类的基类的构造器，
它并不会在匿名类内部被直接使用。
 */
public class InnerClass匿名内部类4 {
	public static Base getBase(int i) {
		return new Base(i) {
			{
				System.out.println("Inside instance initializer");
			}
			public void f() {
				System.out.println("In anonymous f()");
			}
		};
	}
	public static void main(String[] args) {
		Base base = getBase(47);
		base.f();
	}
}

/**在此例中，不要求变量i 一定是final 的。因为i 被传递给匿名类的基类的构造器，
它并不会在匿名类内部被直接使用。下例是带实例初始化的“parcel”形式。
注意dest()的参数必须是final，因为它们是在匿名类内被使用的。
**/
@SuppressWarnings("unused")
class Parcel9 {
	public Base dest(final String dest, final float price) {
		Base ba = new Base() {
			private int cost;
			// Instance initialization for each object:
			{
				cost = Math.round(price);
				if(cost > 100)System.out.println("Over budget!");
			}

			private String label = dest;
			public String readLabel() { 
				return label; 
			}
			@Override
			public void f() {
				System.out.println(label);
				
			}
		};
		ba.f();
		return ba;
	}
	public static void main(String[] args) {
		Parcel9 p = new Parcel9();
		Base d = p.dest("Tanzania", 101.395F);
	}
}





/**
　　在实例初始化的部分，你可以看到有一段代码，那原本是不能作为成员变量初始化的一部分而执行的（就是if 语句）。
  所以对于匿名类而言，实例初始化的实际效果就是构造器。当然它受到了限制：你不能重载实例初始化，
  所以你只能有一个构造器。


　
**/

