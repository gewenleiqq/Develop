package p03_extend;

abstract class SuperClass {
	private int number;


	public SuperClass() {
		this.number = 0;
	}


	public SuperClass(int number) {
		this.number = number;
	}


	public int getNumber() {
		number--;
		return number;
	}
}

class SubClass1 extends SuperClass {
	public SubClass1(int number) {
		super(number);
	}

}

class SubClass2 extends SuperClass {

	public SubClass2(int number) {
		super(number);
	}

}

class SubClass3 extends SuperClass {

	private int number=11;


	public SubClass3(int number) {
		super(number);
	}


	public int getNumber() {
		number--;
		return number;
	}
}

class SubClass4 extends SuperClass {

	public SubClass4(int number) {
		super(number);
	}


	 
}
public class VistorSuper{
	public static void main(String[] args) {
		SuperClass s = new SubClass3(20);
		SuperClass s1 = new SubClass1(20);
		SuperClass s2 = new SubClass2(20);
		SuperClass s4 = new SubClass4(20);
		System.out.println(s.getNumber());
		System.out.println(s1.getNumber());
		System.out.println(s2.getNumber());
		System.out.println(s4.getNumber());
		//结论一：多态时，当子类覆盖了父类的方法，使用子类覆盖的方法
		//结论二：当子类覆盖父类的成员变量时，父类方法使用的是父类的成员变量，子类方法使用的是子类的成员变量
	}
}