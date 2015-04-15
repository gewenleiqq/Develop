package p07_InnerClass;


/**如果在匿名类中定义成员变量，你同样能够对其执行初始化操作：**/
@SuppressWarnings("unused")
public class InnerClass匿名内部类3 {
	// Argument must be final to use inside
	// anonymous inner class:
	public Destination dest(final String s) {
		Destination des = new Destination() {
			private String label = s;
			public String readLabel() { 
				System.out.println(label);
				return label; 
			}
		};
		 
		return des;
	}
	public static void main(String[] args) {
		InnerClass匿名内部类3 p = new InnerClass匿名内部类3();
		Destination d = p.dest("Tanzania");
		
	}
	class Destination{
		 
	}
}
