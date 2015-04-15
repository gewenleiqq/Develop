package p20_Algorithm.Simple;


public class SelectSort {
	public static void main(String args[]){
		Integer[] arry = new Integer[]{10,1,8,3,123,543,9};
		int minIndex;
		for(int out=0;out<arry.length-1;out++){
			minIndex=out;
			for(int in=out+1;in<arry.length;in++){
				if(arry[in]<arry[minIndex]){
					minIndex=in;
				}
			}
			int temp=arry[out];
			arry[out]=arry[minIndex];
			arry[minIndex]=temp;
			System.out.println();
			for(int ii:arry){
				System.out.print(" "+ii+" ");
			}
			
		}
		
		
	}
	 
}

