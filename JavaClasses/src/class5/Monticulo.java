package class5;

public class Monticulo {

	public static void main(String[] args) {
		int[] monticulo = new int[30];
		int[] data = {0,5,7,15,14,9,18,20};
		
		for(int i = 0; i<data.length; i++)
			monticulo[i] = data[i];
		
		// Add
		//priority_queue_add(monticulo, 6);

		for(int n : monticulo)
			if(n != 0)
				System.out.println(n);
		
		// Get
		System.out.println("\n" + priority_queue_get(monticulo) + "\n");
		
		for(int n : monticulo)
			if(n != 0)
				System.out.println(n);
	}
	
	public static void priority_queue_add(int[] heap, int data) {
		pq_add_switch(heap, data, 1);
	}
	
	public static int priority_queue_get(int[] heap) {
		int data = heap[1];
		
		heap[1] = pq_get_right_leaf_pos(heap);
		
		pq_get_switch(heap, 1, 2);

		return data;
	}
	
	public static int pq_get_right_leaf_pos(int[] heap) {
		int leaf = 0;
		
		for(int i = 0; i < heap.length; i++)
			if(heap[i] != 0)
				leaf = i;
		
		int leaf_value = heap[leaf];
		heap[leaf] = 0;
		
		return leaf_value;
	}
	
	public static void pq_get_switch(int[] heap, int parent, int child) {
		if(heap[child] == 0 || child > heap.length)
			return;
		
		pq_switch(heap, parent, child);
		
		parent = child;
		child = child*2;
		child = heap[child] > heap[child+1] ? child + 1 : child;
		
		pq_get_switch(heap, parent, child);
	}
	
	
	public static void pq_add_switch(int[] heap, int data, int parent) {
		int child = parent * 2;
		
		if(heap[child] != 0) 
			pq_add_switch(heap, data, child);
		else
			heap[child] = data;

		pq_switch(heap, parent, child);
	}
	
	public static void pq_switch(int[] heap, int parent, int child) {
		if(heap[parent] > heap[child]) {
			int aux = heap[child];
			heap[child] = heap[parent];
			heap[parent] = aux;
		}
	}
	
	
}
