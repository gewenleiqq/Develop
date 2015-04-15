package p31_CpuEffectiveDemo;

import java.nio.ByteBuffer;
public class MemoryHighDemo {
	public static void main(String[] args) throws Exception{  
		int ll=128*1000*1000;
        Thread.sleep(20000);  
        System.out.println("read to create bytes,so jvm heap will be used");  
        byte[] bytes=new byte[ll];  
        bytes[0]=1;  
        bytes[1]=2;  
        Thread.sleep(10000);  
        System.out.println("read to allocate & put direct bytebuffer,no jvm heap should be used");  
        ByteBuffer buffer=ByteBuffer.allocateDirect(ll);  
        buffer.put(bytes);  
        buffer.flip();  
        Thread.sleep(10000);  
        
        System.out.println("ready to gc,jvm heap will be freed");  
        bytes=null;  
        System.gc();  
        Thread.sleep(10000);  
        
        System.out.println("read to get bytes,then jvm heap will be used");  
        byte[] resultbytes=new byte[ll];  
        buffer.get(resultbytes);//该方法从该缓冲区传输字节到给定的目标数组resultbytes 
        System.out.println("resultbytes[1] is: "+resultbytes[1]);  
        Thread.sleep(10000);  
        
        System.out.println("read to gc all");  
        buffer=null;  
        resultbytes=null;  
        System.gc();  
        Thread.sleep(10000);  
    }  
	    
	 
    
}
/*
Round: 1
......
Round: 10
Execute summary: Round( 10 ) TaskCount Per Round( 200 ) Execute Time ( 10687 ) ms
*/

