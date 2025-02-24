
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
	
    public void mostrarEstadisticas() {
        System.out.println("Estadísticas de " + nombre + " (" + numero + "):");
        System.out.println("  - Aces: " + estadisticas.getAces());
        System.out.println("  - Bloqueos: " + estadisticas.getBloqueos());
        System.out.println("  - Ataques: " + estadisticas.getAtaques());
    }

	@Override
	public String toString() {
		return  nombre;
	}

	
	
	
}
