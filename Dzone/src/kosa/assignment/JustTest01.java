package kosa.assignment;

import java.util.Arrays;

public class JustTest01 {
	
	public static void main(String[] args) {
		int arr[] = {6,2,8,9,7,3};
		
		int temp=0;
		// 배열 역순화
		for(int i=0; i<(arr.length)/2; i++) { // 나누기2를 또 안했음!!바봐보바보바보바보바봐바바보바보바보
			temp = arr[i];
			arr[i] = arr[(arr.length-1)-i]; 
			arr[(arr.length-1)-i] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}
}
