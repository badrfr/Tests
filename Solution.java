package codepad;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import javax.lang.model.element.Element;

/*
 * Implement a data structure, ToyBlob, backed by plain java arrays(s), with the following methods: 
 * - size which returns the number of elements in its collection
 * - add which adds an element to its middle when the ToyBlob's size is even or the end when odd.
 * - remove which removes and returns the element at the end of the collection
 * - toString which pretty-prints the elements
 */
class ToyBlob<E> {
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];

	public ToyBlob() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	public void add(E e) {
		if (size == elements.length) {
			ensureCapa();
		}
		elements[size++] = e;
	}

	@SuppressWarnings("unchecked")
	public E remove() {
		E e = (E) elements[--size];
		elements[size] = null;
		return e;
	}

	private void ensureCapa() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}

	public String toString() {
		String result = "";
		for (Object element : elements) {
			if (element != null)
				result += element.toString();
		}
		return result;
	}
}

class Solution {
	public static void main(String[] args) {
		ToyBlob toyBlob = new ToyBlob();
		toyBlob.add(1);
		toyBlob.add("h");
		toyBlob.add("e");
		toyBlob.add("l");
		toyBlob.add("l");
		toyBlob.add("l");
		toyBlob.add("o");
		toyBlob.add("!");

		toyBlob.remove();
		System.out.println(toyBlob);

	}

}

// create any additional classes here
