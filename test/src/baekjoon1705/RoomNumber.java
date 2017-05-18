package baekjoon1705;
//백준 1475번 방번호
import java.util.Scanner;

public class RoomNumber {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[] count = new int[10];
		int sixOrNine = 0;
		
		String str = sc.nextLine();
		String[] strArray = str.split("");
		int[] array = new int[strArray.length];
		for(int i=0; i<strArray.length; i++){
			array[i] = Integer.parseInt(strArray[i]);
		}
		
		int length = array.length;
		for(int i=0; i<length; i++){
			int tmp = array[i];
			//System.out.println("tmp:"+tmp);
			if(tmp==6 || tmp==9)
				sixOrNine++;
			else{
				count[tmp]++;
			}
		}
		//System.out.println(sixOrNine);
		int sn = (int) Math.ceil((double)sixOrNine / 2);
		//System.out.println(sn);
		count[9] = sn;
		
//		for(int i=0; i<10; i++){
//			System.out.print(count[i]+", ");
//		}
//		System.out.println();
		int max = 0;
		for(int i=0; i<10; i++){
			int tmp = count[i];
			if(tmp>max){
				max = tmp;
			}
		}
		System.out.println(max);
	}
}
