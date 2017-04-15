package baekjoon;
//10875번 뱀 못품,,ㅡ
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Snake1 {
	
	static final int NORTH = 1;
	static final int EAST = 2;
	static final int SOUTH = 3;
	static final int WEST = 4;
	
	static int L;
	static int N;
	
	static int x;//현재 x좌표
	static int y;//현재 y좌표
	
	static int max;
	static String[] array;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		N = sc.nextInt();
		array = new String[10000001];
		Queue<Object> q = new LinkedList<Object>();
		Map<String, String> map = new HashMap<String,String>();
		
		for(int i=0; i<N*2; i++){
			q.offer(sc.next());
		}
		
//		while(!q.isEmpty()){
//			System.out.println(q.poll());
//		}
		
		x = L;
		y = L;
		max = 2*L;
		int dir = EAST;
		int first = 0;
		String str = x+","+y;
		array[0] = str;
		//map.put(str, str);
		first++;
		int result = 1;
		int t = Integer.parseInt((String)q.poll());
		String direction = (String)q.poll();
		
		while(true){
			
			//System.out.println("현재위치:"+x+","+y);
			switch(dir){
			case NORTH:
				y--;
				break;
			case EAST:
				x++;
				break;
			case SOUTH:
				y++;
				break;
			case WEST:
				x--;
				break;
			}
			int duple = 0;
			str = x+","+y;
			for(int j=0; j<first; j++){
				if(array[j].equals(str)){
					duple=1;
					break;
				}
			}
			
			if(x>max || y>max || x<0 || y<0|| duple==1 ){
				//System.out.println("끝나는 위치:"+x+","+y+","+map[y][x]);
				break;
			}else{
				str = x+","+y;
				array[first] = str;
				result++;
				first++;
				//System.out.println("현재위치:"+x+","+y+", first:"+first+", t:"+t);
			}
			
			if(first-1 == t){
				
				switch(dir){
				case NORTH:
					if(direction.equals("L")){
						dir = WEST;
					}else if(direction.equals("R")){
						dir = EAST;
					}
					break;
				case EAST:
					if(direction.equals("L")){
						dir = NORTH;
					}else if(direction.equals("R")){
						dir = SOUTH;
					}
					break;
				case SOUTH:
					if(direction.equals("L")){
						dir = EAST;
					}else if(direction.equals("R")){
						dir = WEST;
					}
					break;
				case WEST:
					if(direction.equals("L")){
						dir = SOUTH;
					}else if(direction.equals("R")){
						dir = NORTH;
					}
					break;
				}
				if(q.isEmpty()){
					t=0;
					direction = "";
				}else{
					t += Integer.parseInt((String)q.poll());
					direction = (String)q.poll();
				}
				
			}
			
			
		}
		int a = 0;
//		while(array[a]!=null){
//			//System.out.println("array[i]:"+array[a]);
//			a++;
//		}
		System.out.println(result);
	}
}
