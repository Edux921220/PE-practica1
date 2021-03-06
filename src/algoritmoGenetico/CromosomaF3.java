package algoritmoGenetico;

/**
 * Atributos heredados
 *  ---------------------	
 *  private boolean[] genes;
 *  private double fenotipo;
 *  private double aptitud;
 *  private double puntuacion;
 *  private double puntuacionAcumulada;
 *  protected int longitud;
 * 
 * Metodos abstractos
 *  ----------------------------------
 *  evaluarCromosoma()
 *  clone() 
 * 
 * Metodos implementados 
 *  ----------------------------------
 *  inicializarGenes(int)
 *  calcularLongitud(double, int, int)
 *  calcularLongitud(double, double, double, double, double, int, int)
 *  calcularFenotipo(int, int, int)
 *  setGen(int, boolean)
 *  mutaGen(int)
 *  toString()
 *  mostrar()
 */
public class CromosomaF3 extends Cromosoma
{
	/* Valores definidos en el problema */
	private static final int xMax = 250;
	private static final int xMin = -250;
		
	private int longitud;
	
	public static int dameLongitud(double tolerancia){
		return calcularLongitud(tolerancia, xMax, xMin);
	}
	
	public CromosomaF3(double tolerancia) 
	{	
		longitud = calcularLongitud(tolerancia, xMax, xMin);
		this.genes = inicializarGenes(longitud);
		evaluarCromosoma();
	}
	
	public CromosomaF3(boolean[] genes, double fenotipo, double aptitud, double puntuacion, double puntuacionAcumulada) 
	{
		super(genes,fenotipo,aptitud,puntuacion,puntuacionAcumulada);
		this.longitud = genes.length;
	}

	@Override
	protected Cromosoma clone()
	{
		return new CromosomaF3(this.getGenes().clone(),this.getFenotipo(),this.getAptitud(),this.getPuntuacion(),this.getPuntuacionAcumulada());
	}

	@Override
	protected void evaluarCromosoma() {
		this.fenotipo = calcularFenotipo(longitud,xMax,xMin);
		double x = fenotipo;
		double resul=x*Math.sin(Math.sqrt(Math.abs(x)));
		resul=Math.abs(resul);
		this.aptitud =  -resul;
	}

}
