package baekjoon1705;
//백준 1021번
import java.util.ArrayList;
import java.util.Scanner;

public class RotationQueue {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] num = new int[m];
		ArrayList<Integer> q = new ArrayList<Integer>();
		int count = 0;
		int now = 0;
		
		for(int i=0; i<m; i++){
			num[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++){
			q.add(i+1);
		}
		
		for(int i=0; i<m; i++){
			int tmp = num[i];
//			System.out.println("tmp:"+tmp);
			int right = 0;
			int left = 0;
			int rnow = now;
			int lnow = now;
			int size = q.size();
//			System.out.println("q size:"+size);
//			System.out.println(q);
			//오른쪽으로 이동
			while(q.get(rnow) != tmp){
				//System.out.println("rnow:"+rnow);
				rnow++;
				if(rnow == size){
					rnow = 0;
				}
				right++;
			}
			//왼쪽으로 이동
			while(q.get(lnow) != tmp){
				lnow--;
				if(lnow == -1){
					lnow = size-1;
				}
				left++;
			}
//			System.out.println("right:"+right);
//			System.out.println("lfet:"+left);
			
			//왼쪽으로 도는게 더 작으면
			if(right>left){
				count += left;
				now = lnow;
			//오른쪽으로 도는게 더 작으면
			}else{
				count += right;
				now = rnow;
			}
			q.remove(now);
			
			//여기가 중요함.. 맨 마지막꺼 지우면 원이기 때문에 현재 인덱스가 0으로 됨.
			if(now == q.size())
				now = 0;
//			System.out.println("now:"+now);
//			System.out.println("count:"+count);
//			System.out.println("----------------");
		}
		System.out.println(count);
		
	}
}
