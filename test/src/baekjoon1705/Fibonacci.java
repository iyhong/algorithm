package baekjoon1705;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] result = new int[46];
		result[0] = 0;
		result[1] = 1;
		
		for(int i=2; i<=n; i++){
			result[i] = result[i-2] + result[i-1];
		}
		
		System.out.println(result[n]);
		
		sc.close();
	}
}
