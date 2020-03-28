import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Test4 {
	
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
	
	@DisplayName("Prueba de Caja Negra Con cadenas vacias")
	@Test
	/*
	 * Prueba en la que le paso cadenas vacias 
	 */
	void prueba1() {
		assertEquals("", f.cadenas("", "", ""));
	}
	
	@DisplayName("Prueba de Caja Negra Con cadenas de 1 caracter")
	@Test
	/*
	 * Prueba en la que le paso cadenas de un caracter
	 */
	void prueba2() {
		assertEquals("bc", f.cadenas("a", "b", "c"));
	}
	
	@DisplayName("Prueba de Caja Negra con Valores aleatorios")
	@Test
	/*
	 * Prueba en la que paso cadenas que he elegido
	 * sin nungun sentido (al azar), para comprobar el
	 * comportamiento de la funcion
	 * 
	 * Le paso:
	 * 
	 * 	- abc
	 * 	- ABC
	 *  - aaa
	 */
	void prueba3() {
		assertEquals("bc", f.cadenas("abc", "ABC", "aaa"));
	}
}