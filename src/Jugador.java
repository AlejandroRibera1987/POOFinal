
public class Jugador {
	private String nombre;
	private int numero;
	private Estadisticas estadisticas;
	
	public Jugador(String nombre, int numero) {
		this.nombre = nombre;
		this.numero = numero;
		this.estadisticas = new Estadisticas();
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumero() {
		return numero;
	}

	public Estadisticas getEstadisticas() {
		return estadisticas;
	}
	
	
}
