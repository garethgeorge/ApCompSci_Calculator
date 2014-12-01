package util;

public class MyStack<T> {
	private Object[] elements;
	private int length = 0;
	
	public MyStack(int size) {
		elements = new Object[size];
	}
	
	public MyStack() {
		this(0);
	}
	
	private void expand() {
		Object[] newElements = new Object[elements.length == 0 ? 1 : elements.length*2];
		for(int i = 0; i < elements.length; ++i)
			newElements[i] = elements[i];
		elements = newElements;
	}
	
	public int length() {
		return length;
	}
	
	public void push(T object) {
		if(length > elements.length)
			expand();
		elements[length++] = object;
	}
	
	@SuppressWarnings("unchecked")
	public T pop() {
		return (T) elements[--length];
	}

	@SuppressWarnings("unchecked")
	public T peek() {
		return (T) elements[length-1];
	}
}
