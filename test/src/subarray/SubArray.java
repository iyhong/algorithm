package subarray;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class SubArray {
	public static void main(String args[]) throws Exception{
		/* 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 sample_input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
		   만약 본인의 PC 에서 테스트 할 때는, 입력값을 sample_input.txt에 저장한 후 이 코드를 첫 부분에 사용하면,
		   표준입력 대신 sample_input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
		   또한, 본인 PC에서 아래 메소드를 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다.
		   단, Codeground 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석(//) 처리 하셔야 합니다. */
		Scanner sc = new Scanner(new FileInputStream("sample.txt"));
     
		//Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도 됩니다.
			
			int N = sc.nextInt();//자연수 갯
			int S = sc.nextInt();//임의의 값
			int[] array = new int[N];
		//	System.out.println("갯수:"+N+", 임의의 값:"+S);
			
			//배열 입력 
			for(int i=0; i<N;i++){
				array[i] = sc.nextInt();
			}
			
			//배열 출력
			for(int i=0; i<N; i++){
				System.out.print(array[i]+",");
			}
			System.out.println();

			int result = 0;
			breakout :
			for(int i=0; i<N-1;i++){
				int batch = i+2;
				System.out.println("batch:"+batch);
				int start = 0;
				//j는 반복회수
				for(int j=0; j<N-i-1;j++){
					int sum = 0;
					for(int k=0;k<batch;k++){
						sum += array[start+k];
						System.out.println("array["+(start+k)+"]="+array[start+k]);
						System.out.println("sum:"+sum);
					}
					start++;
					System.out.println("묶음 for문 끝 ");
					if(sum>=S){
						result = batch;
						break breakout;
					}
				}
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("#testcase" + test_case);
			System.out.println(result);
		}
	}
}
