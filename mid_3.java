package computer2;

import java.io.*;
import java.util.*;

public class mid_3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sentence = Integer.parseInt(br.readLine());

		List<Product> products = new ArrayList<Product>();
		Iterator it;

		StringTokenizer st;

		for(int i=0;i<sentence;i++) {
			st = new StringTokenizer(br.readLine());
			int pronum = Integer.parseInt(st.nextToken());
			String modelname = "";
			while(st.hasMoreTokens()) {
				modelname += st.nextToken();
				modelname += " ";
			}
			modelname = modelname.trim();

			products.add(new Product(pronum, modelname));
		}
		
		Collections.sort(products);
		System.out.println(products.get(0));
		System.out.println(products.get(products.size()-1));


	}
}
class Product implements Comparable<Product> {
	int price;
	String name;

	Product (int price, String name) {
		this.price = price;
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public int getPrice(){
		return this.price;
	}
	public int compareTo(Product o) {
		return this.price - o.price;
	}
	public String toString() {
		return ("[" + price + ",\"" + name + "\"]");
	}
}
