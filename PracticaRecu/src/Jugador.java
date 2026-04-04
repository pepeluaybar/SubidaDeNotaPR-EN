/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JOSE LUIS
 */
public class Jugador extends Participante {

    private String nickname;

    // ─── CONSTRUCTORES 

    // Por defecto
    public Jugador() {
        super(); // llama al constructor por defecto de Participante
        this.nickname = "";
    }

    // Por parámetros
    public Jugador(String nombre, String pais, int edad, String nickname) {
        super(nombre, pais, edad); // llama al constructor de Participante
        this.nickname = nickname;
    }

    // De copia
    public Jugador(Jugador j) {
        super(j); // copia los atributos de Participante
        this.nickname = j.nickname;
    }

    // ─── GETTERS 
    public String getNickname() { return nickname; }

    // ─── SETTERS 
    public void setNickname(String nickname) { this.nickname = nickname; }

    // ─── MÉTODOS
    @Override
    public void mostrarInfo() {
        System.out.println("=== JUGADOR ===");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Nickname: " + nickname);
        System.out.println("País: " + getPais());
        System.out.println("Edad: " + getEdad());
        System.out.println("Victorias: " + getVictorias());
    }

    // ─── TOSTRING 
    @Override
    public String toString() {
        return "Jugador[" + getNombre() + 
               ", nickname=" + nickname + 
               ", pais=" + getPais() + 
               ", victorias=" + getVictorias() + "]";
    }
}
