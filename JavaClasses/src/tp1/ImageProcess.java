package tp1;

public class ImageProcess {
	
	public static void main(String[] args) {
		
		int[][] m = {
			{ 0, 0, 0, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0, 0},
			{ 0, 0, 1, 2, 3, 0, 0},
			{ 0, 0, 4, 5, 6, 0, 0},
			{ 0, 0, 7, 8, 9, 0, 0},
			{ 0, 0, 0, 0, 0, 0, 0},
			{ 0, 0, 0, 0, 0, 0, 0}
		};
		
		int[][] m2 = {
			{ 1, 2, 3, 4, 5, 6, 7},
			{ 8, 9,10,11,12,13,14},
			{15,16,17,18,19,20,21},
			{22,23,24,25,26,27,28},
			{29,30,31,32,33,34,35},
			{36,37,38,39,40,41,42},
			{43,44,45,46,47,48,49}
			};
		
		int[][] m3 = {
				{ 0, 0, 0, 0, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 0, 0},
				{ 0, 0, 1, 1, 1, 0, 0},
				{ 0, 0, 1, 1, 1, 0, 0},
				{ 0, 0, 1, 1, 1, 0, 0},
				{ 0, 0, 0, 0, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 0, 0}
			};
		
		int[][] dilatada = dilatacion(m3, 3);
		
		mostrarMatriz(dilatada);
	}
	
	public static int[][] contorno(int[][] matrix) {
		int dilatada[][] = dilatacion(matrix, 3);
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = dilatada[i][j] - matrix[i][j];
            }
        }
        return result;
    }
	
	public static int[][] dilatacion(int[][] m, int ve) {
		int filas = m.length;
		int columnas = m[0].length;
		int[][] newMatrix = new int[m.length][m[0].length];
		
		for(int fila = 0; fila < filas; fila++)
			for(int cola = 0; cola < columnas; cola++)
				newMatrix[fila][cola] = dilatar(m, fila, cola, ve);
		
		return newMatrix;
	}
	
	public static int[][] erosion(int[][] m, int lv, int lh) {
		int[][] newMatrix = new int[m.length][m[0].length];
		
		for(int i=0; i < m.length; i++)
			for(int j=0; j<m[0].length; j++)
				newMatrix[i][j] = erosionar(m, i, j, lv, lh);
		
		return newMatrix;
	}
	
	public static int dilatar(int[][]m, int y, int x, int tamVE) {
		int max = 0;
		int radio = tamVE/2;
		int margenInf = m.length-1;
		int margenDer = m[0].length-1;
		
		int filaInicial = (y >= radio) ? y - radio : 0;
		int colaInicial = (x >= radio) ? x - radio : 0;
		
		int filaFinal 	= (y + radio <= margenInf) ? y + radio : margenInf;
		int colaFinal 	= (x + radio <= margenDer) ? x + radio : margenDer;
		
		for(int fila = filaInicial; fila <= filaFinal; fila++)
			for(int cola = colaInicial; cola <= colaFinal; cola++)
				if(max < m[fila][cola])
					max = m[fila][cola];
		
		return max;
	}
	
	public static int erosionar(int[][]m, int pv, int ph, int lv, int lh) {
		int min = 255;
		int fi = (pv - lv/2 >= 0) ? pv - lv/2 : 0;
		int ci = (ph - lh/2 >= 0) ? ph - lh/2 : 0;
		int ff = (pv + lv/2 <= m.length-1) ? pv + lv/2 : m.length-1;
		int cf = (ph + lh/2 <= m[0].length-1) ? ph + lh/2 : m[0].length-1;
		
		for(int i=fi; i<=ff; i++)
			for(int j=ci; j<=cf; j++)
				min = min>m[i][j]?m[i][j]:min;
		
		return min;
	}
	
	public static void mostrarMatriz(int[][]m) {
    	System.out.println();
    	for(int[] xl : m)
		{
			for(int x : xl)
				System.out.print(x + "\t");
			System.out.println();
			System.out.println();
		}
    }
}
