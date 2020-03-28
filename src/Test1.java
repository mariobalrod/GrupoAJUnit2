import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Test1 {
	
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
	
	@DisplayName("Prueba de Caja Negra de Valor Aleatorio")
	@Test
	/*
	 * Prueba en la que se evalua el funcionamiento de la 
	 * funcion pasandole el valor al azar. En este caso, he
	 * elegido el 19.
	 */
	void prueba1() {
		assertFalse(f.numeroDivisible(19));
	}
	
	@DisplayName("Prueba de Caja Blanca Cobertura de Condiciones 1")
	@Test
	/*
	 * Prueba en la que se evalua que la condicion
	 * sea True, pasandole un numero divisible entre
	 * 3 para que se cumpla la condicion
	 */
	void prueba2() {
		assertTrue(f.numeroDivisible(18));
	}
	
	@DisplayName("Prueba de Caja Blanca Cobertura de Condiciones 2")
	@Test
	/*
	 * En este caso se evalua la opcion en la 
	 * que no se cumple la condicion y por lo tanto
	 * devuelve False
	 */
	void prueba3() {
		assertFalse(f.numeroDivisible(7));
	}
}
