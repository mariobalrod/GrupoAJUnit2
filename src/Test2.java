import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Test2 {
	
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
	
	@DisplayName("Prueba de Caja Negra de Limite Superior")
	@Test
	/*
	 * Se evalua el comportamiento de la funcion pasandole
	 * el limite superior de la condicion que en este caso
	 * es 200
	 */
	void prueba1() {
		assertTrue(f.numeroIntervalo(200));
	}
	
	@DisplayName("Prueba de Caja Negra de Limite Superior +1")
	@Test
	/*
	 * Se evalua el comportamiento de la funcion pasandole
	 * el limite superior+1 de la condicion que en este caso
	 * es 201
	 */
	void prueba2() {
		assertFalse(f.numeroIntervalo(201));
	}
	
	@DisplayName("Prueba de Caja Negra de Limite Inferior")
	@Test
	/*
	 * Se evalua el comportamiento de la funcion pasandole
	 * el limite inferior que es el 100
	 */
	void prueba3() {
		assertTrue(f.numeroIntervalo(100));
	}
	
	@DisplayName("Prueba de Caja Negra de Limite Inferio -1")
	@Test
	/*
	 * Se evalua el comportamiento de la funcion pasandole
	 * el limite inferior -1 que es el 99
	 */
	void prueba4() {
		assertFalse(f.numeroIntervalo(99));
	}
}
