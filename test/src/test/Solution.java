package test;

import java.util.Scanner;
import java.io.FileInputStream;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

class Solution {
	public static void main(String args[]) throws Exception {
		/*
		 * 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 sample_input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
		 * 만약 본인의 PC 에서 테스트 할 때는, 입력값을 sample_input.txt에 저장한 후 이 코드를 첫 부분에 사용하면,
		 * 표준입력 대신 sample_input.txt 파일로 부터 입력값을 읽어 올 수 있습니다. 또한, 본인 PC에서 아래 메소드를
		 * 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다. 단, Codeground 시스템에서 "제출하기" 할 때에는 반드시
		 * 이 메소드를 지우거나 주석(//) 처리 하셔야 합니다.
		 */
		Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도
			// 됩니다.
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			//System.out.println("nodeNum:" + nodeNum +", courseNum:"+courseNum+", ticketVal:"+ticketVal);
			int[][] D = new int[N][N];
			//초기화
			
			for(int i=0 ; i<N ; i++){
				for(int j=0;j<N ; j++){
					if(i==j){
						D[i][j] = 0;
                    }else{
                    	D[i][j] = 9999999;
                    }
				}
			}
			for(int i =0 ;i<M ;i++){
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				int val = sc.nextInt();
				D[a][b] = val;
				D[b][a] = val;
			}
			//플로이드 알고리즘 시작
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						D[i][j] = (D[i][j] <= D[i][k] + D[k][j] ? D[i][j] : D[i][k] + D[k][j]);
						System.out.println("D["+i+"]["+j+"]:"+D[i][j]+", D["+i+"]["+k+"]:"+D[i][k]+", D["+k+"]["+j+"]:"+D[k][j]);
					}
				}
			}
			int P = sc.nextInt();
			int buy = 0;
			for(int i =0;i<P;i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(D[a-1][b-1]>K){
					buy++;
				}
			}
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(buy);
		}
	}
}
//	public static void printArr(int[][] arr){
//		int x = arr[0].length;
//		int y = arr.length;
//		for(int i=0 ; i<y ; i++){
//			System.out.print("(");
//			for(int j=0;j<x ; j++){
//				System.out.print(arr[i][j]);
//				System.out.print(",");
//			}
//			System.out.println(")");
//		}
//	}
