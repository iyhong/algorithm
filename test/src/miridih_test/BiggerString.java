package miridih_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

//문제 제목 : 더 큰 문자열 
//프로그램의 핵심 알고리즘을 간략히 기술
//뒤에서 두번째부터 기준을 앞쪽으로 한칸씩 옮겨가며
//기준 뒤에있는 것중에 기준의 값보다 큰 문자가 있는지 확인하고
//큰 문자가 있으면 그 문자들중 기준의 값과 가장 가까운 크기의 문자를 찾고 
//그 문자와 위치를 바꾼다.
//그 다음 기준 뒤의 문자들은 작은크기 순서대로 정렬한다.

import java.util.Scanner;


public class BiggerString {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new FileInputStream("src/miridih_test/05-더큰문자열-input01.txt"));
		//Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		String[] strArray = new String[t];
//		문자열들 배열에 담는다.
		for(int i=0; i<t; i++){
			strArray[i] = sc.next();
		}
//		출력확인 
//		for(int i=0; i<t; i++){
//			System.out.println("strArray[i]:"+strArray[i]);
//		}
		
//		문자열 하나씩 재정렬시작 
		for(int i=0; i<t; i++){
			char[] charArray = strArray[i].toCharArray();
			
//			for(char a : charArray){
//				System.out.println(a);
//			}

			boolean find = false;//더 큰문자열이 있을때 true로 바꿔줌
			int count = 1;//한바퀴 돌수록 1씩증가한다.
			
//			기준을 맨 뒤에서 두번째부터 시작해서 배열 맨앞까지 온다.
			for(int j=charArray.length-2;j>=0;j--){
				char min = 0;//기준값과 가장 가까운 문자 담을 변수
				int minDiff = 999999;//문자 차이값 담을 변수
				int minPosition = 0;//기준값과 가장 가까운 문자의 위치 담을 변수
				
//				한바퀴 돌때마다 기준이 앞으로 이동하므로 그 뒤에 배열을 탐색하는 횟수가 증가한다.
				for(int k=0;k<count;k++){
//					현재위치의 뒤에 현위치의 값보다 큰게 있으면!!
//					그것들중 가장 작은값을 현위치로 가져온다.
					int diff = charArray[j] - charArray[j+1+k];
//					System.out.println("diff:"+diff);
					
//					현위치의 값보다 큰값이 뒤에 있으면 
					if(diff<0){
						find = true;
						
//						현위치의 값과 가장 차이가 적은 것의 위치와 값을 저장
						if(Math.abs(diff)<minDiff){
							min = charArray[j+1+k];
							minDiff = Math.abs(diff);
							minPosition = j+1+k;
						}
					}
					
//					System.out.println("j:"+j);
//					System.out.println("min:"+min);
//					System.out.println("minDiff:"+minDiff);
//					System.out.println("minPosition:"+minPosition);
				}
				
//				큰값이 기준보다 뒤에 있는경우
//				기준의 값보다 큰값들중 차이가 적은것의 위치를 기준값과 바꾼다.
				if(find){
					char temp = charArray[j];
					charArray[j] = charArray[minPosition];
					charArray[minPosition] = temp;
					
//					System.out.println("교환후j:"+charArray[j]);
//					System.out.println("교환후min:"+charArray[minPosition]);
					
//					현위치 뒤의 것들을 작은 순서대로 정렬한다.(Arrays의 sort()메서드 활용)
					char[] list = new char[count];
					for(int k=0;k<count;k++){
						list[k] = charArray[j+k+1];
					}
					Arrays.sort(list);
//					for(char a : list){
//						System.out.println("정렬한 배열:"+a);
//					}
					
					for(int k=0;k<count;k++){
						charArray[j+k+1] = list[k];
					}
					break;
				}

				count++;
			}
			
//			더 큰 문자열이 있는경우 그 문자열을 출력하고
			if(find){
				for(char a : charArray){
					System.out.print(a);
				}
				System.out.println();
			}else{
//			더 큰 문자열이 없는경우 no answer를 출력한다.
				System.out.println("no answer");
			}
		}
	}
}
