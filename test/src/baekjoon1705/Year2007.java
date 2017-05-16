package baekjoon1705;
//백준 1924번 
import java.util.Scanner;

public class Year2007 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int moon = sc.nextInt();
		int date = sc.nextInt();
		
		int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		String result = "";
		int day = 0;
		for(int i=0; i<moon-1; i++){
			day += month[i];
		}
		day += date;
		
		switch(day%7){
		case 0:
			result = "SUN";
			break;
		case 1:
			result = "MON";
			break;
		case 2:
			result = "TUE";
			break;
		case 3:
			result = "WED";
			break;
		case 4:
			result = "THU";
			break;
		case 5:
			result = "FRI";
			break;
		case 6:
			result = "SAT";
			break;
		}
		
		System.out.println(result);
		
	}
}
