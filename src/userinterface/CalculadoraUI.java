package userinterface;

import java.util.Scanner;

import service.CalculadoraService;
import service.DivisaoImpossivelException;

public class CalculadoraUI {

	private static Scanner input;
	private static double x;
	private static double y;

	public static void main(String[] args) {

		input = new Scanner(System.in);
		CalculadoraService calcService = new CalculadoraService();

		double resultado = 0.0;
		int opcao = 0;

		do {
			
			try {

				System.out.println("1 - Adição");
				System.out.println("2 - Subtração");
				System.out.println("3 - Multiplicação");
				System.out.println("4 - Divisão");
				System.out.println("0 - Encerrar aplicativo");

				System.out.print("Opção: ");
				opcao = input.nextInt();

				if (opcao == 0) {
					
					continue;
				}

				switch (opcao) {

					case 1:
						obterValores();
						resultado = calcService.somar(x, y);
						break;
	
					case 2:
						obterValores();
						resultado = calcService.subtrair(x, y);
						break;
	
					case 3:
						obterValores();
						resultado = calcService.multiplicar(x, y);
						break;
	
					case 4:
						obterValores();
						resultado = calcService.dividir(x, y);
						break;
	
					default:
						System.out.println("Opção inválida.");
						continue;
				}

				System.out.println("Resultado = " + resultado);

			} catch (DivisaoImpossivelException nnne) {

				System.err.println(nnne.getMessage());
			}
			
		} while (opcao != 0);

		System.out.println("Finalizado.");

	}

	private static void obterValores() {

		System.out.print("Informe o valor de x: ");
		x = input.nextDouble();

		System.out.print("Informe o valor de y: ");
		y = input.nextDouble();
	}
}
