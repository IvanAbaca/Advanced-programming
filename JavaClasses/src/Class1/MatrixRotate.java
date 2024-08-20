package Class1;

public class MatrixRotate {

	public static void rotar90(int[][] imagen) {
        rotarRecursivo(imagen, 0, imagen.length);
    }

    private static void rotarRecursivo(int[][] imagen, int inicio, int tamaño) {
        if (tamaño <= 1)
            return;

        int fin = inicio + tamaño - 1;

        for (int i = 0; i < tamaño - 1; i++) {
            int temp = imagen[inicio][inicio + i];
            imagen[inicio][inicio + i] = imagen[fin - i][inicio];
            imagen[fin - i][inicio] = imagen[fin][fin - i];
            imagen[fin][fin - i] = imagen[inicio + i][fin];
            imagen[inicio + i][fin] = temp;
        }
        rotarRecursivo(imagen, inicio + 1, tamaño - 2);
    }
    
    public static void main(String[] args) {
    	int[][] m1 = {{1,2,3},{4,5,6},{7,8,9}};
    	int[][] m2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    	
    	rotar90(m1);
    	mostrarMatriz(m1);
    	
    	rotar90(m2);
    	mostrarMatriz(m2);
	}
    
    public static void mostrarMatriz(int[][]m) {
    	System.out.println();
    	for(int[] xl : m)
		{
			for(int x : xl)
				System.out.print(x + "\t");
			System.out.println();
		}
    }
}
