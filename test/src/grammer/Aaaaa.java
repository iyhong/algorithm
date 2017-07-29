package grammer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Aaaaa {
	public static void main(String[] args){
		PrintStream p = System.out;
		p.println("테스트 ");
		PrintWriter pw;
		try {
			System.out.println("try!");
			pw = new PrintWriter(new FileWriter("src/grammer/test.txt"),true);
			pw.print("한글 ");
			pw.println("is well");
			pw.println();
			pw.print("good!");
			pw.flush();
			//pw.close();
			System.out.println("end!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("catch!!");
			System.out.println(e);
		}
		Socket so = new Socket();
		
	}
}
