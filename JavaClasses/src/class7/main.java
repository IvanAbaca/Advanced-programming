package class7;

import java.util.List;

import UtilsGrafos.Arista;

public class main {
	public static void main(String[] args) {
		
		String option = "prim";
		
		switch(option) {
		// ||---------||		Prim		||---------||
			case("prim"): 
			{
				MST obj = new MST(option, "MST.txt");
				
				List<Arista> mst = obj.prim(obj.grafo.get(0));
				
				for (Arista arista : mst)
					if(arista.w != null)
						System.out.println(	"(" + arista.v.nombre + ") → " +
											"(" + arista.w.nombre + ") = " + arista.distancia);
				
				break;
			}
		
			// ||---------||		Kruskal			||---------||
			case("kruskal"): 
			{
				MST obj = new MST(option, "MST.txt");
				
				List<Arista> mst = obj.kruskal();
				
				for (Arista arista : mst) {
					System.out.println(	"(" + arista.v.nombre + ") → " +
										"(" + arista.w.nombre + ") = " + arista.distancia);
				}
				break;
			}
		
		}
	}
}