package baekjoon;

import java.util.Scanner;

//단어의 개수 1152번
public class WordCount {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		//System.out.println(str);
		str = str.trim();
		String[] array = str.split(" ");
		if(str.equals("")){
			System.out.println(0);
		}else{
			System.out.println(array.length);
		}
//		System.out.println(str.equals(""));
//		for(int i=0; i<array.length; i++){
//			System.out.println(array[i]);
//		}
	}
}
