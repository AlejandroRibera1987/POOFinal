import java.util.Random;

public class Partido {
	private Equipo equipo1;
	private Equipo equipo2;
	private int[] puntajeEquipo1;
	private int[] puntajeEquipo2;
	private Estado estado;
	private int setActual;
	private static final int PUNTOS_PARA_GANAR = 21;
	private static final int DIFERENCIA_PUNTOS = 2;
	
	public Partido(Equipo equipo1, Equipo equipo2) {
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.puntajeEquipo1 = new int[3];
		this.puntajeEquipo2 = new int[3];
		this.estado = Estado.EN_CURSO;
		this.setActual = 0;
	}

	
	public void registrarPuntos() {
		Random random = new Random();
		
		while (setActual < 3 && obtenerGanador() == null) {
			int puntosEquipo1 = 0;
			int puntosEquipo2 = 0;
			
			while ((puntosEquipo1 < PUNTOS_PARA_GANAR && puntosEquipo2 < PUNTOS_PARA_GANAR) ||
		               Math.abs(puntosEquipo1 - puntosEquipo2) < DIFERENCIA_PUNTOS) {
	            if (random.nextBoolean()) {
	                puntosEquipo1++;
	            } else {
	                puntosEquipo2++;
	            }
			}
			
			puntajeEquipo1[setActual] = puntosEquipo1;
			puntajeEquipo2[setActual] = puntosEquipo2;
			
			System.out.println("Set " + (setActual + 1) + ": " + equipo1.getNombreEquipo() + " " + puntosEquipo1 + " Puntos\n" + 
																equipo2.getNombreEquipo() + " " + puntosEquipo2 + " Puntos");
			
			setActual++;
			
		}
		
		estado = Estado.FINALIZADO;
		System.out.println("El partido termino, equipo ganador: " + obtenerGanador().getNombreEquipo());
		
	}
	
	public Equipo obtenerGanador() {
		int setGanadosEquipo1 = 0;
		int setGanadosEquipo2 = 0;
		
		for (int i = 0; i < setActual; i++) {
			if (puntajeEquipo1[i] > puntajeEquipo2[i]) {
				setGanadosEquipo1++;
			}else {
				setGanadosEquipo2++;
			}
		}
		
		if (setGanadosEquipo1 == 2) {
			return equipo1;
		} else if (setGanadosEquipo2 == 2) {
			return equipo2;
		}
		
		return null;
		
	}
	
}
