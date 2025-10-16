package parcial.com.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import clases.Arma;
import clases.Dragon; // <-- ¡Importante! En JUnit 4, @Test viene de 'junit.framework.Test' o 'org.junit.Test'
import clases.Guerrero; // <-- En JUnit 4, las aserciones están en 'org.junit.Assert'
import clases.Mago;

/**
 * Pruebas unitarias para la simulación de batallas (Versión JUnit 4).
 */
public class BatallaTest {

    // 1. Recursos compartidos para las pruebas
    private final Arma ESPADA_LARGA = new Arma("Espada Larga", 10);
    private final int SALUD_BASE_GUERRERO = 150;
    private final int FUERZA_BASE_GUERRERO = 25;
    private final int SALUD_BASE_DRAGON = 200;
    private final int FUERZA_BASE_DRAGON = 30;
    private final int SALUD_BASE_MAGO = 100;
    private final int FUERZA_BASE_MAGO = 15;

    // --- Prueba de Batalla 1: Guerrero vs Mago ---
    
    // Usamos la anotación @Test 
    @Test
    public void testBatallaGuerreroVsMago() {
        // ARRANGE: Preparación de las instancias
        Guerrero juan = new Guerrero("Juan el Guerrero", SALUD_BASE_GUERRERO, FUERZA_BASE_GUERRERO, ESPADA_LARGA);
        Mago eduardo = new Mago("Eduardo el Mago", SALUD_BASE_MAGO, FUERZA_BASE_MAGO, "Bola de Fuego");

        // ACT: Ejecución de la lógica a probar
        // NOTA: El método simularBatalla debe ser accesible (público)
        Main.simularBatalla(juan, eduardo);

        // ASSERT: Verificación de los resultados esperados
        
        // Los métodos de aserción (assertTrue, assertFalse) funcionan igual
        assertTrue("El Guerrero Juan debería estar vivo al finalizar.", juan.estaViva());
        assertFalse("El Mago Eduardo debería estar muerto (HP <= 0).", eduardo.estaViva());
        assertTrue("El Guerrero debería tener salud restante.", juan.getSalud() > 0);
        assertTrue("El Mago debe tener salud en 0 o menos.", eduardo.getSalud() <= 0);
    }

    // --- Prueba de Batalla 2: Dragón vs Guerrero ---

    @Test
    public void testBatallaDragonVsGuerrero() {
        // ARRANGE: Preparación de las instancias
        Dragon escupefuego = new Dragon("Escupefuego", SALUD_BASE_DRAGON, FUERZA_BASE_DRAGON, "Escamas de Acero");
        Guerrero juan = new Guerrero("Juan el Guerrero", SALUD_BASE_GUERRERO, FUERZA_BASE_GUERRERO, ESPADA_LARGA);
        
        escupefuego.volar(); // Llamada auxiliar

        // ACT: Ejecución de la lógica a probar
        Main.simularBatalla(escupefuego, juan);

        // ASSERT: Verificación de los resultados esperados
        
        assertTrue("El Dragón Escupefuego debería estar vivo al finalizar.", escupefuego.estaViva());
        assertFalse("El Guerrero Juan debería estar muerto (HP <= 0).", juan.estaViva());
        assertTrue("El Dragón debería tener salud restante.", escupefuego.getSalud() > 0);
    }

    // --- Prueba de Muerte  ---

    @Test
    public void testMuerteInmediata() {
        // ARRANGE
        Mago debil = new Mago("Mago Débil", 1, 10, "Hechizo"); // 1 HP
        Guerrero fuerte = new Guerrero("Guerrero Fuerte", 100, 50, ESPADA_LARGA); 

        // ACT
        Main.simularBatalla(fuerte, debil);

        // ASSERT
        assertFalse("El Mago Débil debe morir inmediatamente.", debil.estaViva());
        assertTrue("El Guerrero Fuerte debe sobrevivir el combate.", fuerte.estaViva());
    }

}