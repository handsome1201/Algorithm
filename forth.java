//package computer2;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class forth {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String sentence = br.readLine();
//		String[] word = sentence.split(" ");
//		int n=Integer.parseInt(word[0]);
//		int step=Integer.parseInt(word[1]);
//
//		ArrayList<Products> products = new ArrayList<Products>();
//
//		StringTokenizer st;
//		int count=0;
//
//		while(count<n) {
//
//			st = new StringTokenizer(br.readLine());
//			int pronum = Integer.parseInt(st.nextToken());
//			String modelname = "";
//			while(st.hasMoreTokens()) {
//				modelname += st.nextToken();
//				modelname += " ";
//			}
//			modelname = modelname.trim();
//			products.add(new Products(pronum,modelname));
//			count++;
//		}
//		if(step==1) {
//			System.out.println(products);
//		}
//		else if(step==2) {
//			System.out.println(products);
//			String sentence1 = "";
//			while(true) {
//				st = new StringTokenizer(br.readLine());
//				sentence1=st.nextToken();
//				if(sentence1.equals("quit")) {
//					break;
//				}
//				int index = Integer.parseInt(st.nextToken());
//				if(sentence1.equals("del")) {
//					products.remove(index);
//					System.out.println(products);
//				}
//				else if(sentence1.equals("dup")){
//					products.add(products.get(index));
//					System.out.println(products);
//				}
//			}
//
//		}
//		else {
//			System.out.println(products);
//			String sentence1 = "";
//			while(true) {
//				st = new StringTokenizer(br.readLine());
//				sentence1=st.nextToken();
//				if(sentence1.equals("quit")) {
//					break;
//				}
//				int index = Integer.parseInt(st.nextToken());
//				int compare = products.size();
//				if(index>=compare || index<0) {
//					System.out.println("Wrong Input");
//					continue;
//				}
//				if(sentence1.equals("del")) {
//					products.remove(index);
//					System.out.println(products);
//				}
//				else if(sentence1.equals("dup")){
//					products.add(products.get(index));
//					System.out.println(products);
//				}
//			}
//
//		}
//	}
//}
//class Products {
//	int price;
//	String name;
//
//	Products (int price, String name) {
//		this.price = price;
//		this.name = name;
//	}
//	public String getName(){
//		return this.name;
//	}
//	public int getPrice(){
//		return this.price;
//	}
//	public String toString() {
//		return ("[" + price + ",\"" + name + "\"]");
//	}
//}