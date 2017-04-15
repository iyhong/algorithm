package baekjoon;

//3190번
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Snake2 {
	
	static int N;
	static int K;
	
	//머리위치
	static int hx;
	static int hy;
	//꼬리위치
	static int tx;
	static int ty;
	//뱀의 머리부터 꼬리까지 큐에 담기
	static Queue<Integer> snake;
	
	//회전정보
	static int L;
	static int X;//몇초후 회전하는지
	static String C;
	static int Xcount;
	
	//맵정보
	static int[][] map;
	
	//사과위치정보
	static String[] ai;
	//방향전환정보
	static Queue<Object> di;
	static final int NORTH = 1;
	static final int EAST = 2;
	static final int SOUTH = 3;
	static final int WEST = 4;
	static int dir;
	
	static int time;
	static int max;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[101][101];
		
		K = sc.nextInt();

		ai = new String[101];
		for(int i=0; i<K; i++){
			//System.out.println("i:"+i);
			//배열인덱스와 맞춰주기위해 -1함
			int ax = sc.nextInt()-1;
			int ay = sc.nextInt()-1;
			ai[i] = ax+","+ay;
			//System.out.println("ai[i]:"+ai[i]);
		}
		
		L = sc.nextInt();
		di = new LinkedList<Object>();
		for(int i=0; i<L*2; i++){
			di.offer(sc.next());
		}
		max = N-1;
		//System.out.println("N:"+N);
		snake = new LinkedList<Integer>();
		
		//시작
		map[hx][hy] = 1;
		dir = EAST;
		time = 1;
		snake.offer(0);
		snake.offer(0);
		
		Xcount += Integer.parseInt((String)di.poll());
		C = (String)di.poll();
		
		
		//반복문 시작(뱀움직임시작)
		while(true){
			
			switch(dir){
			case NORTH:
				hx--;
				break;
			case EAST:
				hy++;
				break;
			case SOUTH:
				hx++;
				break;
			case WEST:
				hy--;
				break;
			}
			//System.out.println(hx+","+hy);
			//System.out.println("map["+hx+"]["+hy+"]:"+map[hx][hy]);

			if( hx>max || hy>max || hx<0 || hy<0 || map[hx][hy]==1 ){
				//System.out.println("종료");
				break;
			}
			//현위치에 사과가 있는지 체크
			String aiStr = hx+","+hy;
			int appleExist = 0;
			int a = 0;
			while(ai[a]!=null){
				if(ai[a].equals(aiStr)){
					appleExist = 1;
					ai[a] = "";
					break;
				}
				a++;
			}
			
			//System.out.println("appleExist:"+appleExist);
			//사과가 없으면 꼬리를 줄인다.
			if(appleExist==0){
				tx = snake.poll();
				ty = snake.poll();
				//System.out.println("꼬리좌표:"+tx+","+ty);
				map[tx][ty] = 0;
			}
			
			//머리가 있는 칸을 방문한 칸으로 변경하고 뱀몸인 큐에 추가한다.
			map[hx][hy] = 1;
			//System.out.println("map["+hx+"]["+hy+"]:"+map[hx][hy]);

			snake.offer(hx);
			snake.offer(hy);
			time++;
			//System.out.println("time:"+time);
			//System.out.println(hx+","+hy);
			
			//머리회전
			if(time-1 == Xcount){
				switch(dir){
				case NORTH:
					if(C.equals("L")){
						dir = WEST;
					}else if(C.equals("D")){
						dir = EAST;
					}
					break;
				case EAST:
					if(C.equals("L")){
						dir = NORTH;
					}else if(C.equals("D")){
						dir = SOUTH;
					}
					break;
				case SOUTH:
					if(C.equals("L")){
						dir = EAST;
					}else if(C.equals("D")){
						dir = WEST;
					}
					break;
				case WEST:
					if(C.equals("L")){
						dir = SOUTH;
					}else if(C.equals("D")){
						dir = NORTH;
					}
					break;
				}
				
				//방향정보를 넣어준다.
				if(di.isEmpty()){
					Xcount = 0;
					C = "";
				}else{
					Xcount = Integer.parseInt((String)di.poll());
					C = (String)di.poll();
				}
			}
			//System.out.println("Xcount:"+Xcount);
			//System.out.println("C:"+C);
		}
		System.out.println(time);
	}
}
