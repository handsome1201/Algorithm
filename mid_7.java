package computer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class mid_7 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sentence = br.readLine();
		String[] word = sentence.split(" ");
		int n=Integer.parseInt(word[0]);
		int k=Integer.parseInt(word[1]);
		String[] line= br.readLine().split("");
		
		Stack<String> st = new Stack<String>();
		Queue<String> q = new LinkedList<String>();
		
		String result="";
		int count=0;
		
		for(int i=0;i<line.length;i++) {
			if(line[i].equals("0") && st.isEmpty()) {
				for(int j=0;j<k;j++) {
					st.add(q.poll());
					count--;
				}
				
				
			}
			else if(line[i].equals("0") && !st.isEmpty()) {
				for(int j=0;j<st.size();j++) {
					result+=st.pop();
				}
			}
			else if(count==n){
				result+=q.poll();
				q.add(line[i]);
			}
			else if(count<n) {
				q.add(line[i]);
				count++;
			}
		}
		System.out.println(result);
	}
}
