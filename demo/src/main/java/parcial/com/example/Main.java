package parcial.com.example;

public class Main {

    /**
     * Simula una batalla por turnos entre dos criaturas.
     * La batalla termina cuando una de las criaturas muere.
     * @param criatura1 La primera criatura.
     * @param criatura2 La segunda criatura.
     */
    public static void simularBatalla(Criatura criatura1, Criatura criatura2) {
        System.out.println("\n--- INICIO DE BATALLA: " + criatura1.getNombre() + " (" + criatura1.getSalud() + " HP) vs " + criatura2.getNombre() + " (" + criatura2.getSalud() + " HP) ---");

        int turno = 1;
        
        // Bucle de batalla: Continúa mientras ambos estén vivos
        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("\n--- Turno " + turno + " ---");
            
            // Turno de Criatura 1
            if (criatura1.estaViva()) {
                System.out.print("[" + criatura1.getNombre() + " ataca]: ");
                criatura1.atacar(criatura2);
                if (!criatura2.estaViva()) {
                    System.out.println("\n*** VICTORIA: " + criatura1.getNombre() + " ha derrotado a " + criatura2.getNombre() + " ***");
                    break; 
                }
                System.out.println(criatura2.getNombre() + " [HP restante: " + criatura2.getSalud() + "]");
            }

            // Turno de Criatura 2
            if (criatura2.estaViva()) {
                System.out.print("[" + criatura2.getNombre() + " ataca]: ");
                criatura2.atacar(criatura1);
                if (!criatura1.estaViva()) {
                    System.out.println("\n*** VICTORIA: " + criatura2.getNombre() + " ha derrotado a " + criatura1.getNombre() + " ***");
                    break;
                }
                System.out.println(criatura1.getNombre() + " [HP restante: " + criatura1.getSalud() + "]");
            }
            
            turno++;
        }
        
        System.out.println("--- FIN DE BATALLA ---");
    }

    public static void main(String[] args) {
        System.out.println("--- Simulación de Batallas de Criaturas (v2: Diagrama de Clases) ---");

        // 1. Crear instancias de armas
        Arma espadaLarga = new Arma("Espada Larga", 10);
        Arma baculoMagico = new Arma("Báculo Arcano", 5);
        
        // 2. Crear instancias de criaturas
        
        // Guerrero
        Guerrero juan = new Guerrero(
            "juan el Guerrero", 
            150, // Salud
            25,  // Fuerza Base
            espadaLarga 
        );

        // Dragon
        Dragon escupefuego = new Dragon(
            "el escupefuego", 
            200, // Salud
            30,  // Fuerza Base
            "Escamas de Acero" 
        );
        
        // Mago
        Mago eduardo = new Mago(
            "eduardo el Mago", 
            100, // Salud
            15,  // Fuerza Base
            "bola de Fuego"
        );

        
        // 3. Simular batallas
        
        // BATALLA 1: Guerrero vs Mago
        // (Nota: Se deben crear nuevas instancias para tener salud completa en cada batalla)
        Guerrero juanB1 = new Guerrero("juan el guerrero", 150, 25, espadaLarga);
        Mago eduardoB1 = new Mago("eduardo el mago", 100, 15, "Bola de Fuego");
        simularBatalla(juanB1, eduardoB1);
        
        // BATALLA 2: Dragon vs Guerrero
        Dragon smaugB2 = new Dragon("eduardo el mago", 200, 30, "Escamas de Acero");
        Guerrero conanB2 = new Guerrero("juan el guerrero", 150, 25, espadaLarga);
        eduardoB2.volar(); // Uso de la interfaz Volador fuera de ataque
        simularBatalla(eduardoB2, juanB2);

    }
}