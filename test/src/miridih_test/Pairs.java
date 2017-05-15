package miridih_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

//문제 제목 : 정수쌍(Pairs) 
//프로그램의 핵심 알고리즘을 간략히 기술
//	0번째 배열값과 나머지 배열의 차를 구해보고 그 차가 K와 같으면 count+1해준다.
//  그다음 1번째 배열값과 그 뒤의 배열값들의 차를 구하고 K와 같으면 count+1
//  계속 반복

import java.util.Scanner;

public class Pairs {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new FileInputStream("src/miridih_test/01-정수쌍-input00.txt"));

		//Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();//입력받을 정수의 갯수
		int K = sc.nextInt();//차이 값
		
		int count = 0;//결과 담을 변수
		
		int[] array = new int[N];
	
//		입력받은 숫자들 배열에 담는다.
		for(int i=0; i<N; i++){
			array[i] = sc.nextInt();
		}
		
//		i는 0부터 3까지 4번 반복 
		for(int i=0; i<N-1;i++){
//			j는 i+1부터 4까지 반복
			for(int j=i+1; j<N;j++){
//				System.out.println(i+", "+j);
//				배열의 차을 구하고 그 차의 절다값으로 K와 비교한다.
				int minus = array[i]-array[j];
				if(Math.abs(minus)==K){
					count++;
				}
			}
		}
//		결과출력
		System.out.println(count);
	}
}
