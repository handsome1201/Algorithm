package computer2;

import java.io.*;
import java.util.*;

public class mid_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String sentence = br.readLine();
		String[] word = sentence.split(" ");
		int n=Integer.parseInt(word[0]);
		int k=Integer.parseInt(word[1]);

		Queue<String> q = new LinkedList<String>();

		for(int i=0;i<n;i++) {
			String sentence1 = br.readLine();
			q.add(sentence1);
		}
		while(!q.isEmpty()) {
			for(int i=0;i<k-1;i++) {
				String name = q.poll();
				q.add(name);
			}
			System.out.print(q.poll()+" ");
		}
	}

}
