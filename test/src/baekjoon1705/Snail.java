package baekjoon1705;
//백준 1913번
import java.util.Scanner;

public class Snail {
	static final int down = 0;
	static final int up = 1;
	static final int right = 2;
	static final int left = 3;
	static int dir = down;
	static int x = 0;
	static int y = 0;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int n2 = sc.nextInt();
		int[][] ar = new int[1000][1000];
		
		int val = n*n;
		int a = 0;
		int b = 0;
		int half = n/2;
		
		//System.out.println(half);
		boolean sign = true;
		while(sign){
			ar[x][y] = val;
			if(val==n2){
				a=x+1;
				b=y+1;
			}
			//System.out.println("x:"+x+", y:"+y);
			switch(dir){
			case down:
				x++;
				break;
			case up:
				x--;
				break;
			case right:
				y++;
				break;
			case left:
				y--;
				break;
			}
			if(x>n-1 || x<0 || y>n-1 || y<0 || ar[x][y]!=0){
				//System.out.println("turn!! x:"+x+", y:"+y);
				turn(dir);
			}
			val--;
			if(x==half && y==half){
				ar[x][y]=1;
				if(val==n2){
					a=x+1;
					b=y+1;
				}
				break;
			}
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(a+" "+b);
	}
	
	public static void turn(int di){
		switch(di){
		case down:
			Snail.dir = right;
			x--;
			y++;
			break;
		case up:
			Snail.dir = left;
			x++;
			y--;
			break;
		case right:
			Snail.dir = up;
			y--;
			x--;
			break;
		case left:
			Snail.dir = down;
			y++;
			x++;
			break;
		}
	}
}
