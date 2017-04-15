package baekjoon;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;

	/*
	   012100_2048(Easy)
	   https://www.acmicpc.net/problem/12100
	   완전탐색
	*/
	public class Nam2048 {
	   enum Move {
	      UP, DOWN, LEFT, RIGHT
	   }
	   static int SIZE;
	   static int[][] origin;
	   static int[][] map;

	   public static void main(String[] args) throws IOException {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      SIZE = Integer.parseInt(br.readLine());

	      origin = new int[SIZE][SIZE]; // 원본 table
	      map = new int[SIZE][SIZE]; // 계산하면서 업데트될 table

	      StringTokenizer st;
	      for (int i = 0; i < SIZE; i++) {
	         st = new StringTokenizer(br.readLine());
	         for (int j = 0; j < SIZE; j++)
	            origin[i][j] = Integer.parseInt(st.nextToken());
	      }
	      int max = Integer.MIN_VALUE;

	      for (Move m1 : Move.values()) {
	         for (Move m2 : Move.values()) {
	            for (Move m3 : Move.values()) {
	               for (Move m4 : Move.values()) {
	                  for (Move m5 : Move.values()) {
	                     initMap();
	                     move(m1);
	                     move(m2);
	                     move(m3);
	                     move(m4);
	                     move(m5);
	                     int temp = findMax();
//	                     완전탐색(주석을 풀어보면?)
	                     System.out.println(m1 + "\t" + m2 + "\t" + m3 + "\t" + m4 + "\t" + m5 + "\t" + temp); 
	                     if (temp > max)
	                        max = temp;
	                  }
	               }
	            }
	         }
	      }
	      System.out.println(max);
	   }

	   /*   initMap()
	    *  원본을 map 으로 복사
	    */
	   static void initMap() {
	      for (int i = 0; i < SIZE; i++)
	         System.arraycopy(origin[i], 0, map[i], 0, SIZE);
	   }
	   /*   move(Move m)
	    *   움직이고, 합하고, 업데이트까지 
	    */
	   static void move(Move m) {
	      switch (m) {
	      case UP:
	         for (int i = 0; i < SIZE; i++) {
	            int[] column = getColumn(i);
	            column = optimize(column, m);
	            for (int k = 0; k < SIZE - 1; k++) {
	               int now = column[k];
	               int next = column[k + 1];
	               if (now == next) {
	                  column[k] += next;
	                  column[k + 1] = 0;
	                  k++;      // 같아서 합쳤다면 다음칸은 생각할 필요 없으니 k++ 한번더
	               }
	            }
	            update(optimize(column, m), m, i);
	         }
	         break;
	      case DOWN:
	         for (int i = 0; i < SIZE; i++) {
	            int[] column = getColumn(i);
	            column = optimize(column, m);
	            for (int k = SIZE - 1; k > 0; k--) {
	               int now = column[k];
	               int next = column[k - 1];
	               if (now == next) {
	                  column[k] += next;
	                  column[k - 1] = 0;
	                  k--;
	               }
	            }
	            update(optimize(column, m), m, i);
	         }
	         break;
	      case LEFT:
	         for (int i = 0; i < SIZE; i++) {
	            int[] row = map[i];
	            row = optimize(row, m);
	            for (int k = 0; k < SIZE - 1; k++) {
	               int now = row[k];
	               int next = row[k + 1];
	               if (now == next) {
	                  row[k] += next;
	                  row[k + 1] = 0;
	                  k++;
	               }
	            }
	            update(optimize(row, m), m, i);
	         }
	         break;
	      case RIGHT:
	         for (int i = 0; i < SIZE; i++) {
	            int[] row = map[i];
	            row = optimize(row, m);
	            for (int k = SIZE - 1; k > 0; k--) {
	               int now = row[k];
	               int next = row[k - 1];
	               if (now == next) {
	                  row[k] += next;
	                  row[k - 1] = 0;
	                  k--;
	               }
	            }
	            update(optimize(row, m), m, i);
	         }
	         break;
	      }
	   }

	   /*   optimize(int[] arr, Move m)
	    *   한쪽으로 몰아서 반환(합계산은 안해) 왼쪽몰기 : {2 0 0 2} -> {2 2 0 0}
	    */
	   static int[] optimize(int[] arr, Move m) {
	      int[] result = new int[SIZE];
	      int index;

	      switch (m) {
	      case LEFT:
	      case UP:
	         index = 0;
	         for (int i = 0; i < SIZE; i++) {
	            if (arr[i] == 0)
	               continue;
	            else
	               result[index++] = arr[i];
	         }
	         break;
	      case DOWN:
	      case RIGHT:
	         index = SIZE - 1;
	         for (int i = SIZE - 1; i > -1; i--) {
	            if (arr[i] == 0)
	               continue;
	            else
	               result[index--] = arr[i];
	         }
	         break;
	      }
	      return result;
	   }

	   static int[] getColumn(int index) { // index 열을 반환
	      int[] arr = new int[SIZE];
	      for (int i = 0; i < SIZE; i++)
	         arr[i] = map[i][index];
	      return arr;
	   }

	   static void update(int[] arr, Move m, int index) { // 계산된 결과를 업데이트
	      switch (m) {
	      case DOWN:
	      case UP:
	         for (int i = 0; i < SIZE; i++)
	            map[i][index] = arr[i];
	         break;
	      case RIGHT:
	      case LEFT:
	         System.arraycopy(arr, 0, map[index], 0, SIZE);
	         break;
	      }
	   }

	   static int findMax() {
	      int max = Integer.MIN_VALUE;
	      for (int i = 0; i < SIZE; i++) {
	         for (int j = 0; j < SIZE; j++) {
	            if (map[i][j] > max)
	               max = map[i][j];
	         }
	      }
	      return max;
	   }
	}
