package controlador;

import interfaz.InterfazGrafica;
import algoritmoGenetico.AlgoritmoGenetico;
import algoritmoGenetico.Cromosoma;

public class Controlador {

	private static InterfazGrafica interfaz;
	private static AlgoritmoGenetico genetico;
	
	public static void _main (String[] args)
	{
		Controlador controlador = new Controlador();
		interfaz = new InterfazGrafica(controlador);
		genetico = new AlgoritmoGenetico();
		
		Cromosoma cromosomaMejor = genetico.algoritmo_genetico(interfaz.getParametros());
		
		interfaz.mostrar(cromosomaMejor);
	}
	
}