package computer2;

import java.io.*;
import java.util.*;

public class real_first {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<Products> products = new ArrayList<Products>();

		StringTokenizer st;

		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int pronum = Integer.parseInt(st.nextToken());
			String modelname = "";
			while(st.hasMoreTokens()) {
				modelname += st.nextToken();
				modelname += " ";
			}
			modelname = modelname.trim();

			products.add(new Products(pronum, modelname));
		}

		Products max = Collections.max(products);
		Products min = Collections.min(products);

		System.out.println("Min:" + min);
		System.out.println("Max:" + max);


	}
}
class Products implements Comparable<Products> {
	int price;
	String name;

	Products (int price, String name) {
		this.price = price;
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public int getPrice(){
		return this.price;
	}
	public int compareTo(Products o) {
		return this.price - o.price;
	}
	public String toString() {
		return ("[" + price + ",\"" + name + "\"]");
	}

}
