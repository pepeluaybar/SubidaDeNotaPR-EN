/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author JOSE LUIS
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println("   SISTEMA DE GESTIÓN DE TORNEOS eSports");
        System.out.println("======================================");

        // ─── 1. CREAMOS JUGADORES ────────────────────────
        System.out.println("--- Creando jugadores ---");
        Jugador j1 = new Jugador("Carlos García", "España", 20, "CarlosGG");
        Jugador j2 = new Jugador("Luis Martínez", "España", 22, "LuisPro");
        Jugador j3 = new Jugador("Marc Puig", "España", 19, "MarcX");
        Jugador j4 = new Jugador("John Smith", "USA", 21, "JohnS");

        j1.mostrarInfo();
        System.out.println();

        // ─── 2. CREAMOS UN EQUIPO ────────────────────────
        System.out.println("--- Creando equipo ---");
        Equipo e1 = new Equipo("Team España", "España", 0, "Team España");

        e1.añadirJugador(j1);
        e1.añadirJugador(j2);
        e1.añadirJugador(j3);

        // intentamos añadir un jugador de otro país → debe fallar
        System.out.println("\nIntentando añadir jugador de USA al equipo español:");
        e1.añadirJugador(j4);

        System.out.println();
        e1.mostrarInfo();
        System.out.println();

        // ─── 3. CREAMOS EL TORNEO ────────────────────────
        System.out.println("--- Creando torneo ---");
        Torneo torneo = new Torneo("Liga Nacional", "League of Legends");
        System.out.println(torneo);
        System.out.println();

        // ─── 4. REGISTRAMOS PARTICIPANTES ───────────────
        System.out.println("--- Registrando participantes ---");

        // registramos el equipo
        torneo.registrarParticipante(e1);

        // registramos jugador individual
        torneo.registrarParticipante(j4);

        // intentamos registrar j1 individualmente → debe fallar
        // porque su equipo ya está inscrito
        System.out.println("\nIntentando registrar jugador cuyo equipo ya está inscrito:");
        torneo.registrarParticipante(j1);

        // intentamos registrar e1 dos veces → debe fallar
        System.out.println("\nIntentando registrar el mismo equipo dos veces:");
        torneo.registrarParticipante(e1);

        System.out.println();

        // ─── 5. CREAMOS UNA PARTIDA 
        System.out.println("--- Creando partida ---");
        Partida partida1 = torneo.crearPartida(1);

        // añadimos participantes a la partida
        partida1.añadirParticipante(e1);
        partida1.añadirParticipante(j4);

        System.out.println(partida1);
        System.out.println();

        // ─── 6. INTENTAMOS REGISTRAR RESULTADO SIN FINALIZAR
        System.out.println("--- Intentando registrar resultado sin finalizar ---");
        partida1.registrarResultado(e1); // debe fallar

        // ─── 7. FINALIZAMOS Y REGISTRAMOS RESULTADO ──────
        System.out.println("\n--- Finalizando partida y registrando resultado ---");
        partida1.setFinalizada(true);
        partida1.registrarResultado(e1); // gana el equipo

        System.out.println(partida1);
        System.out.println();

        // ─── 8. COMPROBAMOS VICTORIAS ────────────────────
        System.out.println("--- Comprobando victorias tras la partida ---");
        System.out.println("Victorias equipo Team España: " + e1.getVictorias());
        System.out.println("Victorias Carlos (j1): " + j1.getVictorias());
        System.out.println("Victorias Luis (j2): " + j2.getVictorias());
        System.out.println("Victorias Marc (j3): " + j3.getVictorias());
        System.out.println("Victorias John (j4): " + j4.getVictorias());

        // ─── 9. CLASIFICACIÓN ────────────────────────────
        System.out.println("--- Clasificación del torneo ---");
        torneo.mostrarClasificacion();

        // ─── 10. CONSTRUCTOR DE COPIA ────────────────────
        System.out.println("\n--- Probando constructor de copia ---");
        Jugador j1Copia = new Jugador(j1);
        System.out.println("Original: " + j1);
        System.out.println("Copia:    " + j1Copia);
    }
}
