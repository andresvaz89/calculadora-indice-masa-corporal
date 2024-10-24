package org.factoriaf5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class AppTest {

    @Test
    public void testCalcularIMC() {
        App imcCalculator = new App();
        
        
        double imc = imcCalculator.calcularIMC(70, 1.75);
        assertEquals("El IMC debería ser aproximadamente 22.86 para 70kg y 1.75m", 22.86, imc, 0.01);

        imc = imcCalculator.calcularIMC(80, 1.80);
        assertEquals("El IMC debería ser aproximadamente 24.69 para 80kg y 1.80m", 24.69, imc, 0.01);
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            imcCalculator.calcularIMC(70, 0);
        });
        assertEquals("Peso y estatura deben ser mayores que cero.", exception.getMessage());
        
        exception = assertThrows(IllegalArgumentException.class, () -> {
            imcCalculator.calcularIMC(-10, 1.75);
        });
        assertEquals("Peso y estatura deben ser mayores que cero.", exception.getMessage());
    }

    @Test
    public void testClasificarIMC() {
        App imcCalculator = new App();
        
        assertEquals("La clasificación debería ser 'Delgadez severa'", "Delgadez severa", imcCalculator.clasificarIMC(15));

        assertEquals("La clasificación debería ser 'Delgadez moderada'", "Delgadez moderada", imcCalculator.clasificarIMC(16.5));
        
        assertEquals("La clasificación debería ser 'Peso normal'", "Peso normal", imcCalculator.clasificarIMC(22));
        
     
        assertEquals("La clasificación debería ser 'Sobrepeso'", "Sobrepeso", imcCalculator.clasificarIMC(27));
        
        assertEquals("La clasificación debería ser 'Obesidad leve'", "Obesidad leve", imcCalculator.clasificarIMC(32));
        
        assertEquals("La clasificación debería ser 'Obesidad mórbida'", "Obesidad mórbida", imcCalculator.clasificarIMC(42));
    }
}
