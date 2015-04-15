package p07_InnerClass;

 



/*注意：内部类是一个编译时的概念，一旦编译成功，就会成为完全不同的两类。
对于一个名为outer的外部类和其内部定义的名为inner的内部类。编译完成后出现outer.class和outer$inner.class两类。
B:局部内部类
在方法中定义的内部类称为局部内部类。与局部变量类似，局部内部类不能有访问说明符，因为它不是外围类的一部分，
但是它可以访问当前代码块内的常量，和此外围类所有的成员。*/


public class InnerClass局部内部类 {
	private int s = 100;
	private int out_i = 1;
	
	@SuppressWarnings("unused")
	public void f(final int k) {
		final int s = 200;
		int i = 1;
		final int j = 10;
	
		//定义在方法内部
		class Inner {
			int s = 300; // 可以定义与外部类同名的变量
		
		
			// static int m = 20; //不可以定义静态变量
			Inner(int k) {
				inner_f(k);
			}
	
			int inner_i = 100;
	
			void inner_f(int k) {
				//如果内部类没有与外部类同名的变量，在内部类中可以直接访问外部类的实例变量
				System.out.println(out_i);
				//可以访问外部类的局部变量(即方法内的变量)，但是变量必须是final的
				System.out.println(j);
				//System.out.println(i);
				//如果内部类中有与外部类同名的变量，直接用变量名访问的是内部类的变量
				System.out.println(s);
				//用this.变量名访问的也是内部类变量
				System.out.println(this.s);
				//用外部类名.this.内部类变量名访问的是外部类变量
				System.out.println(InnerClass局部内部类.this.s);
			}
		}
		new Inner(k);
	}

	public static void main(String[] args) {
		// 访问局部内部类必须先有外部类对象
		InnerClass局部内部类 out = new InnerClass局部内部类();
		out.f(3);
	}
}
