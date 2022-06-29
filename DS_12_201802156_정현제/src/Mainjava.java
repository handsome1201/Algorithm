import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Mainjava {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));


		HashTable ht = new HashTable(11, 0.75F);

		String[] arr = br.readLine().split(" ");
		for (int i=0; i<arr.length; i++) {
			ht.insert(arr[i]);
		}
		System.out.println("----------Linear Probing--------------");
		System.out.println("Insert all words");
		System.out.print("collision : ");
		System.out.println(ht.ncollison);
		System.out.println("search 5 words");

		System.out.println(ht.search("a"));
		System.out.println(ht.search("map"));
		System.out.println(ht.search("is"));
		System.out.println(ht.search("an"));
		System.out.println(ht.search("abstract"));
		System.out.println("delete 5 words");
		System.out.println("search 5 words");
		ht.delete("a");
		ht.delete("map");
		ht.delete("is");
		ht.delete("an");
		ht.delete("abstract");

		System.out.println(ht.search("a"));
		System.out.println(ht.search("map"));
		System.out.println(ht.search("is"));
		System.out.println(ht.search("an"));
		System.out.println(ht.search("abstract"));
		System.out.println("----------Linear Probing--------------");
		
	}
}

class HashTable {
	private Entry[] entries;
	private int size, used;
	private float loadFactor;
	int ncollison;
	private final Entry NIL = new Entry(null, -1);

	public HashTable(int capacity, float loadFactor) {
		entries = new Entry[capacity];
		this.loadFactor = loadFactor;
	}

	public HashTable(int capacity) {
		this(capacity, 0.75F);
	}

	public HashTable() {
		this(101);
	}

	public Object search(Object key) {
		int h = hash(key);
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, i);
			Entry entry = entries[j];
			if (entry == null) break;
			if (entry == NIL) continue;
			if (entry.key.equals(key)) return entry.value;
		}
		return -1; // failure: key not found
	}

	public Object insert(Object key) {
		if (used > loadFactor*entries.length) rehash();
		int h = hash(key);
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h,i);
			Entry entry = entries[j];
			if (entry == null) {
				entries[j] = new Entry(key, 1);
				++size;
				++used;
				return null; // insertion success
			}
			if (entry == NIL) continue;
			if (entry.key.equals(key)) {
				int k = (int)entries[j].value;
				entries[j].value = ++k;
				return null; // update success
			}
			ncollison++;
		}
		return null; // failure: table overflow
	}

	public Object delete(Object key) {
		int h = hash(key);
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, i);
			Entry entry = entries[j];
			if (entry == null) break;
			if (entry == NIL) continue;
			if (entry.key.equals(key)) {
				if ((int)entry.value == 1) {
					entries[j] = NIL;
				} else {
					int k = (int)entries[j].value;
					entries[j].value = --k;
				}
				--size;
				return null; // success
			}
		}
		return null; // failure: key not found
	}

	public int size() {
		return size;
	}

	private class Entry {
		Object key, value;

		Entry(Object k, Object v) {
			key = k;
			value = v;
		}
	}

	private int hash(Object key) {
		if (key == null) throw new IllegalArgumentException();
		return (key.hashCode() & 0x7FFFFFFF) % entries.length;
	}

	private int nextProbe(int h, int i) {
		//return (h + i*i) % entries.length; // Quadritic Probing
		return (h + i)%entries.length; //Linear Probing
	}

	private void rehash() {
		Entry[] oldEntries = entries;
		entries = new Entry[2 * oldEntries.length + 1];
		for (int k = 0; k < oldEntries.length; k++) {
			Entry entry = oldEntries[k];
			if (entry == null || entry == NIL) continue;
			int h = hash(entry.key);
			for (int i = 0; i < entries.length; i++) {
				int j = nextProbe(h, i);
				if (entries[j] == null) {
					entries[j] = entry;
					break;
				}
			}
		}
		used = size;
	}
}