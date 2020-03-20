package gs;

import java.util.ArrayList;

public class DequeImplmentation {

	public static void main(String[] args) {
		MyDeueue<String> deque = new MyDeueue<String>();
		deque.addFront("raj");
		deque.addFront("kamal");
		deque.addFront("mamta");
		deque.addFront("garkoti");
		deque.addRear("abc");
		System.out.println(deque.size());
		System.out.println(deque.peekFirst());
		System.out.println(deque.peekLast());
		deque.removeFirst();
		deque.removeLast();

		System.out.println("--------------------------------");

		MyDeueue<Integer> dequeInteger = new MyDeueue<Integer>();
		dequeInteger.addFront(1);
		dequeInteger.addFront(2);
		dequeInteger.addFront(3);
		dequeInteger.addFront(4);
		dequeInteger.addRear(5);
		System.out.println(dequeInteger.size());
		System.out.println(dequeInteger.peekFirst());
		System.out.println(dequeInteger.peekLast());
		dequeInteger.removeFirst();
		dequeInteger.removeLast();

	}

}

class MyDeueue<T> {
	private ArrayList<T> dq = new ArrayList<T>();

	public void removeFirst() {
		System.out.println("item removed in front:" + dq.get(0));
		dq.remove(0);
		System.out.println(dq);
	}

	public void removeLast() {
		System.out.println("item removed in rear:" + dq.get(dq.size() - 1));
		dq.remove(dq.size() - 1);
		System.out.println(dq);
	}

	public void addFront(T item) {
		dq.add(0, item);
		System.out.println("item added in front:" + item);
		System.out.println(dq);
	}

	public void addRear(T item) {
		dq.add(item);
		System.out.println("item added in rear:" + item);
		System.out.println(dq);
	}

	public int size() {
		return dq.size();
	}

	public T peekFirst() {
		System.out.println("Item in front:" + dq.get(0));
		return dq.get(0);
	}

	public T peekLast() {
		System.out.println("Item in front:" + dq.get(dq.size() - 1));
		return dq.get(dq.size() - 1);
	}
}
