package p16_ClassLoad;

public class ClassLoadTest {
	public static void main(String args[]) throws Exception{
		Class.forName("p16ClassLoad.LoadObj").newInstance();
		/**
		 * 1在2前加载说明：静态块是按顺序加载
		 * 3打印a:11,0,13,14说明：非final静态成员按顺序加载，静态块用到的非final静态成员是按顺序加载，final静态成员优先非final静态成员和静态方法（块）加载，
		 * 非静态部分初始化顺序为：声明顺序
		 * 类继承体系初始化顺序：a.父类静态部分b.子类静态部分c.父类非静态部分d.子类非静态部分
		 */
	}
}
class Obj{
	
}
class LoadObj{
	static int 			a1=11;
	final static int 	a3=13;
	static Obj obj1=new Obj();
	final static Obj obj3=new Obj();
	static {//1
		a();
	}
	static int 			a2=12;
	final static int 	a4=14;
	static Obj obj2=new Obj();
	final static Obj obj4=new Obj();

	static {//2
		b();
	}
	int b=2;
	
	
	public static void a(){
		System.out.println("3------"+a1+","+a2);//3
		System.out.println("3------"+a3+","+a4);//3
		System.out.println("3------"+obj1+","+obj2);//3
		System.out.println("3------"+obj3+","+obj4);//3

	}
	
	public static void b(){
		System.out.println("b:");
	}
	
	public  void c(){
		System.out.println("c:");
	}	
	
	public  void d(){
		System.out.println("d:");
	}	
}
