package p06_Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;



public class RandomStr {
	private static final String allStr="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final Random random = new Random();
	private static final File sepDir=new File("e://sepTest//sep");
	private static final File wtFile=new File("e://sepTest//test.txt");
	int max=100000000;//100w个字符串写入文件
	int max_len=max/100;
	final int len=allStr.length();//

	
	public void writeTemp(){
		
	}
	public void init() throws IOException{
		 if(wtFile.exists()&&wtFile.canRead()&&wtFile.canWrite()){
		    	wtFile.delete();
		 }
		 if(!wtFile.exists()&&wtFile.canRead()&&wtFile.canWrite()){
		    	wtFile.createNewFile();
		 }
		 if(sepDir.exists()){
		    	wtFile.delete();
		 }
		 if(!sepDir.exists()){
			 sepDir.mkdirs();
		 }
	}
	public void readF(){
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	    BufferedWriter writer = new BufferedWriter(new FileWriter(wtFile));  
	    
	    RandomStr rm=new RandomStr();
	    rm.init();
		StringBuffer sb=new StringBuffer();
		for(int m=0;m<rm.max;m++){
			char cs=allStr.charAt(random.nextInt(rm.len));
			sb.append(cs);
			if(sb.length()==rm.max_len){
				writer.write(sb.toString()+"\n");
				sb=new StringBuffer();
			}
		}
		writer.close();
 	}

}
