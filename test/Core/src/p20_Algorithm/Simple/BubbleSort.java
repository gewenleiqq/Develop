package p20_Algorithm.Simple;


public class BubbleSort {
	public static void main(String args[]){
		Integer[] arry = new Integer[]{10,1,8,3,123,543,63};
		for(int out=arry.length-1;out>0;out--){
			for(int in=0;in<out;in++){
				if(arry[in]>arry[in+1]){
					int temp=arry[in];
					arry[in]=arry[in+1];
					arry[in+1]=temp;
				}
			}
		}
	}
	 
}
