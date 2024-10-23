package class7;

import UtilsGrafos.Arista;
import UtilsGrafos.Grafo;
import UtilsGrafos.Vertice;

public class main {
    public static void main(String[] args) {
    	// Creación de los vértices
    	Vertice a = new Vertice(0, "a");
    	Vertice b = new Vertice(1, "b");
    	Vertice c = new Vertice(2, "c");
    	Vertice d = new Vertice(3, "d");
    	Vertice e = new Vertice(4, "e");
    	Vertice f = new Vertice(5, "f");
    	Vertice g = new Vertice(6, "g");

    	// Array de vértices
    	Vertice[] vertices = {a, b, c, d, e, f, g};

    	// Array de aristas con los pesos correctos del nuevo grafo
    	Arista[] aristas = {
    	    new Arista(a, b, 2),  // a -> b con peso 2
    	    new Arista(a, d, 4),  // a -> d con peso 4
    	    new Arista(a, f, 5),  // a -> f con peso 5
    	    new Arista(b, d, 1),  // b -> d con peso 1
    	    new Arista(b, e, 3),  // b -> e con peso 3
    	    new Arista(b, f, 8),  // b -> f con peso 8
    	    new Arista(b, g, 4),  // b -> g con peso 4
    	    new Arista(b, c, 7),  // b -> c con peso 7
    	    new Arista(c, g, 6),  // c -> g con peso 6
    	    new Arista(e, c, 10), // e -> c con peso 10
    	    new Arista(f, g, 1),  // f -> g con peso 1
    	    new Arista(d, e, 2)   // d -> e con peso 2
    	};

    	
        // Crear el grafo
        Grafo grafo = new Grafo(vertices, aristas);
        
        // Ejecutar Kruskal para encontrar el MST
        MST mst = new MST();
        mst.kruskal(grafo);
        //mst.prim(grafo);
        System.out.println("a");
        
        /*
        // Imprimir el resultado
        System.out.println("Aristas del Árbol Abarcador de Costo Mínimo (MST):");
        for (Vertice v : grafo.vertices) 
            if (v != null)
                System.out.println(v.nombre + " - " + (v.pred == null ? "null" : v.pred.nombre) + ": " + v.key);
         */
        
        // Imprimir el resultado
        System.out.println("Aristas del Árbol Abarcador de Costo Mínimo (MST):");
        for (Arista arista : mst.mst) 
            if (arista != null) 
                System.out.println(arista.src.nombre + " - " + (arista.dst != null ? arista.dst.nombre : "null") + ": " + arista.w);
        
    }
}
