import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Test8 {
	
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
	
	@DisplayName("Prueba de Caja Negra con Array vacio")
	@Test
	/*
	 * Le paso un array alumnos vacio por lo que no entra 
	 * en el bucle for, y no estudia el sumatorio de tiempos, por
	 * lo que aunq no se estudie ni se cumpla la condicion, devolvera true
	 */
	void prueba1() {
		int[][] tiempo= {{100, 100, 100},{100, 100, 100},{100, 100, 100}};
		String[] alumnos = new String[0];
		assertEquals(true, f.trabajosTiempo(alumnos, tiempo));
	}
	
	@DisplayName("Prueba de Caja Negra con valor límite inferor")
	@Test
	/*
	 * Para probar el funcionamiento de nuestra funcion
	 * con el valor limite inferior le paso el siguiente array 
	 * dimensional tiempo, que sumaran 300.
	 */
	void prueba2() {
		int[][] tiempo= {{100, 100, 100},{100, 100, 100},{100, 100, 100}};
		String[] alumnos = {"javi", "javi", "javi"};
		assertEquals(false, f.trabajosTiempo(alumnos, tiempo));
	}
	
	@DisplayName("Prueba de Caja Negra con cadenas vacias")
	@Test
	/*
	 * Le paso un array alumnos con cadenas vacias. Esto no influira 
	 * en nada, porque solo usa la longitud de dicho array y no de la
	 * longitud de los String de dentro
	 */
	void prueba3() {
		int[][] tiempo= {{100, 100, 100},{100, 100, 100},{100, 100, 100}};
		String[] alumnos = {"", "", ""};
		assertEquals(false, f.trabajosTiempo(alumnos, tiempo));
	}
}