package clases;

import javax.lang.model.util.ElementScanner14;

public abstract class Criatura {
    protected String nombre;
    protected int salud;
    protected int ataque;

    public Criatura(String nombre, int salud, int ataque) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getAtaque() {
        return ataque;
    }

    public void atacar(Criatura objetivo) {
        objetivo.setSalud(objetivo.getSalud() - this.ataque);
        System.out.println(this.nombre + " ataca a " + objetivo.getNombre() + " por " + this.ataque + " puntos de daño.");
        System.out.println(objetivo.getNombre() + " tiene " + objetivo.getSalud() + " puntos de salud restantes.");
    }
    public void defender(int daño) {
        // Lógica de defensa simple: 10% de reducción de daño
        int dañoFinal = (int) (daño * 0.9); 
        this.salud -= dañoFinal;
        this.setSalud(this.salud); 
    }
    
    public boolean estaViva() {
        return this.salud > 0;
        
    }
}
