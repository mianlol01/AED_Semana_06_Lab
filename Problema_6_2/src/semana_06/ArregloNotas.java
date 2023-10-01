package semana_06;

public class ArregloNotas {
	private int[] nota;
	private int indice;

	public ArregloNotas() {
		nota = new int[10];
		indice = 0;
	}

	public int tamanio() {
		return indice;
	}

	public int obtener(int i) {
		return nota[i];
	}

	private void ampliarArreglo() {
		int[] aux = nota;
		nota = new int[indice + 10];
		for (int i = 0; i < indice; i++)
			nota[i] = aux[i];
	}

	public void adicionar(int n) {
		if (indice == nota.length)
			ampliarArreglo();
		nota[indice] = n;
		indice++;
	}

	public void eliminarAlFinal() {
		indice--;
	}

	public void eliminarTodo() {
		indice = 0;
	}

	public int posUltimaNotaDesaprobatoria() {
		for (int i = indice - 1; i >= 0; i--) {
			if (nota[i] < 13) {
				return i;
			}
		}
		return -1;
	}

	public void decrementarUltimaNotaDesaprobatoria() {
		int i = posUltimaNotaDesaprobatoria();
		if (i != -1) {
			nota[i] -= 2;
			if (nota[i] < 0) {
				nota[i] = 0;
			}
		}
	}

	public void remplazarUltimaNotaDesaprobatoria() {
		int i = posUltimaNotaDesaprobatoria();
		if (i != -1 && indice > 0) {
			nota[i] = nota[indice - 1];
		}
	}

}
