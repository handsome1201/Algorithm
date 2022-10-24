package computer2;

import java.io.*;
import java.util.*;

public class second {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<Products> products = new ArrayList<Products>();
		List<Products> firstproduct = new ArrayList<Products>();

		StringTokenizer st;

		int count=0;

		while(count<n) {

			st = new StringTokenizer(br.readLine());
			int pronum = Integer.parseInt(st.nextToken());
			double tax = Double.parseDouble(st.nextToken());
			if(tax>=1.0 || tax<=0.0) {
				System.out.println("Wrong Input");
				continue;
			}
			String modelname = "";
			while(st.hasMoreTokens()) {
				modelname += st.nextToken();
				modelname += " ";
			}
			modelname = modelname.trim();

			pronum=(int) (pronum*(1.0+tax));
			
			count++;

			if(count==1) {
				firstproduct.add(new Products(pronum,modelname));
			}
			else {
				products.add(new Products(pronum,modelname));
			}
		}
		Comparator<Products> comparator = new Comparator<Products>() {
			@Override
			public int compare(Products a, Products b) {
				return b.getPrice() - a.getPrice();
			}
		};

		Collections.sort(products, comparator);
		System.out.println("TV[0]:"+firstproduct.get(0));
		for(int i=0;i<products.size();i++) {
			if(firstproduct.get(0).price < products.get(i).price) {
				System.out.println("TV["+(i+1)+"]:"+products.get(i));
			}
		}
	}
}



class Products {
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
	public String toString() {
		return ("[" + price + ",\"" + name + "\"]");
	}
}


