package clases;




public class Guerrero extends Criatura {
    private Arma arma;



    public Guerrero(String nombre, int salud, int fuerza, Arma arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int dañoTotal = this.ataque + this.arma.getDañoAdicional();
        
        // Uso de Arma
        System.out.println(this.arma.atacarConArma(objetivo));
        System.out.println(this.nombre + " golpea con un daño total de " + dañoTotal + " (Base: " + this.ataque + ").");
        
        // Aplicar daño
        objetivo.defender(dañoTotal); 
    }
}