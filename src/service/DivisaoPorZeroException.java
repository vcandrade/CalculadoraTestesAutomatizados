package service;

public class DivisaoPorZeroException extends Exception {

	public DivisaoPorZeroException() {
	
		super("Impossível dividir por 0.");
	}
}
