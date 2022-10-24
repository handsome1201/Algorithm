//package computer2;
//
//import java.io.*;
//import java.util.*;
//
//public class first {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int n = Integer.parseInt(br.readLine());
//
//		Map<Integer, String> map = new HashMap<Integer, String>();
//
//		StringTokenizer st;
//		
//		for(int i=0;i<n;i++) {
//			st = new StringTokenizer(br.readLine());
//			int pronum = Integer.parseInt(st.nextToken());
//			String modelname = "";
//			while(st.hasMoreTokens()) {
//				modelname += st.nextToken();
//				modelname += " ";
//			}
//			modelname = modelname.trim();
//
//			map.put(pronum,modelname);
//		}
//
//
//		Integer maxKey = Collections.max(map.keySet());
//
//		Integer minKey = Collections.min(map.keySet());
//
//
//
//		System.out.println("Min:["+minKey+",\""+map.get(minKey)+"\"]");
//
//		System.out.println("Max:["+maxKey+",\""+map.get(maxKey)+"\"]");  
//
//	}
//}
