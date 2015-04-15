package p15_JDK7.TryResource;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class TryResourceTest {
	
	public static void main(String args[]) throws Exception{
		try(
			FileInputStream f=new FileInputStream("C:\\Users\\Administrator\\Desktop\\互联网100强.txt");
			BufferedInputStream bf=new BufferedInputStream(f);
		){
			int data=bf.read();
			while(data!=-1){
				System.out.println((char)data);
				data=bf.read();
			}
		}
		
		try(TryResourceImpl closeImp=new TryResourceImpl()){
			closeImp.doTryResourceClose();
		}
	}
}
