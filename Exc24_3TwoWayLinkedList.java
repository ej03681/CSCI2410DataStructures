package datastructures2018;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;

public class Exc24_3TwoWayLinkedList {
	public static void main(String[] args) {
	
  TwoWayLinkedList<Double> list = new TwoWayLinkedList<>();
  System.out.print("Enter 5 integers: ");
  Scanner input = new Scanner(System.in);
  double[] v = new double[5];
  for (int i = 0; i < 5; i++) 
    v[i] = input.nextDouble();

  list.add(v[1]);
  list.add(v[2]);
  list.add(v[3]);
  list.add(v[4]);
  list.add(0, v[0]);
  list.add(2, 10.55);
  list.remove(3);

  java.util.ListIterator<Double> iterator1 = list.listIterator();
  while (iterator1.hasNext())
    System.out.print(iterator1.next() + " ");

  java.util.ListIterator<Double> iterator2 = list.listIterator(list.size() - 1);
  System.out.println();
  while (iterator2.hasPrevious())
    System.out.print(iterator2.previous() + " ");
  
  input.close();
}

	static class TwoWayLinkedList<E> implements MyList<E> {
		private Node<E> head, tail;
		private int size;

		public TwoWayLinkedList() {
		}

		public ListIterator<E> listIterator() {
			return new LinkedListIterator<E>();
		}

		public TwoWayLinkedList(E[] objects) {
			for (E e : objects)
				add(e);
		}

		public E getFirst() {
			if (size == 0) {
				return null;
			} else {
				return head.element;
			}
		}

		public E getLast() {
			if (size == 0) {
				return null;
			} else {
				return tail.element;
			}
		}

		public void addFirst(E e) {
			Node<E> newNode = new Node<E>(e);
			newNode.next = head;
			head = newNode;
			size++;

			if (tail == null)
				tail = head;

			if (head != tail)
				head.next.previous = head;
		}

		public void addLast(E e) {
			Node<E> newNode = new Node<>(e);

			Node<E> temp = tail;

			if (tail == null) {
				head = tail = newNode;
			} else {
				tail.next = newNode;
				tail = tail.next;
			}

			size++;

			tail.previous = temp;
		}

		public void add(int index, E e) {
			if (index == 0) {
				addFirst(e);
			} else if (index >= size) {
				addLast(e);
			} else {
				Node<E> current = head;
				for (int i = 1; i < index; i++) {
					current = current.next;
				}
				Node<E> temp = current.next;
				current.next = new Node<E>(e);
				(current.next).next = temp;
				size++;

				temp.previous = current.next;
				current.next.previous = current;
			}
		}

		public E removeFirst() {
			if (size == 0) {
				return null;
			} else {
				Node<E> temp = head;
				head = head.next;
				size--;
				if (head == null) {
					tail = null;
				}
				return temp.element;
			}
		}

		public E removeLast() {
			if (size == 0) {
				return null;
			} else if (size == 1) {
				Node<E> temp = head;
				head = tail = null;
				size = 0;
				return temp.element;
			} else {
				Node<E> current = head;

				for (int i = 0; i < size - 2; i++) {
					current = current.next;
				}

				Node<E> temp = tail;
				tail = current;
				tail.next = null;
				size--;
				return temp.element;
			}
		}

		public E remove(int index) {
			if (index < 0 || index >= size) {
				return null;
			} else if (index == 0) {
				return removeFirst();
			} else if (index == size - 1) {
				return removeLast();
			} else {
				Node<E> previous = head;

				for (int i = 1; i < index; i++) {
					previous = previous.next;
				}

				Node<E> current = previous.next;
				previous.next = current.next;
				current.next.previous = previous; // For a two-way linked list
				size--;
				return current.element;
			}
		}

		@Override
		public String toString() {
			StringBuilder result = new StringBuilder("[");

			Node<E> current = head;
			for (int i = 0; i < size; i++) {
				result.append(current.element);
				current = current.next;
				if (current != null) {
					result.append(", ");
				} else {
					result.append("]");
				}
			}

			return result.toString();
		}

		public void clear() {
			head = tail = null;
		}

		public boolean contains(Object e) {
			System.out.println("Implementation left as an exercise");
			return true;
		}

		public E get(int index) {
			System.out.println("Implementation left as an exercise");
			return null;
		}

		public int indexOf(Object e) {
			System.out.println("Implementation left as an exercise");
			return 0;
		}

		public int lastIndexOf(Object e) {
			System.out.println("Implementation left as an exercise");
			return 0;
		}

		public E set(int index, E e) {
			System.out.println("Implementation left as an exercise");
			return null;
		}

		public java.util.ListIterator<E> iterator() {
			return new LinkedListIterator<E>();
		}

		private class LinkedListIterator<E> implements java.util.ListIterator<E> {
			private Node<E> current = (Node<E>) head; // Current index
			int index = 0;

			public LinkedListIterator() {
			}

			public LinkedListIterator(int index) {
				if (index < 0 || index > size)
					throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
				for (int nextIndex = 0; nextIndex < index; nextIndex++)
					current = current.next;
			}

			public boolean hasNext() {
				return (current != null);
			}

			public E next() {
				E e = current.element;
				current = current.next;
				return e;
			}

			public void remove() {
				System.out.println("Implementation left as an exercise");
			}

			public void add(E e) {
				System.out.println("Implementation left as an exercise");
			}

			public boolean hasPrevious() {
				return current != head;
			}

			public int nextIndex() {
				System.out.println("Implementation left as an exercise");
				return 0;
			}

			public E previous() {
				E e = current.element;
				current = current.previous;
				return e;
			}

			public int previousIndex() {
				System.out.println("Implementation left as an exercise");
				return 0;
			}

			@Override
			public void set(E e) {
				current.element = e; // TODO Auto-generated method stub
			}
		}

		public class Node<E> {
			E element;
			Node<E> next;
			Node<E> previous;

			public Node(E o) {
				element = o;
			}
		}

		public int size() {
			return size;
		}

		public ListIterator<E> listIterator(int index) {
			return new LinkedListIterator<E>(index);
		}
	}

	public interface MyList<E> extends java.util.Collection<E> {
		/** Add a new element at the specified index in this list */
		public void add(int index, E e);

		/** Return the element from this list at the specified index */
		public E get(int index);

		/**
		 * Return the index of the first matching element in this list. Return -1 if no
		 * match.
		 */
		public int indexOf(Object e);

		/**
		 * Return the index of the last matching element in this list Return -1 if no
		 * match.
		 */
		public int lastIndexOf(E e);

		/**
		 * Remove the element at the specified position in this list Shift any
		 * subsequent elements to the left. Return the element that was removed from the
		 * list.
		 */
		public E remove(int index);

		/**
		 * Replace the element at the specified position in this list with the specified
		 * element and returns the new set.
		 */
		public E set(int index, E e);

		@Override /** Add a new element at the end of this list */
		public default boolean add(E e) {
			add(size(), e);
			return true;
		}

		@Override /** Return true if this list contains no elements */
		public default boolean isEmpty() {
			return size() == 0;
		}

		@Override /**
					 * Remove the first occurrence of the element e from this list. Shift any
					 * subsequent elements to the left. Return true if the element is removed.
					 */
		public default boolean remove(Object e) {
			if (indexOf(e) >= 0) {
				remove(indexOf(e));
				return true;
			} else
				return false;
		}

		// Good to go
		@Override
		public default boolean containsAll(Collection<?> c) {
			Set<?> set = new HashSet<>(c);
			for (E element : this) {
				if (set.contains(element)) {
					set.remove(element);

					if (set.isEmpty()) {
						return true;
					}
				}
			}
			return false;
		}

		// Good to go
		@Override
		public default boolean addAll(Collection<? extends E> c) {
			c.forEach(this::add);
			return true;
		}

		// Good to go
		@Override
		public default boolean removeAll(Collection<?> c) {
			c.forEach(this::remove);
			return true;
		}

		@Override
		public default boolean retainAll(Collection<?> c) {
			List<?> list1 = new LinkedList<>(c);
			List<?> list2 = new LinkedList<>(this);

			list2.retainAll(list1);

			this.clear();

			for (Object i : list2)
				this.add((E) i);

			return true;
		}

		@Override
		public default Object[] toArray() {
			int s = size();
			Object[] arr = new Object[s];
			for (int i = 0; i < s; i++)
				arr[i] = get(i);
			return arr;
		}

		@Override
		public default <T> T[] toArray(T[] array) {
			int s = size();
			for (int i = 0; i < s; i++)
				array[i] = (T) get(i);
			return array;
		}
	}
}