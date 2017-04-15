package baekjoon;

import java.util.Scanner;

public class MakeOne {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int count = 0;
		int temp = X;
		
		while(temp!=1){
			if(temp%3==0){
				temp /= 3;
				count++;
				System.out.println("temp:"+temp);
			}else if(temp%2==0&&temp/2!=5){
				temp/=2;
				count++;
				System.out.println("temp:"+temp);
			}else{
				temp -= 1;
				count++;
				System.out.println("temp:"+temp);
			}
			
		}
		System.out.println(count);
	}
}
