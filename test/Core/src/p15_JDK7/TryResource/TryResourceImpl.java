package p15_JDK7.TryResource;


public class TryResourceImpl implements AutoCloseable {

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("close");
	}
	
	public void doTryResourceClose(){
		System.out.println("do");
	}
	 
}
