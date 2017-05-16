package midas;

import java.io.IOException;
import java.util.Scanner;

public class PrimeSum {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// 입력 받는 숫자
		int M = sc.nextInt();
		int N = sc.nextInt();

		// 나머지
		int r = 0;

		int result = 0;
		// 1을 제외한 2부터 입력한 숫자가 될때까지 약수 모두 구하기
		for (int i = M; i <= N; i++) {
			// 2부터 자기자신이 될 때까지 나누주는 수
			for (int k = 2; k <= i; k++) {
				r = i % k;
				if (r == 0) {
					// 나머지가 0이고, 자기 자신으로 나누어 떨어지지 않을 경우 중단
					if (i != k) {
						break;
					}
					// 자기 자신으로만 나누어 질 경우 출력
					//System.out.println(i);
					result += i;
				}
			}
		}
		if(result>0){
			System.out.println(result);
		}else{
			System.out.println(-1);
		}
		sc.close();
	}
}