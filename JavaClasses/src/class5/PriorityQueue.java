package class5;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<T extends Comparable<T>> {
    private List<T> heap; //Lista generica (Se debe sobrescribir el metodo compare)

    //Constructor
    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    // Main methods
    
    public void add(T elem) {
        heap.add(elem);
        
        heapifyUp();
    }

    public T poll() {
        if (isEmpty()) // Valida la cola
            return null;
        
        T root = heap.get(0); // Toma el primer elemento (mayor prioridad)
        T lastElement = heap.remove(heap.size() - 1); // Toma el ultimo elemento (menor prioridad)
        
        //Si la lista está hacia entonces directamente retorno, sino inserto
        if (!isEmpty()) { 
            heap.set(0, lastElement);
            heapifyDown();
        }
        // Al tomar el ultimo elemento, al acomodarlo en la cola otra vez 
        // por consecuencia acomodo todo el resto de la cola
        
        return root;
    }

    public T peek() {
        return isEmpty() ? null : heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    // Internal methods
    private void heapifyUp() {
    	heapifyUp(heap.size() - 1); // Empiezo del ultimo (Menor prioridad)
    }
    
    private void heapifyUp(int index) {
    	
        int parentIndex = (index - 1) / 2; 
        
        if(index < 1)
    		return; //Terminé de ordenar si estoy en el primer elemento
        
        if (heap.get(index).compareTo(heap.get(parentIndex)) >= 0)
            return; //Terminé de ordenar si mi padre es mas chico que mi hijo 
        
        // Sino swapeo el padre con el hijo
        swap(index, parentIndex);
        
        // Y sigo con el padre
        heapifyUp(parentIndex);
    }

    private void heapifyDown() {
    	heapifyDown(0); // Empiezo del primero (Mayor prioridad)
    }
    
    private void heapifyDown(int index) {
    	
        int size = heap.size();
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestChildIndex = leftChildIndex;
        
        if (index > size)
        	return; //Terminé si ya llegué al final
        
        if (leftChildIndex >= size)
            return; //Terminé tmb si mi hijo izquierdo está fuera del limite
        
        // Si mi hijo derecho está dentro del limite y es menor al hijo izquierdo
        if (rightChildIndex < size && heap.get(rightChildIndex).compareTo(heap.get(leftChildIndex)) < 0)
            smallestChildIndex = rightChildIndex; //El mas prioritario es el hijo derecho
        
        if (heap.get(index).compareTo(heap.get(smallestChildIndex)) <= 0) 
            return; //Terminé si mi padre es mas prioritario que mi hijo mas prioritario
        
        // Sino swapeo padre e hijo
        swap(index, smallestChildIndex);
        
        //Sigo con el hijo mas prioritario
        heapifyDown(smallestChildIndex);
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
