/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JOSE LUIS
 */
public abstract class Participante {

    private String nombre;
    private String pais;
    private int edad;
    private int victorias;

    // ─── CONSTRUCTORES 

    // Por defecto
    public Participante() {
        this.nombre = "";
        this.pais = "";
        this.edad = 0;
        this.victorias = 0;
    }

    // Por parámetros
    public Participante(String nombre, String pais, int edad) {
        this.nombre = nombre;
        this.pais = pais;
        this.edad = edad;
        this.victorias = 0; // siempre empieza en 0
    }

    // De copia
    public Participante(Participante p) {
        this.nombre = p.nombre;
        this.pais = p.pais;
        this.edad = p.edad;
        this.victorias = p.victorias;
    }

    // ─── GETTERS 
    public String getNombre() { return nombre; }
    public String getPais() { return pais; }
    public int getEdad() { return edad; }
    public int getVictorias() { return victorias; }

    // ─── SETTERS
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPais(String pais) { this.pais = pais; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setVictorias(int victorias) { this.victorias = victorias; }

    // ─── MÉTODOS

    // Abstract: cada hijo lo implementa a su manera
    public abstract void mostrarInfo();

    // Las victorias suben de 1 en 1
    public void incrementarVictorias() {
        this.victorias++;
    }

    // ─── TSOTRING
    @Override
    public String toString() {
        return "Participante[nombre=" + nombre + 
               ", pais=" + pais + 
               ", edad=" + edad + 
               ", victorias=" + victorias + "]";
    }
}
