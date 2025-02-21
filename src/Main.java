import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Torneo torneo = new Torneo();

        // Creación de jugadores y equipos
        System.out.println("Creación de Equipos para el Torneo de Voleibol de Playa");
        
        for (int i = 1; i <= 2; i++) {
            System.out.println("\nCreando Equipo " + i);
            
            // Crear Jugador 1
            System.out.print("Nombre del Jugador 1: ");
            String nombreJugador1 = scanner.nextLine();
            System.out.print("Número del Jugador 1: ");
            int numeroJugador1 = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            Jugador jugador1 = new Jugador(nombreJugador1, numeroJugador1);

            // Crear Jugador 2
            System.out.print("Nombre del Jugador 2: ");
            String nombreJugador2 = scanner.nextLine();
            System.out.print("Número del Jugador 2: ");
            int numeroJugador2 = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            Jugador jugador2 = new Jugador(nombreJugador2, numeroJugador2);

            // Crear Suplente (opcional)
            Jugador suplente = null;
            System.out.print("¿Desea agregar un jugador suplente? (s/n): ");
            String respuestaSuplente = scanner.nextLine();
            if (respuestaSuplente.equalsIgnoreCase("s")) {
                System.out.print("Nombre del Suplente: ");
                String nombreSuplente = scanner.nextLine();
                System.out.print("Número del Suplente: ");
                int numeroSuplente = scanner.nextInt();
                scanner.nextLine(); // Consumir salto de línea
                suplente = new Jugador(nombreSuplente, numeroSuplente);
            }

            // Crear nombre de equipo
            System.out.print("Nombre del Equipo: ");
            String nombreEquipo = scanner.nextLine();

            // Crear Equipo
            Equipo equipo = new Equipo(nombreEquipo, jugador1, jugador2, suplente);
            
            // Agregar Equipo al Torneo
            torneo.agragarEquipo(equipo);
        }

        // Iniciar Torneo
        System.out.println("\n--- INICIO DEL TORNEO ---");
        torneo.iniciarTorneo();
    }
    
	
}
