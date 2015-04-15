package p31_CpuEffectiveDemo;

import java.nio.ByteBuffer;
public class ByteBufferDemo {
	public static void main(String[] args) throws Exception{  
		int ll=128*1000*1000;
        byte[] bytes=new byte[ll];  
        bytes[0]=1;  
        bytes[1]=2;  
        ByteBuffer buffer=ByteBuffer.allocateDirect(ll);  
        buffer.put(bytes);  
        buffer.flip();  
        
        System.out.println("ready to gc,jvm heap will be freed");  
       
        System.out.println(buffer.capacity()+"--"+buffer.limit()+"--buffer["+ buffer.position()+"] is: "+buffer.get());
        System.out.println(buffer.capacity()+"--"+buffer.limit()+"--buffer["+ buffer.position()+"] is: "+buffer.get());  

    }  
	    
	 
    
}
