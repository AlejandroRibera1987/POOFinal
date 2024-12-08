
public class Estadisticas {
	private int aces;
	private int bloqueos;
	private int ataques;
		
	
	public int getAces() {
		return aces;
	}
	public int getBloqueos() {
		return bloqueos;
	}
	public int getAtaques() {
		return ataques;
	}
	
	
	public void registrarAce() {
		aces ++;
	}
	
	public void registrarBloqueo() {
		bloqueos ++;
	}
	
	public void registrarAtaque() {
		ataques ++;
	}
	
}
