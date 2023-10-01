package semana_06;

public class ArregloTemperaturas {
	private double[] temperatura;
	private int indice;

	public ArregloTemperaturas() {
		temperatura = new double[10];
		indice = 0;
	}

	public int tamanio() {
		return indice;
	}

	public double obtener(int i) {
		return temperatura[i];
	}

	private void ampliarArreglo() {
		double[] aux = temperatura;
		temperatura = new double[indice + 10];
		for (int i = 0; i < indice; i++)
			temperatura[i] = aux[i];
	}

	public void adicionar(double t) {
		if (indice == temperatura.length)
			ampliarArreglo();
		temperatura[indice] = t;
		indice++;
	}

	public void eliminarAlFinal() {
		indice--;
	}

	public void eliminarTodo() {
		indice = 0;
	}

	public double temperaturaMenor() {
		double menor = temperatura[0];
        for (int i = 1; i < indice; i++) {
            if (temperatura[i] < menor) {
            	menor = temperatura[i];
            }
        }
        return menor;
	}

	public int posPrimeraTemperaturaNormal() {
		for (int i = 0; i < indice; i++) {
			double normal = temperatura[i];
			if (normal >= 36.1 && normal <= 37.2) {
				return i;
			}
		}
		return -1;
	}

	public void remplazarPrimeraTemperaturaNormal() {
		int i = posPrimeraTemperaturaNormal();
		if (i != -1) {
			temperatura[i] = temperaturaMenor();
		}
	}

	public void incrementarTemperaturas() {
		for (int i = 0; i < indice; i++) {
			temperatura[i] += 0.2;
		}
	}

}
