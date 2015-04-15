package p07_InnerClass;
/**
6内部类的重载问题

如果你创建了一个内部类，然后继承其外围类并重新定义此内部类时，会发生什么呢？也就是说，内部类可以被重载吗？
这看起来似乎是个很有用的点子，但是“重载”内部类就好像它是外围类的一个方法，其实并不起什么作用：
**/
@SuppressWarnings("unused")
class Egg {
	private Yolk y;
	
	protected class Yolk {
		public Yolk() {
			System.out.println("Egg.Yolk()");
		}
	}

	public Egg() {
		System.out.println("New Egg()");
		y = new Yolk();
	}
}


public class InnerClass匿名内部类6 extends Egg {
	public class Yolk {
		public Yolk() {
			System.out.println("BigEgg.Yolk()");
		}
	}

	public static void main(String[] args) {
		new InnerClass匿名内部类6();
	}
}




/**　　输出结果为：


New Egg()
Egg.Yolk()


缺省的构造器是编译器自动生成的，这里是调用基类的缺省构造器。你可能认为既然创建了BigEgg 的对象，
那么所使用的应该是被“重载”过的Yolk，但你可以从输出中看到实际情况并不是这样的。

这个例子说明，当你继承了某个外围类的时候，内部类并没有发生什么特别神奇的变化。
这两个内部类是完全独立的两个实体，各自在自己的命名空间内。当然，明确地继承某个内部类也是可以的：

**/
class Egg2 {
	protected class Yolk {
		public Yolk() {
			System.out.println("Egg2.Yolk()");
		}

		public void f() {
			System.out.println("Egg2.Yolk.f()");
		}
	}


	private Yolk y = new Yolk();


	public Egg2() {
		System.out.println("New Egg2()");
	}

	public void insertYolk(Yolk yy) {
		y = yy;
	}

	public void g() {
		y.f();
	}
}


class BigEgg2 extends Egg2 {
	public class Yolk extends Egg2.Yolk {
		public Yolk() {
			System.out.println("BigEgg2.Yolk()");
		}
		public void f() {
			System.out.println("BigEgg2.Yolk.f()");
		}
	}
	public BigEgg2() {
		insertYolk(new Yolk());
	}

	public static void main(String[] args) {
		Egg2 e2 = new BigEgg2();
		e2.g();
	}
}






/**　　输出结果为：


Egg2.Yolk()
New Egg2()
Egg2.Yolk()
BigEgg2.Yolk()
BigEgg2.Yolk.f()


现在BigEgg2.Yolk 通过extends Egg2.Yolk 明确地继承了此内部类，并且重载了其中的方法。
Egg2 的insertYolk()方法使得BigEgg2 将它自己的Yolk 对象向上转型，然后传递给引用y。
所以当g()调用y.f()时，重载后的新版的f()被执行。
第二次调用Egg2.Yolk()是BigEgg2.Yolk 的构造器调用了其基类的构造器。
可以看到在调用g()的时候，新版的f()被调用了。**/