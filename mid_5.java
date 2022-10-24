package computer2;

import java.io.*;
import java.util.*;

public class mid_5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Map<String, Integer> m = new HashMap<String, Integer>();
		List<String> list = new ArrayList<String>();

		for(int i=0;i<n;i++) {
			String[] sentence = br.readLine().split("\\.");
			if(m.containsKey(sentence[1])) {
				m.put(sentence[1], m.get(sentence[1])+1);
			}
			else {
				m.put(sentence[1], 1);
				list.add(sentence[1]);
			}
		}

		Collections.sort(list);

		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i)+" "+m.get(list.get(i)));
		}
	}
}