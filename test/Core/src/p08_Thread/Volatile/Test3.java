package p08_Thread.Volatile;

 
 
public class Test3 {
	static volatile int i = 0, j = 0;
	static void one() {
		i++;
		j++;
	}
	static void two() {
		System.out.println("i=" + i + " j=" + j);
	}
}