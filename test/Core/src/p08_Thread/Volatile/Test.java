package p08_Thread.Volatile;

 
 
public class Test {
	public static void main(String args[]){
		new Thread() {
			public void run() {
				Test1.one();
			};
		}.start();
		new Thread() {
			public void run() {
				Test1.one();
			};
		}.start();
		new Thread() {
			public void run() {
				Test1.two();
			};
		}.start();
	}
}