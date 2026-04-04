/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JOSE LUIS
 */
public class Partida {

    private int id;
    private Participante[] participantes;
    private int numParticipantes;
    private Participante ganador;
    private boolean finalizada;

    // tamaño máximo no especificado en el enunciado, se define por defecto
    private static final int MAX_PARTICIPANTES = 20;

    //  CONSTRUCTORES

    // Por defecto
    public Partida() {
        this.id = 0;
        this.participantes = new Participante[MAX_PARTICIPANTES];
        this.numParticipantes = 0;
        this.ganador = null;
        this.finalizada = false;
    }

    // Por parámetros
    public Partida(int id) {
        this.id = id;
        this.participantes = new Participante[MAX_PARTICIPANTES];
        this.numParticipantes = 0;
        this.ganador = null;
        this.finalizada = false;
    }

    // De copia
    public Partida(Partida p) {
        this.id = p.id;
        this.numParticipantes = p.numParticipantes;
        this.ganador = p.ganador;
        this.finalizada = p.finalizada;
        this.participantes = new Participante[MAX_PARTICIPANTES];
        for (int i = 0; i < p.numParticipantes; i++) {
            this.participantes[i] = p.participantes[i];
        }
    }

    //  GETTERS
    public int getId() { return id; }
    public Participante[] getParticipantes() { return participantes; }
    public int getNumParticipantes() { return numParticipantes; }
    public Participante getGanador() { return ganador; }
    public boolean isFinalizada() { return finalizada; }

    //  SETTERS 
    public void setId(int id) { this.id = id; }
    public void setParticipantes(Participante[] participantes) { 
        this.participantes = participantes; 
    }
    public void setGanador(Participante ganador) { this.ganador = ganador; }
    public void setFinalizada(boolean finalizada) { this.finalizada = finalizada; }

    // MÉTODOS 

    public boolean añadirParticipante(Participante p) {

        // array lleno
        if (numParticipantes >= MAX_PARTICIPANTES) {
            System.out.println("Error: la partida está llena.");
            return false;
        }

        // participante ya está en la partida
        for (int i = 0; i < numParticipantes; i++) {
            if (participantes[i].getNombre().equals(p.getNombre())) {
                System.out.println("Error: el participante ya está en la partida.");
                return false;
            }
        }

        // si pasa las validaciones, lo añadimos
        participantes[numParticipantes] = p;
        numParticipantes++;
        return true;
    }

    public boolean registrarResultado(Participante ganador) {

        // no se puede registrar si no está finalizada
        if (!finalizada) {
            System.out.println("Error: la partida no está finalizada.");
            return false;
        }

        // mínimo 2 participantes
        if (numParticipantes < 2) {
            System.out.println("Error: la partida necesita mínimo 2 participantes.");
            return false;
        }

        // asignamos ganador e incrementamos victorias
        this.ganador = ganador;
        ganador.incrementarVictorias();

        // si el ganador es un equipo, incrementamos victorias de todos sus jugadores
        if (ganador instanceof Equipo) {
            Equipo equipoGanador = (Equipo) ganador;
            for (int i = 0; i < equipoGanador.getNumJugadores(); i++) {
                equipoGanador.getJugadores()[i].incrementarVictorias();
            }
        }

        return true;
    }

    //  TOSTRING 
    @Override
    public String toString() {
        return "Partida[id=" + id +
               ", participantes=" + numParticipantes +
               ", finalizada=" + finalizada +
               ", ganador=" + (ganador != null ? ganador.getNombre() : "sin ganador") + "]";
    }
}