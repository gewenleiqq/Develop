package p07_InnerClass;

/**内部类的继承问题（thinking in java 3th p294）


因为内部类的构造器要用到其外围类对象的引用，所以在你继承一个内部类的时候，事情变得有点复杂。
问题在于，那个“秘密的”外围类对象的引用必须被初始化，而在被继承的类中并不存在要联接的缺省对象。
要解决这个问题，需使用专门的语法来明确说清它们之间的关联：
**/
class WithInner {
	class Inner {
		Inner(){
			System.out.println("this is a constructor in WithInner.Inner");
		};
	}
}

@SuppressWarnings("unused")
public class InnerClass匿名内部类7 extends WithInner.Inner {
	// ! InheritInner() {} // Won't compile
	InnerClass匿名内部类7(WithInner wi) {
		wi.super();
		System.out.println("this is a constructor in InheritInner");
	}
	public static void main(String[] args) {
		WithInner wi = new WithInner();
		InnerClass匿名内部类7 ii = new InnerClass匿名内部类7(wi);
	}
}


/**　输出结果为：
this is a constructor in WithInner.Inner
this is a constructor in InheritInner

可以看到，InheritInner 只继承自内部类，而不是外围类。但是当要生成一个构造器时，缺省的构造器并不算好，
而且你不能只是传递一个指向外围类对象的引用。此外，你必须在构造器内使用如下语法：

enclosingClassReference.super();
这样才提供了必要的引用，然后程序才能编译通过。**/