package computer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mid_6 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> m = new HashMap<String, Integer>();
		List<String> list = new ArrayList<String>();
		
		String name="";
		while(true) {
			String[] sentence = br.readLine().split(" ");	
			if(sentence[1].equals("?")) {
				name=sentence[0];
				break;
			}
			list.add(sentence[0]);
			int num = Integer.parseInt(sentence[1]);
			if(m.containsKey(sentence[0])) {
				if(m.get(sentence[0])<num) {
					m.put(sentence[0], num);
				}
			}
			else {
				m.put(sentence[0], num);
			}
		}
		int count=0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).equals(name)) {
				count++;
			}
		}
		System.out.println(name+m.get(name)+count);
		
	}
}
