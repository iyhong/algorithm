package grammer;

import java.util.Arrays;
import java.util.Collections;

public class Question16 {
	public static void main(String[] args) {
		int[] arr = { 3, 2, 0, 1, 4 };
		int idx = Arrays.binarySearch(arr, 2); // idx = -5 잘못된 결과
		System.out.println(idx);

		Arrays.sort(arr); // 배열 arr을 정렬한다.
		System.out.println(Arrays.toString(arr)); // [0,1,2,3,4]
		int idx2 = Arrays.binarySearch(arr, 2); // idx = 2 올바른 결과
		System.out.println(idx2);
		
		
		String[] colors = { "blue", "red", "green", "yellow", "orange" };
		Arrays.sort(colors);
		System.out.println(Arrays.toString(colors)); // 

		int s2 = Arrays.binarySearch(colors, "orange");
		int s3 = Arrays.binarySearch(colors, "violet");
		System.out.println(s2 + " " + s3);
		
	}

}
