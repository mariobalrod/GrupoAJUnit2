import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Test7 {
	
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
	
	@DisplayName("Prueba de Caja Negra de Array Vacio")
	@Test
	/*
	 * Le paso un Array vacio. Esto nos devuelve como
	 * expresion resultado un ArrayList vacio tambien.
	 */
	void prueba1() {
		assertEquals(new ArrayList<String>(), f.recorte(new String[0]));
	}
	
	@DisplayName("Prueba de Caja Negra de Arrays con un elemento")
	@Test
	/*
	 * Le paso un Array con un solo elemento, es decir, un
	 * array de longitud 1
	 */
	void prueba2() {
		String[] palabras = {"aaaaaaa"};
		ArrayList<String> resultado = new ArrayList<String>();
		resultado.add("aaaa");
		assertEquals(resultado, f.recorte(palabras));
	}
	
	@DisplayName("Prueba de Caja Negra de Arrays con varios elemento")
	@Test
	/*
	 * Le paso un Array con varios elementos, en este caso un array
	 * de longitud 3
	 */
	void prueba3() {
		String[] palabras = {"aaaaaaa", "aaaaaaa", "aaaaaaa"};
		ArrayList<String> resultado = new ArrayList<String>();
		resultado.add("aaaa");
		resultado.add("aaaa");
		resultado.add("aaaa");
		assertEquals(resultado, f.recorte(palabras));
	}
}