package userinterface;

import java.util.Scanner;

import service.CalculadoraService;
import service.DivisaoImpossivelException;

public class CalculadoraUI {

	public static void main(String[] args) {

		try {

			Scanner input = new Scanner(System.in);
			CalculadoraService calcService = new CalculadoraService();
			int opcao;

			do {

				System.out.println("1 - Adição");
				System.out.println("2 - Subtração");
				System.out.println("3 - Multiplicação");
				System.out.println("4 - Divisão");
				System.out.println("0 - Encerrar aplicativo");

				System.out.print("Opção: ");
				opcao = input.nextInt();

				if (opcao == 0)
					break;

				System.out.print("Informe o valor de x: ");
				double x = input.nextDouble();

				System.out.print("Informe o valor de y: ");
				double y = input.nextDouble();

				double resultado = 0.0;

				switch (opcao) {

					case 1:
						resultado = calcService.somar(x, y);
						break;
	
					case 2:
						resultado = calcService.subtrair(x, y);
						break;
	
					case 3:
						resultado = calcService.multiplicar(x, y);
						break;
	
					case 4:
						resultado = calcService.dividir(x, y);
						break;
	
					default:
						System.out.println("Opção inválida.");
						continue;
				}

				System.out.println("Resultado = " + resultado);

			} while (opcao != 0);

		} catch (DivisaoImpossivelException nnne) {

			System.err.println(nnne.getMessage());
		}
	}
}
