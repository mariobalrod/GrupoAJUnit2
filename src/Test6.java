import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Test6 {
	
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
	
	@DisplayName("Prueba de Caja Blanca de Cobertura de Caminos 1")
	@Test
	/*
	 * En primer lugar paso un array con longitud 0, 
	 * para que no entre en el bucle for.
	 * Esto dara como resultado el mismo array, es decir, 
	 * no se ve modificado
	 */
	void prueba1() {
		double[] array = new double[0];
		assertArrayEquals(array, f.modArrayDoubles(array));
	}
	
	@DisplayName("Prueba de Caja Blanca de Cobertura de Caminos 2")
	@Test
	/*
	 * En esta pasare un array de longitud 1 para que solo entre
	 * en la condicion de par.
	 */
	void prueba2() {
		double[] array = {1};
		assertArrayEquals(array, f.modArrayDoubles(array));
	}
	
	@DisplayName("Prueba de Caja Blanca de Cobertura de Caminos 3")
	@Test
	/*
	 * En esta pasare un array de longitud 2 para que entre
	 * tambien en la condicion de impar
	 */
	void prueba3() {
		double[] array = {1, 1};
		assertArrayEquals(array, f.modArrayDoubles(array));
	}
}