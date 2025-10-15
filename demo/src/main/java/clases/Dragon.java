package clases;
import interfaces.Volador;

public class Dragon extends Criatura implements Volador {
    private String escamas; //Las escamas del dragon influencian en su defensa
    
    

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }

    @Override
    public String volar() {
        return this.nombre + " despliega sus alas gigantes y se eleva en el aire!";
    }

    @Override
    public String aterrizar() {
        return this.nombre + " aterriza pesadamente, sintiéndose listo para la acción.";
    }

    @Override
    public void atacar(Criatura objetivo) {
        int dañoTotal = this.ataque + 15; // Daño base del aliento de fuego
        
        // Uso de habilidad de Volador
        System.out.println(this.volar());
        
        // Simulación de Aliento de Fuego
        System.out.println(this.nombre + " lanza un potente aliento de fuego con " + dañoTotal + " de daño base.");
        
        // Aplicar daño
        objetivo.defender(dañoTotal); 
    }
}