package midas;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GatePassword {
	static int[] in;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //자릿수
		int M = sc.nextInt(); //숫자 갯수

		in = new int[M];
		for(int i=0; i<M; i++){
			in[i] = sc.nextInt();
		}
		Arrays.sort(in);
		combination(in, 0, M, N, 0);
	}

	public static void combination(int[] arr, int index, int m, int n, int target) {
		System.out.println("n:"+n+", target:"+target);

		if (n == 0)
			print(arr, index);
		else if (target == m)
			return;
		else {
			System.out.println("target:"+target);
			arr[index] = in[target];
			combination(arr, index + 1, m, n - 1, target+1);
			combination(arr, index, m, n, target+1);
		}
	}// end combination()

	public static void print(int[] arr, int length) {
		for (int i = 0; i < length; i++)
			System.out.print(arr[i]);
		System.out.println("");
	}

}
