/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JOSE LUIS
 */
public class Equipo extends Participante {

    private String nombreEquipo;
    private Jugador[] jugadores;
    private int numJugadores;

    // tamaño máximo del array
    private static final int MAX_JUGADORES = 10;

    // ─── CONSTRUCTORES 

    // Por defecto
    public Equipo() {
        super();
        this.nombreEquipo = "";
        this.jugadores = new Jugador[MAX_JUGADORES];
        this.numJugadores = 0;
    }

    // Por parámetros
    public Equipo(String nombre, String pais, int edad, String nombreEquipo) {
        super(nombre, pais, edad);
        this.nombreEquipo = nombreEquipo;
        this.jugadores = new Jugador[MAX_JUGADORES];
        this.numJugadores = 0;
    }

    // De copia
    public Equipo(Equipo e) {
        super(e);
        this.nombreEquipo = e.nombreEquipo;
        this.numJugadores = e.numJugadores;
        this.jugadores = new Jugador[MAX_JUGADORES];
        for (int i = 0; i < e.numJugadores; i++) {
            this.jugadores[i] = new Jugador(e.jugadores[i]); // copia cada jugador
        }
    }

    // ─── GETTERS 
    public String getNombreEquipo() { return nombreEquipo; }
    public Jugador[] getJugadores() { return jugadores; }
    public int getNumJugadores() { return numJugadores; }

    // ─── SETTERS 
    public void setNombreEquipo(String nombreEquipo) { 
        this.nombreEquipo = nombreEquipo; 
    }
    public void setJugadores(Jugador[] jugadores) { 
        this.jugadores = jugadores; 
    }

    // ─── MÉTODOS 

    public boolean añadirJugador(Jugador j) {

        // array lleno
        if (numJugadores >= MAX_JUGADORES) {
            System.out.println("Error: el equipo está lleno.");
            return false;
        }

        // jugador ya existe en el equipo
        for (int i = 0; i < numJugadores; i++) {
            if (jugadores[i].getNickname().equals(j.getNickname())) {
                System.out.println("Error: el jugador ya está en el equipo.");
                return false;
            }
        }

        // todos los jugadores deben ser del mismo país
        if (numJugadores > 0 && !jugadores[0].getPais().equals(j.getPais())) {
            System.out.println("Error: el jugador debe ser del mismo país que el equipo.");
            return false;
        }

        // si pasa todas las validaciones, lo añadimos
        jugadores[numJugadores] = j;
        numJugadores++;
        return true;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("=== EQUIPO ===");
        System.out.println("Nombre del equipo: " + nombreEquipo);
        System.out.println("País: " + getPais());
        System.out.println("Victorias: " + getVictorias());
        System.out.println("Jugadores:");
        for (int i = 0; i < numJugadores; i++) {
            System.out.println("  - " + jugadores[i].getNickname() 
                               + " (" + jugadores[i].getNombre() + ")");
        }
    }

    // ─── TOSTRING 
    @Override
    public String toString() {
        return "Equipo[" + nombreEquipo + 
               ", pais=" + getPais() + 
               ", victorias=" + getVictorias() + 
               ", jugadores=" + numJugadores + "]";
    }
}