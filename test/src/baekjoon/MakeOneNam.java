package baekjoon;

import java.util.Scanner;

public class MakeOneNam {
    static int[] ar = new int[1000001];
	public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
 
        int tmp1, tmp2, tmp3;
        for (int i = 2; i <= a; i++) {
            tmp1 = 0;
            tmp2 = Integer.MAX_VALUE;
            tmp3 = Integer.MAX_VALUE;
            tmp1 = ar[i - 1] + 1;
            if (i % 2 == 0) {
                tmp2 = ar[i / 2] + 1;
            }
            if (i % 3 == 0) {
                tmp3 = ar[i / 3] + 1;
            }
            ar[i] = Math.min(tmp1, Math.min(tmp2, tmp3));
        }
 
        System.out.println(ar[a]);
        System.out.println(Integer.MAX_VALUE);
    }


}
