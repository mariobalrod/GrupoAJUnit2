import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Test3 {
	
	static Funciones f = null;
	static int numeroPruebasRealizadas = 0;
	@BeforeAll
	static void prepararPruebas() {
		System.out.println("Preparando Tests");
		f = new Funciones();
	}
	@BeforeEach
	private void preparaPruebaEjecutar(){
		numeroPruebasRealizadas++;
		System.out.println("Ejecutando test "+ numeroPruebasRealizadas);
	}
	@AfterEach
	private void terminadaPrueba(){
		System.out.println("Se ha ejecutado el test: "+numeroPruebasRealizadas);
	}
	@AfterAll
	static void terminarPruebas() {
		System.out.println("Se han terminado de ejecutar todas las pruebas");
		f = null;
	}
	
	//---------------------------------------------------------------------------------
	
	// PRUEBAS
	
	/*
	 *	Para la Funcion 3, he decidido realizar Pruebas de Caja Blanca
	 *	de Cobertura de Condiciones. Para ello, hay que evaluar el comportamiento
	 *	de la funcion  haciendo 2 pruebas, una para que la condicion se cumpla y 
	 *	otra para que no se cumpla.
	 */
	
	@DisplayName("Prueba de Caja Blanca de Cobertura de Condiciones 1")
	@Test
	/*
	 * En este caso, estudiaremos la funcion cuando se cumple
	 * la condicion. Para ello, debe de cumplirse
	 * numero%3==0 --> true
	 * numero%numeroDelIntervalo==0 --> true
	 * 
	 * Por lo que pasare:
	 * 		numero = 150
	 * 		numeroDelIntervalo = 150
	 */
	void prueba1() {
		assertEquals(1, f.numeroDivisible2(150, 150));
	}
	
	@DisplayName("Prueba de Caja Blanca de Cobertura de Condiciones 2")
	@Test
	/*
	 * En este caso, estudiaremos la funcion cuando no se cumple
	 * la condicion. Para ello, he elegido que no se cumpla ninguna de ellas:
	 * numero%3==0 --> false
	 * numero%numeroDelIntervalo==0 --> false
	 * 
	 * Por lo que pasare:
	 * 		numero = 7
	 * 		numeroDelIntervalo = 109
	 */
	void prueba2() {
		assertEquals(0, f.numeroDivisible2(7, 109));
	}
	
	@DisplayName("Prueba de Caja Negra con Valores Aleatorios")
	@Test
	/*
	 * Prueba en la que se evalua el comportamiento de la funcion
	 * pasandole numeros al azar.
	 * En este caso le paso el 10 y 9.
	 */
	void prueba3() {
		assertEquals(0, f.numeroDivisible2(10, 9));
	}
}
