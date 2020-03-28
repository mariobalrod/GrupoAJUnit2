import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Test5 {
	
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
	
	@DisplayName("Prueba de Caja  Negra con cadena vacia")
	@Test
	/*
	 * Le paso una cadena vacia
	 */
	void prueba1() {
		assertEquals(0, f.sumaNumerosCadena(""));
	}
	
	@DisplayName("Prueba de Caja de Cobertura de Camino")
	@Test
	/*
	 * Le paso una cadena que no contenga numeros para que
	 * no entre en el condicional
	 */
	void prueba2() {
		assertEquals(0, f.sumaNumerosCadena("dddddddddddddddd"));
	}
	
	@DisplayName("Prueba de Caja Blanca Cobertura de Sentencias")
	@Test
	/*
	 * Para cubrir todas las sentencias hay que pasarle
	 * una cadena que solo sean numeros ya que siempre que
	 * estudie el condicional entrará dentro. Por ejemplo,
	 * aqui le paso "22222"
	 */
	void prueba3() {
		assertEquals(10, f.sumaNumerosCadena("22222"));
	}
}
