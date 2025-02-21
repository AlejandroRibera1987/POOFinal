import java.util.ArrayList;

public class Torneo {
	private ArrayList<Equipo> equipos;
	private ArrayList<Partido> partidos;
	
	
	public Torneo() {
		this.equipos = new ArrayList<>();
		this.partidos = new ArrayList<>();
	}
	
	public void agragarEquipo(Equipo equipo) {
			equipos.add(equipo);
	}
	
	
	public void iniciarTorneo() {
		
		ArrayList<Equipo> rondaActual = new ArrayList<>(equipos);
		int ronda = 1;
		
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
		
		System.out.println("El equipo ganador es: " + rondaActual.get(0));
	}
	
	
    private Equipo simularPartido(Partido partido) {
    	partido.registrarPuntos();
        return partido.obtenerGanador();
    }
	
}
