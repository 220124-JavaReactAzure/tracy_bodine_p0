package com.revature.p0.util.collections;

//this came from example model. if time try to incorporate collections assignment LinkedList or create one


/**
 * Generates a custom LinkedList
 *
 * @author      Charles Jester
 * @since       1.0
 */
public class LinkedList<T> implements List<T> {
	
	private int size;
	private Node<T> head;
	private Node<T> tail;

	@Override // scientistLinkedList.add(null)
	public boolean add(T element) {
		
		if(element == null) {
			return false;
		}
		
		Node<T> newNode = new Node<>(element);
		if(head == null) {
			tail = head = newNode;		
		} else {
			tail.nextNode = newNode;
			tail = newNode;
		}
		size++;
		
		return false;
	}

	@Override
	public boolean contains(T element) {
		
		Node<T> runner = head;
		
		while(runner != null) {
			if(runner.data.equals(element)) {
				return true;
			}
			
			runner = runner.nextNode;
		}
		
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 
	 */
	@Override // TODO Implement this method 
	public boolean remove(T element) {
		Node<T> prevNode = null;
		Node<T> currentNode = head;
		if (size == 0) {
            return false;
        }

        for (int i = 0; i < size; i++) {

            if ((currentNode.data == null && element == null) || (currentNode.data != null && currentNode.data.equals(element))) {

                if (currentNode == head) {
                    head = currentNode.nextNode;
                } else {
                    prevNode.nextNode = currentNode.nextNode;
                }

                size--;
                return true;
            }

            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }

        return false;
	}

	@Override
	public int size() {
		return size;
	}

	/**
	 * This
	 * 
	 * @param index - zero-indexed linkedList location
	 * @return - the value at the specified index if it exists
	 * @throws IndexOutOfBoundsException
	 */
	@Override 
	public T get(int index) {
		
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		
		Node<T> currentNode = head;
		for(int i = 0; i <= index; i++) {
			if(i == index) {
				return currentNode.data;
			}
			
			currentNode = currentNode.nextNode;
		}
		
		return null;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	private static class Node<T>{
		T data;
		Node<T> nextNode;
		
		public Node(T data) {
			this.data = data;
		}
	}

}
