package jing.app.ds;

import java.util.Iterator;
import java.util.Vector;

public class VectorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<Integer>();
		for (int i = 0; i < 20; i++) {
			vector.add(i);
		}
		
		vector.re
		
//		Iterator<Integer> it = vector.iterator();
//		int count = 0;
//		while (it.hasNext() && count <= 7) {
//			it.next();
//			if (count >= 5 && count <= 7) {
//				it.remove();
//			}
//			count++;
//		}
		System.out.println(vector);

	}

}
