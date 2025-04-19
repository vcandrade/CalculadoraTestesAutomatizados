package service;

public class CalculadoraService {

	private String modelo;
	private String marca;
	private boolean status;

	public CalculadoraService(String modelo, String marca) {

		this.modelo = modelo;
		this.marca = marca;
		this.status = false;
	}

	public void ligar() {

		this.status = true;
	}

	public void desligar() {

		this.status = false;
	}

	public double somar(double x, double y) {

		return x + y;
	}

	public double subtrair(double x, double y) {

		return x - y;
	}

	public double multiplicar(double x, double y) {

		return x * y;
	}

	public double dividir(double x, double y) throws DivisaoPorZeroException {

		if (y == 0.0) {

			throw new DivisaoPorZeroException();
		}

		return x / y;
	}
	
	public double calcularRaizQuadrada(double x) throws NumeroNaoNaturalException {
		
		if (x < 0) {
			
			throw new NumeroNaoNaturalException();
		}
		
		return Math.sqrt(x);
	}
	
	public double calcularPotenciacao(double x, double y) {
		
		return Math.pow(x, y);
	}
	
	public double calcularInverso(double x) {

		return 1 / x;
	}

	public boolean isStatus() {

		return this.status;
	}
}
