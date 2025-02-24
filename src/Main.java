import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Torneo torneo = new Torneo();
        int cantidadEquipos = 2;

       
        System.out.println("Equipos al torneo de Voley");
        
        for (int i = 1; i <= cantidadEquipos; i++) {
            System.out.println("\nCreando Equipo " + i);
            
            System.out.print("Nombre del Equipo: ");
            String nombreEquipo = scanner.nextLine();
            
            System.out.print("Nombre del Jugador 1: ");
            String nombreJugador1 = scanner.nextLine();
            System.out.print("Numero del Jugador 1: ");
            int numeroJugador1 = scanner.nextInt();
            scanner.nextLine();
            Jugador jugador1 = new Jugador(nombreJugador1, numeroJugador1);

      
            System.out.print("Nombre del Jugador 2: ");
            String nombreJugador2 = scanner.nextLine();
            System.out.print("Numero del Jugador 2: ");
            int numeroJugador2 = scanner.nextInt();
            scanner.nextLine(); 
            Jugador jugador2 = new Jugador(nombreJugador2, numeroJugador2);

          
            Jugador suplente = null;
            System.out.print("¿Desea agregar un jugador suplente? (s/n): ");
            String respuestaSuplente = scanner.nextLine();
            if (respuestaSuplente.equalsIgnoreCase("s")) {
                System.out.print("Nombre del Suplente: ");
                String nombreSuplente = scanner.nextLine();
                System.out.print("Numero del Suplente: ");
                int numeroSuplente = scanner.nextInt();
                scanner.nextLine(); 
                suplente = new Jugador(nombreSuplente, numeroSuplente);
            }
  
            Equipo equipo = new Equipo(nombreEquipo, jugador1, jugador2, suplente);
            
            torneo.agragarEquipo(equipo);
        }

        System.out.println("\n--- INICIO DEL TORNEO ---");
        torneo.iniciarTorneo();
    }
    
	
}
