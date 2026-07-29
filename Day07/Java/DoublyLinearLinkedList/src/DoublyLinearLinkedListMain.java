
public class DoublyLinearLinkedListMain {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		
//		list.addFirst('N');
//		list.addFirst('U');
//		list.addFirst('S');
//		list.addLast('B');
//		list.addLast('E');
//		list.addLast('A');
//		list.addLast('M');
		
		list.addLast('A');
		list.addLast('B');
		list.addLast('C');
		list.addLast('D');
		
		//list.addPosition('#', 3);
		//list.addPosition('#', 1);
		//list.addPosition('#', 5);
		//list.addPosition('#', -1);
		//list.addPosition('#', 6);
		
		//list.deleteFirst();
		//list.deleteLast();
		
		//list.deletePosition(3);
		//list.deletePosition(1);
		//list.deletePosition(4);
		//list.deletePosition(0);		// < 1
		//list.deletePosition(5);			// > size
		
		list.forwardDisplay();
		list.backwardDisplay();
		System.out.println("List size : " + list.size());
		
		list.deleteAll();

	}

}
