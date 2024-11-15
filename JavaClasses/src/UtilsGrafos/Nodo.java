package UtilsGrafos;

public class Nodo {
	public int id;
	public String nombre;
	public static int count = 0;
	
	public Nodo() {
		id = count++;
		nombre = String.valueOf((char) ('A' + (id)));
	}
}
