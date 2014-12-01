package util;

import java.util.AbstractList;

public class ArrayStack<T> {
	private int top;
	private T[] array;
	
	public ArrayStack(T[] array) {
		this.array = array;
		top = array.length - 1;
	}
	
	public ArrayStack(AbstractList<T> vec) {
		array = (T[]) vec.toArray();
		top = array.length - 1;
	}
	
	public T pop() {
		return top >= 0 ? array[top--] : null;
	}
	
	public T peek() {
		return top >= 0 ? array[top] : null;
	}
	
	public int size() {
		return top + 1;
	}
	
	public void reverse() {
		array = array.clone();
		
		int j = 0, k = array.length-1;
		T temp;
		while(j <= k) {
			temp = array[j];
			array[j++] = array[k];
			array[k--] = temp;
		}
	}
}
