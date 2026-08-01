import java.util.LinkedList;
import java.util.List;

class HashTable{
	static class Entry{
		private int key;			// rollno, empid, pin code, telephone number
		private String value;		// student info, emp info, locations, owner info
		public Entry(int key, String value) {
			this.key = key;
			this.value = value;
		}
		//...
	}
	
	private static final int SIZE = 10;
	private List<Entry>[] table;
	
	public HashTable() {
		table = new List[SIZE];
		for(int i = 0 ; i < SIZE ; i++)
			table[i] = new LinkedList<HashTable.Entry>();
	}
	
	private int h(int k) {
		return k % SIZE;
	}
	
	public void put(int key, String value) {
		// find slot for given key
		int slot = h(key);
		// if list is not empty, then key may exist
		if(!table[slot].isEmpty()) {
			for(Entry e : table[slot]) {
				if(e.key == key) {
					e.value = value;
					return;
				}
			}
		}
		// if list is empty, key is not present
		Entry e = new Entry(key, value);
		table[slot].add(e);		
	}
	
	public String get(int key) {
		// find slot for given key
		int slot = h(key);
		// if list is not empty, then key may exist
		if(!table[slot].isEmpty()) {
			for(Entry e : table[slot]) {
				if(e.key == key) {
					return e.value;
				}
			}
		}
		// if list is empty, key is not present
		return null;		
	}
}



public class Tester {

	public static void main(String[] args) {

		HashTable tbl = new HashTable();
		
		tbl.put(88, "v1");
		tbl.put(93, "v2");
		tbl.put(100, "v3");
		tbl.put(54, "v4");
		tbl.put(76, "v5");
		tbl.put(113, "v6");
		tbl.put(100, "updated");
		
		String value = tbl.get(100);
		if(value == null)
			System.out.println("Key is not found");
		else
			System.out.println("value = " + value);
		

	}

}











