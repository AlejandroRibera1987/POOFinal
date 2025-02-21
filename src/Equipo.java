
public class Equipo {
	private String nombreEquipo;
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador suplente;
	
	public Equipo(String nombreEquipo, Jugador jugador1, Jugador jugador2, Jugador suplente) {
		this.nombreEquipo = nombreEquipo;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}

	
	
	public void setSuplente(Jugador suplente) {
		this.suplente = suplente;
	}
	
	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public Jugador getSuplente() {
		return suplente;
	}



	@Override
	public String toString() {
		return nombreEquipo;
	}
	
	
	
}
