package baekjoon1705;

import java.util.Scanner;

public class RGBstreet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] X = new int[n][3];
		int min = 9999;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				X[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i < n; i++) {
			X[i][0] += Math.min(X[i - 1][1], X[i - 1][2]);
			X[i][1] += Math.min(X[i - 1][0], X[i - 1][2]);
			X[i][2] += Math.min(X[i - 1][0], X[i - 1][1]);
		}
		for(int i=0; i<3; i++){
			if(min>X[n-1][i]){
				min = X[n-1][i];
			}
		}
		System.out.println(min);

	}
}
