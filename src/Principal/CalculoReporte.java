package Principal;

import java.text.DecimalFormat;


public class CalculoReporte {

	public CalculoReporte() {

	}

	public double formula(double total, double ejecutados) {

		double resultado = (ejecutados / total) * (100);
		System.out.println(ejecutados / total);
		resultado = truncar(resultado);
		return resultado;

	}

	public double truncar(double resultado) {
	
		String pattern = "#.####";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		String formattedDouble = decimalFormat.format(resultado);
		System.out.println("Formatted double d = " + formattedDouble);
		double retorno = Double.parseDouble(formattedDouble);
		return retorno;
	}
}
