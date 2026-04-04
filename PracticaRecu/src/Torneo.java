/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JOSE LUIS
 */
public class Torneo {

    // ATRIBUTOS 
    private String nombre;
    private String juego;
    private Participante[] participantes;
    private int numParticipantes;
    private Partida[] partidas;
    private int numPartidas;

    // tamaños máximos no especificados en el enunciado, se definen por defecto
    private static final int MAX_PARTICIPANTES = 20;
    private static final int MAX_PARTIDAS = 50;

    // CONSTRUCTORES

    // Por defecto
    public Torneo() {
        this.nombre = "";
        this.juego = "";
        this.participantes = new Participante[MAX_PARTICIPANTES];
        this.numParticipantes = 0;
        this.partidas = new Partida[MAX_PARTIDAS];
        this.numPartidas = 0;
    }

    // Por parámetros
    public Torneo(String nombre, String juego) {
        this.nombre = nombre;
        this.juego = juego;
        this.participantes = new Participante[MAX_PARTICIPANTES];
        this.numParticipantes = 0;
        this.partidas = new Partida[MAX_PARTIDAS];
        this.numPartidas = 0;
    }

    // De copia
    public Torneo(Torneo t) {
        this.nombre = t.nombre;
        this.juego = t.juego;
        this.numParticipantes = t.numParticipantes;
        this.numPartidas = t.numPartidas;
        this.participantes = new Participante[MAX_PARTICIPANTES];
        this.partidas = new Partida[MAX_PARTIDAS];
        for (int i = 0; i < t.numParticipantes; i++) {
            this.participantes[i] = t.participantes[i];
        }
        for (int i = 0; i < t.numPartidas; i++) {
            this.partidas[i] = new Partida(t.partidas[i]);
        }
    }

    //  GETTERS 
    public String getNombre() { return nombre; }
    public String getJuego() { return juego; }
    public Participante[] getParticipantes() { return participantes; }
    public int getNumParticipantes() { return numParticipantes; }
    public Partida[] getPartidas() { return partidas; }
    public int getNumPartidas() { return numPartidas; }

    // SETTERS 
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setJuego(String juego) { this.juego = juego; }
    public void setParticipantes(Participante[] participantes) { 
        this.participantes = participantes; 
    }
    public void setPartidas(Partida[] partidas) { 
        this.partidas = partidas; 
    }

    //MÉTODOS 

    public boolean registrarParticipante(Participante p) {

        // array lleno
        if (numParticipantes >= MAX_PARTICIPANTES) {
            System.out.println("Error: el torneo está lleno.");
            return false;
        }

        // participante ya inscrito en el torneo
        for (int i = 0; i < numParticipantes; i++) {
            if (participantes[i].getNombre().equals(p.getNombre())) {
                System.out.println("Error: el participante ya está inscrito.");
                return false;
            }
        }

        // un jugador no puede competir individualmente si su equipo ya está inscrito
        if (p instanceof Jugador) {
            for (int i = 0; i < numParticipantes; i++) {
                if (participantes[i] instanceof Equipo) {
                    Equipo e = (Equipo) participantes[i];
                    for (int j = 0; j < e.getNumJugadores(); j++) {
                        if (e.getJugadores()[j].getNombre().equals(p.getNombre())) {
                            System.out.println("Error: el jugador pertenece a un equipo ya inscrito.");
                            return false;
                        }
                    }
                }
            }
        }

        // si pasa todas las validaciones, lo añadimos
        participantes[numParticipantes] = p;
        numParticipantes++;
        return true;
    }

    public Partida crearPartida(int id) {

        // array lleno
        if (numPartidas >= MAX_PARTIDAS) {
            System.out.println("Error: no se pueden crear más partidas.");
            return null;
        }

        // creamos la partida y la añadimos al torneo
        Partida nueva = new Partida(id);
        partidas[numPartidas] = nueva;
        numPartidas++;
        return nueva;
    }

    public void mostrarClasificacion() {
        System.out.println("=== CLASIFICACIÓN — " + nombre + " ===");

        // ordenamos por victorias de mayor a menor (burbuja)
        for (int i = 0; i < numParticipantes - 1; i++) {
            for (int j = 0; j < numParticipantes - i - 1; j++) {
                if (participantes[j].getVictorias() < participantes[j + 1].getVictorias()) {
                    Participante temp = participantes[j];
                    participantes[j] = participantes[j + 1];
                    participantes[j + 1] = temp;
                }
            }
        }

        // mostramos la clasificación ordenada
        for (int i = 0; i < numParticipantes; i++) {
            System.out.println((i + 1) + ". " + participantes[i].getNombre() +
                               " — Victorias: " + participantes[i].getVictorias());
        }
    }

    @Override
    public String toString() {
        return "Torneo[nombre=" + nombre +
               ", juego=" + juego +
               ", participantes=" + numParticipantes +
               ", partidas=" + numPartidas + "]";
    }
}
