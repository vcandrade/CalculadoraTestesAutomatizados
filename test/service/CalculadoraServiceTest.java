package service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class CalculadoraServiceTest {
	
	private CalculadoraService calc;

	@BeforeEach
	public void montarCenario() {

		// MONTAGEM DO CENÁRIO
		calc = new CalculadoraService("ABC-321", "HP");
	}
	
	@AfterEach
	public void limparCenario() {
		
		calc = null;
	}

	@Test
	public void ligarCalculadoraTest() {

		// EXECUÇÃO
		calc.ligar();

		// VERIFICAÇÃO
		assertTrue(calc.isStatus());
	}

	@Test
	public void desligarCalculadoraTest() {

		// EXECUÇÃO
		calc.ligar();
		calc.desligar();

		// VERIFICAÇÃO
		assertFalse(calc.isStatus());
	}

	@Test
	public void somarDoisValoresPositivosTest() {

		// EXECUÇÃO
		double resultado = calc.somar(10, 5);

		// VERIFICAÇÃO
		assertEquals(15, resultado);
	}

	@Test
	public void somarDoisValoresNegativosTest() {

		// EXECUÇÃO
		double resultado = calc.somar(-10, -50);

		// VERIFICAÇÃO
		assertEquals(-60, resultado);
	}

	@Test
	public void somarUmValorPositivoUmNegativoTest() {

		// EXECUÇÃO
		double resultado = calc.somar(5, -10);

		// VERIFICACAO
		assertEquals(-5, resultado);
	}
	
	@Test
	public void subtrairDoisValoresPositivosTest() {

		double resultado = calc.subtrair(50, 70);

		assertEquals(-20, resultado);
	}

	@Test
	public void subtrairDoisValoresNegativosTest() {

		double resultado = calc.subtrair(-50, -70);

		assertEquals(20, resultado);
	}

	@Test
	public void subtrairUmValorPositivoUmNegativoTest() {

		double resultado = calc.subtrair(50, -70);

		assertEquals(120, resultado);
	}
	
	@Test
	public void multiplicarDoisValoresPositivosTest() {

		double resultado = calc.multiplicar(5, 5);

		assertEquals(25, resultado);
	}

	@Test
	public void multiplicarDoisValoresNegativosTest() {

		double resultado = calc.multiplicar(-3, -4);

		assertEquals(12, resultado);
	}

	@Test
	public void multiplicarUmValorPositivoUmNegativoTest() {

		double resultado = calc.multiplicar(5, -4);

		assertEquals(-20, resultado);
	}

	@Test
	public void dividirDoisValoresPositivosTest() {

		try {

			double resultado = calc.dividir(10.0, 5.0);

			assertEquals(2.0, resultado);

		} catch (DivisaoPorZeroException e) {

			fail();
		}
	}
	
	@Test
	public void dividirDoisValoresNegativosTest() {

		try {

			double resultado = calc.dividir(-10.0, -5.0);

			assertEquals(2.0, resultado);

		} catch (DivisaoPorZeroException e) {

			fail();
		}
	}
	
	@Test
	public void dividirUmValorPositivoUmNegativoTest() {

		try {

			double resultado = calc.dividir(10.0, -5.0);

			assertEquals(-2.0, resultado);

		} catch (DivisaoPorZeroException e) {

			fail();
		}
	}

	@Test
	public void dividirPorZeroTest() {

		try {

			double resultado = calc.dividir(10.0, 0.0);

			fail();

		} catch (DivisaoPorZeroException e) {

			assertEquals("Impossível dividir por 0.", e.getMessage());
		}

	}
}
