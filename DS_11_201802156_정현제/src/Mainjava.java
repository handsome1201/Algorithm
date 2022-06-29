import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

interface PriorityQueue { 
	public void add(Object object); 
	public Object best(); 
	public Object removeBest(); 
	public int size(); 

} 

class HeapPriorityQueue implements PriorityQueue {
	private static final int CAPACITY=100;
	private Comparable[] a;
	private int size;

	public HeapPriorityQueue() {
		this(CAPACITY);
	}

	public HeapPriorityQueue(int capacity) {
		a = new Comparable[capacity];
	}

	public void buildheap_iter(int[] t) {
		for(int i=0;i<t.length;i++) {
			add(t[i]);
		}

	} 

	public void add(Object object) {
		if (!(object instanceof Comparable))
			throw new IllegalArgumentException();
		Comparable x = (Comparable)object;
		if (size == a.length) resize();
		int i = size++;
		while (i > 0) {
			int j = i;
			i = (i-1)/2;
			if (a[i].compareTo(x) >= 0) {
				a[j] = x; return; }
			a[ j] = a[i];
		}
		a[i] = x;
	} 

	public Object best() {
		if (size == 0) 
			throw new 
			java.util.NoSuchElementException();
		return a[0];
	} 

	public Object removeBest() { 
		Object best = best(); 
		a[0] = a[--size]; 
		heapify(0, size); 
		return best; 
	} 

	public int size() { 
		return size; 
	} 

	public String print() { 
		if (size == 0) return "{}"; 
		StringBuffer buf = new StringBuffer("" + a[0]); 
		for (int i = 1; i < size; i++) 
			buf.append(" " + a[i]); 
		return buf + " "; 
	} 
	private void heapify(int i, int n) { 
		Comparable ai = a[i]; 
		while (i < n/2) { 
			int j = 2*i+1; 
			if (j+1 < n && a[j+1].compareTo(a[j]) > 0) ++j; 
			if (a[j].compareTo(ai) <= 0) break; 
			a[i] = a[j]; 
			i = j; 
		} 
		a[i] = ai; 
	} 
	private void resize() { 
		Comparable[] aa = new Comparable[2*a.length]; 
		System.arraycopy(a, 0, aa, 0, a.length); 
		a = aa; 
	} 
    public void remove(int index) {
        if (size == 0) return;
        a[index-1] = a[--size];
        heapify(0, size);
    }

} 


public class Mainjava {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));

		HeapPriorityQueue pq = new HeapPriorityQueue();


		String[] basket1=br.readLine().split(" ");
		int length1=basket1.length;
		int[] insert1 = new int[length1];
		for(int i=0;i<length1;i++) {
			insert1[i]=Integer.parseInt(basket1[i]);

		}
		pq.buildheap_iter(insert1);
		System.out.println(pq.print());

		String[] basket2=br.readLine().split(" ");
		int length=basket1.length;
		length=basket2.length;
		int[] remove1 = new int[length];
		for(int i=0;i<length;i++) {
			remove1[i]=Integer.parseInt(basket2[i]);
			pq.remove(remove1[i]);
			System.out.println(pq.print());
		}
		
		
		String[] basket3=br.readLine().split(" ");
		int length2=basket3.length;
		int[] add = new int[length2];
		for(int i=0;i<length2;i++) {
			add[i]=Integer.parseInt(basket3[i]);
			pq.add(add[i]);
		}
				System.out.println(pq.print());
				
				for(int i=0;i<length1+length2-1-length;i++) {
					pq.removeBest();
					System.out.println(pq.print());
				}



	}
}
