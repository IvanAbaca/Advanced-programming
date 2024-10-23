package utils;

public class Sorts <T extends Comparable<T>>{
	
	public void selectionSort(T[] array) {
		int size = array.length;
		
		for (int sig = 0; sig < size - 1; sig++) {
			int min = sig;
			
			for (int i = sig + 1; i < size; i++)
				if (array[i].compareTo(array[min]) < 0) // array[i] < array[min]
					min = i;
			
			swap(sig, min, array);
		}
	}
	
	private void swap(int a, int b, T[] v ) {
		T temp = v[a];
		v[a] = v[b];
		v[b] = temp;
	}
}
