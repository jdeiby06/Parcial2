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
    public int defender(int dano) {
        // Lógica de defensa simple: 10% de reducción de daño
        int danoFinal = (int) (dano * 0.9); 
        this.salud -= danoFinal;
        this.setSalud(this.salud); // Aplica el Math.max(0, salud)
        
        // ¡Importante! Mostrar que la defensa sucede:
        System.out.println("     --> " + this.nombre + " usa defensa. Daño entrante: " + dano + ". Daño reducido a: " + danoFinal + ".");
        
        return danoFinal;
    }
    
    public boolean estaViva() {
        return this.salud > 0;
        
    }
}
