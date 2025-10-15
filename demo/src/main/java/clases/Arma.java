package clases;
import clases.Criatura;

public class Arma {
    private String nombre;
    private int dañoAdicional;


    

    public Arma(String nombre, int dañoAdicional) {
        this.nombre = nombre;
        this.dañoAdicional = dañoAdicional;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDañoAdicional() {
        return dañoAdicional;
    }

    
    public String atacarConArma(Criatura objetivo) {
        return "Ataca con el arma '" + this.nombre + "' e inflige un daño adicional de " + this.dañoAdicional + ".";
    }
}