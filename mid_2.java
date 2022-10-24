package computer2;

import java.io.*;
import java.util.*;

public class mid_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<String> st = new Stack<String>();
		Stack<String> st1 = new Stack<String>();
		int count=1;


		while(true) {
			int all=0;
			String[] sentence = br.readLine().split("");
			int length = sentence.length;
			if(sentence[0].equals("-")) {
				break;
			}
			if(sentence.length==0) {
				System.out.println(count+". "+all);
			}
			for(int i=0;i<length;i++) {
				if(sentence[i].equals("(")) {
					st.add(sentence[i]);
				}
				else if(sentence[i].equals(")") && st.size()==0) {
					st.add(sentence[i]);
				}
				else if(st.peek().equals(")")){
					st.add(sentence[i]);
				}
				else if(st.peek().equals("(")){
					st.pop();
				}
			}
			while(!st.isEmpty()) {
				st1.add(st.pop());
			}

			while(!st1.isEmpty()) {
				if(st1.peek().equals(")")) {
					st1.pop();
					all+=2;

					if(st1.peek().equals(")")) {
						st1.pop();
						all-=1;
					}
					else if(st1.peek().equals("(")) {
						st1.pop();
					}

				}
				else if(st1.peek().equals("(")){
					st1.pop();
					all+=1;
					st1.pop();
				}
			}
			System.out.println(count+". "+all);
			count++;
		}
	}
}
