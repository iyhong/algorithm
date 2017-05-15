package baekjoon1705;

//문제번호 2577(숫자의개수)
import java.util.Scanner;

public class NumberCount {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int num = a*b*c;
		String str = Integer.toString(num);
		//System.out.println(str);
		String[] arr = str.split("");
		int[] result = new int[10];
		
		for(int i=0; i<arr.length; i++){
			int temp = Integer.parseInt(arr[i]);
			//System.out.println("i:"+i);
			//System.out.println("temp:"+temp);
			result[temp] += 1;
		}
		
		for(int i=0; i<result.length; i++){
			System.out.println(result[i]);
		}
	}
}
