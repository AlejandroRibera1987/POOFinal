import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

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
		Scanner scanner = new Scanner(System.in);
		
		while (setActual < 3 && obtenerGanador() == null) {
			int puntosEquipo1 = 0;
			int puntosEquipo2 = 0;
			
			System.out.println("\nIngrese los puntos del set " + (setActual + 1));
			
			while (true) {
				System.out.println(equipo1.getNombreEquipo() + " puntos: ");
				puntosEquipo1 = scanner.nextInt();
				
				System.out.println(equipo2.getNombreEquipo() +" puntos: ");
				puntosEquipo2 = scanner.nextInt();
				
				if ((puntosEquipo1 >= PUNTOS_PARA_GANAR || puntosEquipo2 >= PUNTOS_PARA_GANAR) 
						&& Math.abs(puntosEquipo1 - puntosEquipo2) >= DIFERENCIA_PUNTOS) {
					break;
				}else {
					System.err.println("Los puntos ingresados no son validos, un equipo gano con: " + PUNTOS_PARA_GANAR + " con al menos " +
										DIFERENCIA_PUNTOS + " puntos de diferencia.");
				}
				
			}
			
			puntajeEquipo1[setActual] = puntosEquipo1;
			puntajeEquipo2[setActual] = puntosEquipo2;
			
			System.out.println("\nSet " + (setActual + 1) + " finalizado");
			System.out.println(equipo1.getNombreEquipo() + " " + puntosEquipo1 + " puntos");
			System.out.println(equipo2.getNombreEquipo() + " " + puntosEquipo2 + " puntos");
			System.out.println("\n--------------------------------------------------------");
			setActual ++;
			
		}
		
		estado = Estado.FINALIZADO;
		System.out.println("\nEl partido termino, equipo ganador: " + obtenerGanador().getNombreEquipo());
		
		registrarEstadisticas();
		
		System.out.println("-----------------------------FIN DE RONDA: " + Torneo.getRonda() + "-----------------------------------------");
		
	}
	
	public void registrarEstadisticas() {
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("----Queres registrar las estadisticas del Partido (s/n)-------");
		String opcion = scanner.nextLine();
		
		if (!opcion.equalsIgnoreCase("s")) {
			return;			
		}
			
			System.out.println("\n-----Registar estadisticas del partido-------");
			
			for (Jugador jugador : equipo1.getJugadores()) {
		        
				System.out.println("\nEstadísticas para " + jugador.getNombre() + ":");

		        System.out.print("Numero de aces: ");
		        int aces = scanner.nextInt();
		        for (int i = 0; i < aces; i++) {
		            jugador.getEstadisticas().registrarAce();
		        }

		        System.out.print("Numero de bloqueos: ");
		        int bloqueos = scanner.nextInt();
		        for (int i = 0; i < bloqueos; i++) {
		            jugador.getEstadisticas().registrarBloqueo();
		        }

		        System.out.print("Numero de ataques: ");
		        int ataques = scanner.nextInt();
		        for (int i = 0; i < ataques; i++) {
		            jugador.getEstadisticas().registrarAtaque();
		        }

		        jugador.mostrarEstadisticas(); 
			}
			
			for (Jugador jugador : equipo2.getJugadores()) {
		        System.out.println("\nEstadísticas para " + jugador.getNombre() + ":");

		        System.out.print("Número de aces: ");
		        int aces = scanner.nextInt();
		        for (int i = 0; i < aces; i++) {
		            jugador.getEstadisticas().registrarAce();
		        }

		        System.out.print("Número de bloqueos: ");
		        int bloqueos = scanner.nextInt();
		        for (int i = 0; i < bloqueos; i++) {
		            jugador.getEstadisticas().registrarBloqueo();
		        }

		        System.out.print("Número de ataques: ");
		        int ataques = scanner.nextInt();
		        for (int i = 0; i < ataques; i++) {
		            jugador.getEstadisticas().registrarAtaque();
		        }

		        jugador.mostrarEstadisticas();
		    }		
		
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
