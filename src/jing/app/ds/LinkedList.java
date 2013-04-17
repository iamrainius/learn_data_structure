/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package jing.app.ds;

public class LinkedList<E> {

	int size = 0;
	Link<E> voidLink;
	
	private static final class Link<T> {
		T data;
		Link<T> next;
		
		Link(T o, Link<T> n) {
			data = o;
			next = n;
		}
	}
	
	public LinkedList() {
		voidLink = new Link<E>(null, null);
		voidLink.next = null;
	}
	
	public boolean add(E object) {
		return addLastImpl(object);
	}
	
	
	private boolean addLastImpl(E object) {
		Link<E> newLink = new Link<E>(object, null);
		Link<E> cursor = voidLink;
		
		while (cursor.next != null) {
			cursor = cursor.next;
		}
		
		cursor.next = newLink;
		size++;
		
		return true;
	}
	
	public boolean addFirst(E object) {
		return addLocation(0, object);
	}
	
	public boolean addLocation(int location, E object) {
		return addLocationImpl(location, object);
	}

	private boolean addLocationImpl(int location, E object) {
		
		Link<E> cursor = voidLink;
		
		int i;
		for (i=0; i<location && cursor.next!=null; i++) {
			cursor = cursor.next;
		}
		if (i < location) {
			return false;
		}
		
		Link<E> newLink = new Link<E>(object, cursor.next);
		cursor.next = newLink;
		size++;
		return true;
		
	}
	
	public E get(int location) {
		if (location > 0 && location < size) {
			Link<E> cursor = voidLink;
			for (int i=0; i<=location; i++) {
				cursor = cursor.next;
			}
			
			return cursor.data;
		}
		throw new IndexOutOfBoundsException();
	}
	
	public E remove(int location) {
		if (location > 0 && location < size) {
			Link<E> cursor = voidLink;
			for (int i=0; i<location; i++) {
				cursor = cursor.next;
			}
			cursor.next = cursor.next.next;
			size--;
			return cursor.data;
		}
		throw new IndexOutOfBoundsException();
	}

	public void reverse() {
		reverseImpl();
	}
	
	private void reverseImpl() {
		if (size <= 1) {
			return;
		}
		
		Link<E> origin = voidLink.next;
		Link<E> head = origin;
		Link<E> last = origin;
		
		while (origin.next != null) {
			Link<E> cursor = origin;
			while (cursor.next.next != null) {
				cursor = cursor.next;
			}
			
			if (head == origin) {
				last = cursor.next;
				head = last;
				last.next = origin;
				cursor.next = null;
			} else {
				last.next = cursor.next;
				last = last.next;
				last.next = origin;
				cursor.next = null;
			}
		}
		
		voidLink.next = head;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Link<E> cursor = voidLink;
		while (cursor.next != null) {
			cursor = cursor.next;
			sb.append(cursor.data).append(',');
		}
		
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int[] source = {1,2,3,4,5};
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (int i : source) {
			linkedList.add(i);
		}
		linkedList.reverse();
		System.out.println("reverse: " + linkedList);
		
//		System.out.println("Init: " + linkedList);
//		linkedList.addFirst(100);
//		System.out.println("addFirst: " + linkedList);
//		linkedList.addLocation(4, 200);
//		System.out.println("addLocation: " + linkedList);
//		System.out.println("get: " + linkedList.get(3));
//		linkedList.remove(5);
//		System.out.println("remove: " + linkedList);
	}

}
