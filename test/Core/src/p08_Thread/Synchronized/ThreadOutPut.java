package p08_Thread.Synchronized;

 
public class ThreadOutPut {
	public static void main(String[] args) {
		final Outputter output = new Outputter();
		new Thread() {
			public void run() {
				//output.output("z张三");1
				output.outputSynchronized("z张三");
			};
		}.start();		
		new Thread() {
			public void run() {
				//output.output("l李四");1
				output.outputSynchronized("l李四");
			};
		}.start();
	}
}
