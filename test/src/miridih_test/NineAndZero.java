package miridih_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
// 문제 제목 : 9와0
// 프로그램의 핵심 알고리즘을 간략히 기술
//	- 8자리의 이진수에 9를 곱해 9와 0으로만 이루어져있는 숫자를 만들고
//    그중 입력받은 정수로 나누어 떨어지는 것을 찾음
import java.util.Scanner;

public class NineAndZero {
	public static void main(String[] args) throws FileNotFoundException{
		//Scanner sc = new Scanner(new FileInputStream("src/miridih_test/03-9와0-input07.txt"));
		
		Scanner sc = new Scanner(System.in);
		
//		테스트 케이스 숫자 입력
		int T = sc.nextInt();
//		테스트 케이스 만큼 반복
		int[] n = new int[T];
		for(int i=0; i<T; i++){
			n[i] = sc.nextInt();//0이상의 정수 입력받음
		}
		
		for(int i=0; i<T; i++){
			
			long result = 0;
			
//			정수값을 받을 배열과 문자열값을 담을 배열을 만든다.
			long[] array = new long[999];
			String[] strArray = new String[999];
			
//			System.out.println("array.length:"+array.length);
			
//			1부터 255까지 정수를 2진수로 변환하여 배열에 담는다.
			for(int j=1; j<array.length;j++){
				strArray[j] = Integer.toBinaryString(j);
			}

//			배열 테스트 출력
//			for(int i=1; i<array.length;i++){
//				System.out.println(strArray[i]);
//			}

//			문자열 배열에 담은 2진수를 정수타입으로 변환하고 1을 9로바꾸기 위해 9를 곱한다.
//			그럼 0과 9로만 이루어진 정수만 모을수 있음 0~99999999까지 
			for(int j=1; j<array.length;j++){
				array[j] = Integer.parseInt(strArray[j]);
				array[j] *= 9;
			}
			
//			배열 테스트 출력
//			for(int i=1; i<array.length;i++){
//				System.out.println(array[i]);
//			}
			
//			가장 작은 수 부터 임의의 정수N으로 나누어 나머지가 0인지 확인하고 0이면 result에 담고 반복문을 빠져나간다.
			for(int j=1; j<array.length;j++){
				if(array[j] % n[i] ==0){
					result = array[j];
					break;
				}
			}
//			결과물을 출력한다.
			System.out.println(result);
			
		}
	}
}
