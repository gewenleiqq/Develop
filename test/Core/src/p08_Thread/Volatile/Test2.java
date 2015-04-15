package p08_Thread.Volatile;

 
 
public class Test2 {
	static int i = 0, j = 0;
	static synchronized void one() {
		i++;
		j++;
	}
	static synchronized void two() {
		System.out.println("i=" + i + " j=" + j);
	}
}