package p07_InnerClass;

/**下面的代码展示的是，如果你的基类需要一个有参数的构造器，应该怎么办：**/
public class InnerClass匿名内部类2 {
	public Wrapping wrap(int x) {
		// Base constructor call:
		return new Wrapping(x) { // Pass constructor argument.
			public int value() {
				return super.value() * 47;
			}
		}; // Semicolon required
	}
	public static void main(String[] args) {
		InnerClass匿名内部类2 p = new InnerClass匿名内部类2();
		Wrapping w = p.wrap(10);
		System.out.println(w.value());

	}
	class Wrapping{
		private int x;
		public Wrapping(int x) {
			this.x=x;
		}
		public int value(){
			return this.x;
		}
	}
}
/**　　
 * 只需简单地传递合适的参数给基类的构造器即可，这里是将x 传进new Wrapping(x)。
 * 在匿名内部类末尾的分号，并不是用来标记此内部类结束（C++中是那样）。
 * 实际上，它标记的是表达式的结束，只不过这个表达式正巧包含了内部类罢了。
 * 因此，这与别的地方使用的分号是一致的。
 */

