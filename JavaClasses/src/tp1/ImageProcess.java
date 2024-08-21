package tp1;

public class ImageProcess {
	
	public static void main(String[] args) {
		
		int[][] m = {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,1,2,3,0,0},
			{0,0,4,5,6,0,0},
			{0,0,7,8,9,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}
		};
		
		
		
		int[][] dilatada = dilatacion(m, 3, 3);
		
		mostrarMatriz(dilatada);
	}
	
	public static int[][] dilatacion(int[][] m, int lv, int lh) {
		int[][] newMatrix = new int[m.length][m[0].length];
		
		for(int i=0; i < m.length; i++)
			for(int j=0; j<m[0].length; j++)
				newMatrix[i][j] = dilatar(m, i, j, lv, lh);
		
		return newMatrix;
	}
	
	public static int dilatar(int[][]m, int pv, int ph, int lv, int lh) {
		int max = 0;
		int fi = (pv - lv/2 >= 0) ? pv - lv/2 : 0;
		int ci = (ph - lh/2 >= 0) ? ph - lh/2 : 0;
		int ff = (pv + lv/2 <= m.length-1) ? pv + lv/2 : m.length-1;
		int cf = (ph + lh/2 <= m[0].length-1) ? ph + lh/2 : m[0].length-1;
		
		for(int i=fi; i<=ff; i++)
			for(int j=ci; j<=cf; j++)
				max = max<m[i][j]?m[i][j]:max; 
		
		return max;
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
