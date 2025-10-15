package clases;
import interfaces.Magico;


public class Mago extends Criatura implements Magico {
    private String hechizos; 

    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
    }

    @Override
    public String lanzarHechizo(Criatura objetivo) {
        // Retorna el mensaje y también puede modificar el daño o aplicar un efecto
        return this.nombre + " conjura un hechizo de su grimorio (" + this.hechizos + ") contra " + objetivo.getNombre() + ".";
    }

    @Override
    public String aprenderHechizo(String nuevoHechizo) {
        this.hechizos += ", " + nuevoHechizo;
        return this.nombre + " ha aprendido un nuevo hechizo: " + nuevoHechizo + ".";
    }

    @Override
    public void atacar(Criatura objetivo) {
        int danoTotal = this.ataque * 2; // Los magos duplican su fuerza con magia.
        
        // Uso de Habilidad Mágica
        System.out.println(this.lanzarHechizo(objetivo));
        System.out.println(this.nombre + " inflige un daño mágico total de " + danoTotal + ".");
        
        // Aplicar daño
        objetivo.defender(danoTotal); 
    }
}