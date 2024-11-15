package class6;

public class main {
	public static void main(String[] args) {
		
		String option = "warshall";
		
		switch(option) {
			case("floid"): {
				Floid f = new Floid();
				int[][] m = f.ady;
				
				System.out.print("Matriz vieja");
				mostrarMatriz(m);
				
				f.get_new_graph();
		
				System.out.print("\n\nMatriz nueva");
				mostrarMatriz(m);
				break;
			}
			case("warshall"): {
				Warshall w = new Warshall();
				int[][] m = w.ady;
				
				System.out.print("Matriz vieja");
				mostrarMatriz(m);

				w.get_new_graph();
		
				System.out.print("\n\nMatriz nueva");
				mostrarMatriz(m);
				break;
			}
		}
		

	}
	
	private static void mostrarMatriz(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			System.out.println();
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j]==Integer.MAX_VALUE?"∞ ":m[i][j] + " ");
			}
		}
	}
}
