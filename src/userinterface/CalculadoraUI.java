package userinterface;

import java.util.Scanner;

import service.CalculadoraService;
import service.DivisaoPorZeroException;
import service.NumeroNaoNaturalException;

public class CalculadoraUI {

	private Scanner input;
	private CalculadoraService calcService;

	public CalculadoraUI() {

		this.input = new Scanner(System.in);
		this.calcService = new CalculadoraService("UTF-2005", "UTCalc");
	}

	public void exibirMenuPrincipal() {

		int opcao = 0;
		double x = 0;
		double y = 0;
		double resultado = 0;

		do {
			
			try {

				System.out.println("1 - Somar");
				System.out.println("2 - Substrair");
				System.out.println("3 - Multiplicar");
				System.out.println("4 - Dividir");
				System.out.println("5 - Calcular Raiz Quadrada");
				System.out.println("6 - Calcular Potência");
				System.out.println("7 - Calcular Inverso");
				System.out.println("0 - SAIR");
				System.out.print("Opção: ");
				opcao = input.nextInt();

				switch (opcao) {
					
					case 0: {
						
						continue;
					}
					case 1: {
		
						x = solicitarValor();
						y = solicitarValor();
						resultado = this.calcService.somar(x, y);
						break;
					}
					case 2: {
	
						x = solicitarValor();
						y = solicitarValor();
						resultado = this.calcService.subtrair(x, y);
						break;
					}
					case 3: {
	
						x = solicitarValor();
						y = solicitarValor();
						resultado = this.calcService.multiplicar(x, y);
						break;
					}
					case 4: {
	
						x = solicitarValor();
						y = solicitarValor();
						resultado = this.calcService.dividir(x, y);
						break;
					}
					case 5: {
	
						x = solicitarValor();
						resultado = this.calcService.calcularRaizQuadrada(x);
						break;
					}
					case 6: {
	
						x = solicitarValor();
						y = solicitarValor();
						resultado = this.calcService.calcularPotenciacao(x, y);
						break;
					}
					case 7: {
	
						x = solicitarValor();
						resultado = this.calcService.calcularInverso(x);
						break;
					}
					default: {
						
						System.out.println("Opção Inválida.");
						continue;
					}
				}

				System.out.println("Resultado: " + resultado);

			} catch (DivisaoPorZeroException | NumeroNaoNaturalException e) {

				System.out.println(e.getMessage());
			}
			
		} while (opcao != 0);

		System.out.println("Programa encerrado.");
	}

	public double solicitarValor() {

		System.out.println("Informa o valor: ");
		return input.nextDouble();
	}

	public static void main(String[] args) {

		CalculadoraUI calc = new CalculadoraUI();

		calc.exibirMenuPrincipal();
	}
}
