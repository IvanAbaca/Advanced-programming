package class7;

import UtilsGrafos.Arista;
import UtilsGrafos.Grafo;
import UtilsGrafos.Vertice;
import class5.PriorityQueue;
import utils.Sorts;

public class MST {
    Arista[] mst;
    Vertice[] uf;   // Union-Find array para los padres de los vértices
    int[] rank;     // Arreglo para manejar el rango de cada conjunto

    
    public void kruskal(Grafo G) {
        mst = new Arista[G.vertices.length - 1];  // El MST tiene V-1 aristas
        int E = G.aristas.length;
        Arista[] aristas = G.aristas;  // Asignar las aristas del grafo

        sort(aristas); // Ordenar las aristas (opcional: puedes usar una cola de prioridad)

        UFinit(G.vertices); // Inicializar el Union-Find

        // Recorro todas las aristas
        for (int i = 0, k = 0; i < E && k < (G.vertices.length - 1); i++) {
            Vertice v = aristas[i].src; // Vertice src
            Vertice w = aristas[i].dst; // Vertice dst

            if (!UFfind(v, w)) {         // Si no están unidos
                UFunion(v, w);          // Unir los vértices
                mst[k++] = aristas[i];  // Agrego la arista al MST
            }
        }
    }

    // Método para ordenar las aristas
    private void sort(Arista[] aristas) {
        new Sorts<Arista>().selectionSort(aristas);  // Puedes usar cualquier algoritmo de ordenación
    }

    // Inicialización del Union-Find
    private void UFinit(Vertice[] vertices) {
        uf = new Vertice[vertices.length];
        rank = new int[vertices.length];  // Inicializar rango a 0
        for (int i = 0; i < vertices.length; i++) {
            uf[i] = vertices[i];  // Cada vértice es su propio padre al inicio
            rank[i] = 0;          // Rango inicial 0
        }
    }

    // Encuentra el "padre" o representante del conjunto al que pertenece el vértice
    private Vertice find(Vertice v) {
        int index = v.id;  // Suponiendo que Vertice tiene un campo `id` para identificar el índice
        if (uf[index] != v) {
            uf[index] = find(uf[index]);  // Compresión de caminos
        }
        return uf[index];
    }

    // Devuelve true si los vértices src y dst están en el mismo conjunto
    private boolean UFfind(Vertice src, Vertice dst) {
        return find(src) == find(dst);
    }

    // Une los conjuntos a los que pertenecen src y dst
    private void UFunion(Vertice src, Vertice dst) {
        Vertice rootSrc = find(src);
        Vertice rootDst = find(dst);

        int srcIndex = rootSrc.id;
        int dstIndex = rootDst.id;

        // Unión por rango: el conjunto de menor rango se une al de mayor rango
        if (rank[srcIndex] > rank[dstIndex])
            uf[dstIndex] = rootSrc;  // dst se une al conjunto de src
        else if (rank[srcIndex] < rank[dstIndex])
            uf[srcIndex] = rootDst;  // src se une al conjunto de dst
        else {
            uf[dstIndex] = rootSrc;  // Si tienen el mismo rango, uno se une al otro
            rank[srcIndex]++;        // Incremento el rango del nuevo conjunto
        }
    }
}

