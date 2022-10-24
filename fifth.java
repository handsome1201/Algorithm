//package computer2;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//
//public class fifth {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String sentence = br.readLine();
//		String[] word = sentence.split(" ");
//		int count=Integer.parseInt(word[0]);
//		int level=Integer.parseInt(word[1]);
//
//		List<Product> products = new ArrayList<Product>();
//		Iterator it;
//
//		StringTokenizer st;
//		
//		for(int i=0;i<count;i++) {
//			st = new StringTokenizer(br.readLine());
//		      int pronum = Integer.parseInt(st.nextToken());
//		      String modelname = "";
//		      while(st.hasMoreTokens()) {
//		    	  modelname += st.nextToken();
//		        modelname += " ";
//		      }
//		      modelname = modelname.trim();
//			
//			products.add(new Product(pronum, modelname));
//		}
//		
//		
//		if(level==1) {
//			it = products.iterator();
//			System.out.print("INPUT:");	
//			while(it.hasNext()) {
//
//				System.out.print(it.next());
//			}
//		}
//		else if(level==2) {
//			it = products.iterator();
//			System.out.print("INPUT:");	
//			while(it.hasNext()) {			
//				System.out.print(it.next());
//			}
//			System.out.println();
//			Collections.sort(products);
//			it = products.iterator();
//			System.out.print("SORT By Price:");
//			while(it.hasNext()) {			
//				System.out.print(it.next());
//			}
//		}
//		else if(level==3) {
//			it = products.iterator();
//			System.out.print("INPUT:");	
//			while(it.hasNext()) {			
//				System.out.print(it.next());
//			}
//			System.out.println();
//			Collections.sort(products);
//			it = products.iterator();
//			System.out.print("SORT By Price:");
//			while(it.hasNext()) {			
//				System.out.print(it.next());
//			}
//			System.out.println();
//			Collections.sort(products,new Comparator<Product>(){
//				@Override
//				public int compare(Product prod1, Product prod2) {
//					return prod1.name.compareTo(prod2.name);
//				}
//			});
//			it = products.iterator();
//			System.out.print("SORT By Name(A):");
//			while(it.hasNext()) {			
//				System.out.print(it.next());
//			}
//		}
//		else{
//			it = products.iterator();
//			System.out.print("INPUT:");	
//			while(it.hasNext()) {			
//				System.out.print(it.next());
//			}
//			System.out.println();
//			Collections.sort(products);
//			it = products.iterator();
//			System.out.print("SORT By Price:");
//			while(it.hasNext()) {			
//				System.out.print(it.next());
//			}
//			System.out.println();
//			Collections.sort(products,new Comparator<Product>(){
//				@Override
//				public int compare(Product prod1, Product prod2) {
//					return prod1.name.compareTo(prod2.name);
//				}
//			});
//			it = products.iterator();
//			System.out.print("SORT By Name(A):");
//			while(it.hasNext()) {			
//				System.out.print(it.next());
//			}
//			System.out.println();
//			
//			Collections.reverse(products);
//			it = products.iterator();
//			System.out.print("SORT By Name(D):");
//			while(it.hasNext()) {			
//				System.out.print(it.next());
//			}
//		}
//	}
//}
//class Product implements Comparable<Product> {
//	int price;
//	String name;
//
//	Product (int price, String name) {
//		this.price = price;
//		this.name = name;
//	}
//	public String getName(){
//		return this.name;
//	}
//	public int getPrice(){
//		return this.price;
//	}
//	public int compareTo(Product o) {
//		return this.price - o.price;
//	}
//	public String toString() {
//		return ("[" + price + ",\"" + name + "\"]");
//	}
//}
//
//
