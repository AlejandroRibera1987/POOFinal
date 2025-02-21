import java.util.ArrayList;

public class Torneo {
	private ArrayList<Equipo> equipos;
	private ArrayList<Partido> partidos;
	private static int ronda;
	
	
	public Torneo() {
		this.equipos = new ArrayList<>();
		this.partidos = new ArrayList<>();
		Torneo.ronda = 1;
	}
	
	public static int getRonda() {
		return ronda;
	}


	public void agragarEquipo(Equipo equipo) {
			equipos.add(equipo);
	}
	
	
	public void iniciarTorneo() {
		
		ArrayList<Equipo> rondaActual = new ArrayList<>(equipos);
		
		
		while (rondaActual.size() > 1) {
			
			ArrayList<Equipo> ganadores = new ArrayList<>();
			
			for (int i = 0; i < rondaActual.size(); i += 2) {
				Partido partido = new Partido(rondaActual.get(i), rondaActual.get(i + 1));
                partidos.add(partido);
                
                Equipo ganador = simularPartido(partido);
                ganadores.add(ganador);
			}
			
			rondaActual = ganadores;
			ronda++;
		}
		System.out.println("-----------------------EL CAMPEON-------------------------");
		System.out.println("\n-----------------------" + rondaActual.get(0).toString().toUpperCase() + "-----------------------------");
		System.out.println("Jugadores ganadores: " + rondaActual.get(0).getJugador1() + " - " + rondaActual.get(0).getJugador2() + " - " + rondaActual.get(0).getSuplente());
	}
	
	
    private Equipo simularPartido(Partido partido) {
    	partido.registrarPuntos();
        return partido.obtenerGanador();
    }
	
}
